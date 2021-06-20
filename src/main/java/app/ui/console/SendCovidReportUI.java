package app.ui.console;

import app.controller.App;
import app.controller.SendCovidReportController;
import app.domain.model.Company;
import app.ui.console.utils.Utils;
import java.time.LocalDate;

public class SendCovidReportUI implements Runnable{

    private SendCovidReportController controller;
    private Company company;

    public SendCovidReportUI(){
        controller = new SendCovidReportController();
        company = App.getInstance().getCompany();
    }

    @Override
    public void run() {

        LocalDate now = LocalDate.now();
        System.out.println("Current date: " + now);
        company.dateList.clear();
        company.finaldatesList.clear();

        int hPoints = selectHPoints();
        LocalDate minData = now.minusDays(hPoints);

        for (int i = 0; i < hPoints; i++) {
            company.dateList.add(minData.plusDays(i));
        }

        System.out.println("Available dates:\n" + company.dateList.toString());

        LocalDate initialDate = selectInitialDate();
        LocalDate finalDate = selectFinalDate(initialDate);

        for (int i = 0; i < (finalDate.getDayOfMonth()-initialDate.getDayOfMonth()+1); i++) {
            company.finaldatesList.add(initialDate.plusDays(i));
        }

        controller.regressionMenu();

    }

    private int selectHPoints() {
        int op = Utils.readIntegerFromConsole("Do you prefer typing: \nDays (1)\nWeeks (2)");
        if(!(op==1 || op==2)){
            System.out.println("Choose 1 for Days or 2 for Weeks");
            selectHPoints();
        }
        int hPoints = Utils.readIntegerFromConsole("Enter the number of historical points: ");
        if(op == 2){
            hPoints = hPoints * 7;
        }
        if(Utils.confirm()){
            return hPoints;
        }
        return selectHPoints();
    }

    public LocalDate selectInitialDate(){
        String date = Utils.readLineFromConsole("Enter the begining date: ");
        if(Utils.verifyDate(date)) {
            LocalDate initialDate = LocalDate.parse(date);
            if(company.dateList.contains(initialDate)){
                return initialDate;
            }
        }
        System.out.println("Invalid Date");
        return selectInitialDate();
    }

    public LocalDate selectFinalDate(LocalDate initialDate){
        String date = Utils.readLineFromConsole("Enter the ending date: ");
        if(Utils.verifyDate(date)) {
            LocalDate finalDate = LocalDate.parse(date);
            if (company.dateList.contains(finalDate) && initialDate.compareTo(finalDate) < 0) {
                return finalDate;
            }
        }
        System.out.println("Invalid Date");
        return selectFinalDate(initialDate);
    }

}
