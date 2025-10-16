package selenide.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.refresh;


// Плюсы пейдж обджектов
// 1. Централизованность и структурированность (все хранится в отдельных файлах)
// 2. Отсутствие дубликатов кода
// 3. Легче писать новые тесты обращаясь к уже существующим локаторам и используя уже существующие методы
// 4. Тесты становятся более человекчитаемые

// Минусы пейдж обджектов
// 1. Первый раз писать пейджи долго, нужно описать все нужные поля и методы. Поэтому тестов должно быть много, чтобы это было рентабельно.
// 2. Повторяющиеся элементы на разных страницах
public class MainPage extends BasePage {

    public void firstOpen() {
        open();
        WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("cookie_policy", "1"));
        refresh();
    }

    @Step("Открываем Главную страницу")
    public void open() {
        Selenide.open(baseUrl);
    }
}
