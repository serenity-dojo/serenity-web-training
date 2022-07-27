package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenAddingTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @BeforeEach
    void openApp() {
        todoList.openApplication();
    }

    @Nested
    class ToAnEmptyList {

        @Test
        void addingASingleTask() {
            todoList.addItem("Feed The Cat");

            Serenity.reportThat("The todo list should contain 'Feed The Cat",
                    () -> assertThat(todoList.items()).containsExactly("Feed The Cat")
            );
        }

        @Test
        void addingMultipleTasks() {
            todoList.addItems("Feed The Cat", "Walk the dog");

            Serenity.reportThat("The todo list should contain all the entries in the expected order",
                    () -> assertThat(todoList.items()).containsExactly("Feed The Cat", "Walk the dog")
            );
        }
    }

    @Nested
    class ToAListWithExistingEntries {

        @BeforeEach
        void aListWithSomeEntriesAlreadyAdded() {
            todoList.addItems("Feed The Cat", "Walk the dog");
        }

        @Test
        void theNewItemsShouldBeAddedAtTheEndOfTheList() {
            todoList.addItem("Fleece the sheep");

            Serenity.reportThat("The todo list should contain all the entries in the expected order",
                    () -> assertThat(todoList.items()).containsExactly("Feed The Cat", "Walk the dog", "Fleece the sheep")
            );
        }
    }

    @AfterEach
    public void closeApp() {
        todoList.clearList();
    }


}
