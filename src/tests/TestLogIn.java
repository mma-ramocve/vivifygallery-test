package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class TestLogIn {
    public WebDriver driver;

    @BeforeClass
    public void getHomePage() {
        System.setProperty("webdriver.chrome.driver", Home.driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Home.homeUrl);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }


    @Test(priority = 0, testName = "Test if click on Login tab takes to correct page")
    public void getLoginPage() {
        driver.findElement(By.xpath(Home.loginTabXPath)).click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, Login.loginUrl);
    }

    @Test(priority = 1, testName = "Test login with valid credentials")
    public void logInExistingUser() {
        WebElement email = driver.findElement(By.xpath(Login.loginEmailXPath));
        email.clear();
        email.sendKeys("mma.ramocve@gmail.com");

        WebElement password = driver.findElement(By.xpath(Login.loginPasswordXPath));
        password.clear();
        password.sendKeys("Beljanica1622");

        WebElement submit = driver.findElement(By.xpath(Login.submitButtonXPath));
        submit.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Logout')]")));

        driver.findElement(By.xpath(Login.myGalleriesTabXpath)).click();

        String myGalleriesPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'My Galleries')]")).getText().trim();
        Assert.assertEquals(myGalleriesPageTitle, "MY GALLERIES");
    }
}
