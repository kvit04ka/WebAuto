package test.java.tests.HomeTask6;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);

    }

    public HomePage open() {
        driver.get("http://iteaua-develop.demo.gns-it.com/uk/");
        //   WebElement spinner = driver.findElement(By.id("preload-it"));
        //   wait.until(ExpectedConditions.visibilityOf(spinner));
        //   wait.until(ExpectedConditions.invisibilityOf(spinner));
        logger.info("Home page is opened in Ukrainian language");
        logger.debug("Home page is opened in Ukrainian language");
        return this;
    }

    public HomePage openEveningCourses() {
        WebElement eveningCourses = driver.findElement(By.id("menu-item-7870"));
        wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
        eveningCourses.click();
        logger.info("Opened Evening Courses drop-down");
        logger.debug("Opened Evening Courses drop-down");
        return this;

    }

    public HomePage openCourses() {
        WebElement courses = driver.findElement(By.id("menu-item-7871"));
        courses.click();
        logger.debug("Clicked on the Courses menu item");
        return this;
    }

    public HomePage openDayTimeCourses() {
        WebElement dayCourses = driver.findElement(By.id("menu-item-7956"));
        wait.until(ExpectedConditions.visibilityOf(dayCourses));
        dayCourses.click();
        logger.info("Opened DayTime courses drop-down");
        return this;

    }

    public HomePage openDayCourse() {
        WebElement DayCourse = driver.findElement(By.xpath("//*[@id='menu-item-7885']/a"));
        wait.until(ExpectedConditions.visibilityOf(DayCourse));
        DayCourse.click();
        logger.debug("Clicked on the Courses under the Daytime");
        return this;
    }

    public List<String> getListCourses() {
        List<WebElement> courseElements = driver.findElements(By.xpath("//*[@id='course']/div/div/h2"));
        logger.debug("Expecting the visibility of the list of course items");
        wait.until(ExpectedConditions.visibilityOfAllElements(courseElements));
        List<String> courseActual = new ArrayList<String>();
        for(WebElement el: courseElements) {
            courseActual.add(el.getText());
        }
        logger.info("Get the list of courses on the page");
        return courseActual;
    }

    public HomePage openCoursePage(String courseTitle) {
        WebElement eveningCourses = driver.findElement(By.xpath("//h2[contains(text(), '" + courseTitle + "')]/.."));
        wait.until(ExpectedConditions.elementToBeClickable(eveningCourses));
        eveningCourses.click();
        logger.info("Page of course - '" + courseTitle + "' is opened");
        return this;
    }

}
