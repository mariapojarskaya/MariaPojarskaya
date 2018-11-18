package pageObjects.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxes;
import enums.DropDown;
import enums.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static enums.DropDown.category;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage extends SiteBase {

    private int buttonsSize = 2;

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio input")
    private ElementsCollection radios;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    //================================methods===================================

    @Step
    public void selectCheckboxes(boolean state, CheckBoxes... checkbox) {
        for (CheckBoxes element : checkbox) {
            selectCheckbox(state, element);
        }
    }

    @Step
    public void selectCheckbox(boolean state, CheckBoxes checkbox) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkbox.name))
                element.setSelected(state);
        }
    }

    @Step
    public void selectRadio(RadioButtons radio) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radio.name))
                element.click();
        }
    }

    @Step
    public void selectInDropdown(DropDown dropdownColor) {
        dropdown.selectOption(dropdownColor.name);
    }

    private boolean logContainsCheckbox(CheckBoxes checkbox, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + checkbox.name + ".*" + element.isSelected()))) {
                return true;
            }
        }
        return false;
    }

    private boolean logContainsRadio(String name, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + element.name() + ".*" + name))) {
                return true;
            }
        }
        return false;
    }

    private boolean logContainsDropdown(DropDown dropdownColor) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + category + ".*" + dropdown.getSelectedText())) &&
                    dropdownColor.name.equals(dropdown.getSelectedText())) {
                return true;
            }
        }
        return false;
    }

    //================================checks===================================

    @Step
    public void checkDiffElementsPageInterface() {
        checkboxes.shouldHaveSize(CheckBoxes.size);
        for (SelenideElement element : checkboxes) {
            element.shouldHave(type("checkbox"));
        }
        radios.shouldHaveSize(RadioButtons.size);
        for (SelenideElement element : radios) {
            element.shouldHave(type("radio"));
        }
        dropdown.shouldBe(visible);
        buttons.shouldHaveSize(buttonsSize);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    @Step
    public void checkRightSectionExists() {
        rightSection.shouldBe(visible);
    }

    @Step
    public void checkLogCheckboxes(CheckBoxes... checkboxes) {
        for (CheckBoxes element : checkboxes) {
            checkLogCheckbox(element);
        }
    }

    @Step
    public void checkLogRadios(RadioButtons radio) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radio.name))
                assertTrue(logContainsRadio(radio.name, element));
        }
    }

    @Step
    public void checkLogDropdown(DropDown dropdownColor) {
        assertTrue(logContainsDropdown(dropdownColor));
    }

    private void checkLogCheckbox(CheckBoxes checkbox) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkbox.name))
                assertTrue(logContainsCheckbox(checkbox, element));
        }
    }
}