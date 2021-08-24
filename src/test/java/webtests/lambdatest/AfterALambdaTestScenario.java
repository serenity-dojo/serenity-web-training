package webtests.lambdatest;

import net.serenitybdd.core.webdriver.enhancers.AfterAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.model.TestResult.FAILURE;

public class AfterALambdaTestScenario implements AfterAWebdriverScenario {

    @Override
    public void apply(EnvironmentVariables environmentVariables, TestOutcome testOutcome, WebDriver driver) {
        // Update the test outcome if the test failed
        if (testOutcome.getResult().isAtLeast(FAILURE)) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
        }
    }
}