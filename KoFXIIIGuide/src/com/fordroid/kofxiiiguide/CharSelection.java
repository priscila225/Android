package com.fordroid.kofxiiiguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class CharSelection extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.char_selection);
		
		((ImageButton)findViewById(R.id.imgBtn1)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "kyo");
				intencion.putExtra("completeName", "Kyo Kusanagi");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn2)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "benimaru");
				intencion.putExtra("completeName", "Benimaru Nikaido");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn3)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "daimon");
				intencion.putExtra("completeName", "Goro Daimon");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn4)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "terry");
				intencion.putExtra("completeName", "Terry Bogard");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn5)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "andy");
				intencion.putExtra("completeName", "Andy Bogard");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn6)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "joe");
				intencion.putExtra("completeName", "Joe Higashi");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn7)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "ryo");
				intencion.putExtra("completeName", "Ryo Sakazaki");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn8)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "robert");
				intencion.putExtra("completeName", "Robert Garcia");
				startActivity(intencion);
			}
		});
		
		((ImageButton)findViewById(R.id.imgBtn9)).setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intencion = new Intent(getBaseContext(), Character.class);
				intencion.putExtra("characterSelected", "takuma");
				intencion.putExtra("completeName", "Takuma Sakazaki");
				startActivity(intencion);
			}
		});
	}
}
