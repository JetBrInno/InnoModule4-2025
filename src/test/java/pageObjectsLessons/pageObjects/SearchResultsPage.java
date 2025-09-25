package pageObjectsLessons.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.components.BookCard;
import pageObjectsLessons.pageObjects.components.Header;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public BookCard getFoundedBook(int id) {
        WebElement card = cards.get(id);
        return new BookCard(card, wait);
    }

    public void waitUntilPageOpened() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(titleFounded, "Все, что мы нашли в Лабиринте по запросу"));
    }
}
