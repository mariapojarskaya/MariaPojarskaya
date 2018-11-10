package JDI.forms;

import JDI.enums.Users;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<Users> {

    @FindBy(id = "Name")
    public TextField name;
    @FindBy(id = "Password")
    public TextField password;

    @FindBy(css = "[type=submit]")
    public Button enter;
}