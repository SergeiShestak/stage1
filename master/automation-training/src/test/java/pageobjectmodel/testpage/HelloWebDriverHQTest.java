package pageobjectmodel.testpage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.naming.ldap.PagedResultsControl;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
public class HelloWebDriverHQTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup (){
        driver = new ChromeDriver();

    }

    @Test (description = "test description, JIRA here")
    public void commonSearchTest() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
        System.out.println(firstResult.getAttribute("textContent"));
        Assert.assertNotNull(driver.findElement(By.name("q")));
    }

        @AfterMethod (alwaysRun = true)

        public void  cleanBrowser(){
        driver.quit();
        driver = null;
    }
}
