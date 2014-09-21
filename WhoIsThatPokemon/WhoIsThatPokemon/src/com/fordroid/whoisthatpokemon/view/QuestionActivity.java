package com.fordroid.whoisthatpokemon.view;

import java.io.IOException;

import com.fordroid.whoisthatpokemon.R;
import com.fordroid.whoisthatpokemon.bd.DBHelper;
import com.fordroid.whoisthatpokemon.data.Pokemon;
import com.fordroid.whoisthatpokemon.util.Constants;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuestionActivity extends Activity implements OnClickListener{

	Pokemon pokemon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.question);
		
		EditText textBox = (EditText) findViewById(R.id.editTextPkmName);
		
		InputMethodManager imm = (InputMethodManager) getSystemService(QuestionActivity.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(textBox.getWindowToken(), 0);

		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int id = settings.getInt(Constants.POKEMON, 1);
		
		pokemon = getPokemonByIdFromDb(id);

		ImageView imgPkm = (ImageView) findViewById(R.id.imgPokemon);
		int pkmImgId = getResources().getIdentifier(pokemon.getImage1() + "_2",
					"drawable", getBaseContext().getPackageName());
		imgPkm.setImageResource(pkmImgId);
		
		
		// Button Back
		Button btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		
		// Button Check
		Button btnCheck = (Button) findViewById(R.id.btnCheck);
		btnCheck.setOnClickListener(this);
		
		// Button Next
		Button btnNext = (Button) findViewById(R.id.btnNext);
		btnNext.setOnClickListener(this);
	}

	private Pokemon getPokemonByIdFromDb(int id) throws Error {
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

		Pokemon pkm = myDbHelper.getPokemonById(id);
		myDbHelper.close();
		return pkm;
	}

	@Override
	public void onClick(View v) {
		Intent i;
		
		EditText textBox = (EditText) findViewById(R.id.editTextPkmName);		
		InputMethodManager imm = (InputMethodManager) getSystemService(QuestionActivity.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(textBox.getWindowToken(), 0);
		
		SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int dificult = settings.getInt(Constants.DIFFICULTY, 2);
		
		switch (v.getId()) {
		case R.id.btnCheck:
			String pkmName = textBox.getText().toString().toLowerCase().trim();
			
			if (pkmName.length() == 0)
				return;		
			
			Log.d("Pokemon ans", pkmName);
			Log.d("Pokemon", pokemon.getName());
			
			TextView txtAnswer = (TextView)findViewById(R.id.txtAnswer);
			if(pkmName.compareTo(pokemon.getName().toLowerCase()) == 0)
			{
				txtAnswer.setText("Correct");
				txtAnswer.setTextColor(Color.rgb(0,200,0));
				
				ImageView imgPkm = (ImageView) findViewById(R.id.imgPokemon);
				int pkmImgId = getResources().getIdentifier(pokemon.getImage1() + "_1",
							"drawable", getBaseContext().getPackageName());
				imgPkm.setImageResource(pkmImgId);
				
				if ( dificult > pokemon.getResp() )
				{
					updateRespPokemonFromDb(dificult,pokemon.getNumber());
				}
			}
			else
			{
				txtAnswer.setText("Wrong\nTry again");
				txtAnswer.setTextColor(Color.rgb(200,0,0));
			}
			
			LinearLayout rl1 = (LinearLayout) findViewById(R.id.QuestLayout);
            rl1.setVisibility(View.INVISIBLE);
			
			
			LinearLayout rl2 = (LinearLayout) findViewById(R.id.ansLayout);
            rl2.setVisibility(View.VISIBLE);
			
			break;
			
		case R.id.btnBack:
		case R.id.btnNext:
			i = new Intent(this, PokemonSelectActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
			finish();
			break;
		}
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
		myDbHelper.updateRespPokemon(resp,id);
		myDbHelper.close();
	}
}
