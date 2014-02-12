package lists;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import charts.ChartPersonsIn;
import charts.ChartTarif;
import charts.ChartTicketsSold;

public class StatsList extends ListView {

	Adapter adapter ;
	ChartTicketsSold chartTicketSold ;
	ChartTarif chartTarif ;
	ChartPersonsIn chartPersonsIn ;
	LinearLayout layout ;
	
	public StatsList(final Context context) {
		super(context);
		layout = new LinearLayout(context);
		layout.setOrientation(LinearLayout.VERTICAL);
		chartTicketSold = new ChartTicketsSold(context);
		chartTarif = new ChartTarif(context); 
		chartPersonsIn = new ChartPersonsIn(context);
		HashMap<String , Integer> tariffs = new HashMap<String, Integer>();
		tariffs.put("Etudiant", 15);
		tariffs.put("Normal", 24);
		tariffs.put("Sénior", 5);
		chartTicketSold.createChart(chartTicketSold.createDataset(8, 12));
		chartTarif.createChart(chartTarif.createDataset(tariffs));
		chartPersonsIn.createChart(chartPersonsIn.createDataset(52, 12));
		ArrayList<Items> charts = new ArrayList<Items>();
		charts.add(chartPersonsIn);
		charts.add(chartTicketSold);
		charts.add(chartTarif);
		adapter = new Adapter(context, charts);
		this.setAdapter(adapter);
	}

}
