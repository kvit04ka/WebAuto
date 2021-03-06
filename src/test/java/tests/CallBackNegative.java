package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CallBackNegative extends BaseTest{

    WebDriver driver = new ChromeDriver();


    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/");

        By callback = By.className("callback-btn");
        WebElement callbackEl = driver.findElement(callback);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(callback));
        callbackEl.click();

        WebElement submitBtn = driver.findElement(( By.xpath("//div[@class='b-header-contacte-phone-block']//input[@type='submit']") ));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();

        WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
        wait.until(ExpectedConditions.attributeContains(nameInput,"style", "border-color: red;" ));
        String actualNameStyle = nameInput.getAttribute("style");

        WebElement phoneInput = driver.findElement(By.xpath("//input[@name='phone']"));
        String actualPhoneStyle = phoneInput.getAttribute("style");

        String expectedValue = "border-color: red;";
        assertEquals(expectedValue, actualNameStyle, actualPhoneStyle);


        }

        @AfterMethod
        public void tearDown(){
        driver.quit();


    }
}
