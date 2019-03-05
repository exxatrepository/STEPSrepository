package automation.SchoolAdmin.AllDomain.ManageLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import automation.BaseMethods.Controls;
import automation.ExcelReader.ReadExcel;
import automation.ExtentReport.Reports;




public class Login extends Controls {
//public static Properties property=null;

	
	ReadExcel rdexl=new ReadExcel();
	
	
	public void Verifyschooladminlogin() throws InterruptedException, IOException{
	

		startUP();
		SignIN(loginProp.getProperty("AdminUsername"),loginProp.getProperty("Password"));
	
		
		if(loginProp.getProperty("IsExxatuser").equalsIgnoreCase("y") && Controls.GetText(By.className(loginProp.getProperty("exxatadmintitle.class"))).trim().equalsIgnoreCase("Launch"))
		{
			Reports.log(Status.PASS, "Page is redirected on Exxat Admin Dashboard page successfully");
			GoToClient();
			
		}else if(loginProp.getProperty("IsExxatuser").equalsIgnoreCase("n") && 
				true==Controls.isElementPresent(By.xpath(loginProp.getProperty("SideMenus"))) &&
				true==Controls.isElementPresent(By.xpath(loginProp.getProperty("title.xpath"))) &&
				true==Controls.isElementPresent(By.xpath(loginProp.getProperty("Menu_student.xpath"))))
				
		{
			String loggedinClient=Controls.GetText(By.xpath(loginProp.getProperty("loggedInclient.xpath")));
			Reports.log(Status.PASS, "Page is redirected on School Admin Dashboard page successfully."+" <b>Client Name: </b>"+loggedinClient);
		}
		else
		{
			String loggedinClient=Controls.GetText(By.xpath(loginProp.getProperty("loggedInclient.xpath")));
			Reports.log(Status.FAIL, "Page is redirected on incorrect page."+" <b>Client Name: </b>"+loggedinClient);
		}
		
	}
		
		
		
		
		
		
	public void GoToClient()
	{
		
		//Go to School Admin Dashboard page
		String excelfilename=ConfigProp.getProperty("excelfilename");
		
		ClientloggedIn:
		for(int i=1;i<100;i++)
		{
			String needrun=rdexl.GetXLSData(excelfilename,"Sheet1", i, 3);
			String Clientbysheet=rdexl.GetXLSData(excelfilename,"Sheet1", i, 1);
			String Domain=rdexl.GetXLSData(excelfilename,"Sheet1", i, 0);
			if(Domain=="" || Clientbysheet=="")break;
			
			
			if(Domain.equalsIgnoreCase("PT") && needrun.equalsIgnoreCase("Y"))
			{
					Controls.Click(By.xpath("//*[@id=\"switchform\"]/div[1]/div/div[1]"));
					
					for(int j=1;j<100;j++) 
					{
						String Clientname=Controls.GetText(By.xpath("//*[@id=\"switchform\"]/div[1]/div/div[2]/div/table/tbody/tr["+j+"]/td[2]/a"));
						
						if(Clientbysheet.equalsIgnoreCase(Clientname))
						{
							Controls.Click(By.xpath("//*[@id=\"switchform\"]/div[1]/div/div[2]/div/table/tbody/tr["+j+"]/td[2]/a"));
							
							Controls.dynemicwait(By.id("video"));
							
							String loggedinClient=Controls.GetText(By.xpath(loginProp.getProperty("loggedInclient.xpath")));
							
							if(true==Controls.isElementPresent(By.xpath(loginProp.getProperty("SideMenus"))) &&
									true==Controls.isElementPresent(By.xpath(loginProp.getProperty("title.xpath"))) &&
									true==Controls.isElementPresent(By.xpath(loginProp.getProperty("Menu_student.xpath"))))
									
							{
								Reports.log(Status.PASS, "Page is redirected on School Admin Dashboard page successfully."+" <b>Client Name: </b>"+loggedinClient);
							}
							else
							{
								Reports.log(Status.FAIL, "Page is redirected on incorrect page");
							}
							
							break ClientloggedIn;
						}	
						
						
					}
							
				}else if(Domain.equalsIgnoreCase("PA")  && needrun.equalsIgnoreCase("Y"))
				{
					Controls.Click(By.xpath("//*[@id=\"switchform\"]/div[2]/div/div[1]"));
					
				
				}else if(Domain.equalsIgnoreCase("OT") && needrun.equalsIgnoreCase("Y"))
				{
					
					Controls.Click(By.xpath("//*[@id=\"switchform\"]/div[4]/div/div[1]"));
				
				}else if(Domain.equalsIgnoreCase("Nurshing") && needrun.equalsIgnoreCase("Y"))
				{
				
					Controls.Click(By.xpath("//*[@id=\"switchform\"]/div[8]/div/div[1]"));
				
				}
				
			
		
		
		}
		
	}
	
	
	
	
	
	
	

}
