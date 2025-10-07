package selenide.pageObjects.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class Header {

    public SelenideElement input = $x("//input[@placeholder='Поиск по Лабиринту']");
    public SelenideElement cartCounter = $x("//span[contains(@class,'j-cart-count')]");

    @Step("Найти книгу {name}")
    public void searchBookByName(String name) {
        input.setValue(name).pressEnter();
    }
}
