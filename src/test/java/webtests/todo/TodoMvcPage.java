package webtests.todo;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.webdriver.javascript.ByShadowDom;
import org.openqa.selenium.By;

@DefaultUrl("https://todomvc.com/examples/emberjs/")
public class TodoMvcPage extends PageObject {

    public String placeholderText() {
        return find(By.id("new-todo"))
                .find(ByShadowDom.of("div[pseudo=placeholder]"))
                .getText();
    }
}
