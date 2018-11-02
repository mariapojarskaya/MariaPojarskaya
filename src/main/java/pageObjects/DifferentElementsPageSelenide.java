package pageObjects;

import com.codeborne.selenide.SelenideElement;
import enums.CheckBoxItems;
import enums.DropDownItems;
import enums.RadioButtonItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.mainPage.Titles.DIFFERENT_ELEMENTS_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPageSelenide {

    @FindBy(css = ".label-checkbox > input")
    private List<SelenideElement> checkBoxes;

    @FindBy(css = ".label-radio > input")
    private List<SelenideElement> radioButtons;

    @FindBy(css = "option")
    private List<SelenideElement> dropDownItems;

    @FindBy(css = ".colors")
    private SelenideElement dropDown;

    @FindBy(css = ".main-content-hg .uui-button")
    private List<SelenideElement> buttons;

    @FindBy(css = ".sidebar-menu")
    private SelenideElement leftSection;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement lightSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private List<SelenideElement> logs;

    //==============================methods==================================

    @Step
    public void selectCheckBoxes(CheckBoxItems item) {
        assertTrue(checkBoxes.size() >= item.counter);
        iterateButtons(item.counter, checkBoxes);
    }

    @Step
    public void selectRadioButton(RadioButtonItems item) {
        assertTrue(radioButtons.size() >= item.counter);
        iterateButtons(item.counter, radioButtons);
    }

    @Step
    public void selectDropDownButton(DropDownItems item) {
        assertTrue(dropDownItems.size() >= item.counter);
        iterateButtons(item.counter, dropDownItems);
    }

    private void iterateButtons(int count, List<SelenideElement> items) {
        int i = 0;
        for (SelenideElement item : items) {
            if (i == count) {
                item.click();
            }
            ++i;
        }
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFFERENT_ELEMENTS_TITLE.getTitle());
    }

    @Step
    public void checkDifElPageExists() {
        checkCheckBoxes();
        checkCheckRadios();
        checkDropDown();
        checkButtons();
    }

    @Step
    private void checkCheckBoxes() {
        for (SelenideElement RadioButton : radioButtons) {
            RadioButton.shouldBe(visible);
        }
    }

    @Step
    private void checkCheckRadios() {
        for (SelenideElement CheckBox : checkBoxes) {
            CheckBox.shouldBe(visible);
        }
    }

    @Step
    private void checkDropDown() {
        dropDown.shouldBe(visible);
    }

    @Step
    private void checkButtons() {
        for (SelenideElement Button : buttons) {
            Button.shouldBe(visible);
        }
    }

    @Step
    public void checkRightSection() {
        lightSection.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step
    public void checkCheckBoxesLogs(CheckBoxItems item, CheckBoxItems item2) {
        Iterator<SelenideElement> log = logs.iterator();
        iterateCheckBoxes(item.counter, item.value, log.next().getText());
        iterateCheckBoxes(item2.counter, item2.value, log.next().getText());
    }

    @Step
    private void iterateCheckBoxes(int count, String value, String expected) {
        int i = 0;
        for (SelenideElement item : checkBoxes) {
            if (i == count) {
                checkCheckBoxLog(value, item.is(selected), expected);
            }
            ++i;
        }
    }

    @Step
    private void checkCheckBoxLog(String value, boolean isChecked, String expected) {
        assertTrue(expected.contains(value));
        assertTrue(expected.contains(String.valueOf(isChecked)));
    }

    @Step
    public void checkLog(String value) {
        String lastLogText = logs.get(0).getText();
        assertTrue(lastLogText.contains(value));
    }

    @Step
    public void checkRadioButtonLog(RadioButtonItems item) {
        checkLog(item.value);
    }

    @Step
    public void checkDropDownLog(DropDownItems item) {
        checkLog(item.value);
    }
}