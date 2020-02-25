package test.java.tests.HomeTask6;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.tests.BaseTest;

public class CoursesPageData extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(CoursesPageData.class);

    public CoursesPageData(WebDriver driver) {
        super(driver);
    }

    public CoursesPageData clickBtnPay() {
            WebElement buttonPay = driver.findElement(By.xpath("(//button[@name='roadFull_payOnce']"));
            wait.until(ExpectedConditions.elementToBeClickable(buttonPay));
            buttonPay.click();
            logger.info("Clicked Pay button");
            return this;
        }
        public boolean checkInLocation(String location) {
            By locationEl = By.xpath("//input[@id=//div[contains(text(), '" + location + "')]/../@for]");
            WebElement courseLocation = driver.findElement(locationEl);
            wait.until(ExpectedConditions.presenceOfElementLocated(locationEl));
            logger.info("Checked location '"+ location +"'");
            return courseLocation.isSelected();
        }

        public boolean selectedCheckbox(){
            By checkbox = By.xpath("//*[@id='privacy-policy']/label/span");
            WebElement privacyPolicy = driver.findElement(checkbox);
            wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
            logger.info("Checked checkbox from Privacy Policy");
            return privacyPolicy.isSelected();
        }
    }

