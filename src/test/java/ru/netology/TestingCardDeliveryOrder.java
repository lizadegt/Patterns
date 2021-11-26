package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestingCardDeliveryOrder {
    @Test
    void shouldRegisterByApplication() {
        open("http://localhost:9999/");
        $("[placeholder='Город']").setValue(DataGenerator.generateCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(DataGenerator.generateDate(3));
        $("[name='name']").setValue(DataGenerator.generateName());
        $("[name='phone']").setValue(DataGenerator.generatePhone());
        $("[class=checkbox__box]").click();
        $(withText("Запланировать")).click();
        $(withText("Успешно!")).shouldBe(visible);
      //  $("[data-test-id=success-notification].notification__content").shouldHave(exactText("Встреча успешно запланирована на "+ DataGenerator.generateDate(3)));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(DataGenerator.generateDate(10));
        $(withText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).shouldBe(visible);
        $(withText("Перепланировать")).click();
    //    $("[data-test-id=success-notification].notification__content").shouldHave(exactText("Встреча успешно запланирована на " + DataGenerator.generateDate(10)));
    }
}
