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
public class WhenDeletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @BeforeEach
    public void openApp() {
        todoList.openApplication();
    }

    @Test
    public void deletedItemsShouldDissapearFromTheList() {
        todoList.addItems("Feed The Cat","Walk the dog");

        todoList.deleteItem("Feed The Cat");

        Serenity.reportThat("The todo list should not contain deleted items",
                () -> assertThat(todoList.items()).containsExactly("Walk the dog")
        );
    }
}
