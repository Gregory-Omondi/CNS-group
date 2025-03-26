import org.jfree.chart.*;
import org.jfree.data.general.*;
import java.io.File;
import org.jfree.chart.plot.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.*;

public class Analytics {
    public static JFreeChart makeChart(){//Creates the pie chart
        DefaultPieDataset dataset= Queries.calcAverage();
        return ChartFactory.createPieChart("Average Scores",dataset,true,true,false);
    }
    public static void displayChart(){//Displays the chart3
        JFreeChart chart=makeChart();

        ChartPanel chartPanel=new ChartPanel(chart);
        JFrame frame=new JFrame("COURSE AVERAGE");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600,500);
        frame.add(chartPanel);
        frame.setVisible(true);
    }

    public static void displayTable(){
        String[] columns={"Course","Average Grade"};
        DefaultPieDataset dataset= Queries.calcAverage();
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        for (Object key : dataset.getKeys()) {
            String courseName = key.toString();
            double avgGrade = dataset.getValue(courseName).doubleValue();
            model.addRow(new Object[]{courseName, String.format("%.2f", avgGrade)});
        }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Course Averages - Table");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    public static void displayAnalytics() {
        displayChart();
        displayTable();
    }

}
