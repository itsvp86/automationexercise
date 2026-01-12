package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupLoginPage 
{	
	private WebDriver driver;
	
	//locators
	private By newUserSignupText=By.xpath("//h2[text()='New User Signup!']");
	private By nameInput=By.cssSelector("input[name='name']");
	private By emailInput=By.cssSelector("input[data-qa='signup-email']");
	private By signupbtn=By.cssSelector("button[data-qa='signup-button']");
	
	//constructor
	public SignupLoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//actions
	public void  verifyNewUserSignupVisible()
	{
		String acttext=driver.findElement(newUserSignupText).getText();
		Assert.assertEquals(acttext,"New User Signup!","new user signup text is not visible");
		
		
	}
	public void enternameandemail(String name, String email)
	{
		driver.findElement(nameInput).sendKeys(name);
		driver.findElement(emailInput).sendKeys(email);
	}
	
	public void clickSignupbtn()
	{
		driver.findElement(signupbtn).click();
		
	}
	

}
