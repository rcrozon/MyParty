package lists;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import concert.Client;

public class ClientItem extends LinearLayout implements Items{
	
	public ClientItem(Context context, Client client){
		super(context);
		this.setOrientation(VERTICAL);
		LinearLayout layoutConcertData = new LinearLayout(context);
		layoutConcertData.setOrientation(VERTICAL);

		TextView firstName = new TextView(context);
		firstName.setText(client.getFirstName());
		TextView lastName = new TextView(context);
		lastName.setText(client.getLastName());
		TextView birth = new TextView(context);
//		birth.setText(client.getBirth());
		TextView email = new TextView(context);
		email.setText(client.getEmail());
		TextView login = new TextView(context);
		login.setText(client.getLogin());
		TextView pwd = new TextView(context);
		pwd.setText(client.getPassword());
		this.addView(firstName);
		this.addView(lastName);
		this.addView(birth);
		this.addView(email);
		this.addView(login);
		this.addView(pwd);
	}
}
