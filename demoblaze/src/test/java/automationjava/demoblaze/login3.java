package automationjava.demoblaze;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class login3 {
	// public static void main(String[] args) {
     //    System.out.println("Program started");
    WebDriver driver;
    WebDriverWait wait;
    
    // Locators
    private By signupLink = By.linkText("Sign up");
    private By loginLink = By.linkText("Log in");
    private By contactLink = By.linkText("Contact");
    private By homeLink = By.linkText("Home");
    
    public void HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void openWebsite(String url) {
        driver.get(url);
        System.out.println(" Website opened: " + url);
    }
    
    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLink)).click();
        System.out.println(" Clicked on Sign up button");
    }
    
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        System.out.println(" Clicked on Login button");
    }
    
    public String getPageTitle() {
        return driver.getTitle();
        
        
        
    }
}