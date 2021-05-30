package app.controller.utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtil {

    public void createFile(String s){

        try {
            File myObj = new File(s);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeFile(String s){
        try {
            FileWriter myWriter = new FileWriter(s);
            myWriter.write("Your tests are now available in the app!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}



