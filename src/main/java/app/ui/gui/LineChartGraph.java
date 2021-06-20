package app.ui.gui;

import app.controller.OverviewTestsController;
import app.ui.console.utils.Utils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static javafx.application.Platform.exit;


public class LineChartGraph extends Application {

    LineChart<Number,Number> createLineChart(ArrayList<ArrayList<Integer>> entries, String title, String xLabel, String yLabel){
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();

        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle(title);
        xAxis.setLabel(xLabel);
        yAxis.setLabel(yLabel);
        XYChart.Series series = new XYChart.Series();
        //series.setName("My portfolio");

        for (ArrayList<Integer> entry : entries)
            series.getData().add(new XYChart.Data(entry.get(0), entry.get(1)));

        lineChart.getData().add(series);

        //Creating the scale transformation
        Scale scale = new Scale();

        //Setting the dimensions for the transformation
        scale.setX(1);
        scale.setY(0.7);
        lineChart.getTransforms().addAll(scale);

        return lineChart;
    }



    @Override public void start(Stage stage) throws FileNotFoundException {
        //stage.setTitle("Line Chart Sample");

        OverviewTestsController overviewTestsController;
        try {
            overviewTestsController = new OverviewTestsController();
            while (!overviewTestsController.setEarlyDateUser(Utils.readLineFromConsole("Insert early date:")));
            while (!overviewTestsController.setEarlyDateUser(Utils.readLineFromConsole("Insert late date:")));

            overviewTestsController.createEntries();
            FlowPane root = new FlowPane();

            root.getChildren().addAll(OverviewTestsController.dailyEntries,
                    OverviewTestsController.weeklyEntries,
                    OverviewTestsController.monthlyEntries,
                    OverviewTestsController.yearlyEntries);
            Scene scene  = new Scene(root, 1010,675);
            stage.setScene(scene);
            stage.show();

        } catch (IndexOutOfBoundsException e){
            System.out.println("There are no tests to show!");
            exit();
        }

    }

    public static void main(String[] args) {
        launch(null);
    }
}
