package test.java.tests.HomeTask6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    }
