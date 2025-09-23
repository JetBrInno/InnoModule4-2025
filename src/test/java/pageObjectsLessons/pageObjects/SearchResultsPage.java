package pageObjectsLessons.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public By itemsCardsBy = By.xpath("//a[contains(@class,'product-card__name')]");

    private By titleFounded = By.cssSelector("h1[class=index-top-title]");

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement getFoundedBook(int id) {
        List<WebElement> cards = driver.findElements(itemsCardsBy);
        return cards.get(id);
    }

    public void waitUntilPageOpened() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(titleFounded, "Все, что мы нашли в Лабиринте по запросу"));
    }
}
