package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static pages.PageUtils.waitForJStoLoad;


public class LeadPage {

    private WebDriver driver;

    public LeadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createLead() {
        WebElement createLeadButton = driver.findElement(By.id("leads-new"));
        createLeadButton.click();
    }

    public void assertStatus(String status) {
        WebElement leadStatus = driver.findElement(By.className("lead-status"));
        assertEquals(leadStatus.getText(), status);
}

    public void navigateSettings() {
        WebElement settingsDropdown = driver.findElement(By.id("user-dd"));
        settingsDropdown.click();

        WebElement settingsOptionInDropdown = driver.findElement(By.linkText("Settings"));
        settingsOptionInDropdown.click();
    }

    public void clickEntry() {

        waitForJStoLoad(driver);

        List<WebElement> allEntries = driver.findElements(By.xpath("//a[text()=\"Andrei Emelin\"]"));

        for (WebElement invisible : allEntries) {
            if (invisible.isDisplayed()) {
                invisible.click();
                break;
            }
        }
    }

    public void deleteEntry() {
        WebElement editLeadButton = driver.findElement(By.linkText("Edit"));
        editLeadButton.click();
        WebElement deleteLeadButton = driver.findElement(By.className("remove"));
        deleteLeadButton.click();
        WebElement confirmLeadDeletionButton = driver.findElement(By.linkText("Remove"));
        confirmLeadDeletionButton.click();
    }
}
