package com.phptravels.StepDefinationFiles.LoginSD;
import java.util.Date;
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




public class LoginSD  {
	
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
		
    @When("^Enter Username and password$")
	public void enter_Username_and_password(){
		
    	
    	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sainiwinarth@gmail.com");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("@rpaN@9070676");
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
