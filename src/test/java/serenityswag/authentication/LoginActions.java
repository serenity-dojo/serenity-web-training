package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginActions extends UIInteractionSteps {
    @Step("Log in as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }
}
