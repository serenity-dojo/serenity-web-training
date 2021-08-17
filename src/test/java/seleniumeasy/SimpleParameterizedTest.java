package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class SimpleParameterizedTest {

    @Managed(driver = "chrome", options = "--headless")
    WebDriver driver;

    @TestData(columnNames = "A,B,Total")
    public static Collection<Object[]> testData(){
        return asList(new Object[][]{
                {"1","2","3"},
                {"10","20","30"},
                {"10","-5","5"},
                {"10","0","10"},
                {"0","10","10"},
                {"0","10","10"},
                {"10000000","20000000","30000000"},
        });
    }


    private final String a;
    private final String b;
    private final String total;

    TwoInputFieldForm inputFieldForm;

    public SimpleParameterizedTest(String a, String b, String total) {
        this.a = a;
        this.b = b;
        this.total = total;
    }

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
