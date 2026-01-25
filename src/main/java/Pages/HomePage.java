package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.BasePage;

public class HomePage extends BasePage
{
	
	private By signupLoginBtn = By.xpath("//a[contains(text(),'Signup')]");
    private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    private By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    private By accountDeletedMsg = By.xpath("//b[text()='Account Deleted!']");

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public void clickSignupLogin() {
        click(signupLoginBtn);
    }

    public void verifyLoggedInAsUser(String username) {
        String acttext = waitforvisible(loggedInText).getText();
        System.out.println("Logged in text is: " + acttext);
        Assert.assertTrue(acttext.toLowerCase().contains(username.toLowerCase()), "Logged in as username is not visible");
    }

    public void clickDeleteAccount() {
        click(deleteAccountBtn);
    }

    public void verifyAccountDeleted() {
        String text = waitforclickble(accountDeletedMsg).getText();
        Assert.assertEquals(text, "ACCOUNT DELETED!", "Account deletion message not visible!");
    }
	
	
	

}
