package lesson8;

import org.testng.annotations.Test;

import static JDI.site.JDIExampleSite.homePage;
import static JDI.site.JDIExampleSite.login;


public class SimpleTest extends SimpleTestInit {

    @Test
    public void loginTest() {
        homePage.open();
        login();
        homePage.checkOpened();
    }


}
