package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AccountCreationPage 
{
	private WebDriver driver;
	
	private By enteraccountInfoText=By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
	private By titleMr=By.xpath("//input[@id='id_gender1']");
	private By titleMrs=By.xpath("//input[@id='id_gender2']");
	private By passwordInput=By.xpath("//input[@id='password']");
	
	private By daysdrpdown=By.id("days");
	private By monthsdrpdown=By.id("months");
	private By yearsdrpdown=By.xpath("//select[@id='years']");
	
	
	private By newsletterchkbox=By.cssSelector("input[id='newsletter']");
	private By offerschkbox=By.cssSelector("input[id='optin']");
	
	
	//address inforamation locators
	
	private By firstNameInput=By.id("first_name");
	private By lastNameInput=By.id("last_name");
	private By companyInput=By.id("company");
	private By addressInput=By.id("address1");
	private By address2Input=By.id("address2");
   
	private By countrydrpdown=By.id("country");
	private By stateInput=By.id("state");
	private By cityInput=By.id("city");
	private By zipcode=By.id("zipcode");
	private By mobilenumber=By.id("mobile_number");
	
	 private By createAccountBtn = By.xpath("//button[text()='Create Account']");
	    private By accountCreatedMsg = By.xpath("//b[text()='Account Created!']");

	
	//constructor
	public AccountCreationPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//actions
	public void verifyenteraccountinfodetails()
	{
		String acttext=driver.findElement(enteraccountInfoText).getText();
		Assert.assertEquals(acttext,"ENTER ACCOUNT INFORMATION","enter account info text is not visible");
		
		
	}
	
	public void fillaccountdetails(String title,String password,String day,String month,String year)
	{
		if(title.equalsIgnoreCase("Mr"))
		{
			driver.findElement(titleMr).click();
			
		}else {
			driver.findElement(titleMrs).click();
			
		}
		
		driver.findElement(passwordInput).sendKeys(password);
		
		
		new Select(driver.findElement(daysdrpdown)).selectByValue(day);
		new Select(driver.findElement(monthsdrpdown)).selectByValue(month);
		
		
	
		
		
//		new Select(driver.findElement(yearsdrpdown)).getOptions()
//		    .forEach(option -> System.out.println(option.getText()));
		
		new Select(driver.findElement(yearsdrpdown)).selectByVisibleText(year);;
//		
		 // Wait for dropdowns to appear before selecting
	    
		
	}
	
	public void selectcheckbox()
	{
		driver.findElement(newsletterchkbox).click();
		driver.findElement(offerschkbox).click();
	}
   public void filladdressdetils(String fn,String ln,String comp,String add1,String add2, 
		   String cntry,String st ,String ciy,String zip,String mobn)
   {
	   driver.findElement(firstNameInput).sendKeys(fn);
	   driver.findElement(lastNameInput).sendKeys(ln);
	   driver.findElement(companyInput).sendKeys(comp);
	   driver.findElement(addressInput).sendKeys(add1);
	   driver.findElement(address2Input).sendKeys(add2);
	   
	   new Select (driver.findElement(countrydrpdown)).selectByContainsVisibleText(cntry);
	   
	   driver.findElement(stateInput).sendKeys(st);
	   driver.findElement(cityInput).sendKeys(ciy);
	   driver.findElement(zipcode).sendKeys(zip);
	   driver.findElement(mobilenumber).sendKeys(mobn);
	   
	  
   }
   public void clickCreateAccountbtn()
   {
	   driver.findElement(createAccountBtn).click();
	   
   }
   public void verifyaccountcreatemsg() {
	    
	   // Wait for up to 10 seconds for the message to be visible
	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMsg));

	    String actualText = successMsg.getText().trim();
	    System.out.println("Account creation message: " + actualText);

	    Assert.assertEquals(actualText, "ACCOUNT CREATED!", "account created msg is not visible");
	    System.out.println(" Account created successfully!");
	}
   
   
   
   
}
