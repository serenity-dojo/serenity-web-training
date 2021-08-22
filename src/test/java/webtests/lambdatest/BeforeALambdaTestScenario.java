package webtests.lambdatest;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Optional;

public class BeforeALambdaTestScenario implements BeforeAWebdriverScenario {

    @Override
    public DesiredCapabilities apply(EnvironmentVariables environmentVariables,
                                     SupportedWebDriver driver,
                                     TestOutcome testOutcome,
                                     DesiredCapabilities capabilities) {
        // Do nothing unless a lambdatest URL is specified
        Optional<String> remoteUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getOptionalProperty("webdriver.remote.url");
        if (remoteUrl.isEmpty() || !remoteUrl.get().contains("lambdatest")) {
            return capabilities;
        }

        capabilities.setCapability("build", testOutcome.getStoryTitle());
        capabilities.setCapability("name", testOutcome.getCompleteName());
        return capabilities;
    }
}
