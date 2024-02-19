package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Sandbox {

    SelenideElement s = $("");

    @Test
    void closeCookiePopup(){
        open("https://www.otpbank.ru/retail/bank-services/");
        $(withText("Продолжая просмотр сайта")).shouldBe(Condition.visible);
        $(byTagAndText("strong", "Закрыть")).click();
        $(withText("Продолжая просмотр сайта")).shouldBe(Condition.hidden);
    }

    @Test
    void pageObject() {
        new LoginPO().loginWithUsernameAndPassword("user", "admin1234");
        new HomePO().title.shouldHave(Condition.text("My Balance"));
        new HomePO().showAccountBalance();

        new LoginPO2().loginWithUsernameAndPassword("user", "admin1234")
                .showAccountBalance();
    }

}
