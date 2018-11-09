package JDI.pages;

import JDI.entities.User;
import JDI.enums.Users;
import JDI.sections.Header;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;

public abstract class Login extends WebPage {

    public Header header;

    public void login(Users user) {

        header.profilePhoto.click();

        header.loginForm.loginAs(new User(user));
    }
}