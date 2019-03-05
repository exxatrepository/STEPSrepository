package automation.SchoolAdmin.AllDomain.ClinicalSites;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;

public class PageObject_Slots extends Controls {
	
	PageObject_ClinicalSite CS=new PageObject_ClinicalSite();
	
	public void verifySlots() throws IOException, InterruptedException
	{
		
		VerifyPlacementSlotPage_NAVAndUI();
		VerifyAddSlot();
		VerifyEditSlot();
		VerifyDeleteSlot();
		
	
	}
	
	
//Verify Slots page navigation and UI
	public void VerifyPlacementSlotPage_NAVAndUI() throws InterruptedException {
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Slots"))
		{
			CS.searchsitepageNav();
			CS.sitedetailNav();
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("slots.xpath")));
			Controls.wait(2000);
		}
		
		
		if( 	Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("slotTitle.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("slotbreadcrumb.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Bookmarkthissitetosendconfirmationemailforthisyear?.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("slotSiteDetailPanel.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("SlotSelectYearDropdown.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_GotoSiteDetails.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_PlacementSlot.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("SlotRequestResponse.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("RelatedInformation.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("SiteRequirementNotes.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("SlotWithPlacement.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("ActiveSlot.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("InActiveSlot.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("SlotNotConfirmedBySite.xpath")))==true)
				{
					Reports.log(Status.PASS, "Verified UI of Placement Slots Page.");
				}else
				{
					Reports.log(Status.FAIL, "Verified UI of Placement Slots Page.");
				}
		
		
		}
	
	
	public void VerifyAddSlot() throws InterruptedException {
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Slots"))
		{
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("slots.xpath")));
			Controls.wait(2000);
		}
		
		if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_1stSessionname.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_1stSessionDates.xpath")))==true &&
				Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_1stSessionAddSlotButton.xpath")))==true)
		{
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_1stSessionAddSlotButton.xpath")));
			
			if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Add/edit_slotpopup.xpath"))))
			{
				//Verify Add slot window UI verify
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Setting.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NumberofStudents.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervision.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_RequirementCriteria.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Status.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Status_dropdownOption.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_DescribePatientPopulation.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforStudents.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforSchoolUse.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_UpdatedBy.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_UpdatedDate.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_insertedby.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_insertedDate.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_PlacedStudent.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_CancelledSlots.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddslotTitle.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_closeIcon.xpath"))) &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_SaveAndClose.xpath")))
						
				) {
					
					Reports.log(Status.PASS, "Verified all fields of Add Slot Details.");
					
				}else
				{
					Reports.log(Status.FAIL, "Verified all fields of Add Slot Details.");
				}
				
				
				Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("Slot_Setting.xpath")), clinicalsiteProp.getProperty("Setting").trim());
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NumberofStudents.xpath")), clinicalsiteProp.getProperty("Number_of_Students").trim());
				
				
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervision.xpath")));
				Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervisionDropdownOption.xpath")), clinicalsiteProp.getProperty("Type_of_Supervision").trim());
				
				Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("Slot_RequirementCriteria.xpath")), clinicalsiteProp.getProperty("Requirement_Criteria").trim());
				
				
				if(clinicalsiteProp.getProperty("Interview_Required").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Interview_Required").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired.xpath")));
				
				if(clinicalsiteProp.getProperty("Do_students_need_to_upload_resume?").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Do_students_need_to_upload_resume?").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?.xpath")));
				
				if(clinicalsiteProp.getProperty("Offered_on_FCFS_basis?").equalsIgnoreCase("Yes") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Offered_on_FCFS_basis?").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?.xpath")));
				
				if(clinicalsiteProp.getProperty("Must_be_filled?").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Must_be_filled?").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?.xpath")));
				
				if(clinicalsiteProp.getProperty("Offered_through_consortium?").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Offered_through_consortium?").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?.xpath")));
				
				if(clinicalsiteProp.getProperty("Has_been_requested_by_student?").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Has_been_requested_by_student?").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?_SwitchON.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?.xpath")));
				
				if(clinicalsiteProp.getProperty("Active").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Active").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Active.xpath")));
				
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Status.xpath")));
				Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("Slot_StatusDrodownoptions.xpath")), clinicalsiteProp.getProperty("Status").trim());
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_DescribePatientPopulation.xpath")), "Automation Test- Describe Patient Population");
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforStudents.xpath")), "Automation Test- Notes for Students");
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforSchoolUse.xpath")), "Automation Test- Notes for School Use");
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_SaveAndClose.xpath")));
				Controls.wait(5000);
				
				
				
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")))==true &&
						Controls.GetText(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlotSettingsname.xpath"))).equalsIgnoreCase(clinicalsiteProp.getProperty("Setting")+" "+clinicalsiteProp.getProperty("Number_of_Students"))==true)
				{
					Reports.log(Status.PASS, "Slot is added successfully.");
				
				}else
				{
					Reports.log(Status.FAIL, "Slot is not added properly.");
				}
			
			}else
			{
				Reports.log(Status.FAIL, "Add Slot Details popup doesn't opened.");
			}

		}else
		{
			Reports.log(Status.SKIP, "No Session available so can't add slots.");
		}
	
}
	
	
	public void VerifyEditSlot() throws InterruptedException {
		
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Slots"))
		{
			CS.searchsitepageNav();
			CS.sitedetailNav();
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("slots.xpath")));
			Controls.wait(2000);
		}
		
		
			
		
		if(	Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")))==true)
		{
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")));
			
			if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Add/edit_slotpopup.xpath"))))
			{
				//Verify Edit slot window UI verify
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Setting.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NumberofStudents.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervision.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_RequirementCriteria.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Status.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Status_dropdownOption.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_DescribePatientPopulation.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforStudents.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforSchoolUse.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_UpdatedBy.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_UpdatedDate.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_insertedby.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_insertedDate.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_PlacedStudent.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_CancelledSlots.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddslotTitle.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_closeIcon.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_SaveAndClose.xpath")))==true &&
						Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_DeleteSlot.xpath")))==true
						
				) {
					
					Reports.log(Status.PASS, "Verified all fields of Edit Slot Details.");
					
				}else
				{
					Reports.log(Status.FAIL, "Verified all fields of Edit Slot Details.");
				}
				
				
				Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("Slot_Setting.xpath")), clinicalsiteProp.getProperty("Edit_Setting").trim());
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NumberofStudents.xpath")), clinicalsiteProp.getProperty("Edit_Number_of_Students").trim());
				
				
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervision.xpath")));
				Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("Slot_TypeofSupervisionDropdownOption.xpath")), clinicalsiteProp.getProperty("Edit_Type_of_Supervision").trim());
				
				Controls.SelectDropdonwByValue(By.xpath(clinicalsiteProp.getProperty("Slot_RequirementCriteria.xpath")), clinicalsiteProp.getProperty("Edit_Requirement_Criteria").trim());
				
				
				if(clinicalsiteProp.getProperty("Edit_Interview_Required").equalsIgnoreCase("Yes")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Interview_Required").equalsIgnoreCase("No")==true && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired_SwitchON.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Do_students_need_to_upload_resume?").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Do_students_need_to_upload_resume?").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Offered_on_FCFS_basis?").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Offered_on_FCFS_basis?").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?_SwitchON.xpath")))==true  )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Must_be_filled?").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Must_be_filled?").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?_SwitchON.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Offered_through_consortium?").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Offered_through_consortium?").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?_SwitchON.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Has_been_requested_by_student?").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Has_been_requested_by_student?").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?_SwitchON.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Active").equalsIgnoreCase("Yes")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active_SwitchOff.xpath")))==true || clinicalsiteProp.getProperty("Edit_Active").equalsIgnoreCase("No")==true  && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active_SwitchOff.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Active.xpath")));
				
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Status.xpath")));
				Controls.SelectDropdonwByValue_btnUI(By.xpath(clinicalsiteProp.getProperty("Slot_StatusDrodownoptions.xpath")), clinicalsiteProp.getProperty("Edit_Status").trim());
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_DescribePatientPopulation.xpath")), "Automation Test- Describe Patient Population-Edited");
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforStudents.xpath")), "Automation Test- Notes for Students-Edited");
				Controls.Type(By.xpath(clinicalsiteProp.getProperty("Slot_NotesforSchoolUse.xpath")), "Automation Test- Notes for School Use-Edited");
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_SaveAndClose.xpath")));
				Controls.wait(5000);
				
				
				
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")))==true &&
						Controls.GetText(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlotSettingsname.xpath"))).equalsIgnoreCase(clinicalsiteProp.getProperty("Edit_Setting")+" "+clinicalsiteProp.getProperty("Edit_Number_of_Students"))==true)
				{
					Reports.log(Status.PASS, "Slot is Edited successfully.");
				
				}else
				{
					Reports.log(Status.FAIL, "Slot is not added properly.");
				}
			
			}else
			{
				Reports.log(Status.FAIL, "Edit Slot Details popup doesn't opened.");
			}

		}else
		{
			Reports.log(Status.SKIP, "There is no slot added");
		}
		
	
		
		
		
		
  }
	
	
	public void VerifyDeleteSlot() throws InterruptedException {
		
		
		if(!Controls.GetText(By.xpath(clinicalsiteProp.getProperty("title.xpath"))).trim().equalsIgnoreCase("Slots"))
		{
			CS.searchsitepageNav();
			CS.sitedetailNav();
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("slots.xpath")));
			Controls.wait(2000);
		}
		
		
		
		if(	Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")))==true)
		{
			Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath")));
			
			if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Add/edit_slotpopup.xpath"))))
			{
				if(Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_DeleteSlot.xpath")))==true)
				{
					
					Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_DeleteSlot.xpath")));
					Controls.wait(10000);
					
					
					if(!Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_AddedSlot.xpath"))))
					{
						Reports.log(Status.PASS, "Slot is deleted successfully");
					
					}else
					{
						Reports.log(Status.FAIL, "Slot is not deleted properly");
					}
					
				}else
				{
					Reports.log(Status.FAIL, "'Delete' button is missing");
				}
				
				
				
				
			}else
			{
				Reports.log(Status.FAIL, "Edit Slot Details popup doesn't opened.");
			}
			
		}else
		{
			Reports.log(Status.SKIP, "There is no slot added");
		}
	
		
		
		
		
		
	}
	
}
