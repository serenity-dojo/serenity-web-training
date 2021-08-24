package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.core.Serenity.reportThat;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenCompletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApp() {
        todoList.openApplication();
    }

    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        todoList.addItems("Feed The Cat","Walk the dog");

        todoList.completeItem("Feed The Cat");

        todoList.filterBy("Active");

        reportThat("The todo list should contain only uncompleted items",
                () -> assertThat(todoList.items()).containsExactly("Walk the dog")
        );
        reportThat("The correct number of remaining todo items should be displayed",
                () -> assertThat(todoList.items()).containsExactly("Walk the dog")
        );
    }

    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        todoList.addItems("Feed The Cat","Walk the dog");

        todoList.completeItem("Feed The Cat");

        todoList.filterBy("Completed");

        reportThat("The todo list should contain only uncompleted items",
                () -> assertThat(todoList.items()).containsExactly("Feed The Cat")
        );
    }

}
