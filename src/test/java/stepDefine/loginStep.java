package stepDefine;

import java.util.ArrayList;
import Actions.LoginAction;
import Interface.LoginInterface;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.BasedTest;
import utils.ExcelDataProvider;
import utils.Method;

public class loginStep extends BasedTest{

	LoginAction login;

	@Given("^Open Chrome and navigate$")
	public void open_Chrome_and_navigate() throws Throwable {
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

	static ArrayList<String> array = new ArrayList<String>();

	@Then("^I login success$")
	public void i_login_success() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		Method method = new Method();
		login = new LoginAction(driver);

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

		ArrayList<String> parts = new ArrayList<String>(); // khoi tao 1 table
		String[] partsA = null;
		ExcelDataProvider aaa = new ExcelDataProvider();
		array = aaa.getData("./Data/test.xlsx", "Sheet1");
		// lay gia tri tung dong de cat (split)
		for (int i = 0; i < array.size(); i++) {
			partsA = array.get(i).split(";");

			// lay gia tri moi cat bo vo 1 bang moi
			for (int j = 0; j < partsA.length; j++) {
				parts.add(partsA[j]);
			}
		}
		
			//in gia tri o vi tri can thiet
		System.out.println(parts.get(7).toString());

	}

	@After
	public void quit() {
		driver.quit();
	}
}
