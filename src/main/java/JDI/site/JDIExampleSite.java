package JDI.site;

import JDI.entities.User;
import JDI.site.pages.HomePage;
import JDI.site.sections.LoginForm;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

;

@JSite("https://epam.github.io/JDI/")

public class JDIExampleSite extends WebSite {
    public static HomePage homePage;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    @Step
    public static void login() {
        profilePhoto.click();
        loginForm.loginAs(new User());
    }
}
