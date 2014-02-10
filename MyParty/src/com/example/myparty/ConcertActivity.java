package com.example.myparty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class ConcertActivity extends Activity {

    private float 			lastX;
    private ViewFlipper 	viewFlipper;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_concerts);
		viewFlipper = (ViewFlipper)findViewById(R.id.view_flipper);
		int gallery_grid_Images[]={R.drawable.party1,R.drawable.party2,R.drawable.party4,R.drawable.party2,R.drawable.party4};
		for(int i=0;i<gallery_grid_Images.length;i++){
            setFlipperImage(gallery_grid_Images[i]);
        }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void setFlipperImage(int res) {
	    ImageView image = new ImageView(getApplicationContext());
	    image.setBackgroundResource(res);
	    viewFlipper.addView(image);
	}
	
	public boolean onTouchEvent(MotionEvent touchevent){
    	switch (touchevent.getAction()) {
             case MotionEvent.ACTION_DOWN:  {
                 lastX = touchevent.getX();
                 break;
             }
             case MotionEvent.ACTION_UP:  {
                 float currentX = touchevent.getX();
                 if (lastX < currentX)  {
                	 if (viewFlipper.getDisplayedChild() == 0)
                         break;
                  		 viewFlipper.setInAnimation(this, R.anim.in_from_left);
                         viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                         viewFlipper.showNext();
                 }
                 if (lastX > currentX) {
                     if (viewFlipper.getDisplayedChild() == 1)
                         break;
                     viewFlipper.setInAnimation(this, R.anim.in_from_right);
                     viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                     viewFlipper.showPrevious();
                 }
                 break;
             }
    	}
    	return false;
    }
}
