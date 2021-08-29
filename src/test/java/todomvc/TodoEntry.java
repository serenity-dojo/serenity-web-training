package todomvc;

class TodoEntry {
    static final String COMPLETE_CHECKBOX = "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    static final String ITEM_LABEL = "//label[.='{0}']";
    static final String DELETE_ICON = "//label[.='{0}']/following-sibling::button";
}
