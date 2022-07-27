package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessagePage extends PageObject {

    private static final By ALERT_SUCCESS_MESSAGE = By.cssSelector(".alert-success ");
    private static final String ANY_ALERT_MESSAGE = ".alert";
    /**
     * Hides after 5 seconds
     */
    public void openSuccessMessage() {
        $("#autoclosable-btn-success").click();
    }

    public WebElementState alertSuccessMessage() {
        return $(ALERT_SUCCESS_MESSAGE);
    }

    public String alertSuccessMessageText() {
        return $(ALERT_SUCCESS_MESSAGE).getText();
    }

    public void waitForMessageToDissapear() {
        withTimeoutOf(Duration.ofSeconds(10)).waitForAbsenceOf(ANY_ALERT_MESSAGE);;
    }
}
