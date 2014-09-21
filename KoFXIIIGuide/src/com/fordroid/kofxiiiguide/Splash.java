package com.fordroid.kofxiiiguide;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		// Thread para mostrar o Splash
		Thread splash_screen = new Thread(){
			
			public void run(){
				try{
					sleep(2000);
				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					startActivity(new Intent(getApplicationContext(),CharSelection.class));
					finish();
				}
			}
		};
		splash_screen.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
