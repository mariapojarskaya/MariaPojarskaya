package utils;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SliderHandler {

    private SelenideElement sliderRange = $(".range");

    private Double getStep() {
        return (double) sliderRange.getSize().width / 100;
    }

    public void setPosition(SelenideElement handle, int targetPosition) {
        Actions actions = new Actions(getWebDriver());
        Double current = Double.parseDouble(handle.getCssValue("left").replaceAll("px", "")) / getStep();
        int xOffset = (int) ((targetPosition - current - 1) * getStep());
        actions.dragAndDropBy(handle, xOffset, 0).perform();

    }
}