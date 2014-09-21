package com.fordroid.gameheroequiz.view;

import java.io.IOException;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.bd.DBHelper;
import com.fordroid.gameheroequiz.util.Constants;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ScoreActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int difficult = settings.getInt(Constants.DIFFICULTY, 2);
		
		int ans = getCountPokemonRespByLevelFromDb(1, difficult);
		int ansTotal = ans;
		
		TextView txtLvl1Score = (TextView)findViewById(R.id.txtLvl1Score);
		txtLvl1Score.setText("Level 1: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		ans = getCountPokemonRespByLevelFromDb(2, difficult);
		ansTotal += ans;
		
		TextView txtLvl2Score = (TextView)findViewById(R.id.txtLvl2Score);
		txtLvl2Score.setText("Level 2: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		ans = getCountPokemonRespByLevelFromDb(3, difficult);
		ansTotal += ans;
		
		TextView txtLvl3Score = (TextView)findViewById(R.id.txtLvl3Score);
		txtLvl3Score.setText("Level 3: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		ans = getCountPokemonRespByLevelFromDb(4, difficult);
		ansTotal += ans;
		
		TextView txtLvl4Score = (TextView)findViewById(R.id.txtLvl4Score);
		txtLvl4Score.setText("Level 4: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		ans = getCountPokemonRespByLevelFromDb(5, difficult);
		ansTotal += ans;
		
		TextView txtLvl5Score = (TextView)findViewById(R.id.txtLvl5Score);
		txtLvl5Score.setText("Level 5: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		ans = getCountPokemonRespByLevelFromDb(6, difficult);
		ansTotal += ans;
		
		TextView txtLvl6Score = (TextView)findViewById(R.id.txtLvl6Score);
		txtLvl6Score.setText("Level 6: " + ans + "/" + Constants.NUM_QUESTS_LVL);
		
		
		TextView txtPlayer = (TextView)findViewById(R.id.txtPlayer);
		txtPlayer.setText("Player 1            " + ansTotal + "/120");
		
		Log.d("TOTAL",Integer.toString(ansTotal));
		Log.d("%%",Integer.toString((ansTotal/120)*100));
		
		TextView txtPercent = (TextView)findViewById(R.id.txtPercent);
		txtPercent.setText( ((((float)ansTotal)/120)*100) + "% Completed");
	}

	private int getCountPokemonRespByLevelFromDb(int level, int diff)
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
}
