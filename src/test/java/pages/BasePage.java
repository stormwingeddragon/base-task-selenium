package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToLoginPage() {
        driver.get("https://getbase.com/base/");
        WebElement proceedToLoginPageButton = driver.findElement(By.xpath("//a[text()=\"Log In\"]"));
        proceedToLoginPageButton.click();
    }
}