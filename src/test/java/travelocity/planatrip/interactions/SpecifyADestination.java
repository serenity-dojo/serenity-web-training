package travelocity.planatrip.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.InstrumentedTask;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

import static travelocity.planatrip.interactions.TripPlannerForm.*;

public class SpecifyADestination implements Interaction {

    private String destination;

    public SpecifyADestination() {}

    public SpecifyADestination(String destination) {
        this.destination = destination;
    }

    public static SpecifyADestination of(String destination) {
        return new SpecifyADestination(destination);
    }

    @Override
    @Step("{0} specifies a destination of #destination")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DESTINATION_FIELD),
                SendKeys.of(destination).into(LOCATION_FINDER),
                Click.on(DESTINATION_DROPDOWN_ENTRY.of(destination))
        );
    }
}
