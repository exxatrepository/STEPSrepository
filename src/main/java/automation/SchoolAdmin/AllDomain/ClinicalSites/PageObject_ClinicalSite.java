package automation.SchoolAdmin.AllDomain.ClinicalSites;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;
import org.openqa.selenium.JavascriptExecutor;





public class PageObject_ClinicalSite extends Controls {
	
	//Steps_Common SC=new Steps_Common();
	
	
	public void verifyclinicalsite() throws IOException, InterruptedException
	{
		
		VerifycreateClinicalSite();
		VerifySiteDetailUI();
		VerifyeditClinicalSite();
		
	}
	
	
	//Go to search sites page and verify
		public void searchsitepageNav() {
		
		
		Controls.hoverclick(By.linkText("Clinical Sites"), By.linkText("Search Sites"));
		Controls.dynemicwait(By.xpath("//*[@id=\"mainBody\"]/div[3]/div[2]/div/div[1]/div[2]"));
		
		
		if(Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Search Sites"))
		{
			Reports.log(Status.PASS, "Page is redirected on Search Site page successfully");
		}
		else
		{
			Reports.log(Status.FAIL, "Page is redirected on incorrect page");
			
		}	
		
		
	}
		
		
		public void sitedetailNav() throws InterruptedException {
			
			if (Controls.isElementPresent(By.id(clinicalsiteProp.getProperty("sitename.id")))==true)
	               
            {
                Controls.Type(By.id(clinicalsiteProp.getProperty("sitename.id")),clinicalsiteProp.getProperty("Clinicalsitename"));
               
                if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("searchbutton.xpath")))==true)
	            {
	                Controls.Click(By.xpath(clinicalsiteProp.getProperty("searchbutton.xpath")));
	               
	            }
	            else
	            {
	                Reports.log(Status.FAIL, "Search button is missing");
	            }
           
            }
            else
            {
                Reports.log(Status.FAIL, "Search field doesn't found");
            }
				Controls.wait(5000);
			
				if (Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("1stsitenamename.xpath")))==true)
		               
	            {
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("1stsitenamename.xpath")));
	            }else
	            {
	            	 Reports.log(Status.SKIP, "No search result found so can't be redirected to site detail page.");
	            }
			
			
			
		}
		


		//Create Clinical Site
		public void VerifycreateClinicalSite()  throws IOException, InterruptedException	
		{
			
			if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Search Sites"))searchsitepageNav();
			
			
			if(Controls.isElementPresent(By.id("btnSiteInfo"))==true)
			{
				Controls.wait(5000);
				Controls.Click(By.id("btnSiteInfo"));
				Controls.wait(2000);
				
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("allforms.xpath")))==true)
				{
					
					//Basic Info
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteName.Xpath")), clinicalsiteProp.getProperty("Clinicalsitename"));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteShort/FormerName.xpath")), "Automation Session");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PhoneNumber.xpath")), "1111111111");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("FAX.xpath")), "2222222222");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Website.xpath")), "https://www.google.com");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SupervisingClinician.xpath")), "QA Supervising Clinician");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("DepartmentName.xpath")), "QA Department");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("DepartmentPhone.xpath")), "3333333333");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ContactPerson.xpath")), "QA Contact person");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ContactPersonPhone.xpath")), "4444444444");
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("SiteArea.xpath")), "In Area");
//					//Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsSiteActive.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Email.xpath")), "automationtest@examples.com");
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("SiteStatus.xpath")), "Contacted");
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("YearContactEstablished.xpath")), "2018");
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("FlagSite.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("FlagComment.xpath")), "Flag Comment -test comment by automation");
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsGeorgiaConsortiumofClinicalEducatorsSite?.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("COAApprovalDate.xpath")), "12/01/2018");
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("COAApprovalDate.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Stipend.xpath")), "Test Stipend byt automation");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteContactedBy.xpath")), "Site Contacted By-Automation QA user");
//					
//					
//					//Facilities
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("ParkingProvided.xpath")), "Yes");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ParkingFacilityNotes.xpath")), "Parking Facility Notes-Testing notes");
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("HousingProvided.xpath")), "Yes");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("HousingFacilityNotes.xpath")), "Housing Facility Notes-Testing Notes");
//					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("StudentSchedule.xpath")), "8 Hour Schedule(Weekend/Holiday)");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("WorkingHours.xpath")), "Working Hours-Testing ");
//					
//					
//					//Other Configurations
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSitePreferPaperBasedRequest?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteRequireSpecialApplicationFromStudents?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsThisSiteBasedInARuralArea?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteProvideServicesForAMedicallyUnderservedAreaOrPopulation?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("Category.xpath")));	
//					Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("CategoryDropdownoption.xpath")), "General");
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("ShowOnMapOfAffiliation?.xpath")));
//					int numberofSiteInitiatedBy=Controls.GetnumberofOptionDropdown(By.xpath("//*[@id=\"InitiatingDescipline\"]"));
//					if(numberofSiteInitiatedBy>1)Controls.SelectDropdownByIndex(By.xpath(clinicalsiteProp.getProperty("SiteInitiatedBy.xpath")), 1);

					
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteQalifyForReimbursement?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSitePreceptStudentsFromOtherPrograms?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IncludeThisSiteDuringSlotRequests?.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")), "Regression by Automation(testing Notes)-Please enter notes to be shared with site during slot request");
//					
//					driver.switchTo().frame(driver.findElement(By.tagName("")));
//					
//					WebElement element=driver.findElement(by);
//					element.clear();
//					element.sendKeys(TextToInput);
//					driver.switchTo().frame(driver.findElement(By.xpath("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")))
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")), "Regression by Automation(testing Notes)-Please enter notes to be shared with site during slot request");
//					
//					//Notes
					
					
					
					
					
					
					//Controls.Type(By.xpath(clinicalsiteProp.getProperty("RequirementNotes.xpath")), "Requirement Notes (share with school and students)-Testing Notes");
					
					((JavascriptExecutor) driver).executeScript("document.getElementsByXpath('//*[@id=\\\"siteForm\\\"]/div[3]/div[4]/div[2]/div/div[3]/div/div/iframe\')[0].style.display='inline'");
					driver.findElement(By.xpath("//*[@id=\"siteForm\"]/div[3]/div[4]/div[2]/div/div[3]/div/div/iframe")).sendKeys("Show this message in rich text editor");
					
					
					
					
					
					
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Notessharedwithstudents.xpath")), "Notes(shared with students)-Testing notes");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Notesforschooluseonly.xpath")), "Notes(for school use only)-Testing Notes");
					
					//Save
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("Save.xpath")));
					Controls.wait(10000);
					
					if(Controls.GetText(By.xpath(clinicalsiteProp.getProperty("sitename.xpath"))).equalsIgnoreCase(clinicalsiteProp.getProperty("Clinicalsitename")))
					{
						Reports.log(Status.PASS, "Clinical Site is created successfully and redirected to Site Detail page");
					
					}else
					{
						Reports.log(Status.FAIL, "Clinical Site is not created successfully");
					}
					
					
					}
			}
			else
			{
				Reports.log(Status.FAIL, "'ADD New Site' button is missing");
			}
							
							
							
		}

	
		//Verify site Detail UI
		public void VerifySiteDetailUI() throws InterruptedException {
			
			
			if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Site Details"))
			{
				searchsitepageNav();
				sitedetailNav();
			}
			
			
			if(
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("sitename.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("breadcrumb.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("topsiteInfo.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("sitedetailtitle.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("siteinfo.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("relatedinfo.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("staff.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("note.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("sitedoc.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("approvedPTSE.xpath"))) &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("help.xpath"))) )
			{
				Reports.log(Status.PASS, "Site Details page is showing correctly");
			}
			else
			{
				Reports.log(Status.FAIL, "section missing on Site detail page.");
			}
				
	}
		
		
		public void VerifyeditClinicalSite() throws InterruptedException {
			
			if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Site Details"))
			{
				searchsitepageNav();
				sitedetailNav();
			}
			
			if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("EditInformation.xpath")))==true)
			{
				Controls.wait(8000);
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("EditInformation.xpath")));
				
				
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("allforms.xpath")))==true)
				{
					
					//Basic Info
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteName.Xpath")), clinicalsiteProp.getProperty("Clinicalsitename")+"-Edited");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteShort/FormerName.xpath")), "Automation Session-Edited");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PhoneNumber.xpath")), "9999999999");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("FAX.xpath")), "8888888888");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Website.xpath")), "https://www.gmail.com");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SupervisingClinician.xpath")), "QA Supervising Clinician-Edit");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("DepartmentName.xpath")), "QA Department-Edit");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("DepartmentPhone.xpath")), "7777777777");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ContactPerson.xpath")), "QA Contact person-Edit");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ContactPersonPhone.xpath")), "6666666666");
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("SiteArea.xpath")), "In Area");
					//Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsSiteActive.xpath")));
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Email.xpath")), "editedautomationtest@examples.com");
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("SiteStatus.xpath")), "Contacted");
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("YearContactEstablished.xpath")), "2018");
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("FlagSite.xpath")));
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("FlagComment.xpath")), "Flag Comment -test comment by automation-Edited");
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsGeorgiaConsortiumofClinicalEducatorsSite?.xpath")));
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("COAApprovalDate.xpath")), "12/12/2018");
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("COAApprovalDate.xpath")));
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Stipend.xpath")), "Test Stipend byt automation");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("SiteContactedBy.xpath")), "Site Contacted By-Automation QA user");
					
					
					//Facilities
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("ParkingProvided.xpath")), "Yes");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("ParkingFacilityNotes.xpath")), "Parking Facility Notes-Testing notes");
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("HousingProvided.xpath")), "Yes");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("HousingFacilityNotes.xpath")), "Housing Facility Notes-Testing Notes");
					Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("StudentSchedule.xpath")), "8 Hour Schedule(Weekend/Holiday)");
					Controls.Type(By.xpath(clinicalsiteProp.getProperty("WorkingHours.xpath")), "Working Hours-Testing-edited ");
					
					//Other Configurations
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSitePreferPaperBasedRequest?.xpath")));
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteRequireSpecialApplicationFromStudents?.xpath")));
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IsThisSiteBasedInARuralArea?.xpath")));
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteProvideServicesForAMedicallyUnderservedAreaOrPopulation?.xpath")));
					
					//int numberofcategories=Controls.GetnumberofOptionDropdown(By.xpath(clinicalsiteProp.getProperty("categoriesoptionDIV.xpath")));
