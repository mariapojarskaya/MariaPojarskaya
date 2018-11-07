package JDI.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ResultSection extends Section {

    @FindBy(css = ".panel-body-list.results li")
    public TextList result;
}
