package automation.Tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;
import automation.SchoolAdmin.AllDomain.Placements.PageObject_VerifySession_AddUpdate;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Tests_Placements {
	
	Login login=new Login();
	PageObject_VerifySession_AddUpdate session=new PageObject_VerifySession_AddUpdate();
  
  @BeforeMethod
  public void beforeMethod() {
	  
  }
  
  
  
  
  @Test
  public void execute() {
	  
	  Reports.Startlog();
	  
	  
	  try {
			
			  Reports.StartTest("School Admin Login Verification");
			  login.Verifyschooladminlogin();
			  
			  Reports.StartTest("Placements: Add/Clone/Update session verification");
			  session.verifySession();
			
	  	  
	  
	  
	  
	  
	  
	  	}catch (Exception e) {
			
			Reports.log(Status.ERROR, e.getMessage());
			
		}	
	 
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  

  @AfterMethod
  public void afterMethod() {
	  
	  Reports.endTest();
		 // SignOUT();
  }

}
