package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage 
{
	private WebDriver driver;
	
	//loators
	// private By homeSlider = By.id("slider-carousel");
	By signupLoginBtn =By.xpath("//a[contains(text(),'Signup')]");
	
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	//actions
	
//    public void verifyHomePageVisible() {
//        boolean isVisible = driver.findElement(homeSlider).isDisplayed();
//        Assert.assertTrue(isVisible, "Home page is not visible!");
//    }

	
	
	public void clickSignupLogin()
	{
		driver.findElement(signupLoginBtn).click();
	}
	
	
	

}
