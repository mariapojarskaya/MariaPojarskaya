package JDI.sections;

import JDI.enums.EvenRadioButtons;
import JDI.enums.OddRadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class Summary extends Section {

    @FindBy(css = "#odds-selector p")
    public RadioButtons<OddRadioButtons> oddRadioButtons;

    @FindBy(css = "#even-selector p")
    public RadioButtons<EvenRadioButtons> evenRadioButtons;
}
