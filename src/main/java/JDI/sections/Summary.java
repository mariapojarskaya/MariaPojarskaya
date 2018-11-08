package JDI.sections;

import JDI.enums.Radios;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

import static JDI.enums.Radios.getValueOf;

public class Summary extends Section {

    @FindBy(css = "#odds-selector .radio")
    public RadioButtons<Radios> oddsSummary;

    @FindBy(css = "#even-selector .radio")
    public RadioButtons<Radios> evenSummary;

    public void setOddsSummary(int oddSummary) {

        this.oddsSummary.select(Objects.requireNonNull(getValueOf(oddSummary)));
    }

    public void setEvenSummary(int evenSummary) {

        this.evenSummary.select(Objects.requireNonNull(getValueOf(evenSummary)));
    }
}