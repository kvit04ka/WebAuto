package test.java.tests;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import test.java.tests.PO.HomePage;
import test.java.tests.PO.VacancyPage;


import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ForPO extends BaseTest {
   HomePage homePage;
   VacancyPage vacancyPage;

   @BeforeMethod
   public  void pageLoad(){
       homePage = new HomePage(driver);
       vacancyPage = new VacancyPage(driver);
   }


    @Test
    public void anyTest() {
       homePage
               .open()
               .selectLanguage("uk")
               .openAbout()
               .openVacancies();

       vacancyPage
               .selectVacancy("Викладач UX")
               .setName("Natali")
               .setEmail("email@email.com")
               .submit();
       String actualMsg = vacancyPage.getPhoneErrorMsg();
       String expectedMsg = "Поле не має бути пустим";
       assertEquals(actualMsg, expectedMsg);
    }
    @Test
    public void checkLang(){
        String langExpected[] = {"RU", "UA", "EN" };
       homePage.open();
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text() = 'UA'])[1]"))));

       List<WebElement> langElements = driver.findElements(By.xpath("(//ul[@class='lang'])[1]//a"));
       List<String> langActual = new ArrayList<String>();

   //    for (WebElement el:list) {
  //         System.out.println("\"" + el.getText() + "\"" + ", ");


           for(WebElement el:langElements){
               langActual.add(el.getText());

       }
           for(String lang: langExpected){
               boolean isContains  = langActual.contains(lang);
               assertTrue(isContains, String.format("Expected language '%s' to be present on the page", lang));
           }
    }


}