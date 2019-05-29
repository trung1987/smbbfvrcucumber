package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method {

	public void input(WebDriver driver, String xpath, String input) {
		WebElement inputField = driver.findElement(By.xpath(xpath));
		inputField.sendKeys(input);
	}

	public void click(WebDriver driver, String xpath) {
		WebElement clickField = driver.findElement(By.xpath(xpath));
		clickField.click();
	}

	public void clearData(WebDriver driver, String xpath) {
		WebElement clearField = driver.findElement(By.xpath(xpath));
		clearField.clear();

		new Actions(driver).moveToElement(clearField).perform();
	}

	public void focusField(WebDriver driver, String xpath) {
		WebElement clearField = driver.findElement(By.xpath(xpath));
		new Actions(driver).moveToElement(clearField).perform();
	}

	public void clickWhenClickable(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		element.click();
	}

	public boolean checkExist(WebDriver driver, String xpath) {
		Boolean isExist = false;

		if (driver.findElements(By.xpath(xpath)).size() > 0) {
			isExist = true;
			return isExist;
		} else {
			return isExist;
		}
	}

}
