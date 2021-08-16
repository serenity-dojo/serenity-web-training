package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public void hoverOverFigure(int number) {
        WebElementFacade figure = $("(//*[@class='figure'])[{0}]",number);
        withAction().moveToElement(figure).build().perform();
    }

    public WebElementFacade figureCaption(int number) {
        return $("(//*[@class='figcaption'])[{0}]",number);
    }
}
