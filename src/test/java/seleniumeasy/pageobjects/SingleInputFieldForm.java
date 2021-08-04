package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class SingleInputFieldForm extends PageObject {

    public void enterMessage(String message) {
        $("#user-message").sendKeys(message);
    }

    public void showMessage() {
        $(FormButton.withLabel("Show Message")).click();
    }

    public String displayedMessage() {
        return $("#display").getText();
    }
}
