package serenityswag.theinternet;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NavigationActions extends UIInteractionSteps {

    @Step
    public void toTheHoverPage() {
        openPageNamed("hover");
    }

    @Step
    public void toTheDynamicLoadingPage() {
        openPageNamed("dynamic_loading");
    }


    @Step
    public void toTheHiddenDynamicLoadingPage() {
        openPageNamed("dynamic_loading_hidden");
    }

}
