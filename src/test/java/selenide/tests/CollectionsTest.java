package selenide.tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import selenide.Conditions.HasChildCondition;
import selenide.elements.Button;
import selenide.elements.LocatorTypes;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static selenide.Conditions.HasChildCondition.hasChild;

public class CollectionsTest {


    private static final String baseUrl = "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";

    @BeforeEach
    public void setUp() {
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
        Configuration.headless = true;
        open(baseUrl);
    }

    @Test
    public void testListByText() {
        //SelenideElement button = $x("");
        Button button = new Button(LocatorTypes.XPATH, "//button[@id='my-dropdown-1']", "Синяя кнопка");
        button.click();
        SelenideElement ul = button.sibling(0);
        ElementsCollection elements = ul.findAll("li");
        elements.filter(text("Something else here")).shouldHave(size(1));
    }

    @Test
    public void testLiElements() {
        SelenideElement button = $x("//button[@id='my-dropdown-1']");
        button.click();
        SelenideElement ul = button.sibling(0);
        ElementsCollection elements = ul.findAll("li");
        elements.filter(hasChild("a")).shouldHave(size(4));
    }

    // HOMEWORK
    // 1. Написать тест на проверку раскрытия бокового меню на странице Рейтинги https://www.labirint.ru/rating/?id_genre=-1&nrd=1
    // 2. В процессе - создать пейдж обджект на селениде для страницы рейтинги
}
