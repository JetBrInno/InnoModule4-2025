package other.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsTest {

    private WebDriver driver;

    private static final String baseUrl = "https://jspaint.app/";

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
        Actions actions = new Actions(driver);

        WebElement canvas = driver.findElement(By.cssSelector(".main-canvas"));
        WebElement tools = driver.findElement(By.cssSelector(".tools"));
        WebElement brush = driver.findElement(By.cssSelector("[title='Кисть']"));

        actions.click(brush).clickAndHold(canvas).moveToElement(brush)
                .moveByOffset(55,-55).pause(100).release()
                .moveToLocation(0,0).doubleClick(brush)
                .contextClick(brush)
                .perform();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
