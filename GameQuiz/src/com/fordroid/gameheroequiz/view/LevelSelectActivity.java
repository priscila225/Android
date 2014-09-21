package com.fordroid.gameheroequiz.view;

import java.io.IOException;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.bd.DBHelper;
import com.fordroid.gameheroequiz.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LevelSelectActivity extends Activity {
	private int dificult;
	private int totalAns = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_select);
		
		Display display = getWindowManager().getDefaultDisplay(); 
		int width = display.getWidth(); 

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		dificult = settings.getInt(Constants.DIFFICULTY, 2);
		int ans = 0;
		LayoutParams paransPrgBar = new LayoutParams();
		paransPrgBar.width = (int) (width*(.6));

		LayoutParams paransBtn = new LayoutParams();
		paransBtn.width = width/5;
		paransBtn.height = width/8;

		// Botao level 1
		ans = getCountPokemonRespFromDb(1, dificult);
		totalAns += ans;
		LinearLayout layoutLvl1 = (LinearLayout) findViewById(R.id.lvl1Layout);

		TextView txtPrgLvl1 = (TextView) findViewById(R.id.txtPrgLvl1);
		txtPrgLvl1.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

		ProgressBar prgBar1 = new ProgressBar(this, null,
				android.R.attr.progressBarStyleHorizontal);
		prgBar1.setLayoutParams(paransPrgBar);
		prgBar1.setMax(Constants.NUM_QUESTS_LVL);
		prgBar1.setProgress(ans);

		Button btnLvl1 = new Button(this);
		btnLvl1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences settings = getSharedPreferences(
						Constants.SETTINGS, 0);
				SharedPreferences.Editor editor = settings.edit();

				editor.putInt(Constants.LEVEL, 1);
				editor.commit();

				Intent i = new Intent(getBaseContext(),
						CharacterSelectActivity.class);
				startActivity(i);
				finish();
			}
		});
		btnLvl1.setText("Play");
		btnLvl1.setLayoutParams(paransBtn);

		layoutLvl1.addView(prgBar1);
		layoutLvl1.addView(btnLvl1);

		// Botao level 2
		TextView txtPrgLvl2 = (TextView) findViewById(R.id.txtPrgLvl2);
		LinearLayout layoutLvl2 = (LinearLayout) findViewById(R.id.lvl2Layout);

		// Verifica se já alcançou pontuação para liberar lvl 2
		if (totalAns >= Constants.UNLOCKLVL2) {
			ans = getCountPokemonRespFromDb(2, dificult);
			totalAns += ans;
			txtPrgLvl2.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

			ProgressBar prgBar2 = new ProgressBar(this, null,
					android.R.attr.progressBarStyleHorizontal);
			prgBar2.setLayoutParams(paransPrgBar);
			prgBar2.setMax(Constants.NUM_QUESTS_LVL);
			prgBar2.setProgress(ans);

			Button btnLvl2 = new Button(this);
			btnLvl2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences settings = getSharedPreferences(
							Constants.SETTINGS, 0);
					SharedPreferences.Editor editor = settings.edit();

					editor.putInt(Constants.LEVEL, 2);
					editor.commit();

					Intent i = new Intent(getBaseContext(),
							CharacterSelectActivity.class);
					startActivity(i);
					finish();
				}
			});
			btnLvl2.setText("Play");
			btnLvl2.setLayoutParams(paransBtn);

			layoutLvl2.addView(prgBar2);
			layoutLvl2.addView(btnLvl2);
		} else {
			txtPrgLvl2.setText(+Constants.UNLOCKLVL2 + " points to Unlock");
		}

		// Botao level 3
		TextView txtPrgLvl3 = (TextView) findViewById(R.id.txtPrgLvl3);
		LinearLayout layoutLvl3 = (LinearLayout) findViewById(R.id.lvl3Layout);

		// Verifica se já alcançou pontuação para liberar lvl 2
		if (totalAns >= Constants.UNLOCKLVL3) {
			ans = getCountPokemonRespFromDb(3, dificult);
			totalAns += ans;
			txtPrgLvl3.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

			ProgressBar prgBar3 = new ProgressBar(this, null,
					android.R.attr.progressBarStyleHorizontal);
			prgBar3.setLayoutParams(paransPrgBar);
			prgBar3.setMax(Constants.NUM_QUESTS_LVL);
			prgBar3.setProgress(ans);

			Button btnLvl3 = new Button(this);
			btnLvl3.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences settings = getSharedPreferences(
							Constants.SETTINGS, 0);
					SharedPreferences.Editor editor = settings.edit();

					editor.putInt(Constants.LEVEL, 3);
					editor.commit();

					Intent i = new Intent(getBaseContext(),
							CharacterSelectActivity.class);
					startActivity(i);
					finish();
				}
			});
			btnLvl3.setText("Play");
			btnLvl3.setLayoutParams(paransBtn);

			layoutLvl3.addView(prgBar3);
			layoutLvl3.addView(btnLvl3);
		} else {
			txtPrgLvl3.setText(Constants.UNLOCKLVL3 + " points to Unlock");
		}

		// Botao level 4
		TextView txtPrgLvl4 = (TextView) findViewById(R.id.txtPrgLvl4);
		LinearLayout layoutLvl4 = (LinearLayout) findViewById(R.id.lvl4Layout);

		// Verifica se já alcançou pontuação para liberar lvl 2
		if (totalAns >= Constants.UNLOCKLVL4) {
			ans = getCountPokemonRespFromDb(4, dificult);
			totalAns += ans;
			txtPrgLvl4.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

			ProgressBar prgBar4 = new ProgressBar(this, null,
					android.R.attr.progressBarStyleHorizontal);
			prgBar4.setLayoutParams(paransPrgBar);
			prgBar4.setMax(Constants.NUM_QUESTS_LVL);
			prgBar4.setProgress(ans);

			Button btnLvl4 = new Button(this);
			btnLvl4.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences settings = getSharedPreferences(
							Constants.SETTINGS, 0);
					SharedPreferences.Editor editor = settings.edit();

					editor.putInt(Constants.LEVEL, 4);
					editor.commit();

					Intent i = new Intent(getBaseContext(),
							CharacterSelectActivity.class);
					startActivity(i);
					finish();
				}
			});
			btnLvl4.setText("Play");
			btnLvl4.setLayoutParams(paransBtn);

			layoutLvl4.addView(prgBar4);
			layoutLvl4.addView(btnLvl4);
		} else {
			txtPrgLvl4.setText(Constants.UNLOCKLVL4 + " points to Unlock");
		}

		// Botao level 5
		TextView txtPrgLvl5 = (TextView) findViewById(R.id.txtPrgLvl5);
		LinearLayout layoutLvl5 = (LinearLayout) findViewById(R.id.lvl5Layout);

		// Verifica se já alcançou pontuação para liberar lvl 5
		if ((totalAns >= Constants.UNLOCKLVL5) && (dificult == 3)) {
			ans = getCountPokemonRespFromDb(5, dificult);
			totalAns += ans;
			txtPrgLvl5.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

			ProgressBar prgBar5 = new ProgressBar(this, null,
					android.R.attr.progressBarStyleHorizontal);
			prgBar5.setLayoutParams(paransPrgBar);
			prgBar5.setMax(Constants.NUM_QUESTS_LVL);
			prgBar5.setProgress(ans);

			Button btnLvl5 = new Button(this);
			btnLvl5.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences settings = getSharedPreferences(
							Constants.SETTINGS, 0);
					SharedPreferences.Editor editor = settings.edit();

					editor.putInt(Constants.LEVEL, 5);
					editor.commit();

					Intent i = new Intent(getBaseContext(),
							CharacterSelectActivity.class);
					startActivity(i);
					finish();
				}
			});
			btnLvl5.setText("Play");
			btnLvl5.setLayoutParams(paransBtn);

			layoutLvl5.addView(prgBar5);
			layoutLvl5.addView(btnLvl5);
		} else {
			txtPrgLvl5.setText(Constants.UNLOCKLVL5 + " in hard points to Unlock");
		}

		// Botao level 6
		TextView txtPrgLvl6 = (TextView) findViewById(R.id.txtPrgLvl6);
		LinearLayout layoutLvl6 = (LinearLayout) findViewById(R.id.lvl6Layout);

		// Verifica se já alcançou pontuação para liberar lvl 6
		if ((totalAns >= Constants.UNLOCKLVL6) && (dificult == 3)) {
			ans = getCountPokemonRespFromDb(6, dificult);
			totalAns += ans;
			txtPrgLvl6.setText(ans + "/" + Constants.NUM_QUESTS_LVL);

			ProgressBar prgBar6 = new ProgressBar(this, null,
					android.R.attr.progressBarStyleHorizontal);
			prgBar6.setLayoutParams(paransPrgBar);
			prgBar6.setMax(Constants.NUM_QUESTS_LVL);
			prgBar6.setProgress(ans);

			Button btnLvl6 = new Button(this);
			btnLvl6.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					SharedPreferences settings = getSharedPreferences(
							Constants.SETTINGS, 0);
					SharedPreferences.Editor editor = settings.edit();

					editor.putInt(Constants.LEVEL, 6);
					editor.commit();

					Intent i = new Intent(getBaseContext(),
							CharacterSelectActivity.class);
					startActivity(i);
					finish();
				}
			});
			btnLvl6.setText("Play");
			btnLvl6.setLayoutParams(paransBtn);

			layoutLvl6.addView(prgBar6);
			layoutLvl6.addView(btnLvl6);
		} else {
			txtPrgLvl6.setText(Constants.UNLOCKLVL6 + " points in hard to Unlock");
		}

		Button btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	private int getCountPokemonRespFromDb(int level, int diff) throws Error {
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
