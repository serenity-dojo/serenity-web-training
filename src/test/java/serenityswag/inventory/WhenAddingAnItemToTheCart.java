package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "firefox")
    WebDriver driver;

    @Steps
    LoginActions login;
    @Steps
    AddProductsActions addProducts;
    @Steps
    ProductList productList;
    @Steps
    ViewCartDetailsActions cartDetailsActions;
    List<String> productsAdded;
    InventoryPage inventoryPage;

    @Before
    public void login() {
        login.as(STANDARD_USER);

    }
    @Test
    public void theCorrectItemCountShouldBeShown() {
        Integer numberOfItemsAdded = addProducts.forAllAvailableItems();
        Serenity.reportThat("The badge in shopping cart logo increases correctly according with items added",
                () -> assertThat(inventoryPage.getShoppingCartBadge()).isEqualTo(numberOfItemsAdded.toString()));
    }

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        productsAdded = productList.titles();
        addProducts.forAllAvailableItems();
        cartDetailsActions.openCart();
        List<String> productsCart = productList.titles();
        Serenity.reportThat("The products added are displayed in the cart",
                () -> Assert.assertEquals(productsCart, productsAdded));
    }
}
