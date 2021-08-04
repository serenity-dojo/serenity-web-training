package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

public class FormButton {
    public static By withLabel(String message) {
        return By.xpath("//button[.='" + message + "']");
    }
}
