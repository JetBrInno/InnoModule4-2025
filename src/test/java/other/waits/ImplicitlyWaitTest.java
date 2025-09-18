package other.waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplicitlyWaitTest {

    private WebDriver driver;

    private static final String baseUrl = "https://sky-todo-list.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().window().setPosition(new Point(1900, 0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // плюсы
        // 1. Легко задать общее время ожидания всем элементам
        // 2. Если элемент найден ранее - то тест продолжает выполнение, мы не теряем лишнее время
        // минусы
        // 1. Если какому-то элементу порой нужно, допустим, 20 секунд времени. Это значит, что вам придется
        // задать 20 секунд для поиска всех элементов. И в случае падения теста мы теряем много времени на поиск несуществ. элемента
        // 2. Мы можем задавать ожидание появления элемента. Но не можем задавать конкретные условия.
    }

    @Test
    public void testImplWait() throws InterruptedException {
        driver.get(baseUrl);
        // Thread.sleep(10000); // минусы - нестабильность, слишком много времени теряем
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        assertTrue(rows.size() > 0);
        System.out.println(rows.size());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
