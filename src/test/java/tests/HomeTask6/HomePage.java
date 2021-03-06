package test.java.tests.HomeTask6;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

        WebDriver driver;
        WebDriverWait wait;
        public Logger logger = LogManager.getLogger(HomePage.class);

        public HomePage(WebDriver driver){
            this.driver = driver;
            wait = new WebDriverWait(this.driver, 30);

        }

        @Step("Open home page")
        public HomePage open(){
            driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
            //   WebElement spinner = driver.findElement(By.id("preload-it"));
            //   wait.until(ExpectedConditions.visibilityOf(spinner));
            //   wait.until(ExpectedConditions.invisibilityOf(spinner));
            logger.info("Home page is opened");
            driver.get(PropertyLoader.getProperty("url"));
            return this;
        }

        @Step("Open Evening courses menu item")
        public HomePage openEveningCourses(){
            WebElement eveningCourses = driver.findElement(By.id("menu-item-7870"));
            wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
            eveningCourses.click();
            logger.info("Clicked on Evening courses");
            return this;

        }

        @Step("Click on the Courses under Drop-down menu")
        public HomePage openCourses(){
            WebElement courses = driver.findElement(By.id("menu-item-7871"));
            courses.click();
            logger.debug("Clicked on Courses under the Evening Courses menu item");
            return this;
        }

        @Step("Open Day courses menu item")
        public HomePage openDayTimeCourses(){
            WebElement dayCourses = driver.findElement(By.id("menu-item-7956"));
            wait.until(ExpectedConditions.visibilityOf(dayCourses));
            dayCourses.click();
            logger.info("opened DayTime courses drop-dorwn list");
            return this;
        }

        @Step("Open Courses under the drop-down")
        public HomePage openDayCourse(){
            WebElement DayCourse = driver.findElement(By.id("menu-item-7885"));
            wait.until(ExpectedConditions.visibilityOf(DayCourse));
            DayCourse.click();
            logger.debug("Opened Courses menu item under the DayCourses");
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

        @Step("Open course page of {courseTitle}")
        public HomePage openCoursePage(String courseTitle){
            WebElement eveningCourses = driver.findElement(By.xpath("//h2[contains(text(), '" + courseTitle + "')]/.."));
            wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
            eveningCourses.click();
            logger.info("Opened course'"+ courseTitle +"'");
            logger.debug("Opened course'"+ courseTitle +"'");
            return this;

        }

        @Step("Clicked Buy button to buy with full payment")
      public HomePage clickPayBtn(){
           By buttonPay = By.xpath("//*[@id=\"level-form_course-list\"]/form[1]/ul/li/p[3]/button");
          WebElement buttonPayEl = driver.findElement(buttonPay);
           wait.until(ExpectedConditions.elementToBeClickable(buttonPay));
           buttonPayEl.click();
           logger.debug("Clicked Buy button");
           return this;
    }

    @Step("Checking current selected location")
    public boolean checkInLocation(String location) {
        By locationEl = By.xpath("//input[@id=//div[contains(text(), '" + location + "')]/../@for]");
        WebElement courseLocation = driver.findElement(locationEl);
        wait.until(ExpectedConditions.presenceOfElementLocated(locationEl));
        logger.info("Checked location '"+ location +"'");
        return courseLocation.isSelected();
    }

    @Step("Check if Privacy checkbox is unselected")
    public boolean selectedCheckbox(){
        By checkbox = By.xpath("//div[@id='privacy-policy']/label/span");
        WebElement privacyPolicy = driver.findElement(checkbox);
        wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
        logger.info("Checked checkbox Privacy Policy");
        return privacyPolicy.isSelected();
    }
}


