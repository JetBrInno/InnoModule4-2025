package selenide.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenide.pageObjects.MainPage;
import selenide.pageObjects.SearchResultsPage;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

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

    protected static final String baseUrl = "https://www.labirint.ru/";

    protected MainPage mainPage;
    protected SearchResultsPage searchResultsPage;

    @BeforeEach
    public void setUp() {
        // либо для тонкой настройки:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
              //  .includeSelenideSteps(true)
        );
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.browserSize = "1280x1024";
        Configuration.browserPosition = "1600x0";
        open(baseUrl);
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("cookie_policy", "1"));
        refresh();
        mainPage = new MainPage();
        searchResultsPage = new SearchResultsPage();
    }
}
