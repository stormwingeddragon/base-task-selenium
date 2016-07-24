package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pages.ExpectCondition.jQueryLoad;
import static pages.ExpectCondition.jsLoad;


public final class PageUtils {

    public static boolean waitForJStoLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(jQueryLoad()) && wait.until(jsLoad());
    }
}

