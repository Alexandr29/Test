import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;


public class BarChart_AWT extends JPanel {


    public BarChart_AWT(String chartTitle, int x ) {
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Category",
                "Score",
                createDataset(x),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel( barChart );
        chartPanel.repaint();
        chartPanel.setPreferredSize(new java.awt.Dimension( 1000 ,800  ) );
        add( chartPanel);
        setVisible(true);
        System.out.println(x);

    }
    public double tmp;
    private CategoryDataset createDataset(int x ) {
        String[] arr2 = new String[100];
        double arr1[] = new double[100];
        final String speed = "Array";



        final DefaultCategoryDataset dataset =
                new DefaultCategoryDataset( );



        for (int i = 0; i < x; i++) {
            tmp = x;
            int myRandom = (int) (Math.random() * 100);
            arr1[myRandom]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = String.valueOf(i);
        }

        for (int i = 0; i < 100; i++) {
            dataset.addValue(arr1[i],arr2[i], speed);
        }

        System.out.println(arr1[1]);

        return dataset;
    }
}