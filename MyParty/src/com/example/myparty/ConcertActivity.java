package com.example.myparty;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ConcertActivity extends Activity implements OnClickListener{

	Button buttonConcerts ;
	Button buttonScan ;
	Button buttonStats ;
	ViewFlipper view_flipper ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_concerts);
		buttonConcerts = (Button)findViewById(R.id.buttonConcerts);
		buttonScan = (Button)findViewById(R.id.buttonScan);
		buttonStats = (Button)findViewById(R.id.buttonStats);
		view_flipper = (ViewFlipper)findViewById(R.id.view_flipper);
		buttonConcerts.setOnClickListener(this);
		buttonScan.setOnClickListener(this);
		buttonStats.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Button b = (Button)v;
		int index = view_flipper.getDisplayedChild();
		int nextIndex ;
		buttonConcerts.setBackgroundResource(R.drawable.button_unselected);
		buttonScan.setBackgroundResource(R.drawable.button_unselected);
		buttonStats.setBackgroundResource(R.drawable.button_unselected);
		if (b == buttonConcerts){
			nextIndex = 0;
			buttonConcerts.setBackgroundResource(R.drawable.button_selected);
		}else if (b == buttonScan){
			nextIndex = 1;
			buttonScan.setBackgroundResource(R.drawable.button_selected);
		}else{
			nextIndex = 2;
			buttonStats.setBackgroundResource(R.drawable.button_selected);
		}
		if (nextIndex != index){
			if (nextIndex > index){
				view_flipper.setInAnimation(this, R.anim.in_from_right);
				view_flipper.setOutAnimation(this, R.anim.out_to_left);
			}else{
				view_flipper.setInAnimation(this, R.anim.in_from_left);
				view_flipper.setOutAnimation(this, R.anim.out_to_right);
			}
			view_flipper.setDisplayedChild(nextIndex);	
		}
		
	}
	
}
