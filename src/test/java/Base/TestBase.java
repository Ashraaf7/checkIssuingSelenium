package Base;

import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    protected WebDriver driver ;
    private EdgeOptions edgeOptions;
    public LoginPage loginPage ;
    public HomePage homePage;
    protected final String url ="https://web.checkissuing.net/" ;
    protected final String userName = "Chyannelitchfield13@gmail.com";
    protected final String password = "1qaz!QAZ";
    protected String fundingResource = "Bank 34" ;
    protected String sftpFormat = "Smart Bank" ;

    @BeforeMethod
    public void setup()
    {
        edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--disable-gpu"); // Required for headless mode
        //edgeOptions.addArguments("--disable-software-rasterizer"); // Required for headless mode
        //edgeOptions.addArguments("--disable-dev-shm-usage"); // Required for headless mode
        //edgeOptions.addArguments("--no-sandbox"); // Required for headless mode
        edgeOptions.addArguments("--disable-extensions"); // Disable extensions
        edgeOptions.addArguments("--disable-popup-blocking"); // Disable popup blocking
        edgeOptions.addArguments("--disable-notifications"); // Disable notifications
        //edgeOptions.addArguments("download.default_directory=E:\\Projects\\checkIssuingSelenium\\src\\main\\resources\\Downloads");
        edgeOptions.addArguments("--enable-features=AllowContentSettings");
        edgeOptions.addArguments("--download.prompt_for_download=false");
        edgeOptions.addArguments("--disable-features=BlockInsecurePrivateNetworkRequests");
        edgeOptions.addArguments("--content-settings.type.default_downloads=1"); // Allow downloads by default
        edgeOptions.addArguments("--start-maximized"); // Maximize the virtual browser window

        //edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void quit()
    {
        driver.quit();
    }

}
