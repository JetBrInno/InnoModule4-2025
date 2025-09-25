package pageObjectsLessons.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.MainPage;
import pageObjectsLessons.pageObjects.SearchResultsPage;

import java.time.Duration;

/**
 * Плюсы
 * 1. Становится меньше повторяющегося кода
 * 2. Настройка окружения происходит в одном месте
 * Минусы
 * 1. Читаемость. Не понимаем, где происходит создание переменных. Нужно проваливаться в BaseTest.
 * 2. Если переопределить @BeforeEach с тем же названием метода, можно все сломать
 * 3. Может присутствовать лишний код (который нужен в одном тесте, но не нужен в другом)
 */
public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String baseUrl = "https://www.labirint.ru/";

    protected MainPage mainPage;
    protected SearchResultsPage searchResultsPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(1));
        mainPage = new MainPage(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);

        driver.get(baseUrl);
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
