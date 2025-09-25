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
import pageObjectsLessons.pageObjects.SearchResultsPage;
import pageObjectsLessons.pageObjects.components.BookCard;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchFieldTest extends BaseTest {


    @Test
    public void testSearchValidBookName()  {
        mainPage.header.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();
        BookCard card = searchResultsPage.getFoundedBook(0);
        wait.until(ExpectedConditions.attributeContains(card.findTitle(), "title", "Java. устранение проблем. Чтение, отладка и оптимизация JVM-приложений"));

        card = searchResultsPage.getFoundedBook(2);
        wait.until(ExpectedConditions.attributeContains(card.findTitle(), "title", "Современный Java. Рецепты программирования"));
    }

    @Test
    public void testSearchNonExistentBookName()  {
        String inputValue = "11111111111111";
        mainPage.header.searchBookByName(inputValue);
        searchResultsPage.waitUntilPageOpened();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div[class=search-result]"));
        assertEquals(0, searchResults.size());

        searchResultsPage.header.searchBookByName("JAVAVAVAVA");
    }

}
