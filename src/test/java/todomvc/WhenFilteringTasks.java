package todomvc;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static net.serenitybdd.core.Serenity.reportThat;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @ParameterizedTest(name = "Show correctly filtered items: {0}")
    @CsvSource({
            "Active,        Feed the cat;Walk the dog,  Feed the cat, Walk the dog",
            "Completed,     Feed the cat;Walk the dog,  Feed the cat, Feed the cat",
            "All,           Feed the cat;Walk the dog,  Feed the cat, Feed the cat;Walk the dog",
    })
    public void shouldShowCorrectlyFilteredItems(String filterBy,
                                                 String todoItems,
                                                 String completeItem,
                                                 String filteredItems) {

        todoList.openApplication();

        todoList.addItems(listFrom(todoItems));

        todoList.completeItem(completeItem);

        todoList.filterBy(filterBy);

        reportThat("The todo list should contain the expected items",
                () -> assertThat(todoList.items()).hasSameElementsAs(listFrom(filteredItems))
        );
    }

    private List<String> listFrom(String items) {
        return stream(items.split(";")).collect(Collectors.toList());
    }
}
