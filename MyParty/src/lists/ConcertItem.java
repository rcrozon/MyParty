package lists;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myparty.R;

import concert.Concert;

public class ConcertItem extends LinearLayout implements Items{
	
	public ConcertItem(Context context, Concert concert){
		super(context);
		this.setOrientation(HORIZONTAL);
		LinearLayout layoutConcertData = new LinearLayout(context);
		layoutConcertData.setOrientation(VERTICAL);
		ImageView imgView = new ImageView(context);
		//LayoutParams llp = new LayoutParams(140, 140, Gravity.CENTER_HORIZONTAL); 
		//imgView.setLayoutParams(llp);
		imgView.setBackgroundResource(R.drawable.party1);
		this.addView(imgView);
		TextView title = new TextView(context);
		title.setText(concert.getTitle());
		TextView begin = new TextView(context);
		//begin.setText(concert.getBeginDate());
		TextView end = new TextView(context);
		//end.setText(concert.getEndDate());
		TextView price = new TextView(context);
		price.setText("Price : " + concert.getPrice());
		TextView location = new TextView(context);
		location.setText("Location : " + concert.getLocation());
		layoutConcertData.addView(title);
		//this.layoutConcertData.addView(begin);
		//this.layoutConcertData.addView(end);
		layoutConcertData.addView(price);
		layoutConcertData.addView(location);
		this.addView(imgView);
		this.addView(layoutConcertData);
		
		
	}

}
