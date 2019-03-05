package automation.Tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ClinicalSites.PageObject_ClinicalSite;
import automation.SchoolAdmin.AllDomain.ClinicalSites.PageObject_ClinicalSite_Address;
import automation.SchoolAdmin.AllDomain.ClinicalSites.PageObject_ClinicalSite_Settings;
import automation.SchoolAdmin.AllDomain.ClinicalSites.PageObject_Slots;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Tests_clinicalSite extends Controls {
	
	Login login=new Login();
	PageObject_ClinicalSite_Settings settings=new PageObject_ClinicalSite_Settings();
	PageObject_ClinicalSite_Address address=new PageObject_ClinicalSite_Address();
	PageObject_ClinicalSite CS=new PageObject_ClinicalSite();
	PageObject_Slots slots=new PageObject_Slots();
	
	
	
	
	 @BeforeMethod
	  public void beforeMethod() {
		  
	  }
	
  

	  @Test
	  public void Execute() throws InterruptedException, IOException {
		  
		  Reports.Startlog();
		  
		  
		  try {
				
			  Reports.StartTest("School Admin Login Verification");
			  login.Verifyschooladminlogin();
			  
//			  Reports.StartTest("Clinical Sites Add/Update Verification");
//			  CS.verifyclinicalsite();
//			  
//			  Reports.StartTest("Clinical Site Address Verification");
//			  address.verifyclinicalsiteAddress();
//			  
//			  Reports.StartTest("Clinical Site Settings Verification");
//			  settings.VerifyAddClinicalSettings();
//			
			  Reports.StartTest("Clinical Site Slots Verification");
			  slots.verifySlots();
				
		  	  
		  
		  
		  
		  
		  
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
