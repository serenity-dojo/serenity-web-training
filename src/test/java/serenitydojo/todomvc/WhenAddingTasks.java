package serenitydojo.todomvc;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @BeforeEach
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
