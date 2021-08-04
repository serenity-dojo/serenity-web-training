package theinternet;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import theinternet.pageobjects.CheckboxesPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithFormElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    CheckboxesPage checkboxesPage;

    @Before
    public void openPage() {
        checkboxesPage.open();
    }

    @Test
    public void settingCheckboxValues() {

        assertThat(checkboxesPage.checkBoxValue(1)).isFalse();

        checkboxesPage.checkBox(1);

        assertThat(checkboxesPage.checkBoxValue(1)).isTrue();
    }

}
