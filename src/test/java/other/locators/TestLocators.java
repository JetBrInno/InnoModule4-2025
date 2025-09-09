package other.locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLocators {

    private WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.get(baseUrl);
        driver.manage().window().setPosition(new Point(1900, 0));
    }

    @Test
    public void testFindInputCSS() {
       WebElement inputFind = driver.findElement(By.cssSelector("input[placeholder='Поиск по Лабиринту']"));
       inputFind.sendKeys("Укрытие");
    }

    @Test
    public void testFindInputXPATH() {
        WebElement inputFind = driver.findElement(By.xpath("//input[@placeholder='Поиск по Лабиринту']"));
        inputFind.sendKeys("Укрытие");
    }

    @Test
    public void testFindCartXPATH() {
        //WebElement cartButton = driver.findElement(By.xpath("//*[text() = 'Корзина']"));
        WebElement cartButton = findElementByText("*","Корзина");
        cartButton.click();
    }

    private WebElement findElementByText(String tagName, String text) {
        return driver.findElement(By.xpath("//"+ tagName + "[text()='" + text + "']"));
    }
//
//    WebElement cartButton = driver.findElement(By.id("abc"));
//    WebElement cartButton = driver.findElement(By.cssSelector("*[id='abc']"));
//    WebElement cartButton = driver.findElement(By.xpath("//[@id='abc']"));

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
