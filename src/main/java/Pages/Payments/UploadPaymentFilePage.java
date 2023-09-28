package Pages.Payments;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class UploadPaymentFilePage extends PaymentsSection{
    By uploadArea = By.cssSelector("input[name='payments']");
    By uploadButton = By.cssSelector("input#uploadPayFileBtn");
    //By mappingFrame = By.cssSelector("form#mapForm");
    By saveAndProcessButton =By.cssSelector("[value='Save and Process']");
    By confirmButton =By.cssSelector("input[value='Confirm']");


    public UploadPaymentFilePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUploadButton()
    {
        PageBase.explicitWait(10,uploadButton);
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
    public void uploadPayment() throws AWTException {
        String path = "E:\\Projects\\checkIssuingSelenium\\src\\main\\resources\\Attachments\\Checkissuing.csv" ;
        driver.findElement(uploadArea).sendKeys(path);
        clickOnUploadButton();
        if(!path.contains("csv"))
        {
            saveUpload();
        }
        confirmUpload();
    }
}
