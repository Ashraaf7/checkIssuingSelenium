package Utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class Utilities {
    public final static String screenshotsPath = "src/test/java/Data/Screenshots/";
    public final static String testDataPath = "src/test/java/Data/TestData/";

    public final static String downloadsPath = "E:\\Projects\\checkIssuingSelenium\\src\\test\\java\\Data\\Downloads";
    //TODO: Take Screenshot for specific element
    public static void takeScreenShotForElement(WebDriver driver, By locator , String screenshotName) throws IOException {
        Screenshot screenshot = new AShot().takeScreenshot(driver,driver.findElement(locator));
        String formattedDate =  new SimpleDateFormat("yyyy-MM-dd-HH-m-ss").format(new Date());
        ImageIO.write(screenshot.getImage(), "png", new File(screenshotsPath +screenshotName+"-"+formattedDate+".png"));
    }
    public static String getTimestamp()
    {
       return new SimpleDateFormat("yyyy-MM-dd_h-m-ss a").format(new Date());
    }

    //TODO: Take general Screenshot
    public static void takeScreenShot(WebDriver driver, String screenshotName) throws IOException {
        Screenshot screenshot = new AShot().takeScreenshot(driver);
        String formattedDate = Utilities.getTimestamp();
        ImageIO.write(screenshot.getImage(), "png", new File(screenshotsPath +screenshotName+"-"+formattedDate+".png"));
    }
    //TODO:  Scroll to specific element
    public static void scrollToElement(WebDriver driver,By locator)
    {
        ((JavascriptExecutor)(driver)).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", driver.findElement(locator));
    }

    //TODO:  Scroll to specific position
    public static void scrollToPosition(WebDriver driver,int x,int y)
    {
        ((JavascriptExecutor)(driver)).executeScript("window.scrollTo(" + x + ", " + y + ");");
    }
    // Method to zoom out using JavaScript
    public static void zoomOut(WebDriver driver, int zoomFactor) {
        ((JavascriptExecutor) driver).executeScript("document.body.style.zoom = '" + zoomFactor + "%'");
    }
    //TODO: General Explicit Wait
    public static WebDriverWait explicitlyWait(WebDriver driver )
    {
        return   new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    //TODO:  Explicit Wait For Clickability
    public static void explicitlyWaitForClickability(WebDriver driver , By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(locator));
    }
    //TODO:  Explicit Wait For Visibility
    public static void explicitlyWaitForVisibility(WebDriver driver , By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //TODO: General Fluent Wait
    public static FluentWait<WebDriver> fluentWait(WebDriver driver)
    {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    //TODO: Convert Locator to Web Element
    public static WebElement byToWebElement(WebDriver driver,By locator)
    {
        return driver.findElement(locator);
    }
    //TODO: Function for selecting from drop down

    public static void selectFromDropDown(WebDriver driver,By locator,String option)
    {
        new Select(Utilities.byToWebElement(driver,locator)).selectByVisibleText(option);
    }
    //TODO: Function for getting selected option from drop down
    public static WebElement getSelectedOptionFromDropDown(WebDriver driver,By locator)
    {
      return   new Select(Utilities.byToWebElement(driver,locator)).getFirstSelectedOption();
    }
    //TODO: Read data from json file
    public static String getJsonData( String jsonFilename,String field) {
        try {
            //Define object of json parser
            JsonParser parser = new JsonParser();
            //Define object of file Reader
            FileReader reader = new FileReader(testDataPath+jsonFilename+".json");
            Object object = parser.parse(reader);

            JsonObject jsonObject = (JsonObject) object;

            return jsonObject.get(field).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // TODO: Read Data From Excel Sheet
    public static String getExcelData(String excelFilename,String sheetName,int rowNum, int colNum) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;

        String cellData = null;
        try {
            workBook = new XSSFWorkbook(testDataPath+excelFilename);
            sheet = workBook.getSheet(sheetName);
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cellData;
    }
    public static boolean verifyExportPage(String filename)
    {
        int timeoutSeconds = 60;
        Path filePath = Paths.get(Utilities.downloadsPath, filename);
        boolean fileDownloaded = false;

        for (int i = 0; i < timeoutSeconds; i++) {
            if (Files.exists(filePath)) {
                fileDownloaded = true;
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return fileDownloaded;
    }
    public static boolean verifyDownloadedFiles (String filenamePattern)
    {
        int timeoutSeconds = 60;
        Path downloadDir = Paths.get(Utilities.downloadsPath);
        boolean fileDownloaded = false;

        for (int i = 0; i < timeoutSeconds; i++) {
            if (checkFilesInDirectory(downloadDir, filenamePattern)) {
                fileDownloaded = true;
                break;
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return fileDownloaded;

    }
    private static boolean checkFilesInDirectory(Path directory, String filenamePattern) {
        Pattern regex = Pattern.compile(filenamePattern);

        try {
            return Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .anyMatch(filename -> regex.matcher(filename).matches());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
