package webtests.serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ProductListPageObject extends PageObject {
    public List<String> titles() {
        withTimeoutOf(Duration.ofSeconds(5))
                .waitFor(presenceOfElementLocated(By.cssSelector(".inventory_item_name")));

        return findAll(".inventory_item_name").textContents();
    }

    public void openProductDetailsFor(String itemName) {
        find(By.linkText(itemName)).click();
    }

    public String imageTextForProduct(String productName) {
        return $("//div[@class='inventory_item'][contains(.,'" + productName + "')]//img").getAttribute("alt");
    }
}
