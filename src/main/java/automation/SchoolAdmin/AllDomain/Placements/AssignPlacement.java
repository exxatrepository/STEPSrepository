package automation.SchoolAdmin.AllDomain.Placements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.lang.String;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExtentReport.Reports;
import automation.SchoolAdmin.AllDomain.ManageLogin.Login;

public class AssignPlacement extends Controls 
{
	
	String Session_Name="PTHP 8191: Class of 2020";
	
	int numberofslot=0;
	
	
	public void Assignplacement()  throws IOException, InterruptedException	
	{
		
		GotoPlacemnent_BySession();
		Search_Session();	
		GoTo_AssignPlacement();
		Pick_Student();
		UnPlace_Student();
		Edit_Placement();	
		Edit_Slot();
	}
	
	//Navigation on "By Session" Page 
	public void GotoPlacemnent_BySession()  throws IOException, InterruptedException	
	{
		
	
		Controls.hoverclick(By.linkText("Placements"), By.linkText("By Session"));
		Controls.dynemicwait(By.xpath("//*[@id=\"xform\"]/div/div[1]/div[3]/div/div[3]/div/div"));
						
		if(Controls.VerifyPageTitle("By Session")==true)
		{
				Reports.log(Status.PASS, "Page is redirected on By Session page successfully");
		}
		else
		{
				Reports.log(Status.FAIL, "Page is redirected on incorrect page");
							
		}	
						
						
	
	}
	
	//Search Session & Navigation On Placement Details Page
	public void Search_Session() throws InterruptedException
	{
		
		if (Controls.isElementPresent(By.id(placementProp.getProperty("SessionLabel.id")))==true)
				
			{
				Controls.Type(By.id(placementProp.getProperty("SessionLabel.id")),Session_Name);
				
			}
			else
			{
				Reports.log(Status.FAIL, "Element doesn't found");
			}
			
			Controls.wait(2000);
			if(Controls.isElementPresent(By.xpath(placementProp.getProperty("Search_Button.Xpath")))==true)
			{
				Controls.Click(By.xpath(placementProp.getProperty("Search_Button.Xpath")));
				
			}
			else
			{
				Reports.log(Status.FAIL, "Search button doesn't found");
			}
			
			Controls.wait(3000);
			
			
	}
	
	//Navigation on "Assign Placement" Page
	public void GoTo_AssignPlacement() throws InterruptedException
	{
		
		String Searched_sessionname=Controls.GetText(By.xpath(placementProp.getProperty("Session_SearchResult.Xpath"))).trim();
		
		if(Searched_sessionname.equals(Session_Name)==true)
		{	
		
		    	if (Controls.isElementPresent(By.xpath(placementProp.getProperty("PlacementArrow.Xpath")))==true)
		    	{
		    		Controls.Click(By.xpath(placementProp.getProperty("PlacementArrow.Xpath")));
		    	}
			
		    	else
		    	{
		    		Reports.log(Status.FAIL, "Placement arrow button doesn't found");
		    	}
			
			
		    	if (Controls.isElementPresent(By.xpath(placementProp.getProperty("AssignPlacement_HL.Xpath")))==true)
		    	{
		    		Controls.Click(By.xpath(placementProp.getProperty("AssignPlacement_HL.Xpath")));
		    		
		    	}
			
		    	else
		    	{
		    		Reports.log(Status.FAIL,"Assign placement option not found");
		    	}
			
		    	if(Controls.isElementPresent(By.xpath(placementProp.getProperty(("AssignPlacementPage_Title.Xpath"))))==true)
		    	{
		    		Controls.dynemicwait(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]"));
		    	}
		    	else
		    	{
					Reports.log(Status.FAIL, "Page is redirected on incorrect page");						
		    	}	
			
		    	
		
		}
		
		else
		{
			Reports.log(Status.FAIL, "Searched text mis-matched or doesn't found");
		}

		
		
		Controls.wait(3000);
		
	}
	
