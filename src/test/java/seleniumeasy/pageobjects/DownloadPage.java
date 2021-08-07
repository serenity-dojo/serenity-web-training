package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://the-internet.herokuapp.com/download")
public class DownloadPage extends PageObject {
    public void downloadSamplePngFile() {
        $(By.linkText("sample.png")).click();
    }
}
