package other.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DragAndDropTest {

    private WebDriver driver;

    private static final String baseUrl = "https://the-internet.herokuapp.com/drag_and_drop";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
    }

    @Test
    public void testDrag() throws InterruptedException {
        driver.get(baseUrl);
        Actions actions = new Actions(driver);
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(columnA, columnB).perform();

        assertEquals("B", columnA.getText());
        assertEquals("A", columnB.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
