package webtests.seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html")
public class MultipleRadioButtonsForm extends SeleniumEasyForm {

    public void selectGender(String value) {
        inRadioButtonGroup("gender").selectByValue(value);
    }

    public void selectAgeGroup(String value) {
        inRadioButtonGroup("ageGroup").selectByValue(value);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return $(".groupradiobutton").getText();
    }
}