//					WebElement element=driver.findElement(By.xpath(clinicalsiteProp.getProperty("categoriesoptionDIV.xpath")));
//					List<WebElement> options=element.findElements(By.tagName("li"));
//					int numberofcategories= options.size();
//					if(numberofcategories>1)
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("Category.xpath")));	
					Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("CategoryDropdownoption.xpath")), "General");				
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("ShowOnMapOfAffiliation?.xpath")));
					int numberofSiteInitiatedBy=Controls.GetnumberofOptionDropdown(By.xpath("//*[@id=\"InitiatingDescipline\"]"));
					if(numberofSiteInitiatedBy>1)Controls.SelectDropdownByIndex(By.xpath(clinicalsiteProp.getProperty("SiteInitiatedBy.xpath")), 1);
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSiteQalifyForReimbursement?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("DoesThisSitePreceptStudentsFromOtherPrograms?.xpath")));
//					Controls.Click(By.xpath(clinicalsiteProp.getProperty("IncludeThisSiteDuringSlotRequests?.xpath")));
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")), "Regression by Automation(testing Notes)-Please enter notes to be shared with site during slot request");
//					
//					driver.switchTo().frame(driver.findElement(By.tagName("")));
//					
//					WebElement element=driver.findElement(by);
//					element.clear();
//					element.sendKeys(TextToInput);
//					driver.switchTo().frame(driver.findElement(By.xpath("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")))
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("PleaseEnterNotesToBeSharedWithSiteDuringSlotRequest.xpath")), "Regression by Automation(testing Notes)-Please enter notes to be shared with site during slot request");
//					
//					//Notes
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("RequirementNotes.xpath")), "Requirement Notes (share with school and students)-Testing Notes");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Notessharedwithstudents.xpath")), "Notes(shared with students)-Testing notes");
//					Controls.Type(By.xpath(clinicalsiteProp.getProperty("Notesforschooluseonly.xpath")), "Notes(for school use only)-Testing Notes");
					
					//Save
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("Save.xpath")));
					Controls.wait(10000);
					
					if(Controls.GetText(By.xpath(clinicalsiteProp.getProperty("sitename.xpath"))).equalsIgnoreCase(clinicalsiteProp.getProperty("Clinicalsitename")+"-Edited"))
					{
						Reports.log(Status.PASS, "Clinical Site is edited successfully and redirected to Site Detail page");
					
					}else
					{
						Reports.log(Status.FAIL, "Clinical Site is not edited successfully");
					}
					
					
					}else
					{
						Reports.log(Status.FAIL, "'Missing Add information forms");
					}
			}
			else
			{
				Reports.log(Status.FAIL, "'Edit Information' link is missing");
			}
		}
		
		
		
		
		
		
		
		
		
	

	
	
	
	
	

}
