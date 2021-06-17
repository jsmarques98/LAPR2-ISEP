package app.ui.console;

import app.controller.SendCovidReportController;
import app.domain.model.Company;
import app.ui.console.utils.Utils;

import java.time.LocalDate;

public class SendCovidReportUI implements Runnable{

    private SendCovidReportController controller;

    public SendCovidReportUI(){
        controller = new SendCovidReportController();
    }

    @Override
    public void run() {

        LocalDate now = LocalDate.now();
        System.out.println("Current date: " + now);
        Company.dateList.clear();

        int hPoints = selectHPoints();
        LocalDate minData = now.minusDays(hPoints);

        for (int i = 0; i < hPoints; i++) {
            Company.dateList.add(minData.plusDays(i));
        }

        // Apenas para demonstração
        for (int i = 0; i < Company.dateList.size(); i++) {
            System.out.println(Company.dateList.get(i));
        }

        LocalDate iDate = selectInitialDate();
        LocalDate fDate = selectFinalDate(iDate);

        System.out.println("Initial: " + iDate + "\nFinal: " + fDate);

    }


    private int selectHPoints() {
        int hPoints = Utils.readIntegerFromConsole("Enter the number of historical day points: ");
        if(Utils.confirm()){
            return hPoints;
        }
        return selectHPoints();
    }

    public LocalDate selectInitialDate(){
        String date = Utils.readLineFromConsole("Enter the begining date: ");
        LocalDate iDate = LocalDate.parse(date);
        if(Company.dateList.contains(iDate)){
            return iDate;
        }
        System.out.println("Invalid Date");
        return selectInitialDate();
    }


    public LocalDate selectFinalDate(LocalDate iDate){
        String date = Utils.readLineFromConsole("Enter the ending date: ");
        LocalDate fDate = LocalDate.parse(date);
        if(Company.dateList.contains(fDate) && iDate.compareTo(fDate) < 0){
            return fDate;
        }
        System.out.println("Invalid Date");
        return selectFinalDate(iDate);
    }

}
