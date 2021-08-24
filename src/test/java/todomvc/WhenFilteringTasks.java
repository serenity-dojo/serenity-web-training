package todomvc;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static net.serenitybdd.core.Serenity.reportThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    private final List<String> todoItems;
    private final String completeItem;
    private final String filterBy;
    private final List<String> filteredItems;

    public WhenFilteringTasks(String filterBy, List<String> todoItems, String completeItem, List<String> filteredItems) {
        this.todoItems = todoItems;
        this.completeItem = completeItem;
        this.filterBy = filterBy;
        this.filteredItems = filteredItems;
    }

    @TestData(columnNames = "Filter By, Todo Items, Completed Item, Filtered Items")
    public static Collection<Object[]> testData() {
        return asList(new Object[][]{
                {"Active", asList("Feed the cat", "Walk the dog"), "Feed the cat",  singletonList("Walk the dog")},
                { "Completed", asList("Feed the cat", "Walk the dog"), "Feed the cat",singletonList("Feed the cat")},
                {"All", asList("Feed the cat", "Walk the dog"), "Feed the cat", asList("Feed the cat", "Walk the dog")},
        });
    }

    @Before
    public void openApp() {
        todoList.openApplication();

        todoList.addItems(todoItems);

        todoList.completeItem(completeItem);
    }

    @Test
    public void shouldShowCorrectlyFilteredItems() {

        todoList.filterBy(filterBy);

        reportThat("The todo list should contain the expected items",
                () -> assertThat(todoList.items()).hasSameElementsAs(filteredItems)
        );
    }

}
