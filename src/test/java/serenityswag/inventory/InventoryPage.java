package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/inventory.html")
public class InventoryPage extends PageObject {

    public static final String ADD_TO_CART_BUTTON
            = "//div[@class='inventory_item'][.//*[@class='inventory_item_name'][.='{0}']]//button[.='Add to cart']";

    public static final String REMOVE_FROM_CART_BUTTON
            = "//div[@class='inventory_item'][.//*[@class='inventory_item_name'][.='{0}']]//button[.='Remove']";

    public String getHeading() {
        return $(".title").getText();
    }

    public String getShoppingCartBadge() {
        return $(".shopping_cart_badge").getText();
    }
}
