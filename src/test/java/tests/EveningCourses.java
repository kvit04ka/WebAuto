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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EveningCourses extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void pageLoad() {
        homePage = new HomePage(driver);

    }

    @Test
    public void courseTest() {
        homePage
                .open()
                .openEveningCourses()
                .openCourses();

        String coursesExpected[] = {
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
        };
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"))));
        List<WebElement> courseElements = driver.findElements(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"));
        List<String> coursesActual = new ArrayList<String>();


 //    for (WebElement el : courseElements) {
 //              System.out.println("\"" + el.getText() + "\"" + ", ");
  //         }

        for (WebElement el : courseElements) {
            el.getText();
            for (String course : coursesExpected) {
                boolean isContains = coursesActual.contains(course);
                assertTrue(isContains, String.format("Expected course '%s' to be present on the page", course));
            }
        }
    }}


