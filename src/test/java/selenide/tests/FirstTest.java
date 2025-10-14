package selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {


    private static final String baseUrl = "https://www.labirint.ru";

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1280x1024";
        Configuration.browserPosition = "1600x0";
        open(baseUrl);
    }

    @Test
    public void testClick() {
        SelenideElement cartText = $x("//span[@class='b-header-b-personal-e-icon-count-m-cart basket-in-cart-a j-cart-count']");
        cartText.click();
    }

    @Test
    public void testGet() {
        String currentUrl = WebDriverRunner.url();
        String source = WebDriverRunner.source();
        String title = WebDriverRunner.getWebDriver().getTitle();

        System.out.println(currentUrl);
        System.out.println(source);
        System.out.println(title);
    }

}
