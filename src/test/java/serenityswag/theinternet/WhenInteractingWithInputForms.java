package serenityswag.theinternet;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenInteractingWithInputForms {

    HoverPage hoverPage;
    NavigationActions navigate;

    @Test
    void shouldHoverOverAnElement() {
        navigate.toTheHoverPage();

        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("user1");

        hoverPage.hoverOverFigure(2);
        hoverPage.captionForFigure(2).shouldBeVisible();
        hoverPage.captionForFigure(2).shouldContainText("user2");
    }

    DynamicallyLoadedPage dynamicallyLoadedPage;

    @Test
    void shouldWaitForAnElementToAppear() {
        navigate.toTheDynamicLoadingPage();

        dynamicallyLoadedPage.start();

        assertThat(dynamicallyLoadedPage.result()).isEqualTo("Hello World!");

    }

    @Test
    void shouldWaitForAHiddenElementToAppear() {
        navigate.toTheHiddenDynamicLoadingPage();

        dynamicallyLoadedPage.start();

        assertThat(dynamicallyLoadedPage.result()).isEqualTo("Hello World!");
    }

}
