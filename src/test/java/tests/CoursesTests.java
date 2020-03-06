package test.java.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.HomeTask6.CoursesPageData;
import test.java.tests.HomeTask6.HomePage;
import test.java.utils.RetryAnalyzer;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@Epic("Courses")
public class CoursesTests extends BaseTest{
    HomePage homePage;
   // CoursesPageData coursesPageData;

    @BeforeMethod
    public void pageLoad() {
        homePage = new HomePage(driver);
    //    coursesPageData = new CoursesPageData(driver);


    }

    @Story("Evening courses")
    @Feature("Checking the list of courses")
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void eveCourses() {
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
            coursesActual.add(el.getText());
        }
            for (String course : coursesExpected) {
                boolean isContains = coursesActual.contains(course);
                assertTrue(isContains, String.format("Expected course '%s' to be present on the page", course));
            }
        }

        @Story("Day Time courses")
        @Feature("Checking the list of courses")
        @Test
        public void dayTimeCourses()throws InterruptedException{
        homePage
                .open()
                .openDayTimeCourses()
                .openDayCourse();

        String [] courseExpected = {
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

        for(WebElement el: courseElements){
            courseActual.add(el.getText());
        }
        for(String course: courseExpected){
            boolean isContains = courseActual.contains(course);
            assertTrue(isContains, String.format("Expected course '%s' to be present on the page", course));
        }
        }

        @DataProvider
        public Object[][] providerEveCourses(){
        return new  Object[][]{
                {"Тестування"},
               {"Frontend development"},
                {"JS development"},
               {"Веб-дизайн"},
                {"PHP"},
               {"Java programming"},
                {"Python"},
               {"Data Science/Machine Learning"},
               {"C# /.NET development"},
                {"C++"},
               {"Game Development"},
                {"DEVOPS"},
               {"Digital Marketing"},
                {"Управління персоналом"},
               {"Управління проектами"},
                {"Mobile development"},
                {"Відеомонтаж"},
                {"Cisco"},
                {"Go development"},
               {"Кібербезпека"},
               {"Менеджмент"}

        };

        }

    @Test (dataProvider = "providerEveCourses")
    public void ListCoursesLocation(String courseTitle){
        homePage
                .open()
                .openEveningCourses()
                .openCourses()
                .openCoursePage(courseTitle);
        homePage.clickPayBtn();
        assertTrue(homePage.checkInLocation("Берестейська"));
        assertFalse(homePage.checkInLocation("Позняки"));
        assertFalse(homePage.checkInLocation("ВДНГ"));
        assertFalse(homePage.selectedCheckbox());
    }


}



