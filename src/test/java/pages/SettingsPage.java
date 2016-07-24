package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsPage {

    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateSettingsLeadsLeadStatuses() {
        WebElement leadsTab = driver.findElement(By.linkText("Leads"));
        leadsTab.click();
        WebElement leadStatusesTab = driver.findElement(By.linkText("Lead Statuses"));
        leadStatusesTab.click();
        WebElement editStatusButton = driver.findElement(By.xpath("//*[@class='btn btn-mini edit']"));
        editStatusButton.click();
    }

    public void changeLeadStatus(String status) {
        List<WebElement> editButtons = driver.findElements(By.id("name"));
        for (WebElement invisible : editButtons) {
            if (invisible.isDisplayed()) {
                invisible.clear();
                invisible.sendKeys(status);
            }
        }

        List<WebElement> saveButtons =  driver.findElements(By.xpath("//*[@class='btn btn-primary save']"));
        for (WebElement invisible : saveButtons) {
            if (invisible.isDisplayed()) {
                invisible.click();
            }
        }
    }
}
