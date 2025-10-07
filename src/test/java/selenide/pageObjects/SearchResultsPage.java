package selenide.pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenide.pageObjects.components.BookCard;

import static com.codeborne.selenide.Condition.text;

public class SearchResultsPage extends BasePage {

    @Step("Взять найденную книгу")
    public BookCard getFoundedBook(int id) {
        SelenideElement card = cards.get(id);
        return new BookCard(card);
    }

    @Step("Дождаться, пока откроется страница результатов поиска")
    public void waitUntilPageOpened() {
        titleFounded.shouldBe(text("Все, что мы нашли в Лабиринте по запросу"));
    }
}
