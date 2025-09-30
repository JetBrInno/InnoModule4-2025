package pageObjectsLessons.pageObjects.components;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class Header {
    private final WebDriver driver;

    public By inputSearchBy = By.xpath("//input[@placeholder='Поиск по Лабиринту']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Найти книгу {name}")
    public void searchBookByName(String name) {
        WebElement input = driver.findElement(inputSearchBy);
        input.sendKeys(name, Keys.RETURN);
    }
}
