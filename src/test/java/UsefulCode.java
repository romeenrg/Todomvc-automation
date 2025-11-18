/*
public class UsefulCode {
    public static void main(String[] args) {

    }
}

// ***************************************************************************************************
// Set up tests

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver; // If using Chrome
import org.openqa.selenium.firefox.FirefoxDriver; // If using Firefox
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MakersTest {
    private static ChromeDriver driver;
    private static FirefoxDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }

    // Your tests will go here!
    @Test
    public void whateverMyTestShouldBeCalled() {
        driver.get("https://examplesite.com");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }
}

// ***************************************************************************************************
// Locators

// Element id
WebElement locationDropdown = driver.findElement(By.id("zone"));

// CSS
WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));

// XPath
WebElement rememberMe = driver.findElement(By.xpath("xpath=//span/form/input[@type='checkbox']"));

// Link text
WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));

// Partial link text
WebElement profileLink = driver.findElement(By.partialLinkText("Hello,"));

// ***************************************************************************************************
// Actions

//Text Boxes
WebElement usernameField = driver.findElement(By.name("usr"));
usernameField.sendKeys("sue_smith");

searchField.sendKeys("selenium" + Keys.ENTER);

// Checkboxes and radio buttons

WebElement rememberMe = driver.findElement(By.cssSelector("input[type='checkbox']"));
rememberMe.click();

if ( !rememberMe.isSelected() ) {
        // Element not curently selected, so click it
        rememberMe.click();
}

// Drop-down lists

WebElement locationElement = driver.findElement(By.id("zone"));
Select locationDropdown = new Select(locationElement);

    // Option 1: Select the first item using its label
locationDropdown.selectByVisibleText("Europe"));

    // Option 2: Select the first item using its value (ID)
        locationDropdown.selectByValue("eu");

    // Option 3: Select the first item using its index (starts with zero)
locationDropdown.selectByIndex(0);


// Clicking on a link
WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password?"));
forgotPasswordLink.click();

// Scrolling on a webpage

    //ONLY SUPPORTED IN CHROMIUM-FLAVOURED BROWSERS
    // locate the element
WebElement privacyLink = driver.findElement(By.linkText("Privacy Policy"));

    // use the Actions API to move (scroll) to the element
new Actions(driver).moveToElement(privacyLink).perform();

        // now the link is on-screen, we can click it as normal
privacyLink.click();

    //CROSS-BROWSER COMPATIBLE
    // locate the element
WebElement privacyLink = driver.findElement(By.linkText("Privacy Policy"));

    // execute some JavaScript to move (scroll) to the element
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", privacyLink);
Thread.sleep(2000); // unlike the Actions API, we have to manually wait for the JavaScript to finish executing the scroll

    // now the link is on-screen, we can click it as normal
privacyLink.click();

// Switching to a new window
    // click the link that you want to open
driver.findElement(By.linkText("Open new window")).click();

    // identify all of the windows, and instruct the driver to switch to window 1 (the new one)
Object[] windowHandles=driver.getWindowHandles().toArray();
driver.switchTo().window((String) windowHandles[1]);

// ***************************************************************************************************
//Waiting
Thread.sleep(5000);

//Implicit wait
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://makers.tech");

    // Now the test will wait for up to 10 seconds for this (or any subsequent)
    // element to occur
WebElement myDynamicElement = driver.findElement(By.id("myDynamicElement"));

// Explicit waits
WebElement results = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(driver -> driver.findElement(By.id("results")));

// ***************************************************************************************************
 // Horrify the Cookie Monster and reject cookies.
        WebElement rejectAll = driver.findElement(By.id("ccc-reject-settings"));
        Thread.sleep(3000);
        rejectAll.click();
// ***************************************************************************************************
// Assertions
// Required import for assertions
import static org.junit.jupiter.api.Assertions.*;

WebElement helloMessage = driver.findElement(By.xpath("css=h1"));
assertEquals("Hello, Clive!", helloMessage.getText());

//assertNotEquals
WebElement accountBalance = driver.findElement(By.id("balance"));
    // Fail if the account balance is zero
assertNotEquals("Balance: £0.00", accountBalance.getText());

//assertTrue/assertFalse
WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
assertTrue(loginButton.isDisplayed());

WebElement errorMessage = driver.findElement(By.id("error-message"));
assertFalse(errorMessage.isDisplayed()); // Passes if message not present.

// fail
fail("This test is not yet implemented.");

WebElement errorMessage = driver.findElement(By.id("error-message"));
if (errorMessage.isDisplayed()) {
// If error message appears, print its text in the test output.
fail("Attempted to log in, but error appeared: " + errorMessage.getText());
        }
// Checking the specific number of matching elements
    // Imagine a news website where every news headline was tagged with the class "article"
List<WebElement> newsItems = driver.findElements(By.className("article"));
assertTrue(newsItems.size() == 1, "Only one news article");

    // ...or if, for example, the number of news items is capped to 10 per page
assertTrue(newsItems.size() == 10, "Ten news items found");

    // ...or if you don't care how many there are, as long as it's more than 1
assertTrue(newsItems.size() > 1, "Loads of news items");

// Data-Driven Testing
@DisplayName - this is a JUnit annotation which allows us to specify a custom
name for the test. Just like the name of the test method itself, it should be
a name which encapsulates what you're attempting to test across all of these iterations.

  @ParameterizedTest - this is a JUnit annotation which tells JUnit that this test should
  be run multiple times, with different data each time. The optional name parameter allows
  us to specify a custom name for each iteration, and as you can see from both the code example
  and the screenshot, we can use {0}, {1}, etc. to refer to the first, second, etc. parameters
  from our data, to make the messages in the test output even clearer.

  @CsvSource - this is a JUnit annotation which allows us to specify the data which should be used
  for each iteration of the test. The data is specified as a comma-separated list of values, with
  each line representing a new iteration of the test. The first value on each line is the first
  parameter to the test, the second value is the second parameter, and so on.
 */