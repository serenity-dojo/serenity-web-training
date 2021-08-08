package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void waitingForAModalDialog() {
    }

    @Test
    public void waitingForAMessageToClose() {
    }

    @Test
    public void waitingForElementsToAppear() {
    }
}
