package pageObjectsLessons.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreenTest extends BaseTest {

    @Test
    public void screenTest() throws IOException {
        driver.get("https://www.labirint.ru/series/64699/?erid=2k4GESNvWrVQsVWBnBCJrDrauhrjnhrqHYijMxAYJ");
        WebElement element = driver.findElement(By.xpath("//a[@class='b-header-b-personal-e-link top-link-main analytics-click-js cart-icon-js']"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("(//span[@class='product-title'])[1]"),"Harry Potter and the Prisoner of Azkaban"));
        //element.getScreenshotAs(OutputType.FILE).renameTo(Path.of("divToBe.png").toFile());
        byte[] cartAsIs = element.getScreenshotAs(OutputType.BYTES);
        byte[] cartToBe = Files.readAllBytes(Path.of("divToBe.png"));
        assertArrayEquals(cartToBe, cartAsIs);
    }
}
