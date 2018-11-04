package hw5;

import base.hw4.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw4.DifferentElementsPage;
import pageObjects.hw4.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckBoxes.WATER;
import static enums.CheckBoxes.WIND;
import static enums.DropDown.YELLOW;
import static enums.RadioButtons.SELEN;
import static enums.ServiceItems.getServiceItems;
import static enums.Urls.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Service page interface testing")
@Listeners(AllureAttachmentListener.class)

public class ServicePageInterfaceTest extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;
    private DifferentElementsPage differentElementsPage;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
        differentElementsPage = page(DifferentElementsPage.class);
    }

    @Test
    public void differentElementsPageTest() {

        //1. Open test site by URL
        homePageSelenide.openPage();

        //2. Assert Browser title
        homePageSelenide.checkTitle(HOME_PAGE);

        //3. Perform login
        homePageSelenide.login(PITER_CHAILOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenide.checkUsername(PITER_CHAILOVSKII);

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        homePageSelenide.checkServiceDropdownContains(getServiceItems());

        //6. Click on Service subcategory in the left section and check that drop down contains options

        homePageSelenide.checkServiceLeftDropdownContains(getServiceItems());

        //7 Open through the header menu Service -> Different Elements Page
        homePageSelenide.openDiffElements();

        //8 Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDiffElementsPageInterface();

        //9 Assert that there is Right Section
        differentElementsPage.checkRightSectionExists();

        //10 Assert that there is Left Section
        differentElementsPage.checkLeftSectionExists();

        //11 Select checkboxes
        differentElementsPage.selectCheckboxes(true, WATER, WIND);

        //12 Assert that for each checkbox there is an individual log row and value is corresponded to the status
        // of checkbox. 
        differentElementsPage.checkLogCheckboxes(WIND, WATER);

        //13 Select radio
        differentElementsPage.selectRadio(SELEN);

        //14 Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLogRadios(SELEN);

        //15 Select in dropdown
        differentElementsPage.selectInDropdown(YELLOW);

        //16 Assert that for dropdown there is a log row
        // and value is corresponded to the selected value. 
        differentElementsPage.checkLogDropdown(YELLOW);

        //17 Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(false, WATER, WIND);

        //18 Assert that for each checkbox there is an individual log row and value is corresponded to the status
        // of checkbox. 
        differentElementsPage.checkLogCheckboxes(WIND, WATER);
    }

}
