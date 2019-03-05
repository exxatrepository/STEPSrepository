package automation.SchoolAdmin.AllDomain.Placements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;

public class PageObject_VerifySession_AddUpdate extends Controls {
	
	
	public void verifySession() throws IOException, InterruptedException
	{
//		VerifyPlacementBySessionPage_UI();
//		VerifyAddNewSession();
		VerifyCloneSession();
		
		
	}

	
	//Go to search sites page and verify
	public void Placement_BySession_PageNav() {
			
			
			Controls.hoverclick(By.linkText("Placements"), By.linkText("By Session"));
			Controls.dynemicwait(By.xpath("//*[@id=\"mainBody\"]/div[3]/div[2]/div/div[1]/div[2]"));
			
			
			if(Controls.GetText(By.xpath(placementProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("By Session"))
			{
				Reports.log(Status.PASS, "Page is redirected on Placement 'By Session' page successfully");
			}
			else
			{
				Reports.log(Status.FAIL, "Page is redirected on incorrect page");
				
			}	
			
			
		}
			
			
	//Navigate to Session Setup
	public void SessionSetupNav() throws InterruptedException {
				
				if (Controls.isElementPresent(By.id(placementProp.getProperty("sitename.id")))==true)
		               
	            {
	                Controls.Type(By.id(placementProp.getProperty("SessionLabel.id")),placementProp.getProperty("Clinicalsitename"));
	               
	                if(Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_Button.Xpath")))==true)
		            {
		                Controls.Click(By.xpath(placementProp.getProperty("Search_Button.Xpath")));
		               
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
				
					if (Controls.isElementPresent(By.xpath(placementProp.getProperty("Session_SearchResult.Xpath")))==true)
			               
		            {
						Controls.Click(By.xpath(placementProp.getProperty("SessionSetupArrow.xpath")));
		            }else
		            {
		            	 Reports.log(Status.SKIP, "No search result found so can't be redirected to Session Setup page.");
		            }
				
				
				
			}
	
	
	//Verify Ui of Placement By Session Page
	public void VerifyPlacementBySessionPage_UI() throws InterruptedException {
		
		
		if(!Controls.GetText(By.xpath(placementProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("By Session"))Placement_BySession_PageNav();
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("Instructions.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("tools.xpath")))==true &&
				Controls.isElementPresent(By.id(placementProp.getProperty("AddSessionButton.id")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("quicksearchInput.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("quicksearchicon.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("quicksearchArrow.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_calendaryearddl.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_calendaryearInput.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_sessionLabelddl.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_sessionLabelInput.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_batchlabelddl.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_batchlabelddlInput.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_IsActiveddl.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_IsActivedRadioY.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_IsActivedRadioN.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_IsActivedRadioNA.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_FavoriteOnly.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_searchButton.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_ClearAll.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("FilterByLabel.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Helpicons.xpath=")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("sessiontable.xpath=")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionFav_column1.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("Sessionlbl_column2.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("minweeks_column3.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("startdate_column4.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("calendaryear_column5.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("batchlabel_column6.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("sessionsetup_column7.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("placement_column8.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("postplacements_column9.xpath")))==true)
		{
			
			Reports.log(Status.PASS, "Verified UI of Placement by Session page");
		
		}else
		{
		
			Reports.log(Status.FAIL, "Verified UI of Placement by Session page");
		
		}
		
	}
	
	
	public void VerifyAddNewSession() throws InterruptedException {
		
		if(!Controls.GetText(By.xpath(placementProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("By Session"))Placement_BySession_PageNav();
		
		Controls.Click(By.id(placementProp.getProperty("AddSessionButton.id")));
		Controls.wait(2000);
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel.xpath")))==true)
		{
			
			//Verify UI of Add Session popup model
			
			if(Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_2ndRadio.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_ExistingSessionddl.xpath")))==true &&
					Controls.isElementPresent(By.id(placementProp.getProperty("AddSession_popupModel_okbutton.id")))==true)
			{
				Reports.log(Status.PASS, "Verified UI of Add session popup Window");
			}else
			{
				Reports.log(Status.FAIL, "Verified UI of Add session popup Window");
			}
			
			
			if(Controls.IsRadioSelected(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath"))))Controls.Click(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath")));
			Controls.Click(By.id(placementProp.getProperty("AddSession_popupModel_okbutton.id")));
			Controls.wait(2000);
			
			
			if(Controls.isElementPresent(By.xpath(placementProp.getProperty("Sessionlabel.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("Batch.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("MinWeeks.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("CalendarYear.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("Active.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("ShowOnSlotRequestForm.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("StudentReviewConfirmation.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionCoordinator.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("Semester.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionDescription.xpath")))==true &&
					Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_Savebutton.xpath")))==true)
			{
				Reports.log(Status.PASS, "Verified UI of Create New Session Page");
			}else
			{
				Reports.log(Status.FAIL, "Verified UI of Create New Session Page");
			}
			
			
			Controls.Type(By.xpath(placementProp.getProperty("Sessionlabel.xpath")), placementProp.getProperty("Session_Label"));
			Controls.SelectDropdonwByValue(By.xpath(placementProp.getProperty("Batch.xpath")), placementProp.getProperty("Batch"));
			Controls.Type(By.xpath(placementProp.getProperty("MinWeeks.xpath")), placementProp.getProperty("Minimum_Weeks"));
			Controls.SelectDropdonwByValue(By.xpath(placementProp.getProperty("CalendarYear.xpath")), placementProp.getProperty("Calendar_Year"));
			
			Controls.Click(By.xpath(placementProp.getProperty("Active.xpath")));
			Controls.Click(By.xpath(placementProp.getProperty("ShowOnSlotRequestForm.xpath")));
			Controls.Click(By.xpath(placementProp.getProperty("StudentReviewConfirmation.xpath")));
			
			Controls.SelectDropdonwByValue(By.xpath(placementProp.getProperty("SessionCoordinator.xpath")), placementProp.getProperty("Session_Coordinator"));
			
			Controls.Type(By.xpath(placementProp.getProperty("Semester.xpath")), placementProp.getProperty("Semester"));
			Controls.Type(By.xpath(placementProp.getProperty("SessionDescription.xpath")), placementProp.getProperty("Session_Description"));
			
			Controls.Click(By.xpath(placementProp.getProperty("AddSession_Savebutton.xpath")));
			Controls.wait(8000);
			
			if(Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionDescription.xpath")))==true &&
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_SessionName.xpath"))).trim().equalsIgnoreCase(placementProp.getProperty("Session_Label").trim()) &&	
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_Batch.xpath"))).trim().equalsIgnoreCase(placementProp.getProperty("Batch").trim()) &&
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_CalendarYear.xpath"))).trim().equalsIgnoreCase(placementProp.getProperty("Calendar_Year").trim()) &&
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_IsActive.xpath"))).trim().equalsIgnoreCase(placementProp.getProperty("AddSession_Savebutton.xpath").trim()) &&
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_ShowOnSlotRequestForm.xpath"))).trim().equalsIgnoreCase(placementProp.getProperty("Show_On_Slot_Request_Form").trim()) &&
				Controls.GetText(By.xpath(placementProp.getProperty("SessionDetail_SessionDecription.xpath="))).trim().equalsIgnoreCase(placementProp.getProperty("Session_Description").trim()) ) {
				
				Reports.log(Status.PASS, "Session is added successfully.");
				
			}else
			{
				Reports.log(Status.FAIL, "Session is not added properly.");
			}
				
				
		}else
		{
			Reports.log(Status.FAIL, " Add Session popup model is not opened so can't add sessions");
			
		}
		
	}
	
	
	
	
	
public void VerifyCloneSession() throws InterruptedException {
	
	
	
	
	if(!Controls.GetText(By.xpath(placementProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("By Session"))Placement_BySession_PageNav();
	
	Controls.Click(By.id(placementProp.getProperty("AddSessionButton.id")));
	Controls.wait(2000);
	
	if(Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel.xpath")))==true)
	{
		
		//Verify UI of Add Session popup model
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_1stRadio.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_2ndRadio.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("AddSession_popupModel_ExistingSessionddl.xpath")))==true &&
				Controls.isElementPresent(By.id(placementProp.getProperty("AddSession_popupModel_okbutton.id")))==true)
		{
			Reports.log(Status.PASS, "Verified UI of Add session popup Window");
		}else
		{
			Reports.log(Status.FAIL, "Verified UI of Add session popup Window");
		}
		
		
		if(Controls.IsRadioSelected(By.xpath(placementProp.getProperty("AddSession_popupModel_2ndRadio.xpath")))==false)Controls.Click(By.xpath(placementProp.getProperty("AddSession_popupModel_2ndRadio.xpath")));
		Controls.wait(1000);
		Controls.SelectDropdonwByValue(By.xpath(placementProp.getProperty("AddSession_popupModel_ExistingSessionddl.xpath")), "Mock Session");
		Controls.Click(By.id(placementProp.getProperty("AddSession_popupModel_okbutton.id")));
		Controls.wait(2000);
		
		//Verify UI of Session information 
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Sessionlabel.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Batch.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_MinWeeks.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_CalendarYear.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Active.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_ShowOnSlotRequestForm.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_StudentReviewConfirmation.xpath")))==true &&
				//Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_SessionCoordinator.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Semester.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_SessionDescription.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level1.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level2.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level3.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level4.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level5.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level6.xpath")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_level7.xpath")))==true &&
				Controls.isElementPresent(By.id(placementProp.getProperty("SessionClone_bar.id")))==true &&
				Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Continuebtn.xpath")))==true )
		{
			Reports.log(Status.PASS, "Verified UI of Information page to create Session clone.");
		}else
		{
			Reports.log(Status.FAIL, "Verified UI of Information page to create Session clone.");
		}
		
		
		
		List<String> CloneSession_expectedResult = new ArrayList<String>();
		
		CloneSession_expectedResult.add(placementProp.getProperty("Session_Label")+"-Clone");
		CloneSession_expectedResult.add(Controls.GetSelectedText(By.xpath(placementProp.getProperty("SessionClone_Batch.xpath"))));
		CloneSession_expectedResult.add(Controls.GetValue(By.xpath(placementProp.getProperty("SessionClone_MinWeeks.xpath"))));
		CloneSession_expectedResult.add(Controls.GetSelectedText(By.xpath(placementProp.getProperty("SessionClone_CalendarYear.xpath"))));
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Active_SwitchON.xpath")))==true)
		{
			CloneSession_expectedResult.add("Yes");
		}else
		{
			CloneSession_expectedResult.add("No");
		}
		
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Show_On_Slot_Request_Form.xpath")))==true)
		{
			CloneSession_expectedResult.add("Yes");
			
		}else
		{
			CloneSession_expectedResult.add("No");
		}
		
		if(Controls.isElementPresent(By.xpath(placementProp.getProperty("SessionClone_Student_Review_Confirmation.xpath")))==true)
		{
			CloneSession_expectedResult.add("Yes");
		}else
		{
			CloneSession_expectedResult.add("No");
		}
		CloneSession_expectedResult.add("Yes");
		CloneSession_expectedResult.add(Controls.GetValue(By.xpath(placementProp.getProperty("SessionClone_StudentReviewDueDate.xpath"))));
		CloneSession_expectedResult.add(Controls.GetValue(By.xpath(placementProp.getProperty("SessionClone_Semester.xpath"))));
		CloneSession_expectedResult.add(Controls.GetValue(By.xpath(placementProp.getProperty("SessionClone_SessionDescription.xpath"))));
		
		
		
		
		Controls.Type(By.xpath(placementProp.getProperty("Sessionlabel.xpath")), CloneSession_expectedResult.get(0) );
		
		
		
		
		
		
		
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Continuebtn.xpath")));
		Controls.wait(2000);
		
		//select sequences
		int NumberOfSequence=Controls.GetNoofRows(By.xpath(placementProp.getProperty("SessionClone_Sequence_table.xpath")));
		for(int i=1; i<=NumberOfSequence; i++)
		{
			
			Controls.Click(By.xpath("//*[@id=\"xform1\"]/div/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/span/input"));
			
		}
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Sequence_ContinueBtn.xpath")));
		
		//Select Activities
		int NumberOfActivities=Controls.GetNoofRows(By.xpath(placementProp.getProperty("SessionClone_Activity_table.xpath")));
		for(int i=1; i<=NumberOfActivities; i++)
		{
			
			Controls.Click(By.xpath("//*[@id=\"xform1\"]/div/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/span/input"));
			
		}
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Sequence_ContinueBtn.xpath")));
		
		
		
		//Select Req. Documents
		int NumberOfReqDocuments=Controls.GetNoofRows(By.xpath(placementProp.getProperty("SessionClone_Activity_table.xpath")));
		for(int i=1; i<=NumberOfReqDocuments; i++)
		{
			
			Controls.Click(By.xpath("//*[@id=\"xform1\"]/div/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/span/input"));
			
		}
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Sequence_ContinueBtn.xpath")));

		
		//Select Questionnaires
		int NumberOfQuestionnaires=Controls.GetNoofRows(By.xpath(placementProp.getProperty("SessionClone_Activity_table.xpath")));
		for(int i=1; i<=NumberOfQuestionnaires; i++)
		{
			
			Controls.Click(By.xpath("//*[@id=\"xform1\"]/div/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/span/input"));
			
		}
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Sequence_ContinueBtn.xpath")));
		
		
		
		//Select Documents
		int NumberOfDocuments=Controls.GetNoofRows(By.xpath(placementProp.getProperty("SessionClone_Activity_table.xpath")));
		for(int i=1; i<=NumberOfDocuments; i++)
		{
			
			Controls.Click(By.xpath("//*[@id=\"xform1\"]/div/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr["+i+"]/td[1]/div/span/input"));
			
		}
		Controls.Click(By.xpath(placementProp.getProperty("SessionClone_Sequence_ContinueBtn.xpath")));
		
		
		
		//Confirm all information 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}else
		{
			Reports.log(Status.FAIL, " Add Session popup model is not opened so can't add sessions");
		}

	
	
	

	}
}
