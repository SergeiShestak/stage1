package pageobjectmodel.objectpage;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import  org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {
    public void inputBoxControl() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://google.com");
        //new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"fakebox-input\"]"));
        searchInput.sendKeys("selenium java");

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result is exceed");


        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id=\"fakebox-input\"]"));
        searchBtn.get(0).click();
        List<WebElement> searchResult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@value='Go']")));
        driver.quit();



    }
}
