package base.hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class SelenideTestBase {
    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.timeout = 4000;
        Configuration.pollingInterval = 100;
        Configuration.startMaximized = true;
    }
}