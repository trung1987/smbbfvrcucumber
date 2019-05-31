package stepDefine;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Actions.LoginAction;
import Interface.LoginInterface;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Method;

public class loginStep {

	static WebDriver driver;
	LoginAction login;

	@Given("^Open Chrome and navigate$")
	public void open_Chrome_and_navigate() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "." + File.separator + "libs" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		login = new LoginAction(driver);
		login.openBrowser();
	}
	

	@When("^I input correct \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_input_correct_username_and_password(String username, String password) throws Throwable {
		/// Login form
		login = new LoginAction(driver);
		login.enterUserName(username);
		login.enterPass(password);
		login.clickLogin();
		
	}

	@Then("^I login success$")
	public void i_login_success() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		Method method = new Method();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (method.checkExist(driver, LoginInterface.cusName)) {

			System.out.println("SUCCESS");
		} else {

			System.out.println("FAIL");
		}
	}

}
