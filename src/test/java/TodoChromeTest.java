import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;


public class todo_Chrome {

    private static ChromeDriver driver;

    @BeforeAll
    static void launchBrowser() {
        driver = new ChromeDriver();
    }


    @Test
    public void whateverMyTestShouldBeCalled() {
        driver.get("https://todomvc.com/");
    }


    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }


}
