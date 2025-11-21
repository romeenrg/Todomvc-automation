import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class TodoChromeTest {

    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }

    /// REACT TESTS
    @DisplayName("Adding items to Todo list: React")
    @ParameterizedTest(name = "Adding item {0}, which tests {1}")
    @CsvFileSource(resources = "/ToDoItems.csv")

    public void reactAddItemsTest(String item, String condition) {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo(item);
        assertEquals(driver.findElement(By.cssSelector("li:nth-child(1) label")).getText(), item);
    }

    @Test
    void reactCountItemsTest() {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo("Example1");
        assertEquals(react.getTodoCount(1), react.specifyItemsLeft());
        react.addTodo("Example2");
        assertEquals(react.getTodoCount(2), react.specifyItemsLeft());
        react.clickDownArrow();
        assertEquals(react.getTodoCount(0), react.specifyItemsLeft()); // Assert there are 0 items
    }

    @Test
    void reactMarkCompleteTest() {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo("Example1");
        react.complete(1);
        assertTrue(driver.findElements(By.className("completed")).size() > 0);
        assertEquals(react.getTodoCount(0), react.specifyItemsLeft()); // Assert there are 0 items left
    }

    @Test
    void reactMarkIncompleteTest() throws Exception {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.addTodo("Example1");
        react.complete(1);
        react.incomplete(1);
        driver.findElement(By.className("todo-count"));
        assertTrue(driver.findElements(By.className("completed")).size() == 0);
        assertEquals(react.getTodoCount(1), react.specifyItemsLeft()); // Assert there's 1 item left
    }

    @Test
    void reactAddInvalidItemsTest() {
        TodoMVCReact react = new TodoMVCReact(driver);
        react.navigate();
        react.createList();
        for (String item : react.invalidItems) {
            react.addTodo(item);
              assertTrue(driver.findElements(By.cssSelector("li:nth-child(1) label")).isEmpty());
        }
    }

    /// PREACT TESTS
    @DisplayName("Adding items to Todo list: Preact")
    @ParameterizedTest(name = "Adding item {0}, which tests {1}")
    @CsvFileSource(resources = "/ToDoItems.csv")

    public void preactAddItemsTest(String item, String condition) {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo(item);
        assertEquals(driver.findElement(By.cssSelector("li:nth-child(1) label")).getText(), item);
    }

    @Test
    void preactCountItemsTest() {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo("Example1");
        assertEquals(preact.getTodoCount(1), preact.specifyItemsLeft());
        preact.addTodo("Example2");
        assertEquals(preact.getTodoCount(2), preact.specifyItemsLeft());
        preact.clickDownArrow();
        assertEquals(preact.getTodoCount(0), preact.specifyItemsLeft()); // Assert there are 0 items left
    }

    @Test
    void preactMarkCompleteTest() {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo("Example1");
        preact.complete(1);
        assertTrue(driver.findElements(By.className("completed")).size() > 0);
        assertEquals(preact.getTodoCount(0), preact.specifyItemsLeft()); // Assert there are 0 items left
    }

    @Test
    void preactMarkIncompleteTest() {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.addTodo("Example1");
        preact.complete(1);
        preact.incomplete(1);
        driver.findElement(By.className("todo-count"));
        assertTrue(driver.findElements(By.className("completed")).size() == 0);
        assertEquals(preact.getTodoCount(1), preact.specifyItemsLeft()); // Assert there are 0 items left
    }

    @Test
    void preactAddInvalidItemsTest() {
        TodoMVCPreact preact = new TodoMVCPreact(driver);
        preact.navigate();
        preact.createList();
        for (String item : preact.invalidItems) {
            preact.addTodo(item);
            assertTrue(driver.findElements(By.cssSelector("li:nth-child(1) label")).isEmpty());
        }
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}