package com.phptravels.Pages;
import java.util.Hashtable;
import org.openqa.selenium.WebDriver;
import com.AbstractBase.AbstractBasePage;

public class LoginPage extends AbstractBasePage {

	public LoginPage(WebDriver driver, Hashtable<String, String> TestDataTable) {
		super(driver, TestDataTable);
		// TODO Auto-generated constructor stub
	}
	
	public final static String myAccount = "XPATH=html/body/div[4]/div/div/div[2]/ul/li[1]/a/b";
	
	
	
	public void myAccountClick(){
		
		click(myAccount, "myAccount");
	}

}
