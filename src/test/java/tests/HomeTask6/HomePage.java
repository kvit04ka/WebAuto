package test.java.tests.HomeTask6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

        WebDriver driver;
        WebDriverWait wait;

        public HomePage(WebDriver driver){
            this.driver = driver;
            wait = new WebDriverWait(this.driver, 30);

        }

        public HomePage open(){
            driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
            //   WebElement spinner = driver.findElement(By.id("preload-it"));
            //   wait.until(ExpectedConditions.visibilityOf(spinner));
            //   wait.until(ExpectedConditions.invisibilityOf(spinner));
            return this;
        }

        public HomePage openEveningCourses(){
            WebElement eveningCourses = driver.findElement(By.id("menu-item-7870"));
            wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
            eveningCourses.click();
            return this;

        }
        public HomePage openCourses(){
            WebElement courses = driver.findElement(By.id("menu-item-7871"));
            courses.click();
            return this;
        }

        public HomePage openDayTimeCourses(){
            WebElement dayCourses = driver.findElement(By.id("menu-item-7956"));
            wait.until(ExpectedConditions.visibilityOf(dayCourses));
            dayCourses.click();
            return this;
        }
        public HomePage openDayCourse(){
            WebElement DayCourse = driver.findElement(By.id("menu-item-7885"));
            wait.until(ExpectedConditions.visibilityOf(DayCourse));
            DayCourse.click();
            return this;
        }
        public List<String> getListCourses(){
            List<WebElement> courseElements = driver.findElements(By.xpath("//*[@id='course']/div/div/h2"));
            wait.until(ExpectedConditions.visibilityOfAllElements(courseElements));
            List<String> courseActual = new ArrayList<String>();
            for(WebElement el:courseElements){
                courseActual.add(el.getText());
                }
            return courseActual;
        }

        public HomePage openCoursePage(String courseTitle){
            WebElement eveningCourses = driver.findElement(By.xpath("//h2[contains(text(), '" + courseTitle + "')]/.."));
            wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
            eveningCourses.click();
            return this;

        }

      public HomePage clickPayBtn(){
           By buttonPay = By.xpath("//*[@id=\"level-form_course-list\"]/form[1]/ul/li/p[3]/button");
          WebElement buttonPayEl = driver.findElement(buttonPay);
           wait.until(ExpectedConditions.elementToBeClickable(buttonPay));
           buttonPayEl.click();
           return this;
    }
    public boolean checkInLocation(String location){
        By locationElement = By.xpath("//input[@type='radio'][div[@class='location-item__title'][contains(text(), '" + location + "')]");
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


