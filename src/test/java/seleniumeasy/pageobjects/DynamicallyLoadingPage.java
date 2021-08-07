package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

@DefaultUrl("http://the-internet.herokuapp.com/dynamic_loading/1")
public class DynamicallyLoadingPage extends PageObject {

    private static final By RESULT_MESSAGE = By.id("finish");
    public void start() {
        $("#start button").click();
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(visibilityOfElementLocated(RESULT_MESSAGE));
    }

    public String getMessage() {
        return $("#finish").getText();
    }
}
