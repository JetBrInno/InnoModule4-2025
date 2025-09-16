package other.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebElementCssDomPropertiesTest {

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
    public void testGetValuesAndGetPosition() throws InterruptedException {
        driver.get(baseUrl);

        WebElement button = driver.findElement(By.xpath("(//a[@class='btn buy-link btn-primary'])[1]"));
        System.out.println(button.getCssValue("border"));
        System.out.println(button.getDomProperty("isConnected"));
        System.out.println(button.getAttribute("baseURI"));
        System.out.println(button.getDomAttribute("class"));

        System.out.println(button.getRect().x);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
