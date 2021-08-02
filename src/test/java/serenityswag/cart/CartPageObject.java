package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    public static final String CART_ITEM_DELETE_BUTTON = "//div[@class='cart_item_label'][contains(.,'{0}')]//button";
    private static By CHECKOUT_BUTTON = By.id("checkout");
    private static By TITLE = By.cssSelector(".title");
    private static By CART_ITEMS = By.cssSelector(".cart_item");

    public void checkout() {
        $(CHECKOUT_BUTTON).click();
    }

    public String getTitleText() {
        return $(TITLE).getText();
    }

    public List<CartItem> items() {
        return findAll(CART_ITEMS).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price").getText())
                )
        );
    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$", ""));
    }

    public void removeItem(String itemToDelete) {
        $(CART_ITEM_DELETE_BUTTON,itemToDelete).click();
    }
}
