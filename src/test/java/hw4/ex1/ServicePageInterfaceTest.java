package hw4.ex1;

import base.hw4.SelenideTestBase;
import enums.Titles;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.DifferentElementsPageSelenide;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxItems.WATER;
import static enums.CheckBoxItems.WIND;
import static enums.DropDownItems.YELLOW;
import static enums.RadioButtonItems.SELEN;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")

@Story("Different Elements Page Testing")

@Listeners(AllureAttachmentListener.class)


public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private DifferentElementsPageSelenide differentElementsPageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementsPageSelenide = page(DifferentElementsPageSelenide.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle();

        //3. Perform login
        homePageSelenide.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkLoginTitle(Titles.LOGIN_TITLE);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.headServiceButtonClick();
        homePageSelenide.checkServiceDropDownContains(true);

        //6. Click on Service subcategory in the left section and check that drop down contains options
        homePageSelenide.leftServiceButtonClick();
        homePageSelenide.checkServiceDropDownContains(true);

        //7. Open through the header menu Service -> Different Elements Page
        homePageSelenide.headServiceButtonClick();
        homePageSelenide.differentElementsButtonClick();
        differentElementsPageSelenide.checkTitle();

        //8. Check interface on Different elements page, it contains all needed elements
        differentElementsPageSelenide.checkDifElPageExists();

        //9. Assert that there is Right Section
        differentElementsPageSelenide.checkRightSection();

        //10. Assert that there is Left Section
        differentElementsPageSelenide.checkLeftSection();

        //11. Select checkboxes
        differentElementsPageSelenide.selectCheckBoxes(WATER);
        differentElementsPageSelenide.selectCheckBoxes(WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPageSelenide.checkCheckBoxesLogs(WIND, WATER);

        //13. Select radio
        differentElementsPageSelenide.selectRadioButton(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPageSelenide.checkRadioButtonLog(SELEN);

        //15. Select in dropdown
        differentElementsPageSelenide.selectDropDownButton(YELLOW);

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPageSelenide.checkDropDownLog(YELLOW);

        //17. Unselect and assert checkboxes
        differentElementsPageSelenide.selectCheckBoxes(WATER);
        differentElementsPageSelenide.selectCheckBoxes(WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        differentElementsPageSelenide.checkCheckBoxesLogs(WIND, WATER);
    }
}