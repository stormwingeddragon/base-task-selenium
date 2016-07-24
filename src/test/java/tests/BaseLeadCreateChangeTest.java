package tests;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseLeadCreateChangeTest {
    private WebDriver driver = new FirefoxDriver();
    private BasePage basePage = new BasePage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private DashboardPage dashboardPage = new DashboardPage(driver);
    private LeadPage leadPage = new LeadPage(driver);
    private LeadCreateTab leadCreateTab = new LeadCreateTab(driver);
    private SettingsPage settingsPage = new SettingsPage(driver);

    @Test
    public void createLead() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage.proceedToLoginPage();
        loginPage.login("andrei.s.emelin@yandex.ru", "TestPass!1");
        dashboardPage.proceedToLeads();
        leadPage.createLead();
        leadCreateTab.fillProfile("Andrei", "Emelin");
        leadPage.assertStatus("New");
        leadPage.navigateSettings();
        settingsPage.navigateSettingsLeadsLeadStatuses();
        settingsPage.changeLeadStatus("Changed");
        dashboardPage.proceedToLeads();
        leadPage.clickEntry();
        leadPage.assertStatus("Changed");
    }

    @After
    public void cleanup(){
        leadPage.deleteEntry();
        leadPage.navigateSettings();
        settingsPage.navigateSettingsLeadsLeadStatuses();
        settingsPage.changeLeadStatus("New");
        driver.quit();
    }
}
