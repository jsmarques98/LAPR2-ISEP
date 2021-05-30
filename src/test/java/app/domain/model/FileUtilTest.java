package app.domain.model;

import app.controller.utils.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void createFile() {
        FileUtil file = new FileUtil();
        file.createFile("./results/emailAndSMSMessages.txt");
        File tmpDir = new File("./results/emailAndSMSMessages.txt");
        boolean exists = tmpDir.exists();
        assertEquals(true, exists);
    }

    @Test
    void  writeFile() throws IOException {
        FileUtil file = new FileUtil();
        file.writeFile("./results/emailAndSMSMessages.txt");
        BufferedReader objReader = new BufferedReader(new FileReader("./results/emailAndSMSMessages.txt"));
        assertEquals("Your tests are now available in the app!", objReader.readLine());
    }

}
