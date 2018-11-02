package pageObjects;


import com.codeborne.selenide.SelenideElement;
import enums.Users;
import enums.mainPage.Titles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.ServiceItems.getServiceItemTitles;
import static enums.ServiceItems.values;
import static enums.Urls.HOME_PAGE_URL;
import static enums.mainPage.Titles.HOME_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "div.profile-photo > span")
    private SelenideElement loginTitle;

    @FindBy(css = ".m-l8 .dropdown-toggle")
    private SelenideElement serviceHeadButton;

    @FindBy(css = ".sidebar-menu .menu-title")
    private SelenideElement serviceLeftButton;

    @FindBy(css = ".m-l8 [href = 'dates.html']")
    private SelenideElement datesButton;

    @FindBy(css = ".m-l8 .dropdown-menu > li > a")
    private List<SelenideElement> headerServiceItems;

    @FindBy(css = ".sidebar-menu .menu-title [class = 'sub'] li > a")
    private List<SelenideElement> leftPannelServiceItems;

    @FindBy(css = ".m-l8 .dropdown-menu [href = 'different-elements.html']")
    private SelenideElement differentElementsButton;

    private boolean isHeader = true;

    public HomePageSelenide() {
    }

    //==============================methods==================================

    @Step
    public void openPage() {
        open(HOME_PAGE_URL.getUrl());
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void headServiceButtonClick() {
        serviceHeadButton.click();
        isHeader = true;
    }

    @Step
    public void leftServiceButtonClick() {
        serviceLeftButton.click();
        isHeader = false;
    }

    @Step
    public void datesButtonClick() {
        serviceHeadButton.click();
        datesButton.click();
    }

    @Step
    public void differentElementsButtonClick() {
        differentElementsButton.click();
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), HOME_PAGE_TITLE.getTitle());
    }

    @Step
    public void checkLoginTitle(Titles user) {
        loginTitle.shouldHave(text(user.title));
    }

    @Step
    public void checkServiceDropDownContains(boolean b) {
        if (isHeader) {
            checkDropDownContains(headerServiceItems);
        } else {
            checkDropDownContains(leftPannelServiceItems);
        }
    }

    private void checkDropDownContains(List<SelenideElement> serviceItems) {
        assertEquals(serviceItems.size(), values().length);
        ArrayList<String> actualTitles = new ArrayList<>();
        for (SelenideElement item : serviceItems) {
            actualTitles.add(item.getText().toUpperCase());
        }
        assertTrue(actualTitles.containsAll(getServiceItemTitles()));
    }
}