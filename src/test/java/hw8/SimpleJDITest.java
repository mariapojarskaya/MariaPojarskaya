package hw8;


import org.testng.annotations.Test;

import static JDI.site.JDIExampleSite.homePage;
import static JDI.site.JDIExampleSite.login;


public class SimpleJDITest extends SimpleJDITestInit {

    @Test
    public void loginTest() {
        homePage.open();
        login();
        homePage.checkOpened();
    }
}
