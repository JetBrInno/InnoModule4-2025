package pageObjectsLessons.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookCard {
    private final WebElement element;

    private By title = By.cssSelector(".product-card__name");

    private By button = By.cssSelector(".btn-tocart");

    private WebDriverWait wait;

    public BookCard(WebElement element, WebDriverWait wait) {
        this.element = element;
        this.wait = wait;
    }

    public WebElement findTitle() {
        return element.findElement(title);
    }

    public WebElement findButton() {
        return element.findElement(button);
    }

    @Step("Ждем, пока кнопка не станет равна кнопке оформить")
    public void waitForButtonChanged() {
        wait.until(ExpectedConditions.textToBePresentInElement(findButton(), "оформить"));
    }
}
