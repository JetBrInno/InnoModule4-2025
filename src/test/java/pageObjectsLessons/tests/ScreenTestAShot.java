package pageObjectsLessons.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ScreenTestAShot extends BaseTest {

    @Test
    public void screenTest() throws IOException {
        driver.get("https://www.labirint.ru/series/64699/?erid=2k4GESNvWrVQsVWBnBCJrDrauhrjnhrqHYijMxAYJ");
        WebElement element = driver.findElement(By.xpath("//a[@class='b-header-b-personal-e-link top-link-main analytics-click-js cart-icon-js']"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("(//span[@class='product-title'])[1]"),"Harry Potter and the Prisoner of Azkaban"));
        //element.getScreenshotAs(OutputType.FILE).renameTo(Path.of("divToBe.png").toFile());

        BufferedImage cartToBe = ImageIO.read(Path.of("divToBe.png").toFile());
        BufferedImage cartAsIs = new AShot().takeScreenshot(driver, element).getImage();

        ImageDiff imageDiff = new ImageDiffer().makeDiff(cartToBe, cartAsIs);

        ImageIO.write( imageDiff.getDiffImage(), "png", Path.of("getDiffImage.png").toFile());
        ImageIO.write( imageDiff.getMarkedImage(), "png", Path.of("getMarkedImage.png").toFile());
        ImageIO.write( imageDiff.getTransparentMarkedImage(), "png", Path.of("getTransparentMarkedImage.png").toFile());
        System.out.println(imageDiff.hasDiff());
        assertTrue(imageDiff.hasDiff());
        //ImageIO.write(image, "png", Path.of("divToBe.png").toFile());


       // byte[] cartAsIs = element.getScreenshotAs(OutputType.BYTES);
        //byte[] cartToBe = Files.readAllBytes(Path.of("divToBe.png"));
        //assertArrayEquals(cartToBe, cartAsIs);
    }
}
