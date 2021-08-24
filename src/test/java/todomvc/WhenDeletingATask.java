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
public class WhenDeletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
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
