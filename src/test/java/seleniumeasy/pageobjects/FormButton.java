package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

public class FormButton {
    public static By withLabel(String label) {
        return By.xpath("//button[.='" + label + "']");
    }
}
