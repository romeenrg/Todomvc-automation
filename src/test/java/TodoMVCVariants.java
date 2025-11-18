import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoMVCVariants {

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

    public void assertNumTotal(Integer num){
        WebElement count = driver.findElement(By.className("todo-count"));
        assertEquals(num + " item left!", count.getText());

        //need to refactor: code to change item / items depending on num
    }
    
}
