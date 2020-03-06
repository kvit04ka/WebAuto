package test.java.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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
import static org.testng.Assert.assertEquals;

@Epic("Courses")
public class Random extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void pageLoad() {
        homePage = new HomePage(driver);
    }

    @Story("Evening courses")
    @Feature("Random selection of a course")
    @Test
    public void eveningCourses() {
        homePage
                .open();

        for (int i = 0; i < 2; i++) {
            homePage.openEveningCourses()
                    .openCourses();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//*[contains(@class, 'grid_3')]//h2)"))));
            List<WebElement> courseitem = driver.findElements(By.xpath("//*[@class='container_12 isotope 21']/div"));
            int randCourse = (int) ( Math.random() * courseitem.size() );
            WebElement selectedCourse = courseitem.get(randCourse);
            wait.until(ExpectedConditions.elementToBeClickable(selectedCourse));
            selectedCourse.click();
            homePage.clickPayBtn();


            WebElement nameInput = driver.findElement(By.xpath("//input[@name='name']"));
            wait.until(ExpectedConditions.elementToBeClickable(nameInput));
            nameInput.click();
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Test Contact Name");

            WebElement emailInput = driver.findElement(By.xpath("//input[@name='mail']"));
            wait.until(ExpectedConditions.elementToBeClickable(emailInput));
            emailInput.click();
            driver.findElement(By.xpath("//input[@name='mail']")).sendKeys("emiail@email.com");

            WebElement phoneInput = driver.findElement(By.xpath("//input[@name='phone']"));
            phoneInput.click();
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("0112223333");

            By checkbox = By.xpath("//div[@id='privacy-policy']/label/span");
            WebElement privacyPolicy = driver.findElement(checkbox);
            wait.until(ExpectedConditions.presenceOfElementLocated(checkbox));
            privacyPolicy.click();

            WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[1]/section/div/div[2]/div[1]/form/div[1]/div[6]/input"));
            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
            submitBtn.click();



            By thanksMsg = By.xpath("//div[@class='thanks-block']/h1");
            WebElement thanksMsgEl = driver.findElement(thanksMsg);
            String msgActual = thanksMsgEl.getText();
            String msgExpected = "Ваша заявка прийнята.\n" +
                    "Наш менеджер зв'яжеться з Вами найближчим часом!";
            assertEquals(msgExpected, msgActual);

        }


    }
}

