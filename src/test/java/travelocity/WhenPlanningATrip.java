package travelocity;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import travelocity.planatrip.interactions.SpecifyADestination;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed
    WebDriver driver;

    Actor trevor;

    @Before
    public void setupActors() {
        trevor = Actor.named("Trevor")
                      .describedAs("a traveller")
                      .whoCan(BrowseTheWeb.with(driver));
    }

    @Test
    public void weShouldBeAbleToSpecifyTheDestination() {
        trevor.attemptsTo(
                Open.url("https://www.travelocity.com"),
                SpecifyADestination.of("Paris")
        );
        trevor.should(
                seeThat(
                        the("#location-field-destination-menu"), containsText("Paris")
                )
        );
    }
}
