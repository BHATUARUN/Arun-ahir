package automationjava.demoblaze11;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginpage {

    WebDriver driver;

    // ---------- SETUP ----------
    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\try\\MyDriver\\mychromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/index.html");
    }

    // ---------- EXCEL READ METHOD ----------
    public String getCellData(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        DataFormatter formatter = new DataFormatter();
        String value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));

        workbook.close();
        fis.close();

        return value;
    }

    // ---------- TEST ----------
    @Test
    public void loginWithExcelData() throws IOException, InterruptedException {

        String filePath = "C:\\Users\\Tops\\Downloads\\Demoblaze.xlsx";

        // Excel se username/password read
        String username = getCellData(filePath, "LoginData", 1, 0);
        String password = getCellData(filePath, "LoginData", 1, 1);

        // Step 1: Login link click
        driver.findElement(By.id("login2")).click();
        Thread.sleep(3000);

        // Step 2: Username enter
        driver.findElement(By.id("loginusername")).sendKeys(username);

        // Step 3: Password enter
        driver.findElement(By.id("loginpassword")).sendKeys(password);

        // Step 4: Login button click
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        Thread.sleep(5000);

        // Step 5: Alert aaye to handle karo
        try {
            Alert alert = driver.switchTo().alert();
            String alertMsg = alert.getText();
            System.out.println("Alert Message: " + alertMsg);
            alert.accept();

            Assert.fail("Login failed because alert appeared: " + alertMsg);
        } catch (Exception e) {
            System.out.println("No alert appeared, continue validation...");
        }

        // Step 6: Welcome text validation
        WebElement welcomeUser = driver.findElement(By.id("nameofuser"));
        String welcomeText = welcomeUser.getText();

        System.out.println("Welcome Text: " + welcomeText);

        Assert.assertTrue(welcomeText.contains(username), "Login Failed!");
    }

    // ---------- TEARDOWN ----------
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }
}