package todomvc;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TodoListActions extends UIInteractionSteps {

    public static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    public static final String ITEM_LABELS = ".todo-list li label";
    public static final String FILTER_BUTTON = "//ul[@class='filters']//a[.='{0}']";
    public static final String ITEM_LABEL = "//label[.='{0}']";
    public static final String ITEM_LEFT_COUNT = ".todo-count strong";
    public static final String DELETE_ICON = "//label[.='{0}']/following-sibling::button";

    static final Logger LOGGER = LoggerFactory.getLogger(TodoListActions.class);

    @Step("Open the TodoMVC application")
    public void openApplication() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }

    @Step("Add item {0}")
    public void addItem(String item) {
        LOGGER.info("Adding item '{}'", item);
        $(".new-todo").typeAndEnter(item);
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
}
