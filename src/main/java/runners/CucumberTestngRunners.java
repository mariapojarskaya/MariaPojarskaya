package runners;


import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/java/hw6", glue = "pageObjects")
public class CucumberTestngRunners {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}