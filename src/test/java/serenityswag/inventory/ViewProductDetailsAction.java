package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class ViewProductDetailsAction extends UIInteractionSteps {

    @Step("View product details for product '{0}'")
    public void forProductWithName(String productName) {
        $(ProductList.productDetailsLinkFor(productName)).click();

    }
}
