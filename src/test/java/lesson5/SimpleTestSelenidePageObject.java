package lesson5;
import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;
import static java.lang.System.setProperty;

@Feature("Smoke tests")
@Story("Home Page Testing")
@Listeners(AllureAttachmentListener.class)
public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Flaky
    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        //2 Navigate
        homePageSelenide.openPage();

        //3 Assert Title
        homePageSelenide.checkTitle();

        //4 Login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //5 Check main title
        homePageSelenide.checkTitle();
    }
}