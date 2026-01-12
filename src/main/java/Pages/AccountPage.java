package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountPage
{
	private WebDriver driver;
	
	private By countinuebtn =By.xpath("//a[text()='Continue']");
	private By loggedInText =By.xpath("//a[contains(text(),'Logged in as')]");
	private By deleteAccbtn =By.xpath("//a[contains(text(),'Delete Account')]");
	private By accdeletedmsg=By.ByClassName.xpath("//b[text()='Account Deleted!;']");
	private By continueAfterDeleteBtn = By.xpath("//a[@data-qa='continue-button']");
	
	//constructor
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickcontinuebtn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(countinuebtn)).click();
	        System.out.println("Clicked Continue normally.");
	    } catch (Exception e) {
	        // Fallback: use JS click in case of ad overlay or modal blocking
	        System.out.println("Normal click failed, using JavaScript click...");
	        WebElement contBtn = driver.findElement(countinuebtn);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contBtn);
	    }
	}
	
		public void verifyLoggedInAsUser(String username)
		{
			String acttext=driver.findElement(loggedInText).getText();
			System.out.println("Logged in text in"+acttext);
			
			Assert.assertTrue(acttext.contains(username),"logged in as username is not visible");
		}	
		
		public void clickDeleteaction()
		{
			driver.findElement(deleteAccbtn).click();
		}
		
		public void verifyaccountdeletandconutinue()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // ✅ Wait for "Account Deleted!" message
		    WebElement deletedMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(accdeletedmsg));
		    String actualText = deletedMsg.getText().trim();
		    System.out.println("Account deleted message: " + actualText);

		    Assert.assertEquals(actualText, "Account Deleted!", "❌ 'Account Deleted!' message not visible or text mismatch!");

		    // ✅ Click Continue after deletion
		    WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueAfterDeleteBtn));
		    continueBtn.click();

		    System.out.println("✅ Account deleted successfully and continued.");
		}
}
