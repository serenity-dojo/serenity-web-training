package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html")
public class SelectListForm extends SeleniumEasyForm {

    private static final By DAYS_OF_THE_WEEK = By.id("select-demo");
    private static final By STATES = By.id("multi-select");

    public String selectedDay() {
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    public void selectDay(String day) {
        $(DAYS_OF_THE_WEEK).select().byValue(day);
    }

    public List<String> selectedStates() {
        return $(STATES).getSelectedValues();
    }

    public void selectStates(String... states) {
        stream(states).forEach(
                state -> $(STATES).select().byValue(state)
        );
    }
}
