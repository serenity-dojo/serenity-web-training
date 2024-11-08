package serenityswag.toolshop;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenSearchingForAProduct extends UIInteractions {

    @Test
    void searchByKeyword() {
        openUrl("https://practicesoftwaretesting.com/");

        // Enter "saw" into the search field
        $("#search-query").typeAndEnter("saw");

        // Count the number of products
        List<String> displayedProducts
                = findAll(".card-title")
                .textContents()
                .stream()
                .map(titleValue -> titleValue.strip())
                .toList();

        assertThat(displayedProducts).contains("Wood Saw", "Circular Saw");
    }

}
