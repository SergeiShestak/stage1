package pageobjectmodel.objectpage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Train {
    By container = By.cssSelector(".container");


@Test
    public void openMainPage() {
    By container = By.cssSelector(".container");
    WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout for waiting search result is exceed");

    driver.get("https://google.com/ncr");
    List<WebElement> waiter = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(container));
    WebElement inputBox = driver.findElement(By.xpath("/input[class='gLFyf gsfi'"));
    inputBox.sendKeys("selenium java" + Keys.ENTER);


    List<WebElement> searchBtn = driver.findElements(By.xpath("//input[class='gLFyf gsfi'"));
    List<WebElement> searchResult = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[class='gLFyf gsfi']")));
   }
}
