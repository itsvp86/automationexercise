package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Pages.AccountCreationPage;
import Pages.AccountPage;
import Pages.HomePage;
import Pages.SignupLoginPage;
import base.BaseTest;

public class RagisterTest extends BaseTest
{
  @Test
  public void verifyNewUserSignupFlow() 
  {
	  //home page object
	  HomePage homepage=new HomePage(driver);
	 // homepage.verifyHomePageVisible();
	  homepage.clickSignupLogin();
	  
	  
	  //signup login page object
	  SignupLoginPage signuppage=new SignupLoginPage(driver);
	  signuppage.enternameandemail("vyankatesh", "vyankatesh302@gmail.com");
	  signuppage.clickSignupbtn();
	  
	  
	  AccountCreationPage actpage=new AccountCreationPage(driver);
	  actpage.verifyenteraccountinfodetails();
	  actpage.fillaccountdetails("Mr", "password123","10","1","2021");
	  actpage.selectcheckbox();
	  

	  actpage.filladdressdetils("kartik","panchal", "repsoftsolution", "karvenagr","near pizzahut","India", "Maharashtra","Pune", "411052", "8600756588");
	  actpage.clickCreateAccountbtn();
	  actpage.verifyaccountcreatemsg();
  
	  AccountPage accountpage=new AccountPage(driver);
	  accountpage.clickcontinuebtn();
	  accountpage.verifyLoggedInAsUser("vyankatesh");
	  accountpage.clickDeleteaction();
	  accountpage.verifyaccountdeletandconutinue();
	
  
  
  
  
  
  
  }
 
}
