package JDI.pages;

import JDI.enums.ColorsDropDown;
import JDI.enums.Elements;
import JDI.enums.MetalsDropDown;
import JDI.enums.VegetablesDropDown;
import JDI.sections.Summary;
import JDI.utils.MetalsAndColorsPageData;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.ComboBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static JDI.JDISite.header;
import static JDI.enums.HeaderMenu.METALS_AND_COLORS;
import static JDI.enums.Results.*;
import static JDI.enums.VegetablesDropDown.VEGETABLES;

public class MetalsAndColorsPage extends WebPage {

    @FindBy(css = "#summary-block")
    public Summary summary;

    @FindBy(css = "#elements-checklist p")
    public CheckList<Elements> checkList;

    @JDropdown(
            root = @FindBy(css = "#colors"),
            list = @FindBy(css = "li"))
    public Dropdown<ColorsDropDown> colorsDropDown;

    // TODO
    @JComboBox(
            root = @FindBy(css = ".metals"),
            value = @FindBy(css = "input"))
    public ComboBox<MetalsDropDown> metalsDropDown;


    @JDropdown(
            root = @FindBy(css = ".salad .dropdown-menu"),
            list = @FindBy(css = "a"))
    public Dropdown<VegetablesDropDown> vegetablesDropList;

    @FindBy(css = "#salad-dropdown")
    public Button saladButton;

    @FindBy(css = "#submit-button")
    public Button submitButton;

    public List<String> expectedResult;


    public static void goToMetalsAndColorsPage() {

        header.headerMenu.select(METALS_AND_COLORS);
    }

    public void fillForm(MetalsAndColorsPageData data) {
        expectedResult = new ArrayList<>();
        int sum = 0;
        for (int i : data.getSummary()) {
            if (i % 2 == 0) {
                summary.evenRadioButtons.select(String.valueOf(i));
                sum += i;
            } else {
                summary.oddRadioButtons.select(String.valueOf(i));
                sum += i;
            }
        }
        expectedResult.add(SUMMARY.value + sum);

        String resultElement = "";
        resultElement = ELEMENTS.value + data.getElements()[0];
        for (int i = 0; i < data.getElements().length; i++) {
            checkList.select(data.getElements()[i]);
            if (i > 0) {
                resultElement += ", " + data.getElements()[i];
            }
        }

        expectedResult.add(resultElement);

        colorsDropDown.setValue(data.getColor());
        expectedResult.add(COLOR.value + data.getColor());

        metalsDropDown.setValue(data.getMetals());
        expectedResult.add(METAL.value + data.getMetals());

        saladButton.click();
        vegetablesDropList.select(VEGETABLES);
        String resultSalad = VEGETABLE.value + data.getVegetables()[0];
        for (int i = 0; i < data.getVegetables().length; i++) {
            vegetablesDropList.select(data.getVegetables()[i]);
            if (i > 0) {
                resultSalad += ", " + data.getVegetables()[i];
            }
        }
        vegetablesDropList.close();
        expectedResult.add(resultSalad);
        submitButton.click();
    }
}
