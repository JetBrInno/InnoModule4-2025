import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWindows {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);

        driver.manage().window().setPosition(new Point(1900, 0));
    }

    @Test
    public void testManageAndCookie() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }


    @Test
    public void testWindows() {
        // driver.manage().window().fullscreen();
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        String activeWindow = driver.getWindowHandle();
        System.out.println("Active window: " + activeWindow);
        System.out.println("-----------------");
        Set<String> windowHandles = driver.getWindowHandles();

        windowHandles.forEach(w -> { if (!activeWindow.equals(w)) driver.switchTo().window(w); });

        String actualText = driver.findElement(By.cssSelector("h3")).getText();
        assertEquals("New Window", actualText);
    }


    @Test
    public void testFrames() {
        // driver.manage().window().fullscreen();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-bottom");
        WebElement body = driver.findElement(By.cssSelector("body"));
        assertEquals("BOTTOM", body.getText());

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        body = driver.findElement(By.cssSelector("body"));
        assertEquals("MIDDLE", body.getText());
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
