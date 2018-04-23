package com.AbstractBase;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.Utilities.PropertyFileReader;
import com.config.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;




public class AbstractBaseTestCase {


	public   WebDriver driver = null;
	public   Properties Config = null;
	public   PropertyFileReader  PropFileReader = null;
	public   Hashtable<String , String> TestDataTable = null;
	
	//Extent Report Variables
	public   String extentReportPath = null;


	/*//DDBC Connection Variables
	 public  Connection connection = null;
	 public  Statement st = null;
	 public  ResultSet rs = null;
	 public  String TestCaseName = null;*/



	@Before
	public  void  setupScenario(Method method){
		
		Date d=new Date();	
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		extentReportPath = Configuration.ExtentReportLocation + fileName;
	

		PropFileReader =  new PropertyFileReader();
		//To get the method and class name in before method 
		String classname = getClass().getSimpleName();
		String methodName = method.getName();
		System.out.println("Class Name : " + classname + "Method : " + methodName + "Scenario Status : " );

		//Driver Initialization

		if(Configuration.Browser.equalsIgnoreCase("Mozila")){

		
			System.setProperty("webdriver.gecko.driver", Configuration.MozilaDriver);
			driver  = new FirefoxDriver();

		}else if (Configuration.Browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", Configuration.ChromeDriver);
			driver = new ChromeDriver();

		}else if(Configuration.Browser.equalsIgnoreCase("IE")){

			System.setProperty("webdriver.ie.driver",  Configuration.IEDriver);
			driver = new InternetExplorerDriver();

		}

		driver.get(PropFileReader.configpropertyReader("ApplicationURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		/*	
		//JDBC connection

		try {

			Class.forName(PropFileReader.configpropertyReader("dbDriver")).newInstance();
			connection = DriverManager.getConnection(PropFileReader.configpropertyReader("dbHOSTURL"),PropFileReader.configpropertyReader("dbHOSTUser"), PropFileReader.configpropertyReader("dbHOSTPwd"));
			 st =	connection.createStatement();
			 st.setQueryTimeout(15);

			if (connection.isClosed()){
				System.out.println("JDBC Connection Got Failed");
				TestLog.log(LogStatus.FAIL, "JDBC Connection Got Failed");
			}
			System.out.println("DB Connected Sucessfully");
			    TestLog.log(LogStatus.PASS, "DB Connected Sucessfully");

		} catch (Exception e) {
			   System.out.println("JDBC Connection Got Failed");
			    TestLog.log(LogStatus.FAIL, "JDBC Connection Got Failed");
			     e.printStackTrace();
		} 
		 */


	}


	@After
	public  void teardownScenario(Scenario scenario){

/*		//Db Connection 
		try {
			if ((connection!=null) && ! (connection.isClosed())){

				connection.close();
				TestLog.log(LogStatus.INFO, "DB Connection Closed Sucessfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			TestLog.log(LogStatus.INFO, "DB Connection is Not Closed");
			e.printStackTrace();
		}*/

	/*	
		if(scenario.isFailed()){
			
			Date date = new Date();
			String ScreenShoteFileName =	date.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".png";
			String Filepath = System.getProperty("user.dir") + Configuration.ScreenshotLocation + ScreenShoteFileName;
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, Filepath);
		}
		
		System.out.println("scenario.getId() : " + scenario.getId());
		System.out.println("scenario.getName() : " + scenario.getName());
		System.out.println("scenario.getName() : " + scenario.getStatus());*/
	
		
		driver.close();
	}










	



/*	
	public void OpenExtentReport()
	{

		//Code to open the Extent Report

		System.out.println("Extent Report Path : " + ExtentManager.ExtentReportPath);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ExtentManager.ExtentReportPath);
		driver.manage().window().maximize();

       

	}*/










	/*
	 * Author  : Arpan Saini
	 * Purpose : To Take the screen shot and add that in Extent Report
	 * */

/*	public void takeScreenShot(){

		Date date = new Date();
		String ScreenShoteFileName =	date.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".png";
		String Filepath = System.getProperty("user.dir") + Configuration.ScreenshotLocation + ScreenShoteFileName;
		java.io.File srcFile =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, new java.io.File(Filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
	
	


	
/*
	
	 * Author  : Arpan Saini
	 * Purpose : To Execute the Query 
	 * 

	public void executeQuery(String query){

		try {
			rs = st.executeQuery(query);
			System.out.println(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

*/	
	
/*	
	
	 * Author  : Arpan Saini
	 * Purpose : Hashtable will store  keys values as 1, 2, 3 , 4 ..... and the values corresponding to keys will be in  order in which the columns are written in the Query
	 *           Example 1. if Query : Select customer_no , brch_no , Loan_Number from borm ; 
	 *           then HashTable will store the values as ( key1 = 1 , value = customer_no ) , ( key1 = 2 , value = brch_no ) , ( key1 = 3 , value = Loan_Number )
	 * 

	public Hashtable<String, String> getDbData(int NumberofColumns) { 

		Hashtable<String, String> getdbData = new  Hashtable<String ,String>();


		try {
			//	System.out.println(rs.next());
			while(rs.next()){
				//				 System.out.println(rs.next());
				for(int i=1 ; i <= NumberofColumns ; i++ ){

					String j =  Integer.toString(i);
					if(j==null){
						return null;
					}
					getdbData.put(j, rs.getString(i));


				}

				return getdbData; 
			}
			return null;

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}
*/

	/****************************************************************************Extent Report Methods *********************************************************/  


	//To make specific changes to Heading in Extent Report	
	public String testLogTestStepMessage(String Message){

		return "<p><span style='font-weight:bold; color:blue; font-size:200%; text-transform: uppercase; '>" + Message + "</span></p>" ;
	}


	//To make specific changes to Heading in Extent Report	
	public String testLogPageHeadingMessage(String Message){

		return "<p><span style='font-weight:bold; color:blue; font-size:200%; background-color:Ivory;'>" + Message + "</span></p>" ;
	}

	//To make specific changes to Action Message in Extent Report	
	public String testLogActionMessageString(String Message){

		if (Message.contains("O.K."))
			return "<p><span style='font-weight:bold; color:green; font-size:120%'>" + Message + "</span></p>" ;
		else 
			return "<p><span style='font-weight:bold; color:red; font-size:120%'>" + Message + "</span></p>" ;
	}

	//To make specific changes to TestCase Description Message in Extent Report	

	public String testLogTestCaseDescriptionString(String Message){

		return "<p><span style='font-weight:bold; color:yellow; font-size:150%'>" + Message + "</span></p>" ;

	}


	public String testLogActionMessageString(String Message , String Color){

		if(Color.equals("green"))
			return "<p><span style='font-weight:bold; color:green; font-size:120%'>" + Message + "</span></p>" ;
		else if(Color.equals("red"))
			return "<p><span style='font-weight:bold; color:red; font-size:120%'>" + Message + "</span></p>" ;
		else if(Color.equals("blue"))
			return "<p><span style='font-weight:bold; color:blue; font-size:150%'>" + Message + "</span></p>" ;

		return "<p><span style='font-weight:bold; color:White; font-size:120%'>" + Message + "</span></p>" ;
	}
}
