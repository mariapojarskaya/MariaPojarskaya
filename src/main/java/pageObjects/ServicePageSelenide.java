package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Titles.DIFEL_PAGE_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServicePageSelenide {

    private ElementsCollection CheckBoxes = $$(By.cssSelector(".label-checkbox > input"));

    private ElementsCollection RadioButtons = $$(By.cssSelector(".label-radio > input"));

    private ElementsCollection DropDownItems = $$(By.cssSelector(".colors .uui-form-element > option"));

    private SelenideElement DropDown = $(By.cssSelector(".main-content-hg .colors"));

    private ElementsCollection Buttons = $$(By.cssSelector(".main-content-hg .uui-button"));

    private SelenideElement LeftSection = $(By.cssSelector(".sidebar-menu"));

    private SelenideElement RightSection = $(By.cssSelector(".right-fix-panel"));

    private ElementsCollection Logs = $$(By.cssSelector(".panel-body-list.logs > li"));

    //==============================methods==================================

    @Step
    public void selectCheckBoxes(int count, String value) {
        CheckBoxes.shouldBe(sizeGreaterThan(count));
        int i = 0;
        for (SelenideElement item : CheckBoxes) {
            if (i == count) {
                item.click();
                checkCheckBoxesLog(value, item.is(selected));
            }
            ++i;
        }
    }

    @Step
    public void selectRadioButton(int count, String value) {
        RadioButtons.shouldBe(sizeGreaterThan(count));
        iterateButtons(count, value, RadioButtons);
    }

    @Step
    public void selectDropDownButton(int count, String value) {
        DropDownItems.shouldBe(sizeGreaterThan(count));
        iterateButtons(count, value, DropDownItems);
    }

    private void iterateButtons(int count, String value, ElementsCollection Items) {
        int i = 0;
        for (SelenideElement item : Items) {
            if (i == count) {
                item.click();
                checkLog(value);
            }
            ++i;
        }
    }

    //==============================checks===================================

    @Step
    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), DIFEL_PAGE_TITLE.title);
    }

    @Step
    public void checkDifElPageExists() {
        this.checkCheckBoxes();
        this.checkCheckRadios();
        this.checkDropDown();
        this.checkButtons();
    }

    private void checkCheckBoxes() {
        for (SelenideElement RadioButton : RadioButtons) {
            RadioButton.shouldBe(visible);
        }
    }

    private void checkCheckRadios() {
        for (SelenideElement CheckBoxe : CheckBoxes) {
            CheckBoxe.shouldBe(visible);
        }
    }

    private void checkDropDown() {
        DropDown.shouldBe(visible);
    }

    private void checkButtons() {
        for (SelenideElement Button : Buttons) {
            Button.shouldBe(visible);
        }
    }

    @Step
    public void checkRightSection() {
        RightSection.shouldBe(visible);
    }

    @Step
    public void checkLeftSection() {
        LeftSection.shouldBe(visible);
    }

    @Step
    private void checkCheckBoxesLog(String value, boolean checked) {
        String lastLogText = Logs.first().getText();
        assertTrue(lastLogText.contains(value));
        assertTrue(lastLogText.contains(String.valueOf(checked)));
    }

    @Step
    public void checkLog(String value) {
        String lastLogText = Logs.first().getText();
        assertTrue(lastLogText.contains(value));
    }
}