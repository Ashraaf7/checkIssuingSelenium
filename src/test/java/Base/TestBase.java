package Base;

import Pages.Home.HomePage;
import Pages.Login.LoginPage;
import Utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Objects;

public class TestBase {
    protected WebDriver driver ;

    private EdgeOptions edgeOptions;
    protected final String url ="https://web.checkissuing.net/" ;
    protected final String userName = "Chyannelitchfield13@gmail.com";
    protected final String password = "1qaz!QAZ";
    protected String fundingResource = "Payroll account" ;
    protected String sftpFormat = "Smart Bank" ;

    @BeforeMethod
    public void setup()
    {
        edgeOptions = new EdgeOptions();
        HashMap<String, Object> pref = new HashMap<>();
        pref.put("disable-extensions",true);// Disable extensions
        pref.put("disable-popup-blocking",true); // Disable popup blocking
        pref.put("disable-notifications",true); // Disable notifications
        pref.put("download.default_directory",Utilities.downloadsPath);
        pref.put("download.prompt_for_download",false);
        edgeOptions.setExperimentalOption("prefs",pref);
        //edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
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
