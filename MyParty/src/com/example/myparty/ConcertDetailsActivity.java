package com.example.myparty;

import scan.IntentIntegrator;
import scan.IntentResult;
import scan.ScanLayout;
import lists.ClientList;
import lists.ConcertList;
import lists.StatsList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class ConcertDetailsActivity extends Activity implements OnClickListener,OnMenuItemClickListener{

	Button buttonClients ;
	Button buttonDetails ;
	Button buttonScan ;
	Button buttonStats ;
	ImageView imgScan ;
	RelativeLayout layout_scan;
	ViewFlipper view_flipper ;
	TextView text ;
	private MenuItem decoItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_concert_details);
		buttonClients = (Button)findViewById(R.id.buttonClient);
		buttonDetails = (Button)findViewById(R.id.buttonDetails);
		buttonScan = (Button)findViewById(R.id.buttonScan);
		buttonStats = (Button)findViewById(R.id.buttonStats);
		text = (TextView)findViewById(R.id.textScan);
		imgScan = (ImageView)findViewById(R.id.imgScan);
		layout_scan = (RelativeLayout)findViewById(R.id.layout_scan);
		view_flipper = (ViewFlipper)findViewById(R.id.view_flipper);
		this.view_flipper.addView(new ClientList(this));
		this.view_flipper.addView(new ClientList(this));
		this.view_flipper.addView(new ClientList(this));
		//this.view_flipper.addView(layout_scan);
		this.view_flipper.addView(new StatsList(this));
		buttonClients.setOnClickListener(this);
		buttonDetails.setOnClickListener(this);
		buttonScan.setOnClickListener(this);
		buttonStats.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		decoItem = menu.findItem(R.id.menu_deconect);
		decoItem.setIcon(R.drawable.ic_action_location_found_green);
		decoItem.setOnMenuItemClickListener(this);
		return true;
	}

	@Override
	public void onClick(View v) {
		Button b = (Button)v;
		int index = view_flipper.getDisplayedChild();
		int nextIndex ;
		buttonClients.setBackgroundResource(R.drawable.button_unselected);
		buttonDetails.setBackgroundResource(R.drawable.button_unselected);
		buttonScan.setBackgroundResource(R.drawable.button_unselected);
		buttonStats.setBackgroundResource(R.drawable.button_unselected);
		if (b == buttonDetails){
			nextIndex = 0;
			buttonDetails.setBackgroundResource(R.drawable.button_selected);
		}else if (b == buttonClients){
			nextIndex = 1;
			buttonClients.setBackgroundResource(R.drawable.button_selected);
		}else if (b == buttonScan){
			nextIndex = 2;
			buttonScan.setBackgroundResource(R.drawable.button_selected);
		}else{
			nextIndex = 3; 
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
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanResult != null){
			String barcode;
			String typ;
			barcode = scanResult.getContents();
			typ = scanResult.getFormatName();
			text.setText(barcode + "   " + typ);
//			this.text.setFreezesText(true);
			imgScan.setBackgroundResource(R.drawable.qrcode_green);
		}
	}
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
		return false;
	}
	
}
