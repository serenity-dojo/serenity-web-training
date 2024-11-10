package serenityswag.theinternet;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class DynamicallyLoadedPage extends PageObject {

    public void start() {
        $("#start button").click();
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
//        withTimeoutOf(Duration.ofSeconds(10)).waitFor(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

    }

    public String result() {
        return $("#finish").getText();
    }
}
