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

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddItemFromSearchPageTest {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mainPage = new MainPage(driver);

        driver.get(baseUrl);
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }

    @Test
    public void testAddItemToCart()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(1));
        mainPage.searchBookByName("JAVA");

        List<WebElement> buttonsToCart = driver.findElements(By.xpath("//a[contains(@class,'btn-tocart')]"));
        WebElement firstButton = buttonsToCart.get(0);

        firstButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//a[contains(@class,'btn-tocart')]"), "оформить"));
        firstButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "1"));
    }

    @Test
    public void testAddTwoItemsToCart()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(1));
        mainPage.searchBookByName("JAVA");

        List<WebElement> buttonsToCart = driver.findElements(By.xpath("//a[contains(@class,'btn-tocart')]"));
        WebElement firstButton = buttonsToCart.get(0);
        firstButton.click();
        WebElement secondButton = buttonsToCart.get(1);
        secondButton.click();

        wait.until(ExpectedConditions.textToBePresentInElement(secondButton, "оформить"));
        secondButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "2"));
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
