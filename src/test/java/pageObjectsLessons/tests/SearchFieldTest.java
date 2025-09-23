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

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchFieldTest {

    private WebDriver driver;

    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;

    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mainPage = new MainPage(driver);
        searchResultsPage = new SearchResultsPage(driver, wait);
        mainPage.firstOpen();
    }

    @Test
    public void testSearchValidBookName()  {
        mainPage.searchBookByName("JAVA");
        searchResultsPage.waitUntilPageOpened();
        WebElement firstCard = searchResultsPage.getFoundedBook(0);
        wait.until(ExpectedConditions.attributeContains(firstCard, "title", "Java"));
    }

    @Test
    public void testSearchNonExistentBookName()  {
        String inputValue = "11111111111111";
        mainPage.searchBookByName(inputValue);
        searchResultsPage.waitUntilPageOpened();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div[class=search-result]"));
        assertEquals(0, searchResults.size());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
