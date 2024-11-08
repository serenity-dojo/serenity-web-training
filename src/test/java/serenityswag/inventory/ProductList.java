package serenityswag.inventory;


import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList extends PageObject {

    public List<String> titles() {
        return findAll(".inventory_item_name").textContents();
    }

    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }
}
