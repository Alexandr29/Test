import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class BarChart_AWT extends ApplicationFrame {
    public BarChart_AWT( String applicationTitle , String chartTitle, int x ) {
        super( applicationTitle );
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(x),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
        pack( );
        RefineryUtilities.centerFrameOnScreen(this);
        setVisible(true);
    }

    private CategoryDataset createDataset(int x ) {
        String[] arr2 = new String[100];
        double arr1[] = new double[100];

        final String speed = "Speed";
        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );



        for (int i = 0; i < x; i++) {
            int myRandom = (int) (Math.random() * 100);
            arr1[myRandom]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = String.valueOf(i);
        }

        for (int i = 0; i < 100; i++) {
            dataset.addValue(arr1[i],arr2[i], speed);
        }

        return dataset;
    }

}