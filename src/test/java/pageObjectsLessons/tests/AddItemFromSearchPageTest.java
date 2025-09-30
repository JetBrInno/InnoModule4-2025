package pageObjectsLessons.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.MainPage;
import pageObjectsLessons.pageObjects.components.BookCard;

import java.time.Duration;
import java.util.List;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemFromSearchPageTest extends BaseTest {


    @Test
    @DisplayName("Добавить товар в корзину")
    @Story("Как пользователь я могу искать книги и добавлять их в корзину")
    @Description("Добавление товара в корзину и переход в корзину по кнопке оформить")
    @Tags({@Tag("позитивный"), @Tag("смоук")})
    public void testAddItemToCart()  {
        mainPage.header.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();
        BookCard card = searchResultsPage.getFoundedBook(0);
        WebElement firstButton = card.findButton();
        step("Жмем на кнопку Добавить", () -> firstButton.click());
        card.waitForButtonChanged();
        step("Жмем на кнопку Оформить", () -> firstButton.click());

        step("Проверяем счетчик корзины", () -> wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "1")));
    }

    @Test
    public void testAddTwoItemsToCart()  {
        mainPage.header.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();

        BookCard card = searchResultsPage.getFoundedBook(0);
        WebElement firstButton = card.findButton();
        firstButton.click();

        BookCard secondCard = searchResultsPage.getFoundedBook(1);
        WebElement secondButton = secondCard.findButton();
        secondButton.click();

        secondCard.waitForButtonChanged();
        secondButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "2"));
    }
}
