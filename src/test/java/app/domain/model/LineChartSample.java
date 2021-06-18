package app.domain.model;

import app.Adapter.AlgorithmInterface;
import app.Adapter.ReflectorUtility;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;

public class LineChartSample extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Cancer Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Cancer rates");
        //populating the series with data

        AlgorithmInterface in = ReflectorUtility.AlgorithmReflection("app.Adapter.HelloAlgorithm");
        double result[][] =  in.calculate();
        System.out.println(Arrays.toString((result[0])));

        System.out.println(Arrays.toString(result[1]));

        for (int i = 0; i < result[0].length; i++) {
            series.getData().add(new XYChart.Data(result[0][i], result[1][i]));
        }

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
