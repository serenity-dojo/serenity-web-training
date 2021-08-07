package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.DynamicDataPage;
import seleniumeasy.pageobjects.DynamicallyLoadingPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    AlertMessagePage alertMessagePage;

    @Test
    public void waitingForAMessageToClose() {
        alertMessagePage.open();

        alertMessagePage.openSuccessMessage();

        assertThat(alertMessagePage.alertSuccessMessageText()).contains("I'm an autocloseable success message");

        alertMessagePage.waitForMessageToDissapear();
        alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicallyLoadingPage dynamicallyLoadingPage;

    @Test
    public void waitingForElementsToAppear() {
        dynamicallyLoadingPage.open();

        dynamicallyLoadingPage.start();

        assertThat(dynamicallyLoadingPage.getMessage()).isEqualTo("Hello World!");
    }

    DynamicDataPage dynamicDataPage;

    @Test
    public void waitingForElementsToDisappear() {
        dynamicDataPage.open();
        ;

        dynamicDataPage.getNewUser();

        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }

}
