import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
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

    @Test
    void reactCompleteTest() throws Exception {
        TodoMVCVariants react = new TodoMVCVariants(driver);
        react.navigate();
        react.addTodo("Example1");
//        react.addTodo("Example2");
//        react.addTodo("Example3");

        /// need to refactor
        react.complete(1);
//        takeScreenshot(driver, "completed1.png");
        react.incomplete(1);
//        takeScreenshot(driver, "incompleted1.png");

    }

    @Test
    void addValidItemsReactTest(){
        TodoMVCVariants react = new TodoMVCVariants(driver);
        react.navigate();
        react.createList();
        System.out.println();
        for (String item : react.validItems) {
            react.addTodo(item);

            assertEquals(driver.findElement(By.cssSelector("li:nth-child(1) label")).getText(), item);
            react.deleteItem(1);
        }

    }

    @Test
    void addInvalidItemsReactTest() {
        TodoMVCVariants react = new TodoMVCVariants(driver);
        react.navigate();
        react.createList();
        System.out.println();
        for (String item : react.invalidItems) {
            react.addTodo(item);
              assertTrue(driver.findElements(By.cssSelector("li:nth-child(1) label")).isEmpty());

        }
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
