package selenide.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenide.pageObjects.components.BookCard;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddItemFromSearchPageTest extends BaseTest {

//    @Test
//    @DisplayName("Добавить товар в корзину")
//    @Story("Как пользователь я могу искать книги и добавлять их в корзину")
//    @Description("Добавление товара в корзину и переход в корзину по кнопке оформить")
//    @Tags({@Tag("позитивный"), @Tag("смоук")})
//    public void testAddItemToCartSelenide()  {
//       $x("//input[@placeholder='Поиск по Лабиринту']").setValue("JAVA").pressEnter();
//       $("h1[class=index-top-title]").shouldBe(text("Все, что мы нашли в Лабиринте по запросу"));
//       $$(".btn-tocart").get(0).click();
//       $$(".btn-tocart").get(0).shouldHave(text("Оформить")).click();
//    }

    @Test
    @DisplayName("Добавить товар в корзину")
    @Story("Как пользователь я могу искать книги и добавлять их в корзину")
    @Description("Добавление товара в корзину и переход в корзину по кнопке оформить")
    @Tags({@Tag("позитивный"), @Tag("смоук")})
    public void testAddItemToCart()  {
        mainPage.header.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();
        BookCard card = searchResultsPage.getFoundedBook(0);
        step("Жмем на кнопку Добавить", () -> card.button.click());
        card.waitForButtonChanged();
        step("Жмем на кнопку Оформить", () -> card.button.click());

        step("Проверяем счетчик корзины", () -> searchResultsPage.header.cartCounter.shouldBe(text("5"), Duration.ofSeconds(3)));
    }


}
