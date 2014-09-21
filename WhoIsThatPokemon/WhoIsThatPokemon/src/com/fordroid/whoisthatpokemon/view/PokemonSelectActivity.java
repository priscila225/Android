package com.fordroid.whoisthatpokemon.view;

import java.io.IOException;
import java.util.List;

import com.fordroid.whoisthatpokemon.R;
import com.fordroid.whoisthatpokemon.bd.DBHelper;
import com.fordroid.whoisthatpokemon.data.Pokemon;
import com.fordroid.whoisthatpokemon.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PokemonSelectActivity extends Activity implements OnClickListener {

	List<Pokemon> pkmList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_select);

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int level = settings.getInt(Constants.LEVEL, 0);
		int dificult = settings.getInt(Constants.DIFFICULTY, 2);
		
		TextView txtDiffLevel = (TextView) findViewById(R.id.txtLevelDiff);
		if ( dificult == 1 )
		{
			txtDiffLevel.setText("Level " + level + " - Easy");
		}
		else if ( dificult == 2 )
		{
			txtDiffLevel.setText("Level " + level + " - Medium");
		}
		else if ( dificult == 3 )
		{
			txtDiffLevel.setText("Level " + level + " - Hard");
		}
		
		int totalResp = getCountPokemonRespFromDb(level, dificult);
		
		TextView txtPont = (TextView) findViewById(R.id.txtPoints);
		txtPont.setText(totalResp + "/" + Constants.NUM_QUESTS_LVL);
		
		pkmList = getPokemonByLevelFromDb(level);

		// Button 1
		Button btnPkm1 = (Button) findViewById(R.id.btnPkm1);
		btnPkm1.setOnClickListener(this);

		setButtonImage(pkmList.get(0), btnPkm1, dificult);

		// Button 2
		Button btnPkm2 = (Button) findViewById(R.id.btnPkm2);
		btnPkm2.setOnClickListener(this);

		setButtonImage(pkmList.get(1), btnPkm2, dificult);

		// Button 3
		Button btnPkm3 = (Button) findViewById(R.id.btnPkm3);
		btnPkm2.setOnClickListener(this);

		setButtonImage(pkmList.get(2), btnPkm3, dificult);

		// Button 4
		Button btnPkm4 = (Button) findViewById(R.id.btnPkm4);
		btnPkm4.setOnClickListener(this);

		setButtonImage(pkmList.get(3), btnPkm4, dificult);

		// Button 5
		Button btnPkm5 = (Button) findViewById(R.id.btnPkm5);
		btnPkm5.setOnClickListener(this);

		setButtonImage(pkmList.get(4), btnPkm5, dificult);

		// Button 6
		Button btnPkm6 = (Button) findViewById(R.id.btnPkm6);
		btnPkm6.setOnClickListener(this);

		setButtonImage(pkmList.get(5), btnPkm6, dificult);

		// Button 7
		Button btnPkm7 = (Button) findViewById(R.id.btnPkm7);
		btnPkm7.setOnClickListener(this);

		setButtonImage(pkmList.get(6), btnPkm7, dificult);

		// Button 8
		Button btnPkm8 = (Button) findViewById(R.id.btnPkm8);
		btnPkm8.setOnClickListener(this);

		setButtonImage(pkmList.get(7), btnPkm8, dificult);

		// Button 9
		Button btnPkm9 = (Button) findViewById(R.id.btnPkm9);
		btnPkm9.setOnClickListener(this);

		setButtonImage(pkmList.get(8), btnPkm9, dificult);

		// Button 10
		Button btnPkm10 = (Button) findViewById(R.id.btnPkm10);
		btnPkm10.setOnClickListener(this);

		setButtonImage(pkmList.get(9), btnPkm10, dificult);

		// Button 11
		Button btnPkm11 = (Button) findViewById(R.id.btnPkm11);
		btnPkm11.setOnClickListener(this);

		setButtonImage(pkmList.get(10), btnPkm11, dificult);

		// Button 12
		Button btnPkm12 = (Button) findViewById(R.id.btnPkm12);
		btnPkm12.setOnClickListener(this);

		setButtonImage(pkmList.get(11), btnPkm12, dificult);

		// Button 13
		Button btnPkm13 = (Button) findViewById(R.id.btnPkm13);
		btnPkm13.setOnClickListener(this);

		setButtonImage(pkmList.get(12), btnPkm13, dificult);

		// Button 14
		Button btnPkm14 = (Button) findViewById(R.id.btnPkm14);
		btnPkm14.setOnClickListener(this);

		setButtonImage(pkmList.get(13), btnPkm14, dificult);

		// Button 15
		Button btnPkm15 = (Button) findViewById(R.id.btnPkm15);
		btnPkm15.setOnClickListener(this);

		setButtonImage(pkmList.get(14), btnPkm15, dificult);

		// Button 16
		Button btnPkm16 = (Button) findViewById(R.id.btnPkm16);
		btnPkm16.setOnClickListener(this);

		setButtonImage(pkmList.get(15), btnPkm16, dificult);

		// Button 17
		Button btnPkm17 = (Button) findViewById(R.id.btnPkm17);
		btnPkm17.setOnClickListener(this);

		setButtonImage(pkmList.get(16), btnPkm17, dificult);

		// Button 18
		Button btnPkm18 = (Button) findViewById(R.id.btnPkm18);
		btnPkm18.setOnClickListener(this);

		setButtonImage(pkmList.get(17), btnPkm18, dificult);

		// Button 19
		Button btnPkm19 = (Button) findViewById(R.id.btnPkm19);
		btnPkm19.setOnClickListener(this);

		setButtonImage(pkmList.get(18), btnPkm19, dificult);

		// Button 20
		Button btnPkm20 = (Button) findViewById(R.id.btnPkm20);
		btnPkm20.setOnClickListener(this);

		setButtonImage(pkmList.get(19), btnPkm20, dificult);

		Button btnMenu = (Button) findViewById(R.id.btnMenu);
		btnMenu.setOnClickListener(this);
	}

	private void setButtonImage(Pokemon pkm, Button btnPkm, int diff) {
		int pkmImgId;
		if (diff > pkm.getResp()) {
			pkmImgId = getResources().getIdentifier(pkm.getImage1() + "_2",
					"drawable", getBaseContext().getPackageName());
		} else {
			pkmImgId = getResources().getIdentifier(pkm.getImage1() + "_1",
					"drawable", getBaseContext().getPackageName());
		}

		btnPkm.setBackgroundResource(pkmImgId);
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
		case R.id.btnPkm1:
			editor.putInt(Constants.POKEMON, pkmList.get(0).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;

		case R.id.btnPkm2:

			editor.putInt(Constants.POKEMON, pkmList.get(1).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnPkm3:
			editor.putInt(Constants.POKEMON, pkmList.get(2).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnPkm4:
			editor.putInt(Constants.POKEMON, pkmList.get(3).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnPkm5:
			editor.putInt(Constants.POKEMON, pkmList.get(4).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnPkm6:
			editor.putInt(Constants.POKEMON, pkmList.get(5).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
			
		case R.id.btnPkm7:
			editor.putInt(Constants.POKEMON, pkmList.get(6).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm8:
			editor.putInt(Constants.POKEMON, pkmList.get(7).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm9:
			editor.putInt(Constants.POKEMON, pkmList.get(8).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm10:
			editor.putInt(Constants.POKEMON, pkmList.get(9).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm11:
			editor.putInt(Constants.POKEMON, pkmList.get(10).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm12:
			editor.putInt(Constants.POKEMON, pkmList.get(11).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm13:
			editor.putInt(Constants.POKEMON, pkmList.get(12).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm14:
			editor.putInt(Constants.POKEMON, pkmList.get(13).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm15:
			editor.putInt(Constants.POKEMON, pkmList.get(14).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm16:
			editor.putInt(Constants.POKEMON, pkmList.get(15).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm17:
			editor.putInt(Constants.POKEMON, pkmList.get(16).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm18:
			editor.putInt(Constants.POKEMON, pkmList.get(17).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm19:
			editor.putInt(Constants.POKEMON, pkmList.get(18).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnPkm20:
			editor.putInt(Constants.POKEMON, pkmList.get(19).getNumber());
			editor.commit();

			i = new Intent(this, QuestionActivity.class);
			startActivityForResult(i, Constants.LEVELBUTTON);
			finish();
			break;
		case R.id.btnMenu:
			finish();
			break;
		}
	}

	private List<Pokemon> getPokemonByLevelFromDb(int level) throws Error {
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
		List<Pokemon> pkmList = myDbHelper.getPokemonByLevel(level);
		myDbHelper.close();
		return pkmList;
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
