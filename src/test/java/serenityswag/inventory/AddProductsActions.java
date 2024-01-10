package serenityswag.inventory;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class AddProductsActions extends UIInteractionSteps {

    ProductList productList;
    @Step("Add Products'")
    public Integer forAllAvailableItems() {
        List<WebElementFacade> itemsAdded = productList.availableItems();
        itemsAdded.forEach(WebElementFacade::click);
        return itemsAdded.size();
    }
}
