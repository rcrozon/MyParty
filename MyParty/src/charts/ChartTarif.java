package charts;

import java.util.ArrayList;
import java.util.HashMap;

import org.afree.chart.AFreeChart;
import org.afree.chart.ChartFactory;
import org.afree.chart.plot.PiePlot;
import org.afree.chart.title.TextTitle;
import org.afree.data.general.DefaultPieDataset;
import org.afree.data.general.PieDataset;
import org.afree.graphics.geom.Font;

import android.content.Context;
import android.graphics.Typeface;

public class ChartTarif extends DemoView implements Charts {


	public ChartTarif(Context context){
	    super(context);
	}
    /**
     * Creates a sample dataset.
     * @return a sample dataset.
     */
	
    public PieDataset createDataset(HashMap<String, Integer> values) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (String tarif : values.keySet()) {
        	dataset.setValue(tarif, Double.valueOf(values.get(tarif)));
        }
        return dataset;
    }

    /**
     * Creates a chart.
     * @param dataset the dataset.
     * @return a chart.
     */
    public void createChart(PieDataset dataset) {
        AFreeChart chart = ChartFactory.createPieChart("Tariffs", // chart title
										                dataset, // data
										                true, // include legend
										                true,
										                false);
//        TextTitle title = chart.getTitle();
//        title.setToolTipText("A title tooltip!");

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Typeface.NORMAL, 12));
//        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        this.setChart(chart);
    }
}
