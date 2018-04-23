package com.config;

public class Configuration {
	
    public static final String Browser = "Mozila";
	
//Environment Config file Variables
	public static final String environmentFileName = "QA_Environment.properties";    
	public static final String environmentFileLocationProperty= System.getProperty("user.dir") + "\\src\\test\\java\\com\\config\\" + environmentFileName;
	
	


	//Paths
	//Extent Report Paths
	public static final String ExtentReportLocation = System.getProperty("user.dir") + "\\ExtentReports\\";
	public static final String ReportConfigFilepath = "\\ReportsConfig.xml";
	
	
	public static final String TestDataFileLocation = "\\src\\test\\resources\\InputData\\";
    public static final String  ScreenshotLocation =   "\\ExtentReports\\ScreenShots\\";
	
    //Web Browser Drivers
    
     public static  final String  MozilaDriver = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
     public static  final String  ChromeDriver = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
     public static  final String  IEDriver = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
	
	public static final String RedColour = "red";
	public static final String GreenColour = "green";
	public static final String blueColour = "blue";
	
	
	
	/**********************************Common X-Paths********************************************************************/
	
	
	/************************************Constant Drop Down Values*********************************************************/
	
	

	 public static final String SelectByVisibleText = "byvisibletext";
	 public static final String SelectByValue = "byvalue";
	 public static final String SelectByIndex = "byindex";
	 
	 public static final String AlertAccept = "Accept";
	 public static final String AlertDismiss = "Dismiss";
	 
	 public static final String attributeText_Text = "Text";
	 public static final String attributeText_Attribute = "Attribute";
	 
	 public static final Boolean ExpectedResult_True = true;
	 public static final Boolean ExpectedResult_Fasle = false;
	 
	
}
