package selenide.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenide.pageObjects.components.Header;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public abstract class BasePage {

    protected static final String baseUrl = "https://www.labirint.ru/";

    protected ElementsCollection cards = $$(".product-card");

    protected SelenideElement titleFounded = $("h1[class=index-top-title]");

    public Header header;

    public BasePage() {
        header = new Header();
    }

    @Attachment(type = "image/png", value = "element", fileExtension = "png")
    public byte[] takeScreen(WebElement element) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(type = "text/plain", value = "sql", fileExtension = "txt")
    public String takeSQL() {
        return "SELECT * FROM TABLE";
    }
}
