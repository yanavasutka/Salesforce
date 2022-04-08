package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NewAccountModal;

import java.time.Duration;

public class LoginTest {

    @Test
    public void test () {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tms-e.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("yanavasutka-a5wp@force.com");
        driver.findElement(By.id("password")).sendKeys("375445748346mama");
        driver.findElement(By.id("Login")).click();
        driver.get ("https://tms-e.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']")));
        driver.findElement(By.cssSelector("a[title=New]")).click();

        NewAccountModal newAccountModal= new NewAccountModal(driver);

        newAccountModal.create("TMS", "tms.by", "Analyst");
        newAccountModal.save();



        driver.quit();
    }
}
