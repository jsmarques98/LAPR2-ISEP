package app.ui.console;

import app.controller.App;
import app.ui.console.utils.Utils;

public class RecordSamplesUI implements Runnable{
    @Override
    public void run() {
        Utils.showAndSelectIndex(App.getInstance().getCompany().getTests(), "Tests");
    }
}
