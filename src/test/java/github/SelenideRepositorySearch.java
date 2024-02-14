package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void shouldFindSelenideRepositoryAtTheTopTest() {

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[placeholder='Search or jump to...']").$(byText("Search or jump to...")).click();
        $("#query-builder-test.FormControl-input.QueryBuilder-Input.FormControl-medium").setValue("selenide")
                .pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        $$("h3.Box-sc-g0xbh4-0.eYhAUV").first().$("a").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));


        // ARRANGE
        // ACT
        // ACT
        // (ASSERT)
        // ACT
        // ASSERT
    }

    @Test
    void findJUnitCodeTest() {

        open("/selenide/selenide");

        $("#wiki-tab").click();



    }
}
