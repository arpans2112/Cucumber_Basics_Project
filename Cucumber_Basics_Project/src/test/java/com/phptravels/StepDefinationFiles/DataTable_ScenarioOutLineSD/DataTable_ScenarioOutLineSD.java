package com.phptravels.StepDefinationFiles.DataTable_ScenarioOutLineSD;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.Utilities.PropertyFileReader;
import com.config.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class DataTable_ScenarioOutLineSD  {
	
           WebDriver driver = null;
           PropertyFileReader PropFileReader = null;
           public String extentReportPath = null;

	@Before
	public  void  setupScenario(){
		
		
	

		PropFileReader =  new PropertyFileReader();
	
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

		


	}
	
	
		
	@Given("^Login lending page$")
	public void Login_lending_page(){
		
		
		driver.get(PropFileReader.configpropertyReader("ApplicationURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
    @When("^Enter Credentials username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void enter_Credentials_username_x_and_Password_y(String username,String password){
    	System.out.println("UserName : " + username + "Password : " + password);
    	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
	}
	
    
    @Then("^click login button$")
    public void click_login_Button(){
    	
    	driver.findElement(By.xpath("//input[@value='Log In']")).click();
    	driver.close();
    }

  
    
	@After
	public  void teardownScenario(Scenario scenario){	
		
		driver.close();
	}
    



}
