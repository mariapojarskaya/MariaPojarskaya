package JDI.sections;


import JDI.enums.HeaderMenu;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8>li>a")
    public Menu<HeaderMenu> headerMenu;
}