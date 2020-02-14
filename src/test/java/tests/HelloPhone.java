package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloPhone {
    public static void main(String[] args) throws InterruptedException {
        By contactPhone = By.xpath("//ul[@class='phones-block__list']/../a");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http:\\iteaua-develop.demo.gns-it.com/about-itea/");

        Thread.sleep(5000);

        WebElement contactPhoneEl = driver.findElement(contactPhone);
        String phone = contactPhoneEl.getAttribute("href");
        String phoneFinish = phone.substring(7);
        System.out.println(phoneFinish);

        Thread.sleep(5000);

        driver.quit();
    }
}
