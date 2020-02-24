package test.java.tests.PO;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);


    }

    public HomePage open(){
        logger.info("Home page is opened");
        logger.debug("Home page is opened");
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        WebElement spinner = driver.findElement(By.id("preload-it"));
        wait.until(ExpectedConditions.visibilityOf(spinner));
        wait.until(ExpectedConditions.invisibilityOf(spinner));
        return this;
    }

    public HomePage selectLanguage(String lang){
        WebElement uaLang = driver.findElement(By.xpath("(//a[@hreflang='uk'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(uaLang));
        uaLang.click();
        return this;
    }

    public HomePage openAbout(){
        WebElement aboutBtn = driver.findElement(By.xpath("//a[(contains(@href, 'about_itea')) and @class='parent']"));
        wait.until(ExpectedConditions.visibilityOf(aboutBtn));
        aboutBtn.click();
        return this;
    }

    public HomePage openVacancies() {
        WebElement vacancies = driver.findElement(By.xpath("//li[@id='menu-item-15362']/a"));
        wait.until(ExpectedConditions.elementToBeClickable(vacancies));
        vacancies.click();
        return this;
    }


}
