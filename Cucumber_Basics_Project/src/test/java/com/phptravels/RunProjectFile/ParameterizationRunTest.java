package com.phptravels.RunProjectFile;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		          //To Remove Garbage from console logs(to keep value true)
		             monochrome=true
		             //dryRun is to check the syntax of the test ccase without opening the browser
                 //,dryRun=true
					
		            		 ,plugin={"pretty"
									  ,"html:target/ParameterizeFeatureFile_cucumberHtmlReport"
									  ,"json:target/ParameterizeFeatureFile_cucumberjsonReport.json"
									  ,"com.cucumber.listener.ExtentCucumberFormatter:ExtentReports/ParameterizeFeatureFile_cucumberExtentReport.html"}				     
		             
					//To provide the location of Feature file
					,features={"src/test/java/com/phptravels/FeatureFiles/ParameterizeFeatureFile.feature"}
					//To provide the location of step defination file
					,glue={"com/phptravels/StepDefinationFiles/parameterization"}
                 )
 public class ParameterizationRunTest {
	
	
}
