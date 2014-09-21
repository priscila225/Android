package com.fordroid.gameheroequiz.view;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.util.Constants;
import com.fordroid.gameheroequiz.view.LevelSelectActivity;
import com.fordroid.gameheroequiz.view.ScoreActivity;
import com.fordroid.gameheroequiz.view.SettingsActivity;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements OnClickListener {

	private static final int RESULT_SETTINGS = 1;
	private AdView adView;
	private String ID = "a151fd188a3a652";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Adciona botoes para a criação do menus dinamico
		Button playBtn = (Button) findViewById(R.id.btnPlay);
		playBtn.setOnClickListener(this);
		Button scoreBtn = (Button) findViewById(R.id.btnScore);
		scoreBtn.setOnClickListener(this);
		Button settingsBtn = (Button) findViewById(R.id.btnSettings);
		settingsBtn.setOnClickListener(this);
		Button exitBtn = (Button) findViewById(R.id.btnExit);
		exitBtn.setOnClickListener(this);
		
		adView = new AdView(this, AdSize.BANNER, ID);

		// Lookup your LinearLayout assuming it's been given
		// the attribute android:id="@+id/mainLayout"
		LinearLayout layout = (LinearLayout) findViewById(R.id.LinearLayout1);
		// Add the adView to it
		layout.addView(adView);
		// Initiate a generic request to load it with an ad
		adView.loadAd(new AdRequest());
	}

	@Override
	public void onClick(View v) {
		Intent i;

		// Verifica qual botao foi precionado e vai para a tela correspondente
		switch (v.getId()) {
		case R.id.btnPlay:
			// Botao Play, vai para a tela de selecao de nivel
			i = new Intent(this, LevelSelectActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
			break;
		case R.id.btnScore:
			// Botao Score, abre a tela de pontuacao
			i = new Intent(this, ScoreActivity.class);
			startActivityForResult(i, Constants.SCOREBUTTON);
			break;
		case R.id.btnSettings:
			// Botao Settings, abre a tela de configuracoes
			i = new Intent(this, SettingsActivity.class);
			startActivityForResult(i, RESULT_SETTINGS);
			break;
		case R.id.btnExit:
			// Botao exit, finaliza o aplicativo
			finish();
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.d("Teste", "sim");
		switch (requestCode) {
		case RESULT_SETTINGS:
			SharedPreferences sharedPrefs = PreferenceManager
					.getDefaultSharedPreferences(this);

			String difficulty = sharedPrefs.getString("DIFFICULTY", "2");
			String language = sharedPrefs.getString("LANGUAGE", "1");

			Log.d("DIFFICULTY", difficulty);
			Log.d("LANGUAGE", language);

			SharedPreferences settings = getSharedPreferences(
					Constants.SETTINGS, 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putInt(Constants.DIFFICULTY, Integer.parseInt(difficulty));
			editor.putInt(Constants.LANGUAGE, Integer.parseInt(language));
			editor.commit();

			break;

		}
	}

}
