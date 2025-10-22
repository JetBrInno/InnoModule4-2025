package other;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.get(baseUrl);
    }

    @Test
    public void testUrl() {
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();
        assertEquals(baseUrl, url);
    }

    // @Test
    // public void testGet() {
    //     driver.get(baseUrl);
    //     driver.get(baseUrl + "rating");
    // }

    // @Test
    // public void testNavigate() {
    //     driver.navigate().to(baseUrl);
    //     driver.navigate().refresh();
    //     driver.navigate().back();
    //     driver.navigate().forward();
    // }


    // @Test
    // public void testJs() {
    //     driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    //    Alert alert =  driver.switchTo().alert();
    //    String text = alert.getText();
    //    alert.sendKeys("Text");
    //    alert.accept();
    //    assertEquals("I am a JS prompt", text);
    // }

    // @Test
    // public void testManageAndCookie() {
    //     // driver.manage().window().fullscreen();
    //    driver.manage().window().maximize();
    //    driver.manage().addCookie(new Cookie("cookie_policy", "1"));
    //    driver.navigate().refresh();
    //    driver.navigate().refresh();
    // }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
