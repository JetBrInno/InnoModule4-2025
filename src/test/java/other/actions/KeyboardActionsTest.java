package other.actions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyboardActionsTest {

    private WebDriver driver;

    private static final String baseUrl = "http://uitestingplayground.com/textinput";

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
        Keys co = Platform.getCurrent().is(Platform.WINDOWS) ? Keys.CONTROL : Keys.COMMAND;


//        if (Platform.getCurrent().is(Platform.WINDOWS)) {
//            co = Keys.CONTROL;
//        }
//        else {
//            co = Keys.COMMAND;
//        }

        WebElement inputFind = driver.findElement(By.id("newButtonName"));


        Actions actions = new Actions(driver);

        actions.sendKeys(inputFind, "a")
                .pause(100)
                .sendKeys(inputFind, "b")
                .pause(1000)
                .keyDown(co)
                .sendKeys(inputFind, "a")
                .keyUp(co)
                .pause(1000)
                .perform();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
