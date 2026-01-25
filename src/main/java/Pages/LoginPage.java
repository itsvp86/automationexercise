package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BasePage;

public class LoginPage extends BasePage {

    // Locators
    private By loginheader = By.xpath("//h2[text()='Login to your account']");
    private By emailinput = By.xpath("//input[@name='email']");
    private By passwordinput = By.xpath("//input[@name='password']");
    private By loginbtn = By.xpath("//button[@data-qa='login-button']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver); // initializes driver and wait from BasePage
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void verifyLoginHeaderVisible() {
        String headerText = waitforvisible(loginheader).getText();
        Assert.assertEquals(headerText, "Login to your account", "Login header not visible!");
    }

    public void enterEmail(String email) {
        type(emailinput, email);
    }

    public void enterPassword(String password) {
        type(passwordinput, password);
    }

    public void clickLoginButton() {
        click(loginbtn);
    }
	
	
	
	
	
	
	
	
	
	
	
	
}
