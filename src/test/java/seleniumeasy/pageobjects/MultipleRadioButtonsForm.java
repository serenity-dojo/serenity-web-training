package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html")
public class MultipleRadioButtonsForm extends SeleniumEasyForm {

    public void selectGender(String gender) {
        inRadioButtonGroup("gender").selectByValue(gender);
    }

    public void selectAgeGroup(String ageGroup) {
        inRadioButtonGroup("ageGroup").selectByValue(ageGroup);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return $(".groupradiobutton").getText();
    }
}
