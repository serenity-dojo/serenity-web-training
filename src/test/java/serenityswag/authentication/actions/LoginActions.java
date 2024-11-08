package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class LoginActions extends UIInteractionSteps {

    @Step
    public void asAStandardUser() {
        openUrl("https://www.saucedemo.com");

        $("[data-test='username']").sendKeys("standard_user");
        $("[data-test='password']").sendKeys("secret_sauce");
        $("[data-test='login-button']").click();
    }
}
