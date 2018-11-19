package hw5.ex1;

import base.hw4.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw5.DifferentElementsPage;
import pageObjects.hw5.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.DropDown.YELLOW;
import static enums.RadioButtons.BRONZE;
import static enums.ServiceItems.getServiceItems;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Different elements page testing")
@Listeners(AllureAttachmentListener.class)
public class DifferentElementsPageSuite extends SelenideTestBase {

    private HomePage homePage;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the right-top side of screen that user is logged in
        homePage.checkUsername(PITER_CHAILOVSKII);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        homePage.checkServiceDropdownContains(getServiceItems());

        //6 Click on Service subcategory in the left section and check that drop down contains options
        homePage.checkServiceLeftDropdownContains(getServiceItems());

        //7 Open through the header menu Service -> Different Elements Page
        homePage.openDiffElements();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDiffElementsPageInterface();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionExists();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionExists();

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(true, WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status
        // of checkbox.
        differentElementsPage.checkLogCheckboxes(WIND, WATER);

        //13 Select radio
        differentElementsPage.selectRadio(BRONZE);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        differentElementsPage.checkLogRadios(BRONZE);

        //15 Select in dropdown
        differentElementsPage.selectInDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        differentElementsPage.checkLogDropdown(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(false, WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status
        // of checkbox.
        differentElementsPage.checkLogCheckboxes(WIND, WATER);
    }
}