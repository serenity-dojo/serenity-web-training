package serenityswag.cart;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    public static final String CART_ITEM_DELETE_BUTTON = "//div[@class='cart_item_label'][contains(.,'{0}')]//button";

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(css = ".title")
    WebElementFacade title;

    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItemElements;

    public void checkout() {
        checkoutButton.click();
    }

    public String getTitleText() {
        return title.getText();
    }

    public List<CartItem> items() {
        List<CartItem> cartItems = new ArrayList<>();
        for(WebElementFacade cartItemElement : cartItemElements) {
            String name = cartItemElement.findBy(".inventory_item_name").getText();
            String description = cartItemElement.findBy(".inventory_item_desc").getText();
            Double price = priceFrom(cartItemElement.findBy(".inventory_item_price").getText());
            cartItems.add(new CartItem(name, description, price));
        }
        return cartItems;
    }

    private Double priceFrom(String textValue) {
        return Double.parseDouble(textValue.replace("$",""));
    }

    public void removeItem(String itemToDelete) {
        $(CART_ITEM_DELETE_BUTTON,itemToDelete).click();
    }
}
