package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class TestHome {
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


    @Test(priority = 0, testName = "Test if click on Register tab takes to correct page")
    public void getRegisterPage() {
        driver.findElement(By.xpath(Home.registerTabXPath)).click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, Home.registerUrl);
    }

    @Test(priority = 1, testName = "Test if click on Gallery App tab takes to home page")
    public void getHomePageFromRegister() {
        driver.findElement(By.xpath(Home.galleryAppTabXPath)).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'All Galleries')]")));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, Home.homeUrl + "/");
    }
}
