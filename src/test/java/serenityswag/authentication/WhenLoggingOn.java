package serenityswag.authentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn {

    @Managed
    WebDriver driver;

    @Test
    public void usersCanLogOnViaTheHomePage() {

        driver.get("https://www.saucedemo.com");

        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();

        // Should see product catalog

        assertThat(driver.findElement(By.cssSelector(".title")).getText())
                .isEqualToIgnoringCase("Products");
    }
}
