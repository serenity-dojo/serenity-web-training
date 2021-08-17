package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.DriverOptions;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithDriver;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
@UseTestDataFrom("test-data/calculations.csv")
public class SimpleExternalParameterizedTest {

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    private String a;
    private String b;
    private String total;

    TwoInputFieldForm inputFieldForm;

    @Qualifier
    public String qualifier() {
        return ": " + a + " + " + b + " should equal " + total;
    }

    @Test
    public void shouldCalculateTheRightTotal() {
        inputFieldForm.open();

        inputFieldForm.enterA(a);
        inputFieldForm.enterB(b);
        inputFieldForm.getTotal();

        assertThat(inputFieldForm.displayedTotal()).isEqualTo(total);
    }

}
