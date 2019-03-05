package automation.BaseMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Controls  {
	public static WebDriver driver;
	//public static Properties property=new Properties();
	public static String Result;
	static ArrayList<String> resultlist=new ArrayList<String>();
	public static Logger logger ;
	public static String PastURL;
	public static String CurrentURL;
	public static long start;
	public static long finish;
	public static long loadTime;
	
	public static Properties ConfigProp = new Properties();
	public static Properties loginProp = new Properties();
	public static Properties clinicalsiteProp = new Properties();
	public static Properties placementProp = new Properties();
	
	public static FileInputStream fConfig, floginpage, fclinicalsite,fplacement;
	
	
	
	public static void setpropertyfile() {

		if (driver == null) {

				try {
					
					fConfig = new FileInputStream(System.getProperty("user.dir") + "//resources//PropertyFiles//config.properties");
					ConfigProp.load(fConfig);
					floginpage = new FileInputStream(System.getProperty("user.dir") + "//resources//PropertyFiles//LoginPage.properties");
					loginProp.load(floginpage);
					fclinicalsite = new FileInputStream(System.getProperty("user.dir") + "//resources//PropertyFiles//clinicalsite.properties");
					clinicalsiteProp.load(fclinicalsite);
					fplacement = new FileInputStream(System.getProperty("user.dir") + "//resources//PropertyFiles//placement.properties");
					placementProp.load(fplacement);
					
					} catch (Exception e) {
	
						e.printStackTrace();
					}

		}

	}
	
	
	//Browser startup
	public static void startUP() throws IOException
	{
		
		
		logger= Logger.getLogger("devpinoyLogger");
//		fConfig = new FileInputStream(System.getProperty("user.dir") + "\\resources\\PropertyFiles\\config.properties");
//		ConfigProp.load(fConfig);
		setpropertyfile();
		
		if(ConfigProp.getProperty("Browser").equalsIgnoreCase("Firefox"))
		{
			
			System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"\\resources\\drivers\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		if(ConfigProp.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		if(ConfigProp.getProperty("Browser").equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\resources\\drivers\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigProp.getProperty("URL"));
		//Reporter.log("URL open successfully");
		
		
	}
	
	
	// signIN
	public static void SignIN(String username,String password) throws InterruptedException
	{
		
		
		Type(By.id("Username"),username);
		Controls.wait(2000);
		Type(By.id("Password"),password);
		Click(By.id("btnLogin"));
		Controls.wait(5000);
			
			
	}
	//singOUT
	public static void SignOUT()
	{
		//driver.findElement(By.id("ctl00_headerdetail_dash_top1_QuickLink1_btnLogOut")).click();
		driver.quit();
		
	}
	
	
	//element is present or not
	public static boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
			
			
		}
		catch(NoSuchElementException e)
		{
			return false;
		
		}
	}
	//isalert present
	public static boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException ex)
		{
			return false;
		}
	}
	
	//textbox enable
	public static boolean isDropdownEnable(By by)
	{
	WebElement element=driver.findElement(by);
	return element.isEnabled();
	}
	//dropdown enable
	public static boolean isTextboxEnable(By by)
	{
	WebElement element=driver.findElement(by);
	return element.isEnabled();
	}

	//Handle Alert
	public static void HandleAlertbox()
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	//wait
	public static void wait(int x) throws InterruptedException
	{
		//driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS);
		Thread.sleep(x);
	}
	
	public static void dynemicwait(By by)
	{
		WebDriverWait wait=new WebDriverWait(driver,100);
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
	}
	
	
	//text to verify
	public static boolean VerifyText(By by,String TextTOVerify)
	{
		WebElement element=driver.findElement(by);
		if(element.getText().equalsIgnoreCase(TextTOVerify))
		return true;
		else
		return false;
	}
	
	
	//partial text to verify
	public static boolean VerifyPartialText(By by,String PartialTextTOVerify)
	{
		WebElement element=driver.findElement(by);
		if(element.getText().contains(PartialTextTOVerify))
		return true;
		else
		return false;
	}
	
	//verify URL
	public static boolean VerifyURL(String URLTOVerify)
	{
		if(driver.getCurrentUrl().equals(URLTOVerify))
			return true;
		else
			return false;
	}
	
	//Verify page Title
	public static boolean VerifyPageTitle(String TextToVerify)
	{
		if(driver.getTitle().trim().equals(TextToVerify.trim()))
			return true;
		else
			return false;
	}
	
	//handle scrollbar
	public static void HandleScroll()
	{
		//WebElement scroll=driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,-250)", "");
	}
	public static void HandleScrollup()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("window.scrollBy(0,250)", "");
	}
	//handle horizontalscrollbar
	public static void HandleScrollH(By by)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element=driver.findElement(by);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	//DIV handlig
	public static int GetDIV(By by)
	{
	
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("div"));
		return options.size();
	}
	
	
	//Number of options in dropdown
	public static List<WebElement> GetDropDownOptions(By by)
	{
	
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("option"));
		return options;
	}
	
	//Is dropdown option selected
	public static boolean IsOptionSelected(By by, String TextToVerify)
	{
		boolean IsAvailable=false;
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("option"));
		for(WebElement option : options)
		
		{
			if(option.getText().toLowerCase().equals(TextToVerify.toLowerCase()))
			{
				IsAvailable=option.isSelected();
				break;
			}
			else
			{
				if(option.getText().toLowerCase().startsWith(TextToVerify.toLowerCase()))
				{
					IsAvailable=option.isSelected();
					break;
				}
				else
				{
					IsAvailable=false;
				}
			}
			
		}
		return IsAvailable;
	}
	
	
	
	//Number of values in dropdown
	public static int GetnumberofOptionDropdown(By by)
	{
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("option"));
		return options.size();
		
		
	}
	
	//select dropdown by index
	public static void SelectDropdownByIndex(By by, int index)
	{
		WebElement element=driver.findElement(by);
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	//select dropdown by value
	public static void SelectDropdonwByValue(By by,String value) throws InterruptedException
	{
		WebElement element=driver.findElement(by);
		//Select sel=new Select(element);
		//sel.selectByValue(value);
		List<WebElement> options=element.findElements(By.tagName("option"));
		Controls.wait(2000);
		for(int i=0;i<options.size();i++)
		{
			String text=options.get(i).getText();
			if(text.equalsIgnoreCase(value))
			{
				options.get(i).click();
				Controls.wait(2000);
				break;
			}
		}
		
	}
	
	
	public static void SelectDropdonwByValue_btnUI(By by,String value) throws InterruptedException
	{
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("li"));
		Controls.wait(2000);
		
		for(int i=0;i<options.size();i++)
		{
			String text=options.get(i).getText();
			if(text.equalsIgnoreCase(value))
			{
				options.get(i).click();
				Controls.wait(2000);
				break;
			}
		}
		
	}
	
	
	public static void SelectDropdownByMultiValue(By by) throws InterruptedException
	{
		WebElement element=driver.findElement(by);
		List<WebElement> options=element.findElements(By.tagName("option"));
		Controls.wait(2000);
		//options.get(1).click();
		//Controls.wait(2000);
		//options.get(2).click();
		for(int i=0;i<options.size();i++)
		{
			options.get(i).click();
		}
		
	}
	
	//datepicker
	public static void SelectDateFromDatepicker(By by) throws InterruptedException
	{
		WebElement Date=driver.findElement(by);
		List<WebElement> col=Date.findElements(By.tagName("td"));
		driver.findElement(by).click();
		for(int i=0;i<col.size();i++)
		{
			System.out.println("in loop");
			if(col.get(i).isSelected())
			{
				System.out.println("in if");
				col.get(i).click();
				Controls.wait(2000);
				break;
			}
		}
	}
	//select date
	public static void selectDate(By by) throws InterruptedException
	{
	
		WebElement element=driver.findElement(by);
		List<WebElement> row=element.findElements(By.tagName("td"));
		for(WebElement cell:row)
		{
			if(cell.getText().equals("21"))
			{
				cell.click();
				cell.click();
				break;
			}
		}
		
		
	}
	
	//javascript enable textbox in datepicker
	public static void ExecuteScript(String Script)
    {
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript(Script);
		//js.executeScript("document.getElementById('id').removeAttribute('readonly');");
    }
	public static void EnableTextbox(String ID)
	{
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(ID).removeAttribute('readonly');");
	}
	//type and hit enter
	public static void TypeAndHitEnter(By by,String TextTOInput)
	{
		WebElement element=driver.findElement(by);
		//element.clear();
		element.sendKeys(TextTOInput);
		element.sendKeys(Keys.ENTER);
	}
	
	//click link,text,button 
	
	public static void Click(By by)
	{
		WebElement element=driver.findElement(by);
		element.click();	
	}
	
	//Enter text in textbox
	public static void Type(By by,String TextToInput)
	{
		WebElement element=driver.findElement(by);
		element.clear();
		element.sendKeys(TextToInput);
	}
	
		
	
	//return value
	public static String GetValue(By by)
	{
		WebElement element=driver.findElement(by);
		return element.getAttribute("Value");
	}
	
	//return text
	public static String GetText(By by)
	{
		WebElement element=driver.findElement(by);
		return element.getText();
	}
	
	
	//Radio button
	public static boolean IsRadioSelected(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isSelected();
	}
	
	public static void SelectRadioOption(By by)
	{
		WebElement element=driver.findElement(by);
		if(!element.isSelected())
		{
			element.click();
		}
	}
	
	public static void SelectcheckboxOption(By by)
	{
		WebElement element=driver.findElement(by);
		if(!element.isSelected())
		{
			element.click();
		}
	}
	
	public static boolean IsRadioEnabled(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isEnabled();
	}
	
	public static boolean IsCheckboxEnabled(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isEnabled();
	}
	
	public static boolean IslinkEnabled(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isEnabled();
	}
	
	public static boolean IsDisplayed(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isDisplayed();
	}
	
	public static boolean IslistitemEnabled(By by)
	{
		WebElement element=driver.findElement(by);
		return element.isEnabled();
	}
	
		
	//Take screen shot
	 public static void captureScreenShot(WebDriver driver)
	 {
		 
		  // Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
		  // now copy the  screenshot to desired location using copyFile method
		 
		 FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\Screenshots\\"+System.currentTimeMillis()+".png"));
		}
		 
		catch (IOException e)
		 
		{
		 
		System.out.println(e.getMessage());
		 
		}
		 
	}
	 
	 
	 //get url
	 public static String GetURL()
	 {
		 return driver.getCurrentUrl();
	 }
		 
	 
	 //frame handling
	 
	 public static void SelectFrameFromDefaultContent(By by)
	 {
		 WebElement element=driver.findElement(by);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame(element);
	 }
	 public static void SelectBackToDefaultContent()
	 {
		 driver.switchTo().defaultContent();
	 }
	 
	 
	 
	//SQL data
	public static String GetSQLData(String columnname,String Query) throws ClassNotFoundException, SQLException
	{
		String DBURL=ConfigProp.getProperty("MYSQLDBURL");
		String username=ConfigProp.getProperty("DBUsername");
		String password=ConfigProp.getProperty("DBPassword");
		String query =Query;
		Connection con;
		
		try
		{
			
	
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		con=DriverManager.getConnection(DBURL,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		 Result=rs.getString(columnname);
		// Reporter.log(Result);
		 //ArrayList<String> resultlist=new ArrayList<String>();
		 //resultlist.add(Result);
		 System.out.println(Result);
		
		}
		
				
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		return Result;
		//return resultlist;
		
	}
	public static String ExecuteSQLData(String Query) throws ClassNotFoundException, SQLException
	{
		String DBURL=ConfigProp.getProperty("MYSQLDBURL");
		String username=ConfigProp.getProperty("DBUsername");
		String password=ConfigProp.getProperty("DBPassword");
		String query =Query;
		Connection con;
		
		try
		{
			
	
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		con=DriverManager.getConnection(DBURL,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		return Result;
		//return resultlist;
		
	}
	public static String[] GetMSSQLData(String Query) throws ClassNotFoundException, SQLException
	{
		
		//String DBURL=ConfigProp.getProperty("MSSQLDBURL");
		//String username=ConfigProp.getProperty("DBUsername");
		//String password=ConfigProp.getProperty("DBPassword");
		//String DBName=ConfigProp.getProperty("databasename");
		//String ConnURL="jdbc:sqlserver://"+ConfigProp.getProperty("MSSQLDBURL")+"; databasename="+ConfigProp.getProperty("databasename")+";";
		

	
		String ConnURL="jdbc:sqlserver:XXXX;port=XXXX;databasename=XXXX;";

		String query =Query;
		Statement stmt = null;
		ResultSet rs = null;
		String[] QueryResults=new String[] {};
		Connection con = null;
		String row = "";
		
		try
		{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		con=DriverManager.getConnection(ConnURL,"XXXX","XXXX");
		
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		
		ResultSetMetaData metadata = rs.getMetaData();
	    int columnCount = metadata.getColumnCount();    
	    
	    	while (rs.next()) 
	    	{
	        	
	        	for	 (int i = 1; i <= columnCount; i++) 
	        	{
	            	row += rs.getString(i) + ", ";          
	        	}
     		}
	    				
		}
		
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
		}
		finally 
		{
			rs.close();
			con.close();
			stmt.close();
			
		}
		
		return QueryResults= row.split(",");
		
	}
	
	
	//XSL data
	public static String GetXLSData(String sheet, int row,int col) 
	{
		 try

         {

            
			 FileInputStream fis = new FileInputStream(ConfigProp.getProperty("DataFile"));
             Workbook wb = WorkbookFactory.create(fis);

             Cell cell = wb.getSheet(sheet).getRow(row).getCell(col);
             
             //new DataFormatter().formatCellValue(cell);
             return cell.getStringCellValue().toString();
       
             
         }

         catch (Exception e)

         {

             return "";

         }

    }
		
	public static void SetXLSData(int row,int col,String Value) throws IOException 
	{
		XSSFWorkbook workbookobj = new XSSFWorkbook();
		XSSFSheet Spreadsheet= workbookobj.createSheet("First_Sheet");
		XSSFRow row1;
		int rowid = row;
		int cellid = col;
		row1 = Spreadsheet.createRow(rowid);
	    Cell cell = row1.createCell(cellid);
	    cell.setCellValue(Value);
	        
	 
	    FileOutputStream fstreamobject = new FileOutputStream("EAFormReport.xlsx");
		workbookobj.write(fstreamobject);
		//fstreamobject.close();
		
    }

	
	
	public static double GetXLSDataNumeric(String sheet, int row,int col) 
	{
		 try

         {

             
			 FileInputStream fis = new FileInputStream(ConfigProp.getProperty("DataFile"));
             Workbook wb = WorkbookFactory.create(fis);

             Cell cell = wb.getSheet(sheet).getRow(row).getCell(col);

             return cell.getNumericCellValue();
       
             
         }

         catch (Exception e)

         {      
        	 return col;
         }
		

    }
		
	
	
	//Get table data that doesn't having <th> tag in the table
	
		public static String[][] GetGridDataWithoutTHTag(By by)
		{
			WebElement element=driver.findElement(by);
			List<WebElement> Rowelement=element.findElements(By.tagName("tr"));
			List<WebElement> Colelement=element.findElements(By.tagName("td"));
			
			int Rowcount=Rowelement.size();
			int Colcount=(Colelement.size()/Rowelement.size());
			
			System.out.println(Rowcount);
			System.out.println(Colcount);
			
			String[][] GridData=new String[Rowcount][Colcount];
			for(int i=0;i<Rowcount;i++)
			{
				List<WebElement> iRow=Rowelement.get(i).findElements(By.tagName("td"));
				for(int j=0;j<Colcount;j++)
				{
					GridData[i][j]=iRow.get(j).getText();
				}
			}
			return GridData;
		}
		
		
	//Get Table data that have <th> tag in the table
		public static String[][] GetGridData(By by)
		{
			WebElement element=driver.findElement(by);
			List<WebElement> Headerelement=element.findElements(By.tagName("th"));
			List<WebElement> Rowelement=element.findElements(By.tagName("tr"));
			String[][] GridData=new String[Headerelement.size()][Rowelement.size()];
			
			for(int i=0;i<Rowelement.size();i++)
			{
				if(i==0)
				{
				List<WebElement> Header=Rowelement.get(i).findElements(By.tagName("th"));
					for(int k=0;k<Header.size();k++)
					{
					GridData[i][k]=Header.get(k).getText();
					}
				}
				else
				{
					List<WebElement> Cols=Rowelement.get(i).findElements(By.tagName("td"));
					for(int j=0;j<Cols.size();j++)
					{
					GridData[i][j]=Cols.get(j).getText();
					}
				}
			}
			return GridData;
		}
		
		
		
		//wait for element not present
		public static void WaitForElementNotPresent(By by) throws InterruptedException
		{
			int timeout=60;
			
			for(int second=0; ;second++)
			{
				Thread.sleep(1000);
				
				if(second>=timeout)Assert.fail("Timeout: Element still visible at:" +by);
				try
				{
					WebElement element=driver.findElement(by);
				}
				catch(Throwable t)
				{
					break;
				}
			}
		}
		
		
		
		//getfirst few characters
		public static String GetUrl_FirstFewcharacters(int firstfewcharacters) throws InterruptedException
		{
			driver.wait(200);
			String Driverurl=driver.getCurrentUrl();
			String modifiedURL=Driverurl.substring(0,firstfewcharacters);
			return modifiedURL;
		}
	
		
		//uploadfile
		public static void Uploadfile(By by, String file)
		{
			WebElement element=driver.findElement(by);
			element.sendKeys(file);
		}
		
		//Getselected text
		public static String GetSelectedText(By by)
		{
			String Text=null;
			WebElement element=driver.findElement(by);
			List<WebElement> options=element.findElements(By.tagName("option"));
			for(WebElement option : options)
			{
				if(option.isSelected())
				{
					Text=option.getText();
					break;
				}
			}
			return Text;
		}
		
		
		//Delete statement
		
		
		public static boolean DeleteData(String query)
		{
			String DBURL=ConfigProp.getProperty("MYSQLDBURL");
			String username=ConfigProp.getProperty("DBUsername");
			String password=ConfigProp.getProperty("DBPassword");
			String query1 =query;
			Connection con;
			boolean b_status=true;
			
			try
			{
				
		
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			con=DriverManager.getConnection(DBURL,username,password);
			Statement stmt=con.createStatement();
			stmt.executeQuery(query1);
			
					
			}
			catch(Throwable t)
			{
				System.out.println(t.getMessage());
				b_status=false;
			}
			return b_status;
			
			
		}
		
		
		//Select by text
		public static void SelectDropDownByOption(By by, String Text)
		{
			WebElement element=driver.findElement(by);
			Select sel=new Select(element);
			sel.selectByValue(Text);
		}
		
		
		//click option of dropdown by passing value
		
		public static void SelectOption(By by,String Value)
		{
			boolean IsAvail=false;
			WebElement element=driver.findElement(by);
			List<WebElement> options=element.findElements(By.tagName("option"));
			for(WebElement option : options)
			{
				if(option.getText().toLowerCase().equalsIgnoreCase(Value.toLowerCase()))
				{
					option.click();
					IsAvail=true;
					break;
				}
				else
				{
					if(option.getText().toLowerCase().startsWith(Value.toLowerCase()))
					{
						option.click();
						IsAvail=true;
						break;
					}
					else
					{
						IsAvail=false;
					}
				}
			}
			if(!IsAvail)
			{
				System.out.println("Error:Option is not available!");
			}
		}
		
		
		
		//is option available 
		
		public static boolean IsOptionAvailable(By by,String Optionvalue)
		{
			boolean IsAvailable=false;
			WebElement element=driver.findElement(by);
			List<WebElement> options=element.findElements(By.tagName("option"));
			for(WebElement option : options)
			{
				if(option.getText().toLowerCase().equalsIgnoreCase(Optionvalue.toLowerCase()))
				{
					IsAvailable=true;
					break;
				}
				else
				{
					if(option.getText().toLowerCase().startsWith(Optionvalue.toLowerCase()))
					{
						IsAvailable=true;
						break;
					}
				}
			}
			return IsAvailable;
				
		}
		
		
		//frame within frame
		public static void SelectFrameWithinFrame(By by)
		{
			WebElement element=driver.findElement(by);
			driver.switchTo().frame(element);
		}
		
		//find longest text in an array
		/*public static int[] GetLongestTextInColumn(String[][] TableData,int rows)
		{
			int Height=rows;
			int Width=TableData.length/rows;
			int[] Lengthcounter=new int[Width];
			
			for(int a=0;a<Width;a++)
			{
				int Chars=0;
				for(int b=0;b<Height;b++)
				{
					String Text=TableData[b,a];
					int NewChars=Text.length();
					if(Chars<NewChars)
						Chars=NewChars;
				}
				Lengthcounter[a]=Chars;
			}
			return Lengthcounter;
		}*/
		
		
		
		
		
		
		
		//table
		public static int GetNoofRows(By by)
		{
			WebElement element=driver.findElement(by);
			int count=element.findElements(By.tagName("tr")).size();
			return count;
		}
		
		//table
		public static int GetNoofColumns(By by)
		{
			int count=0;
			WebElement element=driver.findElement(by);
			count=element.findElements(By.tagName("td")).size();
			return count;
		}
		
		//table (may be not work)
		public static String[] GetColumnName(By by)
		{
			int count=GetNoofColumns(by);
			String[] columnname=new String[count];
			int counter =1;
			for(int counter1=0;counter1<count;counter1++)
			{
				columnname[counter1]=GetText(by);
				counter++;
			}
			return columnname;
		}
		
		//list box
		public static String[] GetListBoxText(By by)
		{
			WebElement element=driver.findElement(by);
			List<WebElement> options=element.findElements(By.tagName("option"));
			
			String[] Listboxdata=new String[options.size()];
			if(options.size()!=0)
			{
				int i=0;
				for(WebElement option : options)
				{
					Listboxdata[i++]=option.getText();
				}
			}
			return Listboxdata;
					
		}
		
		
		
		//alert
		public static void AcceptAlert()
		{
			driver.switchTo().alert().accept();
		}
		
		//get alert text
		public static String GetAlertText()
		{
			String Alerttext=driver.switchTo().alert().getText();
			return Alerttext;
		}
		
		
		//log4j method
		public static void Startload()
		{
			start=System.currentTimeMillis();
			PastURL=driver.getCurrentUrl();
			
		}
		
		public static void EndLoad()
		{
			finish=System.currentTimeMillis();
			CurrentURL=driver.getCurrentUrl();
		}
		public static void TotalLoad(String text)
		{
			loadTime=(finish-start)/1000;
			
			String str=text+"  "+loadTime+"  "+PastURL+"  "+CurrentURL;
			logger.info(str);
			
			
		}
		
		public static void Xlslogger(String text1)
		{
			String str1=text1;
			logger.info(str1);
		}
		
		
		//EA methods
		public String GetDOB(int i)
        {
            String dob = "";

            int j = i % 50;
            int[] Year = new int[] { 1940, 1941, 1942, 1943, 1944, 1945, 1946, 1947, 1948, 1949, 1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990 };
            String SYear = Integer.toString(Year[j]);
            
            int K = i % 12;
            int[] month = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
            String smonth = Integer.toString(month[K]);
           // smonth = smonth.padLeft(2, '0');
            smonth=String.format("%1$-2s", smonth);

            int l = i % 30;
            int[] date = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
            String Sdate = Integer.toString(date[l]);
            //Sdate = Sdate.padLeft(2, '0');
            Sdate=String.format("%1$-2s", Sdate);

            dob = SYear + smonth + Sdate;
            return dob;
        }
		
		
		public int location(int i)
		{
			int index1=0;
			int j = i % 5;
	        int[] index = new int[] { 0, 1, 2, 3, 4};
	         
	        return index1=index[j];
		}
		
		
		public static void DismissAlert()
		{
			
			driver.switchTo().alert().dismiss();
		}
		
		
		//Mouse hover and click
		public static void  hoverclick(By hoveron,By clickon )
		{
			WebElement element = driver.findElement(hoveron);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			driver.findElement(clickon).click();
		}
		
		
		
		public void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) 
	        {
	        	return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	        }};
	        
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	    }
		
		
		
		
	}
	
	
	 


