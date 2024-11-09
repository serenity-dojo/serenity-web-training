package serenitydojo.todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("Active", asList("Feed the cat", "Walk the dog"), "Feed the cat", singletonList("Walk the dog")),
                Arguments.of("Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat", singletonList("Feed the cat")),
                Arguments.of("All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void shouldShowCorrectlyFilteredItems(String filterBy, List<String> todoItems, String completeItem, List<String> filteredItems) {

        todoList.openApplication();
        todoList.addItems(todoItems);
        todoList.completeItem(completeItem);
        todoList.filterBy(filterBy);

        assertThat(todoList.items()).hasSameElementsAs(filteredItems);
    }
}
