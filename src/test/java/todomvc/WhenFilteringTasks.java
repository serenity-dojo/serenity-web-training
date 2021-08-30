package todomvc;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.singletonList;
import static net.serenitybdd.core.Serenity.reportThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    //    @ParameterizedTest
    @ParameterizedTest(name = "Show correctly filtered items: {0}")
//    @CsvFileSource(resources="/test-data/filters.csv",numLinesToSkip = 1)
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

    static Stream<Arguments> testData() {
        return Stream.of(
                arguments("Active", asList("Feed the cat", "Walk the dog"), "Feed the cat",  singletonList("Walk the dog")),
                arguments("Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat",singletonList("Feed the cat")),
                arguments("All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog"))
        );
    }
}
