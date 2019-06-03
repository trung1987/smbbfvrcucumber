package cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) //chay = JUnit
@CucumberOptions(features = "src/test/java/features", glue = "stepDefine", plugin = {
		"pretty:target/cucumber-pretty.txt", "json:target/cucumber-3.json", "junit:target/cucumber-3.xml"})
public class testRunner extends AbstractTestNGCucumberTests {

}