package serenityswag.toolshop;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.findby.By;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenSearchingForAProduct extends UIInteractions {

    @BeforeEach
    void openSite() {
        openUrl("https://practicesoftwaretesting.com/");
    }

    @Test
    void searchByKeyword() {
        // Enter "saw" into the search field
        $("#search-query").typeAndEnter("saw");

        // Count the number of products
        List<String> displayedProducts = getDisplayedProducts();

        assertThat(displayedProducts).contains("Wood Saw", "Circular Saw");
    }

    @NotNull
    private List<String> getDisplayedProducts() {
        List<String> displayedProducts
                = findAll(".card-title")
                .textContents()
                .stream()
                .map(titleValue -> titleValue.strip())
                .toList();
        return displayedProducts;
    }

    @Test
    void filterSearchResults() {

        var hammerCheckbox = $("#filters").findBy("//label[contains(.,'Hammer')]/input");

        hammerCheckbox.click();

        boolean isChecked = Boolean.parseBoolean(hammerCheckbox.getAttribute("checked"));
        assertThat(isChecked).isTrue();

        List<String> displayedProducts = getDisplayedProducts();
        assertThat(displayedProducts).allMatch(
                name -> name.toLowerCase().contains("hammer")
        );

    }

    @Test
    void completeTheContactForm() {
        find("[role=menubar]").findBy(By.linkText("Contact")).click();

        $("#first_name").type("Sarah-Jane");
        $("#last_name").type("Smith");
        $("#email").type("sarah@example.com");
        $("#subject").selectByVisibleText("Customer service");
        $("#message").type("A very detailed message to customer service about a problem.");

        WebElement attachmentField = $("#attachment");
        upload("data/sample.txt").to(attachmentField);

        $("[data-test=contact-submit]").click();

        String thankYouMessage = $(".alert-success").getText();

        assertThat(thankYouMessage).contains("Thanks for your message!");
    }


}





















