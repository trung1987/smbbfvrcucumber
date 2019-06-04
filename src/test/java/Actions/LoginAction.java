package Actions;

import org.openqa.selenium.WebDriver;
import Interface.LoginInterface;
import utils.Method;

public class LoginAction extends Method {
	WebDriver driverlocal;

	public LoginAction(WebDriver driver) {
		driverlocal = driver;
	}

	public void enterUserName(String input) {
		inputText(driverlocal, LoginInterface.username, input);
	}

	public void enterPass(String input) {
		inputText(driverlocal, LoginInterface.password, input);
	}

	public void clickLogin() {
		click(driverlocal, LoginInterface.loginBtn);
	}

	public void openBrowser() {
		openPage(driverlocal, LoginInterface.pageURL);
	}

	
}
