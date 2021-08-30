package todomvc;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static todomvc.TodoEntry.*;
import static todomvc.TodoListForm.*;

public class TodoListActions extends UIInteractionSteps {

    static final Logger LOGGER = LoggerFactory.getLogger(TodoListActions.class);

    @Step("Open the TodoMVC application")
    public void openApplication() {
        openPageNamed("home");
    }

    @Step("Add item {0}")
    public void addItem(String item) {
        LOGGER.info("Adding item '{}'", item);
        $(NEW_TODO_FIELD).typeAndEnter(item);
    }

    public void addItems(String... items) {
        addItems(Arrays.asList(items));
    }

    @Step("Add items {0}")
    public void addItems(List<String> items) {
        items.forEach(this::addItem);
    }

    public List<String> items() {
        return $$(ITEM_LABELS).texts();
    }

    public Integer itemLeftCount() {
        return Integer.parseInt($(ITEM_LEFT_COUNT).getText());
    }


    @Step("Complete item {0}")
    public void completeItem(String item) {
        $(COMPLETE_CHECKBOX,item).click();
    }

    @Step("Filter tasks by {0}")
    public void filterBy(String filter) {
        $(FILTER_BUTTON,filter).click();
    }

    @Step("Delete task {0}")
    public void deleteItem(String item) {
        $(ITEM_LABEL, item).click();
        $(DELETE_ICON, item).click();
    }

    public void clearList() {
        ((JavascriptExecutor) getDriver()).executeScript("localStorage.clear();");
    }
}
