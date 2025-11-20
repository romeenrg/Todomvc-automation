import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;

import static org.junit.jupiter.api.Assertions.*;
import java.io.File;


public class TodoChromeTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    void addValidItemsAndCountTest() {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.createList();
        Integer itemCount = 0;
        for (String item : react.validItems) {
            itemCount += 1;
            react.addTodo(item);
            assertEquals(react.getTodoCount(itemCount), react.specifyItemsLeft());
            assertEquals(driver.findElement(By.cssSelector("li:nth-child(" + itemCount + ") label")).getText(), item);
        }

        react.clickDownArrow();
        assertEquals(react.getTodoCount(0), react.specifyItemsLeft()); // Assert there are 0 items
    }

    @Test
    void reactCompleteTest() throws Exception {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo("Example1");
        react.complete(1);
        // Can we refactor this, possibly using a web element for the list of items in place of driver?
        assertTrue(driver.findElements(By.className("completed")).size() > 0);
        assertEquals(react.getTodoCount(0), react.specifyItemsLeft()); // Assert there are 0 items
    }

    @Test
    void reactIncompleteTest() throws Exception {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo("Example1");
        react.complete(1);
        react.incomplete(1);
        driver.findElement(By.className("todo-count"));

        assertTrue(driver.findElements(By.className("completed")).size() == 0);
        assertEquals(react.getTodoCount(1), react.specifyItemsLeft()); // Assert there are 0 items
    }



    @Test
    void addInvalidItemsReactTest() {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.createList();
        System.out.println();
        for (String item : react.invalidItems) {
            react.addTodo(item);
              assertTrue(driver.findElements(By.cssSelector("li:nth-child(1) label")).isEmpty());

        }
    }



    /// PREACT TESTS
    @Test
    void preactAddValidItemsAndCountTest() {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.createList();
        Integer itemCount = 0;
        for (String item : preact.validItems) {
            itemCount += 1;
            preact.addTodo(item);
            assertEquals(preact.getTodoCount(itemCount), preact.specifyItemsLeft());
            assertEquals(driver.findElement(By.cssSelector("li:nth-child(" + itemCount + ") label")).getText(), item);
        }

        preact.clickDownArrow();
        assertEquals(preact.getTodoCount(0), preact.specifyItemsLeft()); // Assert there are 0 items
    }

    @Test
    void preactCompleteTest() throws Exception {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo("Example1");
        preact.complete(1);
        // Can we refactor this, possibly using a web element for the list of items in place of driver?
        assertTrue(driver.findElements(By.className("completed")).size() > 0);
        assertEquals(preact.getTodoCount(0), preact.specifyItemsLeft()); // Assert there are 0 items
    }

    @Test
    void preactIncompleteTest() throws Exception {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo("Example1");
        preact.complete(1);
        preact.incomplete(1);
        driver.findElement(By.className("todo-count"));

        assertTrue(driver.findElements(By.className("completed")).size() == 0);
        assertEquals(preact.getTodoCount(1), preact.specifyItemsLeft()); // Assert there are 0 items
    }



    @Test
    void preactAddInvalidItemsPreactTest()throws Exception {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.createList();
        System.out.println();
        for (String item : preact.invalidItems) {
            preact.addTodo(item);
            Thread.sleep(1000);
            System.out.print(driver.findElements(By.cssSelector("li:nth-child(1) label")).size());
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