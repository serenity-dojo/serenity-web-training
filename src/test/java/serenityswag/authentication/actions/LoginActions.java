package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginActions extends UIInteractionSteps {

    @Step("Log in as a standard user")
    public void asAStandardUser() {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
    }
}
