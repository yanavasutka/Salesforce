package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;

    public Input (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write (String text) {
        driver.findElement(By.xpath(
                String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label)
        )).sendKeys(text);
    }
}
