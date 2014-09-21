package com.fordroid.whoisthatpokemon.view;

import com.fordroid.whoisthatpokemon.R;
import com.fordroid.whoisthatpokemon.util.Constants;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SplashActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		// Adciona botoes para a criação do menus dinamico
		Button playBtn = (Button) findViewById(R.id.btnPlay);
		playBtn.setOnClickListener(this);
		Button scoreBtn = (Button) findViewById(R.id.btnScore);
		scoreBtn.setOnClickListener(this);
		Button settingsBtn = (Button) findViewById(R.id.btnSettings);
		settingsBtn.setOnClickListener(this);
		Button exitBtn = (Button) findViewById(R.id.btnExit);
		exitBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent i;
		
		// Verifica qual botao foi precionado e vai para a tela correspondente
		switch (v.getId()){
		case R.id.btnPlay :
			// Botao Play, vai para a tela de selecao de nivel
			i = new Intent(this, LevelSelectActivity.class);
			startActivityForResult(i, Constants.PLAYBUTTON);
			break;
		case R.id.btnScore :
			// Botao Score, abre a tela de pontuacao
			break;
		case R.id.btnSettings :
			// Botao Settings, abre a tela de configuracoes
			break;
		case R.id.btnExit :
			// Botao exit, finaliza o aplicativo
			finish();
			break;
		}
	}

}
