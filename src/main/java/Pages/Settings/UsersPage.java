package Pages.Settings;

import Base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends SuperSettings{
    public UsersPage(WebDriver driver) {
        super(driver);
    }
    private final By addUserLink = By.linkText("Add User");
    private final By nameField = By.xpath("//div[@class='floating-labels'] /div /input[@id=\"name\"]");
    private final By usernameField = By.xpath("//div[@class='floating-labels'] /div /*[@id=\"username\"]");
    private final By emailField = By.xpath("//div[@class='floating-labels'] /div /*[@id=\"email\"]");

    //Triggers
    private final By addSendPayments = By.xpath("//*[@id=\"payments\"]/div/div[1]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By approvePayments = By.xpath("//*[@id=\"payments\"]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By cancelPayment = By.xpath("//*[@id=\"payments\"]/div/div[3]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By managePayment = By.xpath("//*[@id=\"payments\"]/div/div[4]/table/tbody/tr[1]/td[2]/div/div/span[3]");

    private final By billingPermission = By.xpath("//*[@id=\"finances\"]/div/div[1]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By fundingSources = By.xpath("//*[@id=\"finances\"]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/span[2]");
    private By accountManagement = By.xpath("//*[@id=\"access\"]/div/div[1]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By apiAccess = By.xpath("//*[@id=\"access\"]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By manageInsert = By.xpath("//*[@id=\"access\"]/div/div[3]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By manageUsers = By.xpath("//*[@id=\"access\"]/div/div[4]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By manageWhitelabel = By.xpath("//*[@id=\"access\"]/div/div[5]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By readOnly = By.xpath("//*[@id=\"access\"]/div/div[6]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By reporting = By.xpath("//*[@id=\"access\"]/div/div[7]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By sandboxOnly = By.xpath("//*[@id=\"access\"]/div/div[8]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By security = By.xpath("//*[@id=\"access\"]/div/div[9]/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private By logoManagement = By.xpath("//*[@id=\"misc_user\"]/div/div/table/tbody/tr[1]/td[2]/div/div/span[3]");
    private final By addUserButton = By.xpath("//*[@id=\"inviteForm\"]/div[2]/input[2]");

    //Tabs Button
    private By paymentButton = By.xpath("//*[@id=\"inviteForm\"]/div[1]/div[3]/ul/li[1]/a");
    private By financesButton = By.xpath("//*[@id=\"inviteForm\"]/div[1]/div[3]/ul/li[2]/a");
    private By accessButton = By.xpath("//*[@id=\"inviteForm\"]/div[1]/div[3]/ul/li[3]/a");
    private By otherButton = By.xpath("//*[@id=\"inviteForm\"]/div[1]/div[3]/ul/li[4]/a");

    //for Validation
    private By nameFieldOnTheTable = By.xpath("//*[@id=\"usersList\"]/tbody/tr[1]/td[2]");

    public void clickAddUser() {
        driver.findElement(addUserLink).click();
    }

    public void fillUserData(String name, String username, String email) {
        clickAddUser();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
    }
    public void paymentsPermissions() {
        driver.findElement(paymentButton).click();
        PageBase.ImplicitWait(10);
        driver.findElement(addSendPayments).click();
        driver.findElement(approvePayments).click();
        driver.findElement(cancelPayment).click();
        driver.findElement(managePayment).click();
    }


    public void financePermissions() {
        driver.findElement(financesButton).click();
        PageBase.ImplicitWait(10);
        driver.findElement(billingPermission).click();
        driver.findElement(fundingSources).click();

    }
    public void accessPermissions() {
        driver.findElement(accessButton).click();
        PageBase.ImplicitWait(10);
        driver.findElement(accountManagement).click();
        driver.findElement(apiAccess).click();
        driver.findElement(manageInsert).click();
        driver.findElement(manageUsers).click();
        driver.findElement(manageWhitelabel).click();
        driver.findElement(readOnly).click();
        driver.findElement(reporting).click();
        driver.findElement(sandboxOnly).click();
        driver.findElement(security).click();
    }
    public void otherPermissions() {
        driver.findElement(otherButton).click();
        PageBase.ImplicitWait(10);
        driver.findElement(logoManagement).click();
    }
    public void setAllPermissions( ) {
        paymentsPermissions();
        financePermissions();
        accessPermissions();
        otherPermissions();
    }

    public void clickAddUserButton() {
        driver.findElement(addUserButton).click();
    }

    public String checkIfUserAdded()
    {
       return driver.findElement(nameFieldOnTheTable).getText();
    }

}
