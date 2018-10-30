package hw4.ex1;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;
import pageObjects.PageElementsSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;


public class ServicePageTest extends SelenideTestBase {

    private HomePageSelenide homePage;
    private PageElementsSelenide pageElements;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
        pageElements = page(PageElementsSelenide.class);
    }

    @Test
    public void servicePageTest() {

        //1. Open test site by URL
        homePage.open(HOME_PAGE.url);

        //2. Assert Browser title
        homePage.checkTitle();

        //3. Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePage.checkLoggedUserName(PITER_CHAILOVSKII.displayName);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        //Click
        homePage.clickOnUpperSelect();

        //Check for content
        homePage.checkUpperServiceMenuContent();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        //Click
        homePage.clickOnLeftSelect();
        //Check for content
        homePage.checkLeftServiceMenuContent();

        //7. Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPageThroughTheHeaderMenu();

        //8. Check interface on Different elements page, it contains all needed elements
        pageElements.checkDifferentElementsPageContent();

        //9. Assert that there is Right Section
        pageElements.checkRightSectionExists();

        //10. Assert that there is Left Section
        pageElements.checkLeftSectionExists();

        //11. Select checkboxes
        pageElements.selectWaterAndWindCheckBoxes();

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        pageElements.checkLoggingOfCheckBoxesChecked();

        //13. Select radio
        pageElements.selectSelenRadioButton();

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        pageElements.checkLoggingOfRadioButtons();

        //15. Select in dropdown
        pageElements.selectYellowFromDropDownMenu();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value
        pageElements.checkLoggingOfDropDownMenu();

        //17. Unselect and assert checkboxes
        pageElements.unselectWaterAndWindCheckBoxes();

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        pageElements.checkLoggingOfCheckBoxesUnchecked();
    }
}