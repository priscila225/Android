package com.fordroid.gameheroequiz.view;

import java.io.IOException;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.bd.DBHelper;
import com.fordroid.gameheroequiz.data.Character;
import com.fordroid.gameheroequiz.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionActivity extends Activity {

	Character character;
	int charImgName;
	int difficult;
	int level;
	int id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question);

		final EditText textBox = (EditText) findViewById(R.id.editTextCharName);

		InputMethodManager imm = (InputMethodManager) getSystemService(QuestionActivity.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(textBox.getWindowToken(), 0);

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		difficult = settings.getInt(Constants.DIFFICULTY, 2);
		level = settings.getInt(Constants.LEVEL, 0);
		id = settings.getInt(Constants.CHARACTER, 1);

		TextView txtDiffLevel = (TextView) findViewById(R.id.txtLevelDiff);
		if (difficult == 1) {
			txtDiffLevel.setText("Level " + level + " - Easy");
		} else if (difficult == 2) {
			txtDiffLevel.setText("Level " + level + " - Medium");
		} else if (difficult == 3) {
			txtDiffLevel.setText("Level " + level + " - Hard");
		}

		int totalResp = getCountCharacterRespFromDb(level, difficult);

		TextView txtPont = (TextView) findViewById(R.id.txtPoints);
		txtPont.setText(totalResp + "/" + Constants.NUM_QUESTS_LVL);

		character = getCharacterByIdFromDb(id);

		ImageView imgChar = (ImageView) findViewById(R.id.imgHeroe);
		int charImgId = getResources().getIdentifier(
				"game_" + character.getId() + "_1", "drawable",
				getBaseContext().getPackageName());
		imgChar.setImageResource(charImgId);

		ImageView imgName = (ImageView) findViewById(R.id.imgName);
		if (difficult == 1) {
			charImgName = getResources().getIdentifier(
					"game_" + character.getId() + "_easy", "drawable",
					getBaseContext().getPackageName());
		} else if (difficult == 2) {

			if (character.getImage().length() > 1) {
				Log.d("Image", "game_medium" + character.getName().length());
				charImgName = getResources().getIdentifier(character.getImage(),
						"drawable", getBaseContext().getPackageName());
			} else {
				Log.d("Image", "game_medium" + character.getName().length());
				charImgName = getResources().getIdentifier(
						"game_medium_" + character.getName().length(),
						"drawable", getBaseContext().getPackageName());
			}
		}

		imgName.setImageResource(charImgName);

		// Button Check
		((Button) findViewById(R.id.btnCheck))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						String charName = textBox.getText().toString()
								.toLowerCase().trim();

						if (charName.length() == 0)
							return;

						Intent i = new Intent(getBaseContext(),
								AnswerActivity.class);
						i.putExtra("heroeName", charName);
						startActivity(i);
						finish();
					}
				});

		// Button Back
		((Button) findViewById(R.id.btnBack))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent i = new Intent(getBaseContext(),
								CharacterSelectActivity.class);
						startActivity(i);
						finish();
					}
				});

	}

	private Character getCharacterByIdFromDb(int id) throws Error {
		DBHelper myDbHelper = new DBHelper(this);
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			myDbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}

		Character character = myDbHelper.getCharacterById(id);
		myDbHelper.close();
		return character;
	}

	private int getCountCharacterRespFromDb(int level, int diff) throws Error {
		DBHelper myDbHelper = new DBHelper(this);
		try {
			myDbHelper.createDataBase();
		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}
		try {
			myDbHelper.openDataBase();
		} catch (SQLException sqle) {
			throw sqle;
		}
		int num = myDbHelper.getCountRespByLevel(level, diff);
		myDbHelper.close();
		return num;
	}
}
