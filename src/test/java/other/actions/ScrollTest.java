package other.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrollTest {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
    }

    @Test
    public void testScroll() throws InterruptedException {
        driver.get(baseUrl);
        Actions actions = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("(//a[@class='btn buy-link btn-primary'])[25]"));
        actions.scrollToElement(button).pause(1000).click().perform();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
