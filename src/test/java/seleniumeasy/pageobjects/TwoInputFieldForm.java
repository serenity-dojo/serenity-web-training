package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class TwoInputFieldForm extends SeleniumEasyForm {

    public void enterA(String value) {
        $("#sum1").sendKeys(value);
    }

    public void enterB(String value) {
        $("#sum2").sendKeys(value);
    }

    public void getTotal() {
        $(FormButton.withLabel("Get Total")).click();
    }

    public String displayedTotal() {
        return $("#displayvalue").getText();
    }
}
