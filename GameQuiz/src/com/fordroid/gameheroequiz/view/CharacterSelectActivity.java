package com.fordroid.gameheroequiz.view;

import java.io.IOException;
import java.util.List;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.bd.DBHelper;
import com.fordroid.gameheroequiz.data.Character;
import com.fordroid.gameheroequiz.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CharacterSelectActivity extends Activity implements
		OnClickListener {

	List<Character> charList;
	int level;
	int difficult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.character_select);

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		level = settings.getInt(Constants.LEVEL, 1);
		difficult = settings.getInt(Constants.DIFFICULTY, 2);

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

		charList = getCharacterByLevelFromDb(level);

		// Button 1
		Button btnChar1 = (Button) findViewById(R.id.btnChar1);
		btnChar1.setOnClickListener(this);

		setButtonImage(charList.get(0), btnChar1, difficult);

		// Button 2
		Button btnChar2 = (Button) findViewById(R.id.btnChar2);
		btnChar2.setOnClickListener(this);

		setButtonImage(charList.get(1), btnChar2, difficult);

		// Button 3
		Button btnChar3 = (Button) findViewById(R.id.btnChar3);
		btnChar3.setOnClickListener(this);

		setButtonImage(charList.get(2), btnChar3, difficult);

		// Button 4
		Button btnChar4 = (Button) findViewById(R.id.btnChar4);
		btnChar4.setOnClickListener(this);

		setButtonImage(charList.get(3), btnChar4, difficult);

		// Button 5
		Button btnChar5 = (Button) findViewById(R.id.btnChar5);
		btnChar5.setOnClickListener(this);

		setButtonImage(charList.get(4), btnChar5, difficult);

		// Button 6
		Button btnChar6 = (Button) findViewById(R.id.btnChar6);
		btnChar6.setOnClickListener(this);

		setButtonImage(charList.get(5), btnChar6, difficult);

		// Button 7
		Button btnChar7 = (Button) findViewById(R.id.btnChar7);
		btnChar7.setOnClickListener(this);

		setButtonImage(charList.get(6), btnChar7, difficult);

		// Button 8
		Button btnChar8 = (Button) findViewById(R.id.btnChar8);
		btnChar8.setOnClickListener(this);

		setButtonImage(charList.get(7), btnChar8, difficult);

		// Button 9
		Button btnChar9 = (Button) findViewById(R.id.btnChar9);
		btnChar9.setOnClickListener(this);

		setButtonImage(charList.get(8), btnChar9, difficult);

		// Button 10
		Button btnChar10 = (Button) findViewById(R.id.btnChar10);
		btnChar10.setOnClickListener(this);

		setButtonImage(charList.get(9), btnChar10, difficult);

		// Button 11
		Button btnChar11 = (Button) findViewById(R.id.btnChar11);
		btnChar11.setOnClickListener(this);

		setButtonImage(charList.get(10), btnChar11, difficult);

		// Button 12
		Button btnChar12 = (Button) findViewById(R.id.btnChar12);
		btnChar12.setOnClickListener(this);

		setButtonImage(charList.get(11), btnChar12, difficult);

		// Button 13
		Button btnChar13 = (Button) findViewById(R.id.btnChar13);
		btnChar13.setOnClickListener(this);

		setButtonImage(charList.get(12), btnChar13, difficult);

		// Button 14
		Button btnChar14 = (Button) findViewById(R.id.btnChar14);
		btnChar14.setOnClickListener(this);

		setButtonImage(charList.get(13), btnChar14, difficult);

		// Button 15
		Button btnChar15 = (Button) findViewById(R.id.btnChar15);
		btnChar15.setOnClickListener(this);

		setButtonImage(charList.get(14), btnChar15, difficult);

		// Button 16
		Button btnChar16 = (Button) findViewById(R.id.btnChar16);
		btnChar16.setOnClickListener(this);

		setButtonImage(charList.get(15), btnChar16, difficult);

		// Button 17
		Button btnChar17 = (Button) findViewById(R.id.btnChar17);
		btnChar17.setOnClickListener(this);

		setButtonImage(charList.get(16), btnChar17, difficult);

		// Button 18
		Button btnChar18 = (Button) findViewById(R.id.btnChar18);
		btnChar18.setOnClickListener(this);

		setButtonImage(charList.get(17), btnChar18, difficult);

		// Button 19
		Button btnChar19 = (Button) findViewById(R.id.btnChar19);
		btnChar19.setOnClickListener(this);

		setButtonImage(charList.get(18), btnChar19, difficult);

		// Button 20
		Button btnChar20 = (Button) findViewById(R.id.btnChar20);
		btnChar20.setOnClickListener(this);

		setButtonImage(charList.get(19), btnChar20, difficult);

		Button btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(this);
	}

	private void setButtonImage(Character character, Button btnChar, int diff) {
		int charImgId;

		if (diff > character.getResp()) {
			charImgId = getResources().getIdentifier(
					"game_" + character.getId() + "_1", "drawable",
					getBaseContext().getPackageName());
		} else {
			charImgId = getResources().getIdentifier(
					"game_" + character.getId() + "_2", "drawable",
					getBaseContext().getPackageName());
		}

		btnChar.setBackgroundResource(charImgId);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onClick(View v) {
		Intent i;

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		SharedPreferences.Editor editor = settings.edit();

		switch (v.getId()) {
		case R.id.btnChar1:
			if (difficult <= charList.get(0).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(0).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar2:
			if (difficult <= charList.get(1).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(1).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar3:
			if (difficult <= charList.get(2).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(2).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar4:
			if (difficult <= charList.get(3).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(3).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar5:
			if (difficult <= charList.get(4).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(4).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar6:
			if (difficult <= charList.get(5).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(5).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnChar7:
			if (difficult <= charList.get(6).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(6).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar8:
			if (difficult <= charList.get(7).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(7).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar9:
			if (difficult <= charList.get(8).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(8).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar10:
			if (difficult <= charList.get(9).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(9).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar11:
			if (difficult <= charList.get(10).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(10).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar12:
			if (difficult <= charList.get(11).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(11).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar13:
			if (difficult <= charList.get(12).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(12).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar14:
			if (difficult <= charList.get(13).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(13).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar15:
			if (difficult <= charList.get(14).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(14).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar16:
			if (difficult <= charList.get(15).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(15).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar17:
			if (difficult <= charList.get(16).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(16).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar18:
			if (difficult <= charList.get(17).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(17).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar19:
			if (difficult <= charList.get(18).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(18).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnChar20:
			if (difficult <= charList.get(19).getResp())
				return;

			editor.putInt(Constants.CHARACTER, charList.get(19).getId());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnMenu:
			i = new Intent(this, LevelSelectActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
			finish();
			break;
		}
	}

	private List<Character> getCharacterByLevelFromDb(int level) throws Error {
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
		List<Character> charList = myDbHelper.getCharacterByLevel(level);
		myDbHelper.close();
		return charList;
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
