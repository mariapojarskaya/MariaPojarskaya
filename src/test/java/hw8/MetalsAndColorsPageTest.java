package hw8;

import JDI.dataProviders.DataProviders;
import JDI.entities.User;
import JDI.utils.MetalsAndColorsPageData;
import org.testng.annotations.Test;

import static JDI.JDISite.*;
import static com.epam.web.matcher.testng.Assert.areEquals;


public class MetalsAndColorsPageTest extends SimpleJDITest {

    @Test(dataProvider = "dataProviders", dataProviderClass = DataProviders.class)
    public void metalsAndColorsTest(MetalsAndColorsPageData data) {

        homePage.open();

        //1. Login on JDI site as User
        login(new User());
        homePage.checkOpened();

        // TODO Take a look on IDEA warning
        //2. Open Metals & Colors page by Header menu
        metalsAndColorsPage.goToMetalsAndColorsPage();
        metalsAndColorsPage.checkOpened();

        //3. Fill form Metals & Colors by data and submit form Metals & Colors
        metalsAndColorsPage.fillForm(data);

        // TODO It is completely essential to have a hi-level method for that rather than low-level cycle...
        //4. Result sections should contains expected data
        for (int i = 0; i < metalsAndColorsPage.expectedResult.size(); i++) {
            areEquals(resultSection.result.getElement(i).getText(), metalsAndColorsPage.expectedResult.get(i));
        }

        logout();
    }
}
