package other.locators;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
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


    @Test
    public void testFindElementByFollowingSib() {
        //WebElement cartButton = driver.findElement(By.xpath("//*[text() = 'Корзина']"));
        WebElement a = driver.findElement(By.xpath("//span[@class='product-title large-name']/.."));
        WebElement span = findFollowingElement(a, "span");
        span.click();
    }

    @Test
    public void testFindButton() {
        WebElement header = driver.findElement(By.xpath("//span[@class='b-header-b-search-outer-e-input']"));
        WebElement button = findFollowingElement(header, "button");
        button.click();
    }

    @Test
    public void testFindAllDivs() {
        List<WebElement> divs = driver.findElements(By.xpath("//div"));
        System.out.println(divs.get(4));
    }

    private WebElement findElementByText(String tagName, String text) {
        return driver.findElement(By.xpath("//"+ tagName + "[text()='" + text + "']"));
    }

    private WebElement findFollowingElement(WebElement element, String siblingTag) {
        return element.findElement(By.xpath( "following-sibling::" + siblingTag));
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
