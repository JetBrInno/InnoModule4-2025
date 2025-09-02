import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void testUrl() {
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();
        assertEquals(baseUrl, url);
    }

    @Test
    public void testGet() {
        driver.get(baseUrl);
        driver.get(baseUrl + "rating");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
