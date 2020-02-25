package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.HomeTask6.CoursesPageData;
import test.java.tests.HomeTask6.HomePage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CoursesTests extends BaseTest {
    HomePage homePage;
    CoursesPageData  coursesPageData;
    WebDriver driver;
    WebDriverWait wait;

    public CoursesTests(WebDriver driver) {

        super(driver);
    }

    @BeforeMethod
    public void pageLoad() {
        homePage = new HomePage(driver);

    }

    @Test
    public void eveCourseTest() {
        homePage
                .open()
                .openEveningCourses()
                .openCourses();

        String[] coursesExpected = {
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
                "Менеджмент"};
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"))));
        List<WebElement> courseElements = driver.findElements(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"));
        List<String> coursesActual = new ArrayList<String>();

 //    for (WebElement el : courseElements) {
 //              System.out.println("\"" + el.getText() + "\"" + ", ");
  //         }

        for (WebElement el : courseElements) {
            coursesActual.add(el.getText());
        }
            for (String course : coursesExpected) {
                boolean isContains = coursesActual.contains(course);
                assertTrue(isContains, String.format("Expected course '%s' to be present on the page", course));
            }
        }

    @Test
    public void dayTimeCourses() throws InterruptedException {
        homePage.open()
                .openDayTimeCourses()
                .openDayCourse();

        String[] courseExpected = {
                "Microsoft",
                "Cisco",
                "UNIX / Linux",
                "Oracle",
                "ITIL",
                "Программирование",
                "Управление проектами",
                "Пользовательские курсы",
                "Vmware",
                "Teradata",
                "EC-Council"};
        List<WebElement> courseElements = driver.findElements(By.xpath("//*[@id='course']/div/div/h2"));
        wait.until(ExpectedConditions.visibilityOfAllElements(courseElements));
        List<String> courseActual = new ArrayList<String>();

        for(WebElement el: courseElements) {
            courseActual.add(el.getText());
        }
        for(String course: courseExpected) {
            boolean isContains = courseActual.contains(course);
            assertTrue(isContains, String.format("Expected language '%s' to be present on the page", course));
        }

    }

    @Test (dataProvider = "providerEveningCourses")
    public void ListCoursesSetLocation(String courseTitle){
        homePage.open()
                .openEveningCourses()
                .openCourses()
                .openCoursePage(courseTitle);
        coursesPageData.clickBtnPay();
        assertTrue(coursesPageData.checkInLocation("Берестейская"));
        assertFalse(coursesPageData.checkInLocation("Позняки"));
        assertFalse(coursesPageData.checkInLocation("ВДНХ"));
        assertFalse(coursesPageData.selectedCheckbox());
    }

    @DataProvider
    public Object[][] providerEveningCourses() {
        return new Object[][]{
                {"Тестирование"},
                {"Frontend development"},
                {"Frontend development"},
                {"JS development"},
                {"Веб-дизайн"},
                {"PHP"},
                {"Программирование под IOS"},
                {"Программирование под Android"},
                {"Java programming"},
                {"Python"},
                {"Data Science/Machine Learning"},
                {"C# /.NET development"},
                {"C++"},
                {"Game Development"},
                {"DEVOPS"},
                {"Digital Marketing"},
                {"Управление персоналом"},
                {"Управление проектами"},
                {"Менеджмент"},
                {"Кибербезопасность"},
                {"Mobile development"},
                {"Видеомонтаж"},
                {"Cisco"},
                {"Go development"},
                {"Go development"}

        };
    }

}


