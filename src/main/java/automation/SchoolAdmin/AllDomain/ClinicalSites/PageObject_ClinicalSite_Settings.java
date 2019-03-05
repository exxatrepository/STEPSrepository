package automation.SchoolAdmin.AllDomain.ClinicalSites;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;

public class PageObject_ClinicalSite_Settings extends Controls {
	
	PageObject_ClinicalSite CS=new PageObject_ClinicalSite();
	
	public void VerifyClinicalSettings() throws InterruptedException {
	
	
		VerifyAddClinicalSettings();
	
	}


//Verify Add settings
	public void VerifyAddClinicalSettings() throws InterruptedException {
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Site Details"))
		{
			CS.searchsitepageNav();
			CS.sitedetailNav();
		}
		
		
		if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("settings.xpath")))==true)
		{
			Controls.wait(2000);
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("settings.xpath")));
			
			
			if(		Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("addresssectionDIV.xpath")))==true &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("addresssectionDIV.xpath")))==true &&
					Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("addresssectionDIV.xpath")))==true )
			{
				Reports.log(Status.PASS, "Settings fields verified");
			}
					
			
			
			List<String> settingsvalue=new ArrayList<String>();
			
			GeneralSettingAllSelected:
			for(int i=1;i<=10;i++)
			{
				
				for(int j=1;j<=4;j++)
				{
				
				 if(Controls.isElementPresent(By.xpath("//*[@id=\"sitesetting_form\"]/div[3]/div[2]/div/div/div/div["+i+"]/div["+j+"]/label/div/span/input"))==true)
					{
					 	Controls.SelectcheckboxOption(By.xpath("//*[@id=\"sitesetting_form\"]/div[3]/div[2]/div/div/div/div["+i+"]/div["+j+"]/label/div/span/input"));
						//Controls.SelectcheckboxOption(By.xpath("//*[@id=\"sitesetting_form\"]/div[3]/div[2]/div/div/div/div["+i+"]/div["+j+"]/label/div/span"));
						settingsvalue.add(Controls.GetText(By.xpath("//*[@id=\"sitesetting_form\"]/div[3]/div[2]/div/div/div/div["+i+"]/div["+j+"]/label")));
					}else
					{
						break GeneralSettingAllSelected;
					}
				 
				
				}
					
			}	
			

			
			Controls.Click(By.id(clinicalsiteProp.getProperty("save.id")));
			Controls.dynemicwait(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/div/div/div/div"));
			
			String settingsondetail=Controls.GetText(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]/ul/li[11]/div/div/div[2]/div/span/b"));
			String[] settingArr = settingsondetail.split(", ");
			
			
			//remove white space from all elements
			
			String[] settingstrimmedArray = new String[settingArr.length];
			for (int i = 0; i < settingArr.length; i++)
				settingstrimmedArray[i] = settingArr[i].trim();
			
			
			
			
			List<String> settingsondetaillist=new ArrayList<String>(Arrays.asList(settingstrimmedArray));
			
			Collections.sort(settingsvalue);
	        Collections.sort(settingsondetaillist);
	        
	        if(settingsvalue.equals(settingsondetaillist)==true)
	        {
	        	Reports.log(Status.PASS, "All Settings saved successfully");
	        }else
	        {
	        	Reports.log(Status.FAIL, "All Settings are not saved");
	        }
					
			
		}else
		{
			Reports.log(Status.FAIL, "Settings link is missing");
		}
	
		
		
	}
	
	
	
	

}
