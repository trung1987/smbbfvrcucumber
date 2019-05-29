package cucumberRunner;

import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefine")
public class testRunner {

}
