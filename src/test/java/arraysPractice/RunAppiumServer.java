package arraysPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunAppiumServer {
	public static void main(String[] args) throws IOException {
		String cmd= "C:\\Users\\ER\\AppData\\Roaming\\npm appium -a 0.0.0.0 -p 4723 --base-path wd/hub";
		ProcessBuilder builder = new ProcessBuilder(cmd.split(" "));
		Process result = builder.start();
		InputStreamReader inputStreamReader = new InputStreamReader(result.getInputStream());
		BufferedReader successMsaage = new BufferedReader(inputStreamReader);
		String line=null;
		while((line=successMsaage.readLine())!=null) {
			System.out.println(line);
		}
	}
}