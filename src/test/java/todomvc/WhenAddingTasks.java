package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenAddingTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApp() {
        todoList.openApplication();
    }

    @Test
    public void addingASingleTask() {
        todoList.addItem("Feed The Cat");

        Serenity.reportThat("The todo list should contain 'Feed The Cat",
                () -> assertThat(todoList.items()).containsExactly("Feed The Cat")
        );
        Serenity.reportThat("The todo list count should be 1",
                () -> assertThat(todoList.itemLeftCount()).isEqualTo(1)
        );

    }

    @Test
    public void addingMultipleTasks() {
        todoList.addItems("Feed The Cat","Walk the dog");

        Serenity.reportThat("The todo list should contain all the entries in the expected order",
                () -> assertThat(todoList.items()).containsExactly("Feed The Cat","Walk the dog")
        );
        Serenity.reportThat("The todo list count should be 2",
                () -> assertThat(todoList.itemLeftCount()).isEqualTo(2)
        );
    }

}
