package pageObjectsLessons.pageObjects;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectsLessons.pageObjects.components.Header;

import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;

    protected static final String baseUrl = "https://www.labirint.ru/";

    protected final WebDriverWait wait;

    @FindBy(css= ".product-card")
    protected List<WebElement> cards;

    protected By titleFounded = By.cssSelector("h1[class=index-top-title]");

    public Header header;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
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
