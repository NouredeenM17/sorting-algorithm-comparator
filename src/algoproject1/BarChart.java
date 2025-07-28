
package algoproject1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Techno
 */
public class BarChart extends ApplicationFrame {
    
    public BarChart(String title) {
        super(title);
    }
    
    public BarChart(String applicationTitle, String chartTitle, String xAxisTitle, 
            String yAxisTitle, DefaultCategoryDataset dataSet) {
        
        super(applicationTitle);
        JFreeChart jFreeChartObj = ChartFactory.createBarChart(
                chartTitle,
                xAxisTitle,
                yAxisTitle,
                dataSet,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(jFreeChartObj);
        setContentPane(chartPanel);
    }
    
    public static void addToDataset(DefaultCategoryDataset ds, String[] barHeaders, Number[] barValues, String categoryName){
        for (int i = 0; i < barValues.length; i++) {
            ds.addValue(barValues[i], categoryName, barHeaders[i]);
        }
    }
    
}
