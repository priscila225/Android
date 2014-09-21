package com.fordroid.whoisthatpokemon.view;

import java.io.IOException;

import com.fordroid.whoisthatpokemon.R;
import com.fordroid.whoisthatpokemon.bd.DBHelper;
import com.fordroid.whoisthatpokemon.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LevelSelectActivity extends Activity implements OnClickListener {
	private int dificult;
	private int totalAns = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_select);

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		dificult = settings.getInt(Constants.DIFFICULTY, 2);

		int cadeadoId = getResources().getIdentifier("cadeado",
				"drawable", getBaseContext().getPackageName());
		int ans = 0;

		// Botao level 1
		ans = getCountPokemonRespFromDb(1, dificult);
		totalAns += ans;
		Button btnLvl1 = (Button) findViewById(R.id.btnLvl1);
		btnLvl1.setOnClickListener(this);

		btnLvl1.setText("Level 1\n" + ans + "/" + Constants.NUM_QUESTS_LVL);

		// Botao level 2
		Button btnLvl2 = (Button) findViewById(R.id.btnLvl2);
		btnLvl2.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 2
		if (totalAns >= Constants.UNLOCKLVL2) {
			ans = getCountPokemonRespFromDb(2, dificult);
			totalAns += ans;

			btnLvl2.setText("Level 2\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
			btnLvl2.setDrawingCacheQuality(cadeadoId);
		} else {
			btnLvl2.setText("Level 2 LOCKED\n" + Constants.UNLOCKLVL2
					+ " points to UNLOCK");
		}

		// Botao level 3
		Button btnLvl3 = (Button) findViewById(R.id.btnLvl3);
		btnLvl3.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 3
		if (totalAns >= Constants.UNLOCKLVL3) {
			ans = getCountPokemonRespFromDb(3, dificult);
			totalAns += ans;

			btnLvl3.setText("Level 3\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
			btnLvl3.setDrawingCacheQuality(cadeadoId);
		} else {
			btnLvl3.setText("Level 3 LOCKED\n" + Constants.UNLOCKLVL3
					+ " points to UNLOCK");
		}

		// Botao level 4
		Button btnLvl4 = (Button) findViewById(R.id.btnLvl4);
		btnLvl4.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 4
		if (totalAns >= Constants.UNLOCKLVL4) {
			ans = getCountPokemonRespFromDb(4, dificult);
			totalAns += ans;

			btnLvl4.setText("Level 4\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl4.setText("Level 4 LOCKED\n" + Constants.UNLOCKLVL4
					+ " points to UNLOCK");
		}

		// Botao level 5
		Button btnLvl5 = (Button) findViewById(R.id.btnLvl5);
		btnLvl5.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 5
		if (totalAns >= Constants.UNLOCKLVL5) {
			ans = getCountPokemonRespFromDb(5, dificult);
			totalAns += ans;

			btnLvl5.setText("Level 5\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl5.setText("Level 5 LOCKED\n" + Constants.UNLOCKLVL5
					+ " points to UNLOCK");
		}

		// Botao level 6
		Button btnLvl6 = (Button) findViewById(R.id.btnLvl6);
		btnLvl6.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 6
		if (totalAns >= Constants.UNLOCKLVL6) {
			ans = getCountPokemonRespFromDb(6, dificult);
			totalAns += ans;

			btnLvl6.setText("Level 6\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl6.setText("Level 6 LOCKED\n" + Constants.UNLOCKLVL6
					+ " points to UNLOCK");
		}

		// Botao level 7
		Button btnLvl7 = (Button) findViewById(R.id.btnLvl7);
		btnLvl7.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 7
		if (totalAns >= Constants.UNLOCKLVL7) {
			ans = getCountPokemonRespFromDb(7, dificult);
			totalAns += ans;

			btnLvl7.setText("Level 7\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl7.setText("Level 7 LOCKED\n" + Constants.UNLOCKLVL7
					+ " points to UNLOCK");
		}

		// Botao level 8
		Button btnLvl8 = (Button) findViewById(R.id.btnLvl8);
		btnLvl8.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 8
		if (totalAns >= Constants.UNLOCKLVL8) {
			ans = getCountPokemonRespFromDb(8, dificult);
			totalAns += ans;

			btnLvl8.setText("Level 8\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl8.setText("Level 8 LOCKED\n" + Constants.UNLOCKLVL8
					+ " points to UNLOCK");
		}

		// Botao level 9
		Button btnLvl9 = (Button) findViewById(R.id.btnLvl9);
		btnLvl9.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 9
		if (totalAns >= Constants.UNLOCKLVL9) {
			ans = getCountPokemonRespFromDb(9, dificult);
			totalAns += ans;

			btnLvl9.setText("Level 9\n" + ans + "/" + Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl9.setText("Level 9 LOCKED\n" + Constants.UNLOCKLVL9
					+ " points to UNLOCK");
		}

		// Botao level 10
		Button btnLvl10 = (Button) findViewById(R.id.btnLvl10);
		btnLvl10.setOnClickListener(this);
		// Verifica se já alcançou pontuação para liberar lvl 7
		if (totalAns >= Constants.UNLOCKLVL10) {
			ans = getCountPokemonRespFromDb(10, dificult);
			totalAns += ans;

			btnLvl10.setText("Level 10\n" + ans + "/"
					+ Constants.NUM_QUESTS_LVL);
		} else {
			btnLvl10.setText("Level 10 LOCKED\n" + Constants.UNLOCKLVL10
					+ " points to UNLOCK");
		}
		
		Button btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent i;

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		SharedPreferences.Editor editor = settings.edit();

		switch (v.getId()) {
		case R.id.btnLvl1:

			editor.putInt(Constants.LEVEL, 1);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnLvl2:

			if (totalAns < Constants.UNLOCKLVL2)
				return;

			editor.putInt(Constants.LEVEL, 2);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnLvl3:

			if (totalAns < Constants.UNLOCKLVL3)
				return;

			editor.putInt(Constants.LEVEL, 3);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl4:

			if (totalAns < Constants.UNLOCKLVL4)
				return;

			editor.putInt(Constants.LEVEL, 4);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl5:

			if (totalAns < Constants.UNLOCKLVL5)
				return;

			editor.putInt(Constants.LEVEL, 5);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl6:

			if (totalAns < Constants.UNLOCKLVL6)
				return;

			editor.putInt(Constants.LEVEL, 6);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl7:

			if (totalAns < Constants.UNLOCKLVL7)
				return;

			editor.putInt(Constants.LEVEL, 7);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl8:

			if (totalAns < Constants.UNLOCKLVL8)
				return;

			editor.putInt(Constants.LEVEL, 8);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl9:

			if (totalAns < Constants.UNLOCKLVL9)
				return;

			editor.putInt(Constants.LEVEL, 9);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnLvl10:

			if (totalAns < Constants.UNLOCKLVL10)
				return;

			editor.putInt(Constants.LEVEL, 10);
			editor.commit();

			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnMenu:
			finish();
			break;
		}
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
		int num = myDbHelper.getCountResp(level, diff);
		myDbHelper.close();
		return num;
	}
}
