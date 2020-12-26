package pageobjectmodel.hardcore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainTask {
    String adressTargetPage = "https://cloud.google.com";
    String adressMailingApp = "https://10minutemail.com";
    String inputSearchInfo = "Google Cloud Platform Calculator";
    By toBtnInstancesBy = By.name("q");
    By toFieldInstancesBy = By.name("q");
    By turnOnCalculatorFromSearchPage = By.xpath("//a[@class ='gs-title'] ");
    By toFieldOfInstances = By.xpath("//input[@name='quantity']");

    By toCheckBtnOfSeries = By.xpath("//md-select[@name='series']");
    By selectOfMachineType = By.xpath("//md-option[@value='n1']");

    By toCheckBtnOfMachineType = By.xpath("//md-select[@id ='select_88']");
    By selectOfMachine = By.xpath("//md-option[@id ='select_option_359']");

    By checkboxGPU = By.xpath("//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']");
    By checkNumberOfGPU = By.xpath("//md-select[@id='select_393']");
    By selectOfQuantityGPU = By.xpath("//md-option[@id='select_option_410']");
    By checkTypeOfGPU = By.xpath("//md-select[@id='select_395']");
    By selectTypeOfGPU = By.xpath("//md-option[@id='select_option_405']");

    By checkLocalSSD = By.xpath("//md-select[@id='select_354']");
    By selectLocalSSD = By.xpath("//md-option[@id='select_option_380']");

    By checkDatacenterLocation = By.xpath("//md-select[@id='select_90']");
    By selectDatacenterLocation = By.xpath("//md-option[@id='select_option_204']");

    By checkUsage = By.xpath("//md-select[@id='select_97']");
    By selectUsage = By.xpath("//md-option[@id='select_option_95']");

    By buttonAddToEstimate = By.xpath("//button[@aria-label ='Add to Estimate']");
    By buttonEmailToEstimate = By.xpath("//button[@aria-label='Email Estimate']");

    By buttonSendMailAddress = By.xpath("//button[@aria-label='Send Email']");

    String temporaryMailService = "https://10minutemail.com/";
    String gottenMailAdress;
    String secondWindow;
    String priceOfMessageMailService;
    String priceOfEstimateForm;
    Set<String> windowsSet;
    WebDriver driver;


    public void switchToWindow(int windowNumber) {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        int i = 1;
        while (iterator.hasNext() && i < 10) {
            String winHandle = iterator.next().toString();
            driver.switchTo().window(winHandle);
            System.out.println("Window title is " + driver.getTitle() + "size " + windows.size());
            if (i == windowNumber) break;
            i++;

        }
    }



    @Before
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(adressTargetPage);
    }

    @Test
    public void calculateGoogleCloudFee() throws InterruptedException, IOException, UnsupportedFlavorException {
        driver.findElement(toBtnInstancesBy).click();
        driver.findElement(toFieldInstancesBy).sendKeys(inputSearchInfo, Keys.RETURN);
        switchToWindow(0);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(turnOnCalculatorFromSearchPage));
        driver.findElement(turnOnCalculatorFromSearchPage).click();
        switchToWindow(1);

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        wait.until(ExpectedConditions.presenceOfElementLocated(toFieldOfInstances));
        driver.findElement(toFieldOfInstances).sendKeys("4");
        driver.findElement(toCheckBtnOfSeries).click();
        driver.findElement(selectOfMachineType).click();

        driver.findElement(toCheckBtnOfMachineType).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selectOfMachine));
        driver.findElement(selectOfMachine).click();

        driver.findElement(checkboxGPU).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(checkTypeOfGPU));
        driver.findElement(checkTypeOfGPU).click();
        driver.findElement(selectTypeOfGPU).click();
        driver.findElement(checkNumberOfGPU).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectOfQuantityGPU));
        driver.findElement(selectOfQuantityGPU).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(checkLocalSSD));
        driver.findElement(checkLocalSSD).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selectLocalSSD));
        driver.findElement(selectLocalSSD).click();

        driver.findElement(checkDatacenterLocation).click();
        wait.until(ExpectedConditions.elementToBeClickable(selectDatacenterLocation));
        driver.findElement(selectDatacenterLocation).click();

        driver.findElement(checkUsage).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selectUsage));
        driver.findElement(selectUsage).click();
        wait.withTimeout(Duration.ofSeconds(5));

        driver.findElement(buttonAddToEstimate).click();
        wait.withTimeout(Duration.ofSeconds(1));
        priceOfEstimateForm = driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/h2/b")).getText();

        wait.until(ExpectedConditions.elementToBeClickable(buttonEmailToEstimate));
        driver.findElement(buttonEmailToEstimate).click();

        //open mail service
        ((JavascriptExecutor)driver).executeScript("window.open();");
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        switchToWindow(0);
        driver.get(temporaryMailService);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("copy_address")));
        driver.findElement(By.id("copy_address")).click();
        gottenMailAdress = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        switchToWindow(1);
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        driver.findElement(By.id("input_475")).sendKeys(gottenMailAdress);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSendMailAddress));
        driver.findElement(buttonSendMailAddress).click();

        switchToWindow(0);
        wait.withTimeout(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id='mail_messages_content']/div/div[1]/div[2]/span")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        priceOfMessageMailService = driver.findElement(By.xpath("//*[@id='mobilepadding']/td/table/tbody/tr[2]/td[2]/h3")).getText();
        Assert.assertTrue((priceOfMessageMailService.contains(priceOfEstimateForm)));


    }

    @After
    public void cleanAfterSelf() { driver.quit();
    }
}





