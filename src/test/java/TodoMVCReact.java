import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMVCReact {
    static List<String> validItems = new ArrayList<>();
    static List<String> invalidItems = new ArrayList<>();

    protected WebDriver driver;
    private By inputBox = By.id("todo-input");


    public TodoMVCReact(WebDriver driver){
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
        // Consider converting to a hashmap if time.

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
        driver.findElement(By.className("completed"));
    }

    public void incomplete(Integer num) {
        driver.findElement(By.cssSelector(".completed:nth-child(" + num + ") .toggle")).click();
    }

    public String specifyItemsLeft() {
        return driver.findElement(By.className("todo-count")).getText();
    }

    public String getTodoCount(Integer itemCount) {
         driver.findElement(By.className("todo-count"));

         if (itemCount == 1) {
             return "1 item left!";
         } else {
             return itemCount + " items left!";
         }

//         String itemsLeft = Pattern.compile("item[s]? left!");
////        assertTrue(Pattern.compile("[-]?[0-9]+°C").matcher

        //need to refactor: code to change item / items depending on num
    }

    public void deleteItem(Integer num) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.cssSelector("li:nth-child(1) label"));
        actions.moveToElement(hover);

        WebElement cross = driver.findElement(By.cssSelector("li:nth-child(" + num + ") .destroy"));
        actions.moveToElement(cross);
        actions.click();
        actions.perform();

    }

}

