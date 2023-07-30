package Pages.Payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class UploadPaymentFilePage extends PaymentsSection{
    By uploadArea = By.cssSelector("input[name='payments']");
    By uploadButton = By.cssSelector("input#uploadPayFileBtn");
    //By mappingFrame = By.cssSelector("form#mapForm");
    By saveAndProcessButton =By.cssSelector("input#mapSaveBtn");
    By confirmButton =By.cssSelector("[value='Confirm']");


    public UploadPaymentFilePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnUploadButton()
    {
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
        //saveUpload();
        confirmUpload();
    }
}
