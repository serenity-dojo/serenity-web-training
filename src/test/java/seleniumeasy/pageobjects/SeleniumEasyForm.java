package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Use this class as a base class for your page component objects so that the popup window is closed correctly
 * if it appears.
 */
public abstract class SeleniumEasyForm extends PageObject {

    private static final By POPUP_WINDOW_CLOSE_ICON = By.cssSelector("a[title='Close']");

    /**
     * When the SeleniumEasy page opens, a popup appears. We need to close this popup before we can interact with the page.
     */
    @WhenPageOpens
    public void clearPopupWindow() {
        if ($(POPUP_WINDOW_CLOSE_ICON).isPresent()) {
            waitFor(visibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON)).click();
            waitFor(invisibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON));
        }
    }
}
