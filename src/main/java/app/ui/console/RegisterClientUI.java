package app.ui.console;

import app.controller.RegisterClientController;

public class RegisterClientUI implements Runnable{

    public RegisterClientController controller;

    public RegisterClientUI(){
        controller = new RegisterClientController();
    }

    @Override
    public void run() {
        //run the controller here
    }
}
