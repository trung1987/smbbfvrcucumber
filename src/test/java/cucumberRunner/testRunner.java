package cucumberRunner;
<<<<<<< HEAD

import cucumber.api.CucumberOptions;
=======

import cucumber.api.CucumberOptions;
>>>>>>> branch 'master' of https://bitbucket.org/smbbfvr/cucumber/src/master/
import cucumber.api.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class) //chay = JUnit
@CucumberOptions(features = "src/test/java/features", glue = "stepDefine", plugin = {
		"pretty:target/cucumber-pretty.txt", "json:target/cucumber-3.json", "junit:target/cucumber-3.xml"})
public class testRunner extends AbstractTestNGCucumberTests {

}