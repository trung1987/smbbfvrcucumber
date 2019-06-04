package utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportHandler {

	public String createFolder(long time) {
		String currentDirect = System.getProperty("user.dir");
		String dir = currentDirect + File.separator + "report" + File.separator + "error-" + time;

		System.out.println(dir);

		File file = new File(dir);
		if (!file.exists()) {
			file.mkdir();
		}
		return dir;
	}

	public void reportPrint(WebDriver driver, boolean isSuccess, String printStackTrace, long time) {
		if (isSuccess == false) {
			String dir = createFolder(time);
			PrintWriter writer;
			try {
				StringWriter err = new StringWriter();
				writer = new PrintWriter(dir + "/error.txt", "UTF-8");
				writer.println(printStackTrace);
				writer.close();

				takeSnapshot(driver, dir, "error");
				driver.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			takeSnapshot(driver, System.getProperty("user.dir") + "/report", "success");
		}

	}

	public void takeSnapshot(WebDriver driver, String filePath, String status) {
		Calendar cal = Calendar.getInstance();

		TakesScreenshot srcShot = (TakesScreenshot) driver;

		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		String path = filePath + "/" + status + "-" + cal.getTimeInMillis() + ".png";
		System.out.println(path);
		File destFile = new File(path);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void publicReport(String testProject, String testPlan, String testCase, String buildName, String note, String result) {
//		final String URL = "http://127.0.0.1/testlink/index.php";
//		final String devKey = "a48493397dbd0be5144ee9edf41fd607";
////		final String devKey = "86dc4095ea2753e6c6af1bb7f9ea259690a8178c113ba2913234394465ee78c1";
//		TestLinkAPIClient api=new TestLinkAPIClient(devKey, URL);
//		try {
//			api.reportTestCaseResult(testProject, testPlan, testCase, buildName, note, result);
//		} catch (TestLinkAPIException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
