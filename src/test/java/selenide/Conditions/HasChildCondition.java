package selenide.Conditions;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class HasChildCondition extends WebElementCondition {

    private final String tagName;

    //static factory method
    public static HasChildCondition hasChild(String tagName) {
        return new HasChildCondition(tagName);
    }

    protected HasChildCondition(String tagName) {
        super(tagName);
        this.tagName = tagName;
    }

    @Override
    public CheckResult check(Driver driver, WebElement element) {
        try {
            element.findElement(By.cssSelector(tagName));
            return CheckResult.accepted();
        }
        catch (NoSuchElementException exception) {
            return CheckResult.rejected("Этот дочерний элемент отсутствует", "");
        }
    }
}
