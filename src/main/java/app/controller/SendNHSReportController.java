package app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class SendNHSReportController {

    public static void dailyReportTimer()  {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        try {
            date = dateFormatter.parse("2021-06-18 6:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Timer timer = new Timer();
        int period = 86400000; // 1 day in milliseconds
        //timer.schedule(new DailyReportController(), date, period);

    }
}