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
		             //,tags={"@Important"} //all scenarios under feature file will be executed as @Important Tag is on Feature level
		            //,tags={"@smoke"} // only those scenario will be executed which are under tag smoke in a feature file
		             //,tags={"@smoke","@Regression"} // This is and condition all scenario will execute if has both the tags @smoke and @Regression
		             //,tags={"@smoke,@Regression"} // This is or Condition scenario will exectue if it belongs to either of the tag smoke or Regression
		            		 ,plugin={"pretty"
									  ,"html:target/DataTable_ScenarioOutLine_cucumberHtmlReport"
									  ,"json:target/DataTable_ScenarioOutLine_cucumberjsonReport.json"
									  ,"com.cucumber.listener.ExtentCucumberFormatter:ExtentReports/DataTable_ScenarioOutLine_cucumberExtentReport.html"}	             
		             
					//To provide the location of Feature file
					,features={"src/test/java/com/phptravels/FeatureFiles/DataTable_ScenarioOutLine.feature"}
					//To provide the location of step defination file
					,glue={"com/phptravels/StepDefinationFiles/DataTable_ScenarioOutLineSD"}
                 )
 public class DataTable_ScenarioOoutlineRunTest {
	
	
}
