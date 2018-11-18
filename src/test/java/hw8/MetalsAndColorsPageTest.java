package hw8;

import JDI.base.JDITestBase;
import JDI.dataProviders.DataProviders;
import JDI.entities.MetalsColorsData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static JDI.JDISite.homePage;
import static JDI.JDISite.metalsAndColorsPage;
import static JDI.enums.HeaderMenu.METALS_COLORS;
import static JDI.enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Metals and Colors Page Testing")
public class MetalsAndColorsPageTest extends JDITestBase {

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        homePage.clearCache();
    }


    @Test(dataProvider = "metalsColorsDataProvider", dataProviderClass = DataProviders.class)
    public void MetalsAndColorsFormTest(MetalsColorsData data) {

        //1 Login on JDI site as User
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        homePage.header.menu.select(METALS_COLORS);

        //3 Fill form Metals & Colors by data from DataProvider and submit
        metalsAndColorsPage.form.submit(data);

        //4 Result sections contains data from DataProvider:
        metalsAndColorsPage.results.check(data);
    }
}
