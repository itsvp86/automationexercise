package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//wait until visible
	protected WebElement  waitforvisible(By locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	
	// wait until clickable
	protected WebElement waitforclickble(By locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	//click
	protected void click(By locator)
	{
		waitforclickble(locator).click();
	}
	
	//safe sendkeys
	protected void type(By locator,String text)
	{
		WebElement element=waitforvisible(locator);
		element.clear();
		element.sendKeys(text);
	}
}

