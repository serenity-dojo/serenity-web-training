package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html")
public class MultiSelectListForm extends SeleniumEasyForm {

    private static final By STATE = By.id("multi-select");

    public List<String> selectedStates() {
        return $(STATE).getSelectedValues();
    }

    public void selectStates(String... states) {
        for(String state : states) {
            $(STATE).select().byValue(state);
        }
    }
}
