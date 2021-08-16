package webtests.todo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenManagingMyTodoList {

    @Managed
    WebDriver driver;

    TodoMvcPage todoMvcPage;

    @Test
    public void aPlaceholderTextShouldBeDisplayed() {
        todoMvcPage.open();

        assertThat(todoMvcPage.placeholderText()).isEqualTo("What needs to be done?");
    }
}
