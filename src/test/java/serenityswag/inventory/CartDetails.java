package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.pages.WithLocator;

public class CartDetails extends PageObject {
    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementFacade cartLink() {
        return $(".shopping_cart_link");
    }
}
