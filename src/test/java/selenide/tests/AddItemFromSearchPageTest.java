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
import pageObjectsLessons.pageObjects.components.BookCard;
import pageObjectsLessons.tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AddItemFromSearchPageTest {


//    @Test
//    @DisplayName("Добавить товар в корзину")
//    @Story("Как пользователь я могу искать книги и добавлять их в корзину")
//    @Description("Добавление товара в корзину и переход в корзину по кнопке оформить")
//    @Tags({@Tag("позитивный"), @Tag("смоук")})
//    public void testAddItemToCart()  {
//        mainPage.header.searchBookByName("JAVA");
//        searchResultsPage.waitUntilPageOpened();
//        BookCard card = searchResultsPage.getFoundedBook(0);
//        WebElement firstButton = card.findButton();
//        step("Жмем на кнопку Добавить", () -> firstButton.click());
//        card.waitForButtonChanged();
//        step("Жмем на кнопку Оформить", () -> firstButton.click());
//
//        step("Проверяем счетчик корзины", () -> wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "1")));
//    }
private static final String baseUrl = "https://www.labirint.ru";


    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1280x1024";
        Configuration.browserPosition = "1600x0";
        open(baseUrl);
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("cookie_policy", "1"));
        refresh();
    }

    @Test
    @DisplayName("Добавить товар в корзину")
    @Story("Как пользователь я могу искать книги и добавлять их в корзину")
    @Description("Добавление товара в корзину и переход в корзину по кнопке оформить")
    @Tags({@Tag("позитивный"), @Tag("смоук")})
    public void testAddItemToCartSelenide()  {
       $x("//input[@placeholder='Поиск по Лабиринту']").sendKeys("JAVA", Keys.ENTER);
       $("h1[class=index-top-title]").shouldBe(text("Все, что мы нашли в Лабиринте по запросу"));
       $$(".btn-tocart").get(0).click();
       $$(".btn-tocart").get(0).shouldHave(text("Оформить")).click();
    }



}
