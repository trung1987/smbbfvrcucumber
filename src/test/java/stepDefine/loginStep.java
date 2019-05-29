package stepDefine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.Method;

public class loginStep {

	static WebDriver driver;

	@Given("^Open Chrome and navigate$")
	public void open_Chrome_and_navigate() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D://selenium-java-3.141.59/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String url = "http://bb.test.php:40080/index.php?option=com_dashboard&view=login#/customer?customerId=BBC-00000235&action=view&view=frame";
		driver.get(url);
	}

	@When("^I input correct \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_input_correct_username_and_password(String username, String password) throws Throwable {
		/// Login form
		Method method = new Method();

		String usernameXpath = "//input[@id='username']";
//		String usernameInput = "jay";
		String usernameInput = username;
		method.input(driver, usernameXpath, usernameInput);

		String passwordXpath = "//input[@id='password']";
//		String passwordInput = "P2ssword";
		String passwordInput = password;
		method.input(driver, passwordXpath, passwordInput);

		String loginXpath = "//button[@id='submit-button']";
		method.click(driver, loginXpath);
	}

	@Then("^I login success$")
	public void i_login_success() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String cusName = "//a[@title='Jay Nguyen']";
		Method method = new Method();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (method.checkExist(driver, cusName)) {

			System.out.println("SUCCESS");
		} else {

			System.out.println("FAIL");
		}
	}

}
