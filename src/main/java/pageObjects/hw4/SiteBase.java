package pageObjects.hw4;

import com.codeborne.selenide.SelenideElement;
import enums.Urls;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

abstract class SiteBase {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    //================================checks===================================

    public void checkTitle(Urls page) {
        assertEquals(getWebDriver().getTitle(), page.title);
    }

    public void checkUsername(Users user) {

        profileButton.shouldHave(text(user.username));
    }

    public void checkLeftSectionExists() {
        leftSection.shouldBe(visible);
    }
}
