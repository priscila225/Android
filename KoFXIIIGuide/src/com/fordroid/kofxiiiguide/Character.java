package com.fordroid.kofxiiiguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Character extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.character);
		
		// Recupera informações enviadas pela página anterior (CharSelection.java)
		String completeName = getIntent().getExtras().get("completeName").toString().toUpperCase();
		String character = getIntent().getExtras().get("characterSelected").toString();
				
		// Cria objetos para interação com objetos da interface
		TextView txtName = (TextView)findViewById(R.id.charName);
		ImageView imgHeader = (ImageView)findViewById(R.id.imgHeader);
		
		// Recupera id da imagem com o caminhos montado apartir do nome enviado pela página anterior
		int headerImgId = getResources().getIdentifier("character_header_" + character, "drawable", getBaseContext().getPackageName());
		
		// Seta imagem
		imgHeader.setImageResource(headerImgId);
		
		// Seta o nome
		txtName.setText(completeName);
	}
}
