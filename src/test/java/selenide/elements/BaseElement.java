package selenide.elements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public abstract class BaseElement {

    protected SelenideElement element;

    protected String name;

    public BaseElement( LocatorTypes locatorType, String locator, String name) {
        if (locatorType == LocatorTypes.XPATH) {
            element = $x(locator);
        } else if (locatorType == LocatorTypes.CSS) {
            element = $(locator);
        }
        this.name = name;
    }

    @Step("Кликаем по элементy {this.name}")
    public void click() {
        element.click();
    }

    @Step("Найти сиблинга")
    public SelenideElement sibling(int index) {
        return element.sibling(index);
    }
}
