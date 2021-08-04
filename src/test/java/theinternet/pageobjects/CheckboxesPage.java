package theinternet.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://the-internet.herokuapp.com/checkboxes")
public class CheckboxesPage extends PageObject {

    private static final String CHECKBOX_FIELD = "#checkboxes input:nth-of-type({0})";
    public void checkBox(int checkboxNumber) {
        $(CHECKBOX_FIELD, checkboxNumber).click();
    }

    public boolean checkBoxValue(int checkboxNumber) {
        return $(CHECKBOX_FIELD, checkboxNumber).isSelected();
    }
}
