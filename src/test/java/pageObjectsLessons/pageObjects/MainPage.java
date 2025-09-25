package pageObjectsLessons.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.components.Header;


// Плюсы пейдж обджектов
// 1. Централизованность и структурированность (все хранится в отдельных файлах)
// 2. Отсутствие дубликатов кода
// 3. Легче писать новые тесты обращаясь к уже существующим локаторам и используя уже существующие методы
// 4. Тесты становятся более человекчитаемые

// Минусы пейдж обджектов
// 1. Первый раз писать пейджи долго, нужно описать все нужные поля и методы. Поэтому тестов должно быть много, чтобы это было рентабельно.
// 2. Повторяющиеся элементы на разных страницах
public class MainPage extends BasePage {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
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
