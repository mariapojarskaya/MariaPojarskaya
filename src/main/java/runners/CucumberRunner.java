package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects/hw4")
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        Configuration.startMaximized = true;
    }
}
