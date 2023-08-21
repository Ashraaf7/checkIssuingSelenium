package Pages.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogosPage extends SuperSettings{
    public LogosPage(WebDriver driver) {
        super(driver);
    }
    private By logoAddLink = By.xpath("//*[@id=\"addLogoBtn\"]");
    private By logoName = By.xpath("//*[@id=\"al_name\"]");
    private By logoDescription = By.xpath("//*[@id=\"al_description\"]");
    private By logoUploader = By.xpath("//*[@id=\"logo_file\"]");
    private By logoNameOnTheTable = By.xpath("//*[@id=\"logoList\"]/tbody/tr[1]/td[2]");
    private By addLogoButton = By.xpath("//*[@id=\"uploadLogoBtn\"]");
    public void addLogo (String name , String description, String path)
    {
        driver.findElement(logoAddLink).click();
        driver.findElement(logoName).sendKeys(name);
        driver.findElement(logoDescription).sendKeys(description);
        driver.findElement(logoUploader).sendKeys(path);
        driver.findElement(addLogoButton).click();

    }

    public String verifyIfLogoAdded ()
    {
        return driver.findElement(logoNameOnTheTable).getText();

    }}
