package automation.SchoolAdmin.AllDomain.ClinicalSites;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;

public class PageObject_ClinicalSite_Address extends Controls {
	
	PageObject_ClinicalSite CS=new PageObject_ClinicalSite();
	
	
	
	public void verifyclinicalsiteAddress() throws IOException, InterruptedException
	{
		
		VerifyAddClinicalAddress();
		
	
	}
	
	
	
	
	private void VerifyAddClinicalAddress() throws InterruptedException {
		
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Site Details"))
		{
			CS.searchsitepageNav();
			CS.sitedetailNav();
		}
		
		
		if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("address.xpath")))==true)
		{
			
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("address.xpath")));
			
			
			if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("addresssectionDIV.xpath")))==true)
			{
				
				if(
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("Paddress1.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("Paddress2.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("PCity.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("PCounty.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("PState.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("PCountry.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("PZipCode.id"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("PInternationalAddress?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("MAutofillMailingAddressWithPhysicalAddress?.xpath"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MAddress1.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MAddress2.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MCity.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MCounty.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MState.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MCountry.id"))) &&
						Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("MZipCode.id")))) {
					
					Reports.log(Status.PASS, "Add/Edit Address field verified");
					
				}else
				{
					Reports.log(Status.FAIL, "Add/Edit Address field verified");
				}
				
				//Enter values in Physical Address
				Controls.Type(By.id(clinicalsiteProp.getProperty("Paddress1.id")), clinicalsiteProp.getProperty("ClinicalsiteAddress1"));
				Controls.Type(By.id(clinicalsiteProp.getProperty("Paddress2.id")), clinicalsiteProp.getProperty("ClinicalsiteAddress2"));
				Controls.Type(By.id(clinicalsiteProp.getProperty("PCity.id")), clinicalsiteProp.getProperty("ClinicalsiteCity"));
				Controls.Type(By.id(clinicalsiteProp.getProperty("PCounty.id")), clinicalsiteProp.getProperty("ClinicalsiteCounty"));
				Controls.SelectDropdonwByValue(By.id(clinicalsiteProp.getProperty("PState.id")), clinicalsiteProp.getProperty("Clinicalstate"));
				Controls.SelectDropdonwByValue(By.id(clinicalsiteProp.getProperty("PCountry.id")), clinicalsiteProp.getProperty("Clinicalcountry"));
				Controls.Type(By.id(clinicalsiteProp.getProperty("PZipCode.id")), clinicalsiteProp.getProperty("ClinicalZip"));
				if(clinicalsiteProp.getProperty("IsInternationalAddress?").equalsIgnoreCase("Y"))Controls.Click(By.xpath(clinicalsiteProp.getProperty("PInternationalAddress?.xpath")));
				
				//Mailing Address
				if(clinicalsiteProp.getProperty("IsAutofillMailingAddressWithPhysicalAddress?").equalsIgnoreCase("Y"))
				{
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("MAutofillMailingAddressWithPhysicalAddress?.xpath")));
				
				}else
				{
			
					Controls.Type(By.id(clinicalsiteProp.getProperty("MAddress1.id")), clinicalsiteProp.getProperty("ClinicalsiteAddress1")+"Test");
					Controls.Type(By.id(clinicalsiteProp.getProperty("MAddress2.id.id")), clinicalsiteProp.getProperty("ClinicalsiteAddress2")+"Test");
					Controls.Type(By.id(clinicalsiteProp.getProperty("MCity.id")), "Carrollton");
					Controls.Type(By.id(clinicalsiteProp.getProperty("MCounty.id")), "Test County");
					Controls.SelectDropdonwByValue(By.id(clinicalsiteProp.getProperty("MState.id")), "Georgia(GA)");
					Controls.SelectDropdonwByValue(By.id(clinicalsiteProp.getProperty("MCountry.id")), "United States");
					Controls.Type(By.id(clinicalsiteProp.getProperty("MZipCode.id")), "30117");
				}
				
				Controls.Click(By.id(clinicalsiteProp.getProperty("Addersssave.id")));
				
				Controls.wait(12000);
				
				String EnteredAddress=clinicalsiteProp.getProperty("ClinicalsiteAddress1")+", "+clinicalsiteProp.getProperty("ClinicalsiteAddress2")+", "+clinicalsiteProp.getProperty("ClinicalsiteCity")+" "+clinicalsiteProp.getProperty("ClinicalsiteCounty")+" "+clinicalsiteProp.getProperty("Clinicalstate")+"- "+clinicalsiteProp.getProperty("ClinicalZip");
				String Savedaddress=Controls.GetText(By.xpath(clinicalsiteProp.getProperty("savedaddress.xpath")));
				
				if(Savedaddress.equalsIgnoreCase(EnteredAddress))
				{
					Reports.log(Status.PASS, "Address is saved successfully");
				}else
				{
					Reports.log(Status.FAIL, "Address is not saved successfully");
				}
				
			}else
			{
				Reports.log(Status.FAIL, "There is no Edit address section");
			}
			
			}
		driver.navigate().back();
		Controls.wait(3000);
	}


}
