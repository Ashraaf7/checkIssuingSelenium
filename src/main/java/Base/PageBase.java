package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PageBase {
    public static WebDriver driver ;
    private static WebElement helperWebElement ;
    public PageBase (WebDriver driver)
    {
        this.driver = driver;
    }
    public static void explicitWait(long seconds, By element)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         helperWebElement = driver.findElement(element);
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.or(visibilityOf(helperWebElement),ExpectedConditions.elementToBeClickable(helperWebElement))) ;
    }
    public static void scrollToElement(By element)
    {
         helperWebElement = driver.findElement(element);
        ((JavascriptExecutor)(driver)).executeScript("arguments[0].scrollIntoView()",helperWebElement);
    }
    public static void scrollToPosition(int x,int y)
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(arguments[0], arguments[1])", x, y);
    }
}
