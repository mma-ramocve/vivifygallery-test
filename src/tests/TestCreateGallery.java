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

public class TestCreateGallery {
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

    @Test(priority = 0, testName = "Test if click on Create Gallery as logged in user takes to correct page")
    public void logInExistingUser() {
        driver.findElement(By.xpath(Home.loginTabXPath)).click();

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

        driver.findElement(By.xpath(Login.createGalleryTabXPath)).click();

        String createGalleryPageTitle = driver.findElement(By.xpath("//h1[contains(text(),'Create Gallery')]")).getText().trim();
        Assert.assertEquals(createGalleryPageTitle, "CREATE GALLERY");
    }

    @Test(priority = 1, testName = "Test to create gallery as logged in user")
    public void createGallery() {
        WebElement title = driver.findElement(By.xpath(Login.newGalleryTitleXPath));
        title.clear();
        title.sendKeys("Snow");

        WebElement descriptions = driver.findElement(By.xpath(Login.newGalleryDescriptionXPath));
        descriptions.clear();
        descriptions.sendKeys("Snow on trees");

        WebElement image = driver.findElement(By.xpath(Login.newGalleryImagesUrlXPath));
        image.clear();
        image.sendKeys("https://cdn.pixabay.com/photo/2019/12/30/20/34/snow-4730553_1280.jpg");

        driver.findElement(By.xpath(Login.newGallerySubmitButtonXPath)).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Snow')]")));

        String newGalleryAuthor = driver.findElement(By.xpath("//a[contains(text(),'Aleksandra Kovacevic')]")).getText().trim();
        Assert.assertEquals(newGalleryAuthor, "Aleksandra Kovacevic");
    }

    @Test(priority = 2, testName = "Test if new gallery is created")
    public void openNewGallery() {
        driver.findElement(By.xpath(Login.myGalleriesTabXpath)).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'My Galleries')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Snow')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Edit Gallery')]")));

        String newGalleryTitle = driver.findElement(By.xpath("//h1[contains(text(),'Snow')]")).getText().trim();
        Assert.assertEquals(newGalleryTitle, "SNOW");
    }


}