package JDI.pages;

import JDI.forms.MetalsAndColorsForm;
import JDI.sections.ResultSection;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;

@JPage(url = "/metals-color.html", title = "Metal and Colors")
public class MetalsAndColorsPage extends Login {

    public MetalsAndColorsForm form;
    public ResultSection results;
}