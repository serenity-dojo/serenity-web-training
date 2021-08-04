package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.SingleInputFieldForm;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    @Managed(driver = "chrome")
    WebDriver driver;

    SingleInputFieldForm singleInputFieldForm;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */
    @Test
    public void basicForms() {

        singleInputFieldForm.open();

        singleInputFieldForm.enterMessage("Hi there");

        singleInputFieldForm.showMessage();

        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there");
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    @Test
    public void checkboxes() {
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    @Test
    public void radioButtons() {
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void selectList() {

    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    @Test
    public void multiSelectList() {

    }

    /**
     * JQuery Select  list
     * https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html
     */
    @Test
    public void jquerySelectList() {

    }

}
