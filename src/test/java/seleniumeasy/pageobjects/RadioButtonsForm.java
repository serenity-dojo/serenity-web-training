package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html")
public class RadioButtonsForm extends SeleniumEasyForm {

    public void selectOption(String radioOption) {
//      $("[name='optradio'][value='{0}']", radioOption).click();
        inRadioButtonGroup("optradio").selectByValue(radioOption);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }
}
