package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.tests.HomeTask6.HomePage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Random extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void pageLoad() {
        homePage = new HomePage(driver);
    }

    @Test
    public void eveningCourses() {
        homePage
                .open()
                .openEveningCourses()
                .openCourses();

    /*    String courseElements[] = {
                "Тестування",
                "Frontend development",
                "JS development",
                "Веб-дизайн",
                "PHP",
                "Java programming",
                "Python",
                "Data Science/Machine Learning",
                "C# /.NET development",
                "C++",
                "Game Development",
                "DEVOPS",
                "Digital Marketing",
                "Управління персоналом",
                "Управління проектами",
                "Mobile development",
                "Відеомонтаж",
                "Cisco",
                "Go development",
                "Кібербезпека",
                "Менеджмент"
        };  */

        for (int i = 0; i < 21; i++) {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"))));
            List<WebElement> courseitem = driver.findElements(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"));
            int randCourse = (int) ( Math.random() * courseitem.size() );
            WebElement selectedCourse = courseitem.get(randCourse);
            wait.until(ExpectedConditions.elementToBeClickable(selectedCourse));
            selectedCourse.click();

        }

        homePage.clickPayBtn();
    }
}

