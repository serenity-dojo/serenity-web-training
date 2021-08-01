package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList  extends PageObject {

    public List<String> titles() {
        return findAll(".inventory_item_name").textContents();
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }

    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }
}
