package travelocity.planatrip.interactions;

import net.serenitybdd.screenplay.targets.Target;

public class TripPlannerForm {
    public static final Target DESTINATION_FIELD = Target.the("destination field").locatedBy("#location-field-destination-menu");
    public static final Target LOCATION_FINDER = Target.the("location finder").locatedBy("[data-stid='location-field-destination-menu-input']");
    public static final Target DESTINATION_DROPDOWN_ENTRY = Target.the("Entry for {0}").locatedBy("//span[.='{0}']");
}
