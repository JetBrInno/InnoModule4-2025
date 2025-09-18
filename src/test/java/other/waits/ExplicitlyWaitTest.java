package other.waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExplicitlyWaitTest {

    private WebDriver driver;

    private static final String baseUrl = "https://sky-todo-list.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testExplWait() throws InterruptedException {
        driver.get(baseUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tr"), 5));

        WebElement button = driver.findElement(By.xpath("//button"));

        wait.until(ExpectedConditions.visibilityOf(button));
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        assertTrue(rows.size() > 0);
       System.out.println(rows.size());
    }

    @Test
    public void testWaitLoad() throws InterruptedException {
        driver.get("http://uitestingplayground.com/ajax");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(22));
        wait.until(ExpectedConditions.textToBe(By.xpath("//p[@class='bg-success']"), "Data loaded with AJAX get request."));
    }

    @Test
    public void testWaitProgressBar() throws InterruptedException {
        driver.get("http://uitestingplayground.com/progressbar");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(1));
        WebElement startButton = driver.findElement(By.id("startButton"));
        WebElement stopButton = driver.findElement(By.id("stopButton"));
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        startButton.click();

        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "75"));

        stopButton.click();
    }


    @RepeatedTest(1)
    public void testAddToCart()  {
        driver.get("https://www.labirint.ru/");
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(1));
        WebElement input = driver.findElement(By.xpath("//input[@placeholder='Поиск по Лабиринту']"));
        input.sendKeys("JAVA", Keys.RETURN);
        List<WebElement> buttonsToCart = driver.findElements(By.xpath("//a[contains(@class,'btn-tocart')]"));
        WebElement firstButton = buttonsToCart.get(0);

        firstButton.click();
        wait.until(ExpectedConditions.textToBe(By.xpath("//a[contains(@class,'btn-tocart')]"), "оформить"));
        firstButton.click();

        wait.until(ExpectedConditions.textToBe(By.xpath("//span[contains(@class,'j-cart-count')]"), "1"));
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
