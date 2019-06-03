package utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasedTest {
	public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter; //tao file html report , nen de o beforeTest , ko dc de o beforeclass
    public static ExtentBDDReporter bddReporter;
    public static ExtentTest test;
    public static ExtentReports extent;
    
	
	@Parameters({"browser"})
	@BeforeTest
	public void openBrowser(String browser) {
		
		//khoi tao
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/my_report/Automation.xml"); //khai bao 1 file html report
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter); //save data len html report
		
		
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void saveReport() {
		extent.flush();
	}
	
	@AfterTest
	public void cleanUp() throws IOException {
		driver.quit();
		String cmd = "taskkill /F /IM chromedriver.exe";
		if (System.getProperty("os.name").contains("Win")) {
			Runtime.getRuntime().exec(cmd);
		}
	}
	
	
}
