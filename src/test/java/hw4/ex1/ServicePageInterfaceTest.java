package hw4.ex1;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElementsPageSelenide;
import pageObjects.hw4.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxItems.WATER;
import static enums.CheckBoxItems.WIND;
import static enums.DropDownItems.YELLOW;
import static enums.RadioButtonItems.SELEN;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Different Elements Page Testing")
@Listeners(AllureAttachmentListener.class)

public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePage;
    private DifferentElementsPageSelenide differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPageSelenide.class);
    }

    @Test
    public void ServicePageInterfaceTest() {

        //1. Open test site by URL
        homePage.openPage();

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoginTitle(PITER_CHAILOVSKII);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePage.ServiceButtonClick();
        homePage.checkServiceDropDownContains();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePage.leftServiceButtonClick();
        homePage.checkServiceDropDownContains();

        //7. Open through the header menu Service -> Different Elements Page
        homePage.ServiceButtonClick();
        homePage.differentElementsButtonClick();
        differentElementsPage.checkTitle();

        //8. Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDifElPageExists();

        //9. Assert that there is Right Section
        differentElementsPage.checkRightSection();

        //10. Assert that there is Left Section
        differentElementsPage.checkLeftSection();

        //11. Select checkboxes
        differentElementsPage.selectCheckBoxes(WATER);
        differentElementsPage.selectCheckBoxes(WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkCheckBoxesLogs(WIND, WATER);

        //13. Select radio
        differentElementsPage.selectRadioButton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkRadioButtonLog(SELEN);

        //15. Select in dropdown
        differentElementsPage.selectDropDownButton(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.checkDropDownLog(YELLOW);

        //17. Unselect and assert checkboxes
        differentElementsPage.selectCheckBoxes(WATER);
        differentElementsPage.selectCheckBoxes(WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        differentElementsPage.checkCheckBoxesLogs(WIND, WATER);
    }
}