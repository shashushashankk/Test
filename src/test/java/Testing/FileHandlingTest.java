package Testing;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileHandlingTest {
    @Test
    void CreateFile() throws IOException {
        File file  = new File("C:\\Users\\ER\\Downloads\\Shashank.pdf");
        if(file.exists()){
            file.delete();
                System.out.println("File deleted successfully");
        } else {
            if(file.createNewFile()){
                System.out.println("File created successfully");
            } else {
                System.out.println("Failed to create the file");
            }
        }

    }
}
