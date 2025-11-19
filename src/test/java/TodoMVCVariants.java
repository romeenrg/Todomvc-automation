import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMVCVariants {
    static List<String> validItems = new ArrayList<>();
    static List<String> invalidItems = new ArrayList<>();

    protected WebDriver driver;
    private By inputBox = By.id("todo-input");


    public TodoMVCVariants(WebDriver driver){
        this.driver = driver;
    }

    public void navigate(){
        driver.get("https://todomvc.com/examples/react/dist/");
    }

    public void assertTitle(){
        assertEquals("TodoMVC: React", driver.getTitle());
    }


    public void addTodo(String task){
        driver.findElement(inputBox).sendKeys(task);
        driver.findElement(inputBox).sendKeys(Keys.ENTER);
    }

    public void createList() {
        invalidItems.add(""); //empty input
        invalidItems.add(" "); // space
        invalidItems.add("t"); //single letter

        validItems.add("èxample"); // lower case accent
        validItems.add("ÅnExample"); // upper case accent
        validItems.add("Example!"); // symbol (!)
        validItems.add("Lorem ipsum dolor sit amet consectetur adipiscing elit. " +
                "Quisque faucibus ex sapien vitae pellentesque sem placerat. In" +
                " id cursus mi pretium tellus duis convallis. Tempus leo eu aenean" +
                " sed diam urna tempor. Pulvinar vivamus fringilla lacus nec metus bibendu"); // 256 characters
        validItems.add("Æxample"); // ligature
        validItems.add("Example1"); // number
    }

    public void clickDownArrow() {
        driver.findElement(By.id("toggle-all")).click();
        // way to call, and assert that all items are marked as completed.
        //  react.clickDownArrow();
        //  react.assertNumTotal(0);
    }

    public void modifyItem() {
        WebElement dropdown = driver.findElement(By.className("todo-list"));

    }

    // need to refactor
    public void complete(Integer num) {
        driver.findElement(By.cssSelector("li:nth-child(" + num + ") .toggle")).click();
    }

    public void incomplete(Integer num) {
        driver.findElement(By.cssSelector("li:nth-child(" + num + ") .toggle")).click();
    }

    public void assertNumTotal(Integer num){
        WebElement count = driver.findElement(By.className("todo-count"));

        if (num == 1) {
            assertEquals(num + " item left!", count.getText());
        }
        else {
            assertEquals(num + " items left!", count.getText());
        }
        //need to refactor: code to change item / items depending on num
    }

}
