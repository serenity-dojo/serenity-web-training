package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewCartDetailsActions extends UIInteractionSteps {

    CartDetails cartDetails;

    @Step("View cart details for added products'")
    public void openCart() {
        $(cartDetails.cartLink()).click();

    }
}
