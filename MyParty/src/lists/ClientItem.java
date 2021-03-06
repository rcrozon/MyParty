package lists;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myparty.R;

import concert.Client;

public class ClientItem extends LinearLayout implements Items{ 
	
	public ClientItem(Context context, Client client){
		super(context);
		this.setBackgroundResource(R.drawable.list_border);
		this.setOrientation(HORIZONTAL);
		LinearLayout layoutClientData = new LinearLayout(context);
		layoutClientData.setOrientation(VERTICAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT-50, 
				   															   LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(20, 0, 20, 0);
		layoutClientData.setLayoutParams(layoutParams);

		ImageView imgView = new ImageView(context);
		LayoutParams llp = new LayoutParams(140, 250, Gravity.CENTER_HORIZONTAL); 
		imgView.setBackgroundResource(R.drawable.ic_action_person);
		imgView.setLayoutParams(llp);
		this.addView(imgView);
		
		TextView firstName = new TextView(context);
		TextView lastName = new TextView(context);
		TextView birth = new TextView(context);
		TextView email = new TextView(context);
		TextView login = new TextView(context);
		TextView pwd = new TextView(context);
		
		firstName.setText(client.getFirstName());
		lastName.setText(client.getLastName());
//		birth.setText(client.getBirth());
		email.setText(client.getEmail());
		login.setText(client.getLogin());
		pwd.setText(client.getPassword());
		
		firstName.setTextColor(getResources().getColor(R.color.white));
		lastName.setTextColor(getResources().getColor(R.color.white));
		birth.setTextColor(getResources().getColor(R.color.white));
		email.setTextColor(getResources().getColor(R.color.white));
		login.setTextColor(getResources().getColor(R.color.white));
		pwd.setTextColor(getResources().getColor(R.color.white));

		layoutClientData.addView(firstName);
		layoutClientData.addView(lastName);
		layoutClientData.addView(birth);
		layoutClientData.addView(email);
		layoutClientData.addView(login);
		layoutClientData.addView(pwd);
		
		this.addView(layoutClientData); 
	}
}
