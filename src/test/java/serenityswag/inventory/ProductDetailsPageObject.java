package serenityswag.inventory;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetailsPageObject extends PageObject {
    public String productName() {
        return $(".inventory_details_name").getText();
    }

    public WebElementState productImageWithAltValueOf(String productName) {
        return find(By.cssSelector(".inventory_details_container img[alt='" + productName + "']"));
    }
}
