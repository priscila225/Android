package com.fordroid.gameheroequiz.view;

import java.io.IOException;
import java.util.Random;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.bd.DBHelper;
import com.fordroid.gameheroequiz.data.Character;
import com.fordroid.gameheroequiz.util.Constants;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerActivity extends Activity {

	private AdView adView;
	private String ID = "a151fd188a3a652";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.answer);

		int charImgName = 0;
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int difficult = settings.getInt(Constants.DIFFICULTY, 2);
		int level = settings.getInt(Constants.LEVEL, 0);
		int id = settings.getInt(Constants.CHARACTER, 1);

		Character character = getCharacterByIdFromDb(id);

		String charName = getIntent().getExtras().get("heroeName").toString();
		String mensage = "";

		if (charName.length() == 0)
			return;

		TextView txtAnswer = (TextView) findViewById(R.id.txtAnswer);
		TextView txtAnswer2 = (TextView) findViewById(R.id.txtAnswer2);
		
		ImageView imgHeroe = (ImageView) findViewById(R.id.imgHeroe);
		int heroeImgId = getResources().getIdentifier(
				"game_" + character.getId() + "_1", "drawable",
				getBaseContext().getPackageName());
		imgHeroe.setImageResource(heroeImgId);
		
		if ((charName.compareTo(character.getName().toLowerCase()) == 0)
				|| (charName.compareTo(character.getName_pos1().toLowerCase()) == 0)
				|| (charName.compareTo(character.getName_pos2().toLowerCase()) == 0)) {

			if (difficult > character.getResp()) {
				updateRespPokemonFromDb(difficult, character.getId());
			}

			txtAnswer.setText("Correct");
			txtAnswer.setTextColor(Color.rgb(0, 200, 0));

			int respTotalLevel = getCountCharacterRespByLevelFromDb(level,
					difficult);

			if (respTotalLevel == Constants.NUM_QUESTS_LVL) {
				mensage = "LEVEL " + level + " COMPLETED";
			} else {
				mensage = getMesageUnlocked(difficult);
			}

			txtAnswer2.setText(mensage);
			txtAnswer2.setTextColor(Color.rgb(0, 200, 0));

			ImageView imgName = (ImageView) findViewById(R.id.imgName);
			charImgName = getResources().getIdentifier(
					"game_" + character.getId() + "_ok", "drawable",
					getBaseContext().getPackageName());
			imgName.setImageResource(charImgName);

		} else {

			ImageView imgName = (ImageView) findViewById(R.id.imgName);
			if (difficult == 1) {
				charImgName = getResources().getIdentifier(
						"game_" + character.getId() + "_easy", "drawable",
						getBaseContext().getPackageName());
			} else if (difficult == 2) {

				charImgName = getResources().getIdentifier(
						"game_medium_" + character.getName().length(), "drawable",
						getBaseContext().getPackageName());
			}

			imgName.setImageResource(charImgName);

			txtAnswer.setText("Wrong");
			txtAnswer.setTextColor(Color.rgb(200, 0, 0));

			txtAnswer2.setText("Try again");
			txtAnswer2.setTextColor(Color.rgb(200, 0, 0));
		}

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
		
		if ((new Random().nextInt() % 2 == 0)) {
			adView = new AdView(this, AdSize.BANNER, ID);

			// Lookup your LinearLayout assuming it's been given
			// the attribute android:id="@+id/mainLayout"
			LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
			// Add the adView to it
			layout.addView(adView);
			// Initiate a generic request to load it with an ad
			adView.loadAd(new AdRequest());
		}
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

	private void updateRespPokemonFromDb(int resp, int id) throws Error {
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
		myDbHelper.updateRespCharacter(resp, id);
		myDbHelper.close();
	}

	private String getMesageUnlocked(int diff) {
		switch (getCountCharacterRespFromDb(diff)) {
		case Constants.UNLOCKLVL2:
			return "LEVEL 2 UNLOCKED";
		case Constants.UNLOCKLVL3:
			return "LEVEL 3 UNLOCKED";
		case Constants.UNLOCKLVL4:
			return "LEVEL 4 UNLOCKED";
		case Constants.UNLOCKLVL5:
			return "LEVEL 5 UNLOCKED";
		case Constants.UNLOCKLVL6:
			return "LEVEL 6 UNLOCKED";
		case Constants.UNLOCKLVL7:
			return "LEVEL 7 UNLOCKED";
		case Constants.UNLOCKLVL8:
			return "LEVEL 8 UNLOCKED";
		case Constants.UNLOCKLVL9:
			return "LEVEL 9 UNLOCKED";
		case Constants.UNLOCKLVL10:
			return "LEVEL 10 UNLOCKED";
		default:
			return "";
		}
	}

	private int getCountCharacterRespFromDb(int diff) throws Error {
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
		int num = myDbHelper.getCountResp(diff);
		myDbHelper.close();
		return num;
	}

	private int getCountCharacterRespByLevelFromDb(int level, int diff)
			throws Error {
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
