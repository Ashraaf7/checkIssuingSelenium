package Pages.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhitelabelPage extends SuperSettings{


    public WhitelabelPage(WebDriver driver) {
        super(driver);
    }

    private By addWhitelabelLink = By.xpath("//*[@id=\"main-wrapper\"]/div/div/div[1]/div[2]/a");
    private By whitelabelName = By.xpath("//*[@id=\"name\"]");
    private By whitelabelSubdomain = By.xpath("//*[@id=\"domain\"]");
    private By enabledCheckbox = By.xpath("//*[@id=\"enabled\"]");
    private By setDefaultCheckbox = By.xpath("//*[@id=\"is_default\"]");

    private By addWhitelabelButton = By.xpath("//*[@id=\"addWlForm\"]/div[3]/input[2]");
    private By idOnTable= By.xpath("//*[@id=\"wlsList\"]/thead/tr/th[1]");
    private By whitelabelNameOnTheTable = By.xpath("//*[@id=\"wlsList\"]/tbody/tr[1]/td[3]");
    public void addWhitelabel (String name, String subdomain,boolean enabled ,boolean setDefault )
    {
            driver.findElement(addWhitelabelLink).click();
            driver.findElement(whitelabelName).sendKeys(name);
            driver.findElement(whitelabelSubdomain).sendKeys(subdomain);
            if (!enabled)
                driver.findElement(enabledCheckbox).click();
            if (setDefault)
                driver.findElement(setDefaultCheckbox).click();

            driver.findElement(addWhitelabelButton).click();
    }

    public String verifyIfLabelAdded () throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(idOnTable).click();
        Thread.sleep(2000);
        driver.findElement(idOnTable).click();
        Thread.sleep(2000);
        return driver.findElement(whitelabelNameOnTheTable).getText();

    }
}
