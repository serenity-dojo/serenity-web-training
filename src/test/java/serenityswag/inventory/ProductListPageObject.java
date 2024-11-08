package serenityswag.inventory;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class ProductListPageObject extends PageObject {
    public List<String> titles() {
        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String productName) {
        find(By.linkText(productName)).click();
    }

    public String imageTextForProduct(String productName) {
        return find("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
