package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver");
        Configuration.browser = "chrome";
//        Configuration.screenshots = false;
//        Configuration.browserSize = "1620x1080";

    }
}
