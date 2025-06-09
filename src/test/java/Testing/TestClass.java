package Testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Testing.RetryListner.class)
public class TestClass {
	String s="sa";
	
	private void test() throws InterruptedException {
		// TODO Auto-generated method stub
//		Thread.sleep(5000);
		Assert.assertTrue(false,"Shashank 1");
	}

}
class TestInheritence extends TestClass{
	String s="bh";
	@Test
	public  void main()   {
		System.out.println(s);
		ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "appium -a 127.0.0.1 -p 4723 --base-path wd/hub");

        try {
            Process result = processBuilder.start();
            InputStream inputStream = result.getInputStream();
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line=bufferedReader.readLine())!=null) {
				System.out.println(line);
				if(line.contains("The server is ready to accept new connections")) {
//					break;
				}
				
			}
//            int exitCode = result.waitFor();
            System.out.println("Batch file executed with exit code: ");
        } catch (Exception e) {
        	System.out.println(e.getLocalizedMessage());
        }
	}

}