package pageObjectsLessons.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.MainPage;
import pageObjectsLessons.pageObjects.components.BookCard;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemFromSearchPageTest extends BaseTest {


    @Test
    public void testAddItemToCart()  {
        mainPage.header.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();
        BookCard card = searchResultsPage.getFoundedBook(0);
        WebElement firstButton = card.findButton();
        firstButton.click();
        card.waitForButtonChanged();
        firstButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "1"));
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
