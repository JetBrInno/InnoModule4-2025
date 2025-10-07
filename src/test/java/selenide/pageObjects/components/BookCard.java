package selenide.pageObjects.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BookCard {

    public SelenideElement element;

    public SelenideElement title = $(".product-card__name");

    public SelenideElement button = $(".btn-tocart");


    public BookCard(SelenideElement element) {
        this.element = element;
    }

    @Step("Ждем, пока кнопка не станет равна кнопке оформить")
    public void waitForButtonChanged() {
        button.shouldHave(text("Оформить"));
    }
}
