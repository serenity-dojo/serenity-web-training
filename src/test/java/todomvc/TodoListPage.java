package todomvc;

class TodoListPage {
    static final String NEW_TODO_FIELD = ".new-todo";
    static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    static final String ITEM_LABELS = ".todo-list li label";
    static final String FILTER_BUTTON = "//ul[@class='filters']//a[.='{0}']";
    static final String ITEM_LABEL = "//label[.='{0}']";
    static final String ITEM_LEFT_COUNT = ".todo-count strong";
    static final String DELETE_ICON = "//label[.='{0}']/following-sibling::button";
}
