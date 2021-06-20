package app.controller;
import app.domain.model.Test;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.transform.Scale;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OverviewTestsController {
    Company company;
    List<Test> tests;

    public static Date earlyDate;
    public static Date lateDate;

    public static LineChart<Number,Number> dailyEntries;
    public static LineChart<Number,Number> weeklyEntries;
    public static LineChart<Number,Number> monthlyEntries;
    public static LineChart<Number,Number> yearlyEntries;

    public OverviewTestsController(){
        this.company = App.getInstance().getCompany();

        /*
        1-the number of clients,
        2-the number of tests waiting for results,
        3-the number of tests waiting for diagnosis
        4-the total number of tests processed (tests validated) in the laboratory in each day,
        week, month and year.
        The system should show these statistics for a given interval that should be selected/defined by the user

         */

        int numClients = company.clientsList.size();
        int testsWaitingResults = company.getTestsWaitingResults().size();
        int testsWaitingDiagnosis = company.getTestsWaitingDiagnosis().size();

        tests = company.getTestsValidated();
        int testsValidated = company.tests.size();

        System.out.println("Total Clients: " + numClients);
        System.out.println("Tests Waiting Results: " + testsWaitingResults);
        System.out.println("Tests Waiting Diagnosis: " + testsWaitingDiagnosis);
        System.out.println("Tests Validated: " + testsValidated);

        earlyDate = getEarliestDate(tests);
        lateDate = getLatestDate(tests);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Earliest Date: " + sdf.format(earlyDate));
        System.out.println("Latest Date: " + sdf.format(lateDate));

    }

    public boolean setEarlyDateUser(String earlyDateUsr){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            earlyDate = sdf.parse(earlyDateUsr);
        } catch (ParseException e) {
            System.out.println("Illegal format, should be dd-MM-yyyy");
            return false;
        }
        System.out.println("Chosen: " + sdf.format(earlyDate));
        return true;
    }

    public boolean setLateDateUser(String lateDateUsr){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            lateDate = sdf.parse(lateDateUsr);
        } catch (ParseException e) {
            System.out.println("Illegal format, should be dd-MM-yyyy");
            return false;
        }
        System.out.println("Chosen: " + sdf.format(lateDate));
        return true;
    }


    private Date getEarliestDate(List<Test> tests){
        Date earlyDate = tests.get(0).getTest_Validation_DateHour();

        for (Test test : tests)
            if(earlyDate.compareTo(test.getTest_Validation_DateHour())>0)
                earlyDate = test.getTest_Validation_DateHour();

        return earlyDate;

        //Mon May 17 19:50:00 WEST 2021
    }

    private Date getLatestDate(List<Test> tests){
        Date lateDate = tests.get(0).getTest_Validation_DateHour();

        for (Test test : tests)
            if(lateDate.compareTo(test.getTest_Validation_DateHour())<0)
                lateDate = test.getTest_Validation_DateHour();

        return lateDate;

        //Tue Jun 01 16:43:00 WEST 2021
    }
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

    public ArrayList<ArrayList<Integer>> getDailyTests(){
        Date earlyDate = this.getEarliestDate(tests);
        Date lateDate = this.getLatestDate(tests);

        ArrayList<ArrayList<Integer>> returnDailyTests = new ArrayList<>();

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(earlyDate);

        Calendar finalDate = Calendar.getInstance();
        finalDate.setTime(lateDate);

        for (Integer i = 0; i < tests.size(); i++){

            Integer numDailyTests = 0;

            for (Test test : tests) {
                Calendar dateTest = Calendar.getInstance();
                dateTest.setTime(test.getTest_Validation_DateHour());

                if(currentDate.get(Calendar.DAY_OF_YEAR)*currentDate.get(Calendar.YEAR)==
                        (dateTest.get(Calendar.DAY_OF_YEAR)*dateTest.get(Calendar.YEAR)))
                    numDailyTests++;
            }
            ArrayList<Integer> dayTest = new ArrayList<>();
            dayTest.add(currentDate.get(Calendar.DAY_OF_YEAR));
            dayTest.add(numDailyTests);
            returnDailyTests.add(dayTest);

            currentDate.roll(Calendar.DAY_OF_YEAR,true);
        }
        return returnDailyTests;
    }

    public ArrayList<ArrayList<Integer>> getWeeklyTests(){
        Date earlyDate = this.getEarliestDate(tests);
        Date lateDate = this.getLatestDate(tests);

        ArrayList<ArrayList<Integer>> returnWeeklyTests = new ArrayList<>();

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(earlyDate);

        Calendar finalDate = Calendar.getInstance();
        finalDate.setTime(lateDate);

        for (Integer i = 0; i < tests.size(); i++){

            Integer numDailyTests = 0;

            for (Test test : tests) {
                Calendar dateTest = Calendar.getInstance();
                dateTest.setTime(test.getTest_Validation_DateHour());

                if(currentDate.get(Calendar.WEEK_OF_YEAR)*currentDate.get(Calendar.YEAR)==
                        (dateTest.get(Calendar.WEEK_OF_YEAR)*dateTest.get(Calendar.YEAR)))
                    numDailyTests++;
            }
            ArrayList<Integer> weeklyTest = new ArrayList<>();
            weeklyTest.add(currentDate.get(Calendar.WEEK_OF_YEAR));
            weeklyTest.add(numDailyTests);
            returnWeeklyTests.add(weeklyTest);

            currentDate.roll(Calendar.WEEK_OF_YEAR,true);
        }
        return returnWeeklyTests;
    }

    public ArrayList<ArrayList<Integer>> getMonthlyTests(){
        Date earlyDate = this.getEarliestDate(tests);
        Date lateDate = this.getLatestDate(tests);

        ArrayList<ArrayList<Integer>> returnMonthlyTests = new ArrayList<>();

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(earlyDate);

        Calendar finalDate = Calendar.getInstance();
        finalDate.setTime(lateDate);

        for (Integer i = 0; i < tests.size(); i++){

            Integer numMonthlyTests = 0;

            for (Test test : tests) {
                Calendar dateTest = Calendar.getInstance();
                dateTest.setTime(test.getTest_Validation_DateHour());

                if(currentDate.get(Calendar.MONTH)*currentDate.get(Calendar.YEAR)==
                        (dateTest.get(Calendar.MONTH)*dateTest.get(Calendar.YEAR)))
                    numMonthlyTests++;
            }
            ArrayList<Integer> weeklyTest = new ArrayList<>();
            weeklyTest.add(currentDate.get(Calendar.MONTH));
            weeklyTest.add(numMonthlyTests);
            returnMonthlyTests.add(weeklyTest);

            currentDate.roll(Calendar.MONTH,true);
        }
        return returnMonthlyTests;
    }

    public ArrayList<ArrayList<Integer>> getAnualTests(){
        Date earlyDate = this.getEarliestDate(tests);
        Date lateDate = this.getLatestDate(tests);

        ArrayList<ArrayList<Integer>> returnAnualTests = new ArrayList<>();

        Calendar currentDate = Calendar.getInstance();
        currentDate.setTime(earlyDate);

        Calendar finalDate = Calendar.getInstance();
        finalDate.setTime(lateDate);

        for (Integer i = 0; i < tests.size(); i++){

            Integer numAnualTests = 0;

            for (Test test : tests) {
                Calendar dateTest = Calendar.getInstance();
                dateTest.setTime(test.getTest_Validation_DateHour());

                if(currentDate.get(Calendar.YEAR)==
                        (dateTest.get(Calendar.YEAR)))
                    numAnualTests++;
            }
            ArrayList<Integer> annualTest = new ArrayList<>();
            annualTest.add(currentDate.get(Calendar.YEAR)-1999);
            annualTest.add(numAnualTests);
            returnAnualTests.add(annualTest);

            if(currentDate.get(Calendar.YEAR)<2025)
                currentDate.roll(Calendar.YEAR,true);
        }
        return returnAnualTests;
    }

    public void createEntries() {
        dailyEntries = createLineChart(getDailyTests(), "Number of Daily Tests","Day", "Tests");
        weeklyEntries = createLineChart(getWeeklyTests(), "Number of Weekly Tests","Week", "Tests");
        monthlyEntries = createLineChart(getMonthlyTests(), "Number of Monthly Tests","Month", "Tests");
        yearlyEntries = createLineChart(getAnualTests(), "Number of Yearly Tests","Year", "Tests");

    }
}
