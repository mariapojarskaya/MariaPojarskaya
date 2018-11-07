package JDI;

import JDI.entities.User;
import JDI.pages.HomePage;
import JDI.pages.MetalsAndColorsPage;
import JDI.sections.Header;
import JDI.sections.LoginForm;
import JDI.sections.ResultSection;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

public class JDISite extends WebSite {

    @JPage(url = "/index.html", title = "Home Page")
    public static HomePage homePage;

    @JPage(url = "/metals-colors.html", title = "Metal and Colors")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static LoginForm loginForm;
    public static Header header;
    public static ResultSection resultSection;

    public static void login(User user) {
        loginForm.profilePhoto.click();
        loginForm.loginAs(user);
    }

    public static void logout() {
        loginForm.profilePhoto.click();
        loginForm.submitButton.click();
    }
}
