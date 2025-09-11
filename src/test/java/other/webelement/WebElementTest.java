package other.webelement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebElementTest {

    private WebDriver driver;

    private static final String baseUrl = "http://uitestingplayground.com/textinput";
    private static final String baseUrl2 = "http://the-internet.herokuapp.com/upload";
    private static final String baseUrl3 = "http://the-internet.herokuapp.com/dynamic_controls";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
    }
    @Test
    public void testButtonChangeText() throws InterruptedException {
        driver.get(baseUrl);

        WebElement inputFind = driver.findElement(By.id("newButtonName"));
        // inputFind.sendKeys("/Users/sam/IdeaProjects/Module4/shrek-surprised.png");
        inputFind.sendKeys(Keys.chord(Keys.LEFT_SHIFT, "abc"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "c"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, Keys.ARROW_RIGHT, Keys.ARROW_RIGHT));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        inputFind.sendKeys(Keys.chord(Keys.COMMAND, "v"));

        WebElement button = driver.findElement(By.id("updatingButton"));
        button.click();
        assertEquals("ABCABCABCABCABC", button.getText());
    }

    @Test
    public void testUploadFile() throws InterruptedException {
        driver.get(baseUrl2);

        WebElement inputFind = driver.findElement(By.id("file-upload"));
        System.out.println(inputFind.getAttribute("type"));
        inputFind.sendKeys("/Users/sam/IdeaProjects/Module4/shrek-surprised.png");
         WebElement sendBut = driver.findElement(By.id("file-submit"));
        sendBut.click();
    }

    @Test
    public void testCheckbox() {
        driver.get(baseUrl3);

        WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox']/input"));
        WebElement inputField = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        WebElement buttonRemove = driver.findElement(By.xpath("//form[@id='checkbox-example']/button"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        System.out.println(inputField.isEnabled());
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
