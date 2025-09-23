package pageObjectsLessons.pageObjects;

import org.openqa.selenium.*;


// Плюсы пейдж обджектов
// 1. Централизованность и структурированность (все хранится в отдельных файлах)
// 2. Отсутствие дубликатов кода
// 3. Легче писать новые тесты обращаясь к уже существующим локаторам и используя уже существующие методы
// 4. Тесты становятся более человекчитаемые

// Минусы пейдж обджектов
// 1. Первый раз писать пейджи долго, нужно описать все нужные поля и методы. Поэтому тестов должно быть много, чтобы это было рентабельно.
// 2.
public class MainPage {
    private final WebDriver driver;

    private static final String baseUrl = "https://www.labirint.ru/";

    public By inputSearchBy = By.xpath("//input[@placeholder='Поиск по Лабиринту']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchBookByName(String name) {
        WebElement input = driver.findElement(inputSearchBy);
        input.sendKeys(name, Keys.RETURN);
    }

    public void firstOpen() {
        open();
        driver.manage().addCookie(new Cookie("cookie_policy", "1"));
        driver.navigate().refresh();
    }

    public void open() {
        driver.get(baseUrl);
    }
}
