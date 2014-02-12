package lists;

import android.content.Context;
import android.widget.LinearLayout;
import charts.Charts;

public class StatsList extends LinearLayout {
	
	public StatsList(final Context context) {
		super(context);
		this.addView(new Charts(context));
	}

}
