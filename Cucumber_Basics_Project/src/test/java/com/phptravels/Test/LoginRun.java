package com.phptravels.Test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		           //To Remove the garbage from the console Logs
		           monochrome=true
                  //To run the tests case to check with sytax is written correctly without running selenium code
                 //,dryRun=true
		           //to Generate html and Json Reports
                 ,plugin={"pretty","html:target/cucumber-htmlreport1","json:target/cucumber-report.json"}
		        
		      
		           
		         
		           
                 )
 public class LoginRun {
	
	
}
