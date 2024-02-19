package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideNumberTwoTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void chooseSolutionsEnterpriseGithubTest() {

        open("https://github.com/");

        $(byText("Solutions")).hover();
        $(".dropdown-menu a[href*=enterprise]").click();
        $("#hero-section-brand-heading").should(appear);
    }

    @Test
    void DragAndDropActionsHerokuTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(230, 57)
                .release().perform();
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void DragAndDropWithSelenideDragAndDropHerukoTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");

        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }
}
