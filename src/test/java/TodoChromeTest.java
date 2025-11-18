import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;


public class TodoChromeTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }


    @Test
    void reactTest() throws Exception {
        TodoMVCVariants react = new TodoMVCVariants(driver);
        react.navigate();
        react.assertTitle();
        react.addTodo("Example1");
        react.assertNumTotal(1);
    }





    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
    public static void takeScreenshot(WebDriver webdriver, String desiredPath) throws Exception{
        TakesScreenshot screenshot = ((TakesScreenshot)webdriver);
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(desiredPath);
        FileUtils.copyFile(screenshotFile, targetFile);
    }
}
