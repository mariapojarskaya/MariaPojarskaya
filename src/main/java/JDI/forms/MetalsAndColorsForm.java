package JDI.forms;

import JDI.entities.MetalsColorsData;
import JDI.enums.ColorsDropDown;
import JDI.enums.MetalsDropDown;
import JDI.enums.Nature;
import JDI.enums.VegetablesDropDown;
import JDI.sections.Summary;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsForm extends Form<MetalsColorsData> {

    public Summary summary;

    @FindBy(css = "[id='elements-checklist'] label")
    public CheckList<Nature> elements;

    @JDropdown(
            root = @FindBy(css = ".colors"),
            list = @FindBy(css = "a"),
            value = @FindBy(css = "button")
    )
    public Dropdown<ColorsDropDown> color;

    @JDropdown(
            root = @FindBy(css = ".metals"),
            list = @FindBy(css = "li"),
            value = @FindBy(css = "button"),
            expand = @FindBy(css = ".metals .caret")
    )
    public Dropdown<MetalsDropDown> metals;

    @JDropdown(
            root = @FindBy(css = ".salad"),
            list = @FindBy(css = "a"),
            value = @FindBy(css = "button")
    )
    public Dropdown<VegetablesDropDown> vegetables;

    @FindBy(css = "#submit-button")
    public Button submit;

    //================================methods===================================

    @Override
    public void submit(MetalsColorsData data) {
        selectSummary(data.summary);
        selectElements(data.elements);
        this.color.select(data.color);
        this.metals.select(data.metals);
        selectVegetables(data.vegetables);
        submit.click();
    }

    private void selectVegetables(String... vegetables) {
        this.vegetables.select(VegetablesDropDown.VEGETABLES);
        for (String element : vegetables) {
            this.vegetables.select(element);
        }
    }

    private void selectElements(String... elements) {
        for (String element : elements) {
            this.elements.select(element);
        }
    }

    private void selectSummary(int[] summary) {
        this.summary.setOddsSummary(summary[0]);
        this.summary.setEvenSummary(summary[1]);
    }
}