  //Pick Student for the placement
  public void Pick_Student() throws InterruptedException
  {
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]"));
		List<WebElement> Available_Slots=element.findElements(By.tagName("a"));
		numberofslot=Available_Slots.size();
	
		
		ArrayList<String> Students = new ArrayList<java.lang.String>();
		ArrayList<String> Placed_Students = new ArrayList<java.lang.String>();
		
			
    				if(Controls.isElementPresent(By.xpath(placementProp.getProperty("Placement_Actions.Xpath")))==true)
    				{
    						
    						Controls.Click(By.xpath(placementProp.getProperty("Placement_Actions.Xpath")));
    						Controls.wait(5000);
    						Controls.dynemicwait(By.xpath(placementProp.getProperty("Student_List.Xpath")));
    						
    						
		
    						if(Controls.isElementPresent(By.xpath("1stStudent_checkbox.Xpath"))==false)
    						{
    							
    							
	    						for(int i=1;i<=numberofslot;i++)
	    			    		{
	    						
		    						if(Controls.isElementPresent(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr["+i+"]/td[1]/div/span/input"))==true)
		    						{
		    							
		    							Controls.Click(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr["+i+"]/td[1]/div/span/input"));
		    							
		    							//Storing Students into the array
		    							Students.add(Controls.GetText(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr["+i+"]/td[2]")).trim());
		    							Controls.wait(2000);
		    										
		    						}
		    						
		    					}
	    						
	    						//Save Placement for the selected students
	    						Controls.isElementPresent(By.id(placementProp.getProperty("SavePlacement_Button.id")));
	    						Controls.Click(By.id(placementProp.getProperty("SavePlacement_Button.id")));
	    						
	    						//Verification of placed students
	    						if (Controls.isElementPresent(By.xpath(placementProp.getProperty("Placement_Actions_Table.Xpath")))==true)
	    						{
	    							
	    								for (int i=1;i<=numberofslot;i++)
	    								{
	    									int a=0;
	    									
	    									String placedstudentname=Controls.GetText(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]/button["+i+"]/small"));
	    									String[] StArr=placedstudentname.split(" ", 2);
	    									
	    									Placed_Students.add(StArr[a+1]);
	    									
	    								}
	    								
	    								//Verification of student placement
	    								
	    								Collections.sort(Students);
	    					            Collections.sort(Placed_Students);
	    					           
	    					            if(Students.equals(Placed_Students)==true)
	    					            {
	    					                Reports.log(Status.PASS, "Students placed successfully");
	    					            }
	    					            else
	    					            {
	    					                Reports.log(Status.FAIL, "Students not placed ");
	    					            }
	    								
	    				    	}
	    				    	else
	    				    	{
	    							Reports.log(Status.FAIL, "Page doesn't redirected on Assign Placement page");						
	    				    	}	
	    						
	    						
	    					}
    						else
    	    	    		{
    	    	    			Reports.log(Status.SKIP, "Student is not available so can't be placed");
    	    					driver.navigate().back();
    	    	    		}
    			}
    						
    			else
    			{
    				Reports.log(Status.FAIL,"Placement slot doesn't found");
    			}
    			
    			Controls.wait(2000);
    			
    		
    		
   }

	//Unplaced Student
	public void UnPlace_Student() throws InterruptedException
	{
		String Unplaced_StudentName="";
		Controls.dynemicwait(By.xpath(placementProp.getProperty("EditPlacement_Button.Xpath")));
		
		if (Controls.isElementPresent(By.xpath(placementProp.getProperty("Placement_Actions_Table.Xpath")))==true)
		{
			Controls.Click(By.xpath(placementProp.getProperty("EditPlacement_Button.Xpath")));
			
			if(Controls.isElementPresent(By.id(placementProp.getProperty("Unplace_Student_Button.id")))==true)
			{
				Controls.wait(3000);
				Controls.Click(By.id(placementProp.getProperty("Unplace_Student_Button.id")));
				
				Controls.dynemicwait(By.xpath(placementProp.getProperty("UnPlace-PopUp.Xpath")));
				if(Controls.isElementPresent(By.xpath(placementProp.getProperty("UnPlace-PopUp.Xpath")))==true)
				{
					
						if(Controls.isElementPresent(By.xpath(placementProp.getProperty("UnPlace_Cancel_Button.Xpath")))==true)
						{
							Controls.Click(By.xpath(placementProp.getProperty("UnPlace_Cancel_Button.Xpath")));
							Reports.log(Status.PASS, "User redirected on Edit Placement screen & Placed student remains as it is");
						}
						
						Controls.wait(3000);
						Controls.Click(By.id(placementProp.getProperty("Unplace_Student_Button.id")));
						Controls.dynemicwait(By.xpath(placementProp.getProperty("UnPlace-PopUp.Xpath")));
						
						if(Controls.isElementPresent(By.xpath(placementProp.getProperty("UnPlace_OK_Button.Xpath")))==true)
						{
							Unplaced_StudentName = Controls.GetValue(By.id(placementProp.getProperty("StudentName.id"))).trim();
							//Unplaced_StudentName = "Mouse Mickey";
							Controls.Click(By.xpath(placementProp.getProperty("UnPlace_OK_Button.Xpath")));
							Controls.wait(3000);
							
						}
						
				}
			}
			
			
			//Verification of unplaced student
			ArrayList<String> Placed_Students_AfterUnplaced = new ArrayList<java.lang.String>();
			for (int i=1;i<=numberofslot;i++)
			{
					int a=0;
					
					if(Controls.isElementPresent(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]/button["+i+"]/small"))==true)
					{
						String placedstudentname=Controls.GetText(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[5]/button["+i+"]/small"));
						String[] StArr=placedstudentname.split(" ", 2);
						Placed_Students_AfterUnplaced.add(StArr[a+1]);
					}
					
			}
			
			
			for(int i=0;i<Placed_Students_AfterUnplaced.size();i++)
			{
					if (Unplaced_StudentName.equalsIgnoreCase(Placed_Students_AfterUnplaced.get(i)))
					{
						Reports.log(Status.FAIL, "Student is not unplaced properly");
						break;
						
					}else
					{
						if(i==Placed_Students_AfterUnplaced.size())Reports.log(Status.PASS, "Student is unplaced successfully");
					}
			}

			
		}
		
		
	}
	
	//Edit Placement
	public void Edit_Placement() throws InterruptedException
	{
		
		Controls.wait(10000);
		if (Controls.isElementPresent(By.xpath(placementProp.getProperty("Placement_Actions_Table.Xpath")))==true)
		{
			Controls.Click(By.xpath(placementProp.getProperty("EditPlacement_Button.Xpath")));
			
			if(Controls.isElementPresent(By.xpath(placementProp.getProperty("EditPlacement_Screen.Xpath")))==true)
			{
				//Changing value from "Actual Setting" Drop-down
				Controls.SelectDropdonwByValue(By.id(placementProp.getProperty("ActualSetting_DD.id")),placementProp.getProperty("ActualSetting"));
				
				//Changing "Actual Start Date"
				Controls.Type(By.id(placementProp.getProperty("ActualStart_Date.id")),placementProp.getProperty("ActualStart_Date"));
				
				//Changing "Actual End Date"
				Controls.Click(By.xpath(placementProp.getProperty("ActualEndDate_Label.Xpath")));
				Controls.Type(By.id(placementProp.getProperty("ActualEndDate.id")),placementProp.getProperty("ActualEndDate"));
				Controls.wait(3000);
				
				//Changing Value from "Contact Person at Site" Drop-down
				Controls.Click(By.xpath(placementProp.getProperty("ContactPerson_Label.Xpath")));
				//Controls.SelectDropdonwByValue_btnUI(By.xpath(placementProp.getProperty("ContactPerson_Site.Xpath")),placementProp.getProperty("ContactPerson_Site"));
				
				Controls.Type(By.id(placementProp.getProperty("Placement_Notes.id")),placementProp.getProperty("Placement_Notes"));
				
				Controls.Click(By.xpath(placementProp.getProperty("FOR_DropDown.Xpath")));
				Controls.SelectDropdonwByValue_btnUI(By.xpath(placementProp.getProperty("FOR.Xpath")),placementProp.getProperty("FOR"));
				
				Controls.Click(By.xpath(placementProp.getProperty("SchoolNotes_Label.Xpath")));
				Controls.Type(By.id(placementProp.getProperty("SchoolNotes.id")),placementProp.getProperty("SchoolNotes"));
				
				Controls.Click(By.id(placementProp.getProperty("Save&Close.id")));
				
				Controls.wait(4000);
				
				System.out.println(Controls.GetValue(By.id(placementProp.getProperty("ActualSetting_DD.id"))));
				
				
				if(Controls.GetValue(By.id(placementProp.getProperty("ActualSetting_DD.id"))).equalsIgnoreCase(placementProp.getProperty("ActualSetting"))==true &&
						Controls.GetValue(By.id(placementProp.getProperty("ActualStart_Date.id"))).equalsIgnoreCase(placementProp.getProperty("ActualStart_Date"))==true &&
						Controls.GetValue(By.id(placementProp.getProperty("ActualEndDate.id"))).equalsIgnoreCase(placementProp.getProperty("ActualEndDate"))==true &&
						Controls.GetValue(By.id(placementProp.getProperty("Placement_Notes.id"))).equalsIgnoreCase(placementProp.getProperty("Placement_Notes"))==true &&
						Controls.GetValue(By.xpath(placementProp.getProperty("FOR.Xpath"))).equalsIgnoreCase(placementProp.getProperty("FOR"))==true &&
						Controls.GetValue(By.id(placementProp.getProperty("SchoolNotes.id"))).equalsIgnoreCase(placementProp.getProperty("SchoolNotes"))==true) 
				{
					Reports.log(Status.PASS, "All the details have been edited successfully");
					
				}
				
				else
				{
					Reports.log(Status.FAIL, "Edited details don't match");
				}
				
			
			}
		}
	}
	
	
	//Edit Slot
	public void Edit_Slot() throws InterruptedException
	{
		
		
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
				
				
				if(clinicalsiteProp.getProperty("Edit_Interview_Required").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired_SwitchOff.xpath")))==true)
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_InterviewRequired.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Do_students_need_to_upload_resume?").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?_SwitchOff.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Dostudentsneedtouploadresume?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Offered_on_FCFS_basis?").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?_SwitchOff.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_OfferedonFCFSbasis?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Must_be_filled?").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?_SwitchOff.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Mustbefilled?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Offered_through_consortium?").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?_SwitchOff.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Offeredthroughconsortium?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Has_been_requested_by_student?").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?_SwitchOff.xpath")))==true )
				Controls.Click(By.xpath(clinicalsiteProp.getProperty("Slot_Hasbeenrequestedbystudent?.xpath")));
				
				if(clinicalsiteProp.getProperty("Edit_Active").equalsIgnoreCase("Y") && Controls.isElementPresent(By.xpath(clinicalsiteProp.getProperty("Slot_Active_SwitchOff.xpath")))==true )
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
	
	private java.lang.String String(String getText) {
		// TODO Auto-generated method stub
		return null;
	}
}