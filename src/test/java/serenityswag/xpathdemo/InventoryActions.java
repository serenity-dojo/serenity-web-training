package serenityswag.xpathdemo;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.InventoryPage;

import static serenityswag.inventory.InventoryPage.ADD_TO_CART_BUTTON;
import static serenityswag.inventory.InventoryPage.REMOVE_FROM_CART_BUTTON;

public class InventoryActions extends UIInteractionSteps  {
    InventoryPage inventoryPage;

    public void viewInventory() {
        inventoryPage.open();
    }

    // "//div[@class='inventory_item'][.//*[@class='inventory_item_name'][.='{0}']]//button[.='Add to cart']"

    @Step("Add items {0} to cart")
    public void addItemsToCart(String... items) {
        for (String item : items) {
            $(ADD_TO_CART_BUTTON,item).click();
        }
    }

    public Integer shoppingCartTally() {
        return Integer.parseInt(inventoryPage.getShoppingCartBadge());
    }

    @Step("Remove items {0} from cart")
    public void removeFromCart(String... items) {
        for (String item : items) {
            $(REMOVE_FROM_CART_BUTTON,item).click();
        }
    }
}
