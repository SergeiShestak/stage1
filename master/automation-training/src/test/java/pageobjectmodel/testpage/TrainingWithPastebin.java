package pageobjectmodel.testpage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TrainingWithPastebin {
    private WebDriver driver;
    private By submitButtonTarget = By.xpath("//button[@type='submit']");
    private By inputTextForm = By.xpath("//textarea[@id='postform-text']");
    private By mainMenuTarget = By.id("select2-postform-expiration-container");
    private By subMenuTarget = By.cssSelector("#select2-postform-expiration-container");
    private String congratulation = "Hello WebDriver";
    private String greeting = "helloweb";

    @BeforeMethod (alwaysRun = true)
    public void setupDriver(){
        driver = new FirefoxDriver();
        driver.get("https://pastebin.com/");

    }
    @Test
    public void createNewPaste() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement selectMainMenu = driver.findElement(mainMenuTarget);
        WebElement selectSubMenuTime = driver.findElement(submitButtonTarget);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;",mainMenuTarget);
        wait.until(ExpectedConditions.elementToBeClickable(subMenuTarget));
        js.executeScript("arguments[0].click;",subMenuTarget);

        driver.findElement(By.xpath("//input[@id='postform-name']")).sendKeys(greeting);
        driver.findElement(inputTextForm).sendKeys(congratulation);
        driver.findElement(submitButtonTarget).click();

    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

}

