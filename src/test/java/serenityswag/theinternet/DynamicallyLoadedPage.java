package serenityswag.theinternet;

import net.serenitybdd.core.pages.PageObject;

public class DynamicallyLoadedPage extends PageObject {

    public void start() {
        $("#start button").click();
    }

    public String result() {
        return $("#finish").getText();
    }
}
