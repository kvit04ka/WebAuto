package test.java.tests.HomeTask6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.tests.BaseTest;

public class CoursesPageData extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    public CoursesPageData(WebDriver driver) {

    }
//   public CoursesPageData clickPayBtn(){
 //       By buttonPay = By.xpath("//*[@id=\"level-form_course-list\"]/form[1]/ul/li/p[3]/button");

 //       WebElement buttonPayEl = driver.findElement(buttonPay);
 //       wait.until(ExpectedConditions.elementToBeClickable(buttonPay));
 //       buttonPayEl.click();
 //       return this;
//    }
    public boolean checkInLocation(String location){
        By locationElement = By.xpath("//input[@id=//div[contains(text(), '" + location + "')/../@for");
        WebElement courseLocation = driver.findElement(locationElement);
        wait.until(ExpectedConditions.presenceOfElementLocated(locationElement));
        return  courseLocation.isSelected();
    }

    public boolean selectedCheckbox(){
      By checkbox = By.xpath("//div[@id='privacy-policy']/label/span");
      WebElement privacyPolicy = driver.findElement(checkbox);
      wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
      return privacyPolicy.isSelected();
    }
}
