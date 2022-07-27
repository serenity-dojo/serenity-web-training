package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.*;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    SingleInputFieldForm singleInputFieldForm;

    @Test
    public void basicForms() {
        singleInputFieldForm.open();

        singleInputFieldForm.enterMessage("Hi there");

        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://demo.seleniumeasy.com/basic-first-form-demo.html
     */

    TwoInputFieldForm twoInputFieldForm;

    @Test
    public void basicFormsWithMultipleFields() {
        twoInputFieldForm.open();

        twoInputFieldForm.enterA("2");
        twoInputFieldForm.enterB("3");

        twoInputFieldForm.getTotal();

        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo("5");

    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://demo.seleniumeasy.com/basic-checkbox-demo.html
     */

    CheckboxForm checkboxForm;

    @Test
    public void singleCheckbox() {
        checkboxForm.open();

        checkboxForm.setAgeSelected();

        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_THE_OPTIONS = asList("Option 1", "Option 2","Option 3","Option 4");

    @Test
    public void multipleCheckboxes() {

        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );

        checkboxForm.checkAll();

        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://demo.seleniumeasy.com/basic-radiobutton-demo.html
     */
    RadioButtonsForm radioButtonsForm;

    @Test
    public void radioButtons() {
        radioButtonsForm.open();

        radioButtonsForm.selectOption("Male");

        radioButtonsForm.getCheckedValue();

        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }

    MultipleRadioButtonsForm multipleRadioButtonsForm;

    @Test
    public void multipleRadioButtons() {
        multipleRadioButtonsForm.open();

        multipleRadioButtonsForm.selectGender("Female");
        multipleRadioButtonsForm.selectAgeGroup("15 - 50");
        multipleRadioButtonsForm.getValues();

        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex : Female")
                .contains("Age group: 15 - 50");
    }

    /**
     * Dropdown lists
     * https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    SelectListForm selectListForm;

    @Test
    public void selectList() {
        selectListForm.open();

        assertThat(selectListForm.selectedDay()).isEmpty();

        selectListForm.selectDay("Wednesday");

        assertThat(selectListForm.selectedDay()).isEqualTo("Wednesday");

    }

    /**
     * Multi-Select Dropdown lists
     * https://demo.seleniumeasy.com/basic-select-dropdown-demo.html
     */
    MultiSelectListForm multiSelectListForm;

    @Test
    public void multiSelectList() {
        multiSelectListForm.open();

        assertThat(multiSelectListForm.selectedStates()).isEmpty();

        multiSelectListForm.selectStates("Florida","Ohio","Texas");

        assertThat(multiSelectListForm.selectedStates()).containsExactly("Florida","Ohio","Texas");
    }
}
