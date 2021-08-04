package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class SeleniumEasyForm extends PageObject {

    private static final By POPUP_WINDOW = By.cssSelector("a[title='Close']");

    @WhenPageOpens
    public void clearPopupWindow() {
        waitFor(ExpectedConditions.presenceOfElementLocated(POPUP_WINDOW));
        $(POPUP_WINDOW);
    }

}
