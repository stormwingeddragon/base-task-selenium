package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DashboardPage {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToLeads() {
       WebElement proceedToLeadsButton = driver.findElement(By.id("nav-leads"));
       proceedToLeadsButton.click();
    }
}
