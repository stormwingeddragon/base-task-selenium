package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LeadCreateTab {

    private WebDriver driver;

    public LeadCreateTab(WebDriver driver) {
        this.driver = driver;
    }

    public void fillProfile(String name, String surname) {
        WebElement firstNameField = driver.findElement(By.id("lead-first-name"));
        firstNameField.sendKeys(name);

        WebElement lastNameField = driver.findElement(By.id("lead-last-name"));
        lastNameField.sendKeys(surname);

        WebElement saveButton = driver.findElement(By.xpath("//*[@class='save btn btn-large btn-primary']"));
        saveButton.click();
    }
}