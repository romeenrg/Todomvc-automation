import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMVCPreact {
    static List<String> invalidItems = new ArrayList<>();

    protected WebDriver driver;
    private By inputBox = By.className("new-todo");

    public TodoMVCPreact(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get("https://todomvc.com/examples/preact/dist/");
    }

    public void addTodo(String task){
        driver.findElement(inputBox).sendKeys(task);
        driver.findElement(inputBox).sendKeys(Keys.ENTER);
    }

    public void createList() {
        invalidItems.add(""); //empty input
        invalidItems.add(" "); // space
    }

    public void clickDownArrow() {
        driver.findElement(By.className("toggle-all")).click();
    }

    public void complete(Integer num) {
        driver.findElement(By.cssSelector("li:nth-child(" + num + ") .toggle")).click();
    }

    public void incomplete(Integer num) {
        driver.findElement(By.cssSelector(".completed:nth-child(" + num + ") .toggle")).click();
    }

    public String specifyItemsLeft() {
        return driver.findElement(By.className("todo-count")).getText();
    }

    public String getTodoCount(Integer itemCount) {
         if (itemCount == 1) {
             return "1 item left!";
         } else {
             return itemCount + " items left!";
         }
    }
}

