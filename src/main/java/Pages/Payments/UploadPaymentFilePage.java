package Pages.Payments;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class UploadPaymentFilePage extends PaymentsSection{

    // Upload Elements
    private By uploadArea = By.cssSelector("input[name='payments']");
    private By uploadButton = By.cssSelector("input#uploadPayFileBtn");

    // Save and Process Elements
    private By saveAndProcessButton = By.cssSelector("[value='Save and Process']");
    private By confirmButton = By.cssSelector("input[value='Confirm']");

    public UploadPaymentFilePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUploadButton()
    {
        Utilities.explicitlyWaitForClickability(driver,uploadButton);
        driver.findElement(uploadButton).click();
    }
    public void saveUpload()
    {
        if(driver.findElement(saveAndProcessButton).isDisplayed())
             driver.findElement(saveAndProcessButton).click();
    }
    public void confirmUpload()
    {
        driver.findElement(confirmButton).click();
    }
    public void uploadPayment(String fileName) throws AWTException {
        driver.findElement(uploadArea).sendKeys(Utilities.testDataPath+fileName);
        clickOnUploadButton();
        if(!fileName.contains("csv"))
        {
            saveUpload();
        }
        confirmUpload();
    }
}
