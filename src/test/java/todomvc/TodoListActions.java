package todomvc;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class TodoListActions extends UIInteractionSteps {

    public static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    public static final String ITEM_LABELS = ".todo-list li label";
    public static final String FILTER_BUTTON = "//ul[@class='filters']//a[.='{0}']";

    @Step
    public void openApplication() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }

    @Step("Add item {0}")
    public void addItem(String item) {
        $(".new-todo").typeAndEnter(item);
    }

    @Step("Add items {0}")
    public void addItems(String... items) {
        for (String item : items) {
            addItem(item);
        }
    }

    public List<String> items() {
        return $$(ITEM_LABELS).texts();
    }

    @Step("Complete item {0}")
    public void completeItem(String item) {
        $(COMPLETE_CHECKBOX,item).click();
    }

    @Step("Filter tasks by {0}")
    public void filterBy(String filter) {
        $(FILTER_BUTTON,filter).click();
    }
}
