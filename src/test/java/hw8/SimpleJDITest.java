package hw8;

import JDI.JDISite;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import org.testng.annotations.BeforeSuite;

public class SimpleJDITest extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
    }
}
