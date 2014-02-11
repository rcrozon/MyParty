package com.example.myparty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button buttonConnexion ;
	Button buttonRegister ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonConnexion = (Button)findViewById(R.id.buttonConnexion);
		buttonRegister = (Button)findViewById(R.id.buttonRegister);
		buttonConnexion.setOnClickListener(this);
		buttonRegister.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	@Override
	public void onClick(View v) {
		Button b = (Button)v;
		if (v == buttonConnexion){
			Intent intent = new Intent(this, ConcertActivity.class);
	    	this.startActivity(intent);
		}else {
			Intent intent = new Intent(this, RegisterActivity.class);
	    	this.startActivity(intent);
		}
	}
}
