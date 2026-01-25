package tests;

import org.testng.annotations.Test;

import Pages.LoginPage;

import Pages.HomePage;
import base.BaseTest;

public class LoginTest extends BaseTest
{
  @Test
  public void verifyloginflow() 
  {
	  //1 and 2 steps are in before method of basetest class
	  
	  //create page object
	  
	  HomePage homepage= new HomePage(driver);
	  LoginPage loginpage=new LoginPage(driver);
	 
	  //verify home page is visible
	 // homepage.verifyHomePageVisible();
	  
	  //click on signup login
	  homepage.clickSignupLogin();
	  
	  //verify login to your account
	  loginpage.verifyLoginHeaderVisible();
	  
	 loginpage.enterEmail("vyankatesh302@gmail.com");
	  
	  loginpage.enterPassword("password123");
	  
	  loginpage.clickLoginButton();
	  
	  homepage.verifyLoggedInAsUser("Vyankatesh");
	  
	// Delete account
      homepage.clickDeleteAccount();
      homepage.verifyAccountDeleted();

      System.out.println(" Login and account deletion flow executed successfully!");
	  
	  
	  
	  
  }
}
