package com.AbstractBase;

import java.io.IOException;  
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.config.Configuration;




public class AbstractBasePage {

 //Oject Variables
 public   WebDriver driver = null;
 public   Properties Config = null;
 public   Hashtable<String , String> TestDataTable = null;
 public   static  Hashtable<String, String > iframeTable =  null;
 public   String  TestStepResult =  null;
 public   static boolean PageConstructorCalledFirstTime = true;  


 
 //Buttons
// public static final String ButtonSubmit = "//Input[@value='Submit']";


 
 
 
 
 
 //Operations Menu Frames
 //public static final String IFRAME_OPERATIONS_CUSTOMERS       = "[common].operationscustomeriframe" ;


 
 


  public AbstractBasePage (WebDriver driver , Hashtable<String , String> TestDataTable){
	  
	  this.driver = driver;
	  this.TestDataTable = TestDataTable;
	//  this.TestLog = TestLog;

	  putiframesinIframeTable();
	  System.out.println(getClass().getSimpleName());
      //TestLog.log(LogStatus.INFO,  testLogPageHeadingMessage(getClass().getSimpleName()));
	 
  }
  
	    
	
  public void putiframesinIframeTable(){
	  
	  iframeTable = new Hashtable<String, String >();
	  
	  
	  //iframe
	//  iframeTable.put("[common].InterestMenuPageiframe", "NAME=interestLON:popDivBranchIframe");	  

  }
  
 

  /****************************************************************************Selenium API Methods ***********************************************************************/ 
   
   /*
    * Author : Arpan Saini
    * Purpose: To get the Object ID out of Object passed as an Argument eg. object name=userid then it will return only userid
    * */
   public  String getObjectid(String Object){
	  
	String ObjectID = null;
	  if(Object.contains("NAME=")){
		   
		  ObjectID = Object.substring(5);
		   }else if(Object.contains("ID=")){
			   
			   ObjectID = Object.substring(3);
		   }else if(Object.contains("")){
			   
			   ObjectID = Object.substring(6);
		   }
	  
	  return ObjectID;
  }
   
   //Selenium Functions
   
  /*
   * Author : Arpan Saini
   * Purpose: To set the Text value in a field on WebPage
   * 
   * */
   public  void setText(String Object, String Text , String variableName ){
	   
	String   ObjectId = getObjectid(Object);
	   
	   try {
		if(Object.contains("NAME=")){
			   
			 driver.findElement(By.name(ObjectId)).sendKeys(Text);  
			 
             System.out.println(" [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
			 //TestLog.log(LogStatus.PASS, " [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
			 
		   }else if(Object.contains("ID=")){
			   
			   driver.findElement(By.id(ObjectId)).sendKeys(Text);
			   System.out.println(" [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
			   //TestLog.log(LogStatus.PASS, " [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
		   }else if(Object.contains("")){
			   
			   driver.findElement(By.xpath(ObjectId)).sendKeys(Text);
			   System.out.println(" [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
			   //TestLog.log(LogStatus.PASS, " [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		   System.out.println(" [ Method = setText ] "   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
		       //TestLog.log(LogStatus.FAIL, "[ Method = setText ]"   + " [ " + variableName + " = " + Text + " ] " + " [ Object = " + Object + " ] ");
		      e.printStackTrace();
	}
	   
   }
   
   
   
   public  void clearText(String Object,  String variableName ){
	   
		String   ObjectId = getObjectid(Object);
		   
		   try {
			if(Object.contains("NAME=")){
				   
				 driver.findElement(By.name(ObjectId)).clear(); 
				 
	             System.out.println(" [ Method = clearText ] "  + " [ clearText = True ] " + " [ " + variableName +  " ] "  + " [ Object = " + Object + " ] " );
				//TestLog.log(LogStatus.PASS, " [ Method = clearText ] "   + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
				 
			   }else if(Object.contains("ID=")){
				   
					 driver.findElement(By.name(ObjectId)).clear(); 
				   System.out.println(" [ Method = clearText ] "    + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = clearText ] "    + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
			   }else if(Object.contains("")){
				   
					 driver.findElement(By.name(ObjectId)).clear(); 
				   System.out.println(" [ Method = clearText ] "    + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = clearText ] "    + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			     
			       System.out.println(" [ Method = clearText ] "   + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
			       //TestLog.log(LogStatus.FAIL, "[ Method = clearText ]"   + " [ clearText = True ] " + " [ " + variableName +  " ] " + " [ Object = " + Object + " ] ");
			       e.printStackTrace();
		}
		   
	   }
  
   /*
    * Author : Arpan Saini 
    * Purpose : To Select Thr Drop Down 
    * Key Parameters : Object = e.g name=userid , ValueTobeSelected(Visible text/ Value/Index, SelectBY : ( byvisibletext / byvalue/ byindex))
    * */
 public  void select(String Object, String valueTobeSelected , String Selectby , String variableName){
	   
	    Select select = null ;
	    String   ObjectId = getObjectid(Object);
	    
	   if(Object.contains("NAME=")){
		  
		   try {
			select = new Select( driver.findElement(By.name(ObjectId)));
			  
			   if (Selectby.equalsIgnoreCase("byvisibletext")){
				   select.selectByVisibleText(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   
			   } else if(Selectby.equalsIgnoreCase("byvalue")){
				   select.selectByValue(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   } else if(Selectby.equalsIgnoreCase("byindex")){
				   
				    int Index = Integer.parseInt(valueTobeSelected);
				   select.selectByIndex(Index);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   }
		} catch (NumberFormatException e) {
			    
			 System.out.println("[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] "); 
			 //TestLog.log(LogStatus.FAIL, "[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			
			    e.printStackTrace();
		}
		  
	   }else if(Object.contains("ID=")){
		   
		   try {
			select = new Select(driver.findElement(By.id(ObjectId)));
				  
			   if (Selectby.equalsIgnoreCase("byvisibletext")){
				   select.selectByVisibleText(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   } else if(Selectby.equalsIgnoreCase("byvalue")){
				   select.selectByValue(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   } else if(Selectby.equalsIgnoreCase("byindex")){
				   
				    int Index = Integer.parseInt(valueTobeSelected);
				   select.selectByIndex(Index);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] "  +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] "  +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   }
		} catch (NumberFormatException e) {
			 
			System.out.println("[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] "); 
			  //TestLog.log(LogStatus.FAIL, "[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			 e.printStackTrace();
		}
		   
		   
	   }else if(Object.contains("")){
		   
		   try {
			select = new Select(driver.findElement(By.xpath(ObjectId)));
				  
			   if (Selectby.equalsIgnoreCase("byvisibletext")){
				   
				   select.selectByVisibleText(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				   //TestLog.log(LogStatus.PASS, " [ Method = select ] "  +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   } else if(Selectby.equalsIgnoreCase("byvalue")){
				   select.selectByValue(valueTobeSelected);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				    //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   } else if(Selectby.equalsIgnoreCase("byindex")){
				   
				    int Index = Integer.parseInt(valueTobeSelected);
				   select.selectByIndex(Index);
				   System.out.println(" [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
				    //TestLog.log(LogStatus.PASS, " [ Method = select ] " + " [ Selected = true ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			   }
		} catch (NumberFormatException e) {
			 
			 System.out.println("[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] "); 
			  //TestLog.log(LogStatus.FAIL, "[ Method = select ] " + " [ Selected = false ] " +  " [ " + variableName + " = " + valueTobeSelected + " ] " + " [ Selected By Category = " + Selectby + " ] "  + " [ Object = " + Object + " ] ");
			e.printStackTrace();
		}
		   
		   
	   }
   }
 
	 //To Clik an Object 
	   public void click(String Object , String variableName){
		   
		   String   ObjectId = getObjectid(Object);
		   try {
			if(Object.contains("NAME=")){
				   
					 driver.findElement(By.name(ObjectId)).click();  
					
					 System.out.println(" [ Method = click ] " + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
					 //TestLog.log(LogStatus.PASS, "[ Method = click]" + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
				
			}else if(Object.contains("ID=")){
					   
					   driver.findElement(By.id(ObjectId)).click();  
					   System.out.println(" [ Method = click ] " + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
					   //TestLog.log(LogStatus.PASS, "[ Method = click]" + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
				   }else if(Object.contains("")){
					   
					   driver.findElement(By.xpath(ObjectId)).click();  
					   System.out.println(" [ Method = click ] " + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
						 //TestLog.log(LogStatus.PASS, "[ Method = click]" + " [ Clicked = true ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
				   }
		} catch (Exception e) {
			
			 System.out.println(" [ Method = click ] " + " [ Clicked = false ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
			 //TestLog.log(LogStatus.FAIL, "[ Method = click]" + " [ Clicked = false ] " + " [ " + variableName + " ] "  + " [ Object = " + Object + " ] ");
		   	e.printStackTrace();
		}
		   
	   }
 
   
	   /*
	    * Author : Arpan Saini
	    * Purposer: To Provide the total no of Frames on a Html Page. 
	    * 
	    * */
	  
	   public int getiframeTotalNoOfFrames(){
		
		   try {
			int Totaliframes = driver.findElements(By.tagName("iframe")).size();
			   
			System.out.println(" [ Method = getiframeTotalNoOfFrames ] " + " [ Frame Found = true ] "  + " [ Total no of Frames = " + Totaliframes + " ] "); 
			//TestLog.log(LogStatus.PASS, "[ Method = getiframeTotalNoOfFrames]" + " [ Frame Found = true ] " + " [Total no of Frames = " + Totaliframes + " ] "  );
			   return Totaliframes;
			   
		} catch (Exception e) {
			
			 System.out.println(" [ Method = getiframeTotalNoOfFrames ] " + " [ Frame Found = false ] " + " [ Total no of Frames = " + 0 + " ] "); 
			 //TestLog.log(LogStatus.FAIL, " [ Method = getiframeTotalNoOfFrames ] " + " [ Frame Found = false ] " + " [ Total no of Frames = " + 0 + " ] "  );
			 e.printStackTrace();
			 return 0;
			
		}
		   
	   }
	   
	   /*
	    * Author : Arpan Saini 
	    * Purpose : To get the Index name of a frame for which index no is given
	    * */
	   public String getiframeNameOfAnObject(int Index){
		  
		   try {
			List<WebElement>  ele = driver.findElements(By.tagName("iframe"));
			   
			   String iframeName = ele.get(Index).getAttribute("name");
			   
			    System.out.println("[ Method = getiframeNameOfAnObject ] " + " [ Iframe Name Found = true ] " + " [ Index = " + Index + " ] " + " [ Iframe Name = " + iframeName + " ] ");
			    //TestLog.log(LogStatus.PASS, " [ Method = getiframeNameOfAnObject ] " + " [ Iframe Name Found = true ] "  + " [ Index = " + Index + " ] " + " [ Iframe Name = " + iframeName + " ] "  );
			   
			   
			   return iframeName ;
		} catch (Exception e) {

			  System.out.println(" [ Method = getiframeNameOfAnObject ] " + " [ Iframe Name Found = false ] " + " [ Index = " + Index + " ] " + " [ Iframe Name = " + null + " ] ");
			  //TestLog.log(LogStatus.FAIL, "[ Method = getiframeNameOfAnObject ] " + " [ Iframe Name Found = false ] "  + " [ Index = " + Index + " ] " + " [ Iframe Name = " + null + " ] "  );
			e.printStackTrace();
			return null;
		}
		   
		   
	   }
	   
	   public Boolean verifyPageChildControl(String Object , String variableName){
		   
		    Boolean verifyObjectExist = null;
			verifyObjectExist = verifyExist(Object, variableName);
			System.out.println(" [ Method = verifyPageChildControl ] "   + " [ veriable Name = " + variableName + " ] " + " [ Object = " + Object + " ] "  + " [ VerifyExist = " + verifyObjectExist + " ] ");
             if(verifyObjectExist){
            	 
            		//TestLog.log(LogStatus.INFO, " [ Method = verifyPageChildControl ] "   + " [veriable Name = " + variableName + " ] " + " [ Object = " + Object + " ] " + " [ VerifyExist = " + verifyObjectExist + " ] " );
            		 return verifyObjectExist;
             }else{
		 	
             //TestLog.log(LogStatus.INFO, " [ Method = verifyPageChildControl ] "   + " [veriable Name = " + variableName + " ] " + " [ Object = " + Object + " ] " + " [ VerifyExist = " + verifyObjectExist + " ] " );
     		return verifyObjectExist;
             }
		   
	   }
	   
	   
          
	   
	   /*
	    * Author : Arpan Saini;
	    * Purpose : Pass the object id as an argument it will return you the frame name on which the object is Present if object is 
	    *           Not found on any of the frame it will return you null
	    * 
	    * */
	   
	   public int getiframeIndexofAnObjct(String Object){
		   
		   List<WebElement>  ele = driver.findElements(By.tagName("iframe"));
		   int Totaliframes = ele.size();
		  
		   String   ObjectId = getObjectid(Object);
		   
		   try {
			for(int index=0; index < Totaliframes; index++){
					driver.switchTo().frame(index);
					
					if(Object.contains("NAME=")){
						
					if (driver.findElements(By.name(ObjectId)).size()!=0){
						
						
					
					   int Frame_Index = index;
					
						driver.switchTo().defaultContent();
						return Frame_Index;
					}
					   
					}else if(Object.contains("ID=")){
						   
						if (driver.findElements(By.id(ObjectId)).size()!=0){
							
							int Frame_Index = index;
							driver.switchTo().defaultContent();
							return Frame_Index;
						} 
						
					   }else if(Object.contains("")){
						   
						   if (driver.findElements(By.xpath(ObjectId)).size()!=0){
								
							   int Frame_Index = index;
								driver.switchTo().defaultContent();
								return Frame_Index;
							}
					   }
					
					driver.switchTo().defaultContent();
				
			   
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 0;
	  
	   }	
	   
	   
	   /*
	    * Author : Arpan Saini
	    * Purpose : To get the Text of the object passed as an argument
	    * */
	   
	   public String getText(String Object , String variableName){
		   
		   
		   String   ObjectId = getObjectid(Object);
		   try {
			if(Object.contains("NAME=")){
				   
				TestStepResult = driver.findElement(By.name(ObjectId)).getText();  
				
				System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
				//TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
				 
				
				return TestStepResult;
					 
				   }else if(Object.contains("ID=")){
					   
					   TestStepResult =   driver.findElement(By.id(ObjectId)).getText(); 
					   System.out.println(" [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   //TestLog.log(LogStatus.PASS, " [ Method = getText ] "  + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   return TestStepResult;
				   }else if(Object.contains("")){
					   
					   TestStepResult =   driver.findElement(By.xpath(ObjectId)).getText(); 
					   System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   //TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   return TestStepResult;
				   }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(" [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					//TestLog.log(LogStatus.FAIL, " [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					e.printStackTrace();
					return null;
				}
		   
		   return null;
	   }
	   

	   /*
	    * Author : Arpan Saini
	    * Pupose : To get Text of Attribute value or Text of a Tag, if getting the the value of Attribute then set attributeText as attribute else set as Text
	    * */
  public String getText(String Object , String variableName, String attributeName , String attributeText ){
		   
		  
	
		   String   ObjectId = getObjectid(Object);
		   
		   if(attributeText.equals("Text")) {
		   
		   try {
			if(Object.contains("NAME=")){
				   
				TestStepResult = driver.findElement(By.name(ObjectId)).getText();  
				
				System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
				//TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
				 
				
				return TestStepResult;
					 
				   }else if(Object.contains("ID=")){
					   
					   TestStepResult =   driver.findElement(By.id(ObjectId)).getText(); 
					   System.out.println(" [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   //TestLog.log(LogStatus.PASS, " [ Method = getText ] "  + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   return TestStepResult;
				   }else if(Object.contains("")){
					   
					   TestStepResult =   driver.findElement(By.xpath(ObjectId)).getText(); 
					   System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   //TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					   return TestStepResult;
				   }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(" [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					//TestLog.log(LogStatus.FAIL, " [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Object = " + Object + " ] ");
					e.printStackTrace();
					return null;
				}
		   
		   return null;
		   }else if (attributeText.equals("Attribute")) {
			   

			   
			   try {
				if(Object.contains("NAME=")){
					   
					TestStepResult = driver.findElement(By.name(ObjectId)).getAttribute(attributeName); 
					
					System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] " + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
					//TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] " + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
					 
					
					return TestStepResult;
						 
					   }else if(Object.contains("ID=")){
						   
						   TestStepResult =   driver.findElement(By.id(ObjectId)).getAttribute(attributeName); 
						   System.out.println(" [ Method = getText ] " + " [ getText = true ] "  + " [ " + variableName + " = "  + TestStepResult + " ] " + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
						   //TestLog.log(LogStatus.PASS, " [ Method = getText ] "  + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
						   return TestStepResult;
					   }else if(Object.contains("")){
						   
						   TestStepResult =   driver.findElement(By.xpath(ObjectId)).getAttribute(attributeName);
						   System.out.println(" [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "   + " [ Attribute Name = " + attributeName + " ] " + " [ Object = " + Object + " ] ");
						   //TestLog.log(LogStatus.PASS, " [ Method = getText ] " + " [ getText = true ] " + " [ " + variableName + " = "  + TestStepResult + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
						   return TestStepResult;
					   }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(" [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + null + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
						//TestLog.log(LogStatus.FAIL, " [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + null + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
						e.printStackTrace();
						return null;
					}
			   
			   System.out.println(" [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + null + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
				//TestLog.log(LogStatus.FAIL, " [ Method = getText ] " + " [ getText = false ] "  + " [ " + variableName + " = "  + null + " ] "  + " [ Attribute Name = " + attributeName + " ] "  + " [ Object = " + Object + " ] ");
			   return null;
			   
		   }
		return null;
	   }
	   
	   
	   public void switchToFrame(String iframe , String variableName){
		   
			try {
				String iFramObject  = iframeTable.get(iframe);
				String iFramObjectID =  getObjectid(iFramObject);
				driver.switchTo().frame(iFramObjectID);
				System.out.println(" [ Method = switchToFrame ] " + " [ Frame Switched = True ] "  + " [ " + variableName + " = " + iframe + " ] ");
				//TestLog.log(LogStatus.PASS, " [ Method = switchToFrame ] " + " [ Frame Switched = True ] " + " [ " + variableName + " = " + iframe + " ] ");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(" [ Method = switchToFrame ]" + " [ Frame Switched = false ] " + " [ " + variableName + " = " + iframe + " ] ");
				//TestLog.log(LogStatus.FAIL, " [ Method = switchToFrame ] " + " [ Frame Switched = false ] " + " [ " + variableName + " = " + iframe + " ] " );
				e.printStackTrace();
			}
		
	   }
	   
	   /*
	    * Author : Arpan Saini
	    * Purpose : To switch to the Default html page from any inside Frame 
	    * */
	   
	   public void resetiframetoDefaultContent(){
			try {
				
				
                driver.switchTo().defaultContent();
                System.out.println(" [ Method = resetiframetoDefaultContent ] " + " [ Reset To Default Frame = true ] " + " [ Reset To Default  Frame ] ");
				//TestLog.log(LogStatus.PASS, " [ Method = resetiframetoDefaultContent ] " + " [ Reset To Default Frame = true ] " + " [ Reset To Default  Frame ] ");
				
			} catch (Exception e) {
				
				 System.out.println(" [ Method = resetiframetoDefaultContent ] " + " [ Reset To Default Frame = false ] " + " [ Default  Frame Not Found ] ");
				 //TestLog.log(LogStatus.FAIL, " [ Method = resetiframetoDefaultContent ] " + " [ Reset To Default Frame = false ] " + " [ Default  Frame Not Found ] ");
				e.printStackTrace();
			}
		   
	   }
	   
	   
	   /*
	    * Author : Arpan Saini
	    * Purpose : To switch to the parent Frame from the Inside Frame  
	    * */
	   
		 public void resetiframetoParentFrame(){
				   
				try {
					
					 driver.switchTo().parentFrame();
					 System.out.println(" [ Method = resetiframetoParentFrame ] " + " [ Reset To Parent Frame = true ] ");
					 //TestLog.log(LogStatus.PASS, "[ Method = resetiframetoParentFrame ] " + " [Reset To Parent Frame]");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					 System.out.println("[ Method = resetiframetoParentFrame ] " + " [ Reset To Parent Frame = false ] " + " [ Parent Frame Not Found ] ");
					//TestLog.log(LogStatus.FAIL, "[ Method = resetiframetoParentFrame ] " + " [ Reset To Parent Frame = false ] " + " [ Parent Frame Not Found ] ");
					e.printStackTrace();
				}
				 
			   }

		 
		 /*
		  * Author : Arpan Saini
		  * Purposer : To verify if the object exist on the Page or Not 
		  * 
		  * */
		 
		 public boolean verifyExist(String Object , String variableName){
		
			 String   ObjectId = getObjectid(Object);
			   try {
				if(Object.contains("NAME=")){
					   
						if ( driver.findElements(By.name(ObjectId)).size()!=0){
							
							System.out.println(" [ Method = verifyExist ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
							//TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
							
							return true;
						}
						 
					   }else if(Object.contains("ID=")){
						   
						   if ( driver.findElements(By.id(ObjectId)).size()!=0){
							   
							   System.out.println(" [ Method = verifyExist ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
							   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
								
								return true;
							}
							 
						   
					   }else if(Object.contains("")){
						   
						   if ( driver.findElements(By.xpath(ObjectId)).size()!=0){
							  
							   System.out.println(" [ Method = verifyExist ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
							   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
								
								return true;
							}
							 
					   }
			} catch (Exception e) {
				
				  System.out.println(" [ Method = verifyExist ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
				  //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.RedColour) );
				  // TODO Auto-generated catch block
				return false;
			}

			   System.out.println(" [ Method = verifyExist ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
			   //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.RedColour) );
			 
			 return false;
			 
		 }
		 
		 
		 /*
		  * Author : Arpan Saini
		  * Purposer : To verify if the object exist on the Page or Not 
		  * 
		  * */
		 
		 public boolean verifyExist(String Object , String variableName , Boolean expectedResult){
		
			if(expectedResult){
				
				 String   ObjectId = getObjectid(Object);
				   try {
					if(Object.contains("NAME=")){
						   
							if ( driver.findElements(By.name(ObjectId)).size()!=0){
								
								System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = true ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								//TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
								
								return true;
							}
							 
						   }else if(Object.contains("ID=")){
							   
							   if ( driver.findElements(By.id(ObjectId)).size()!=0){
								   
								   System.out.println(" [ Method = verifyExist ] "  + " [ ExpectedResult = true ] " +  " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
									
									return true;
								}
								 
							   
						   }else if(Object.contains("")){
							 
							   if ( driver.findElements(By.xpath(ObjectId)).size()!=0){
								  
								   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = true ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ ExpectedResult = true ] " + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour) );
									
									return true;
								}
								 
						   }
				} catch (Exception e) {
					
					  System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = true ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
					  //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ ExpectedResult = true ] " + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] " , Configuration.RedColour) );
					// TODO Auto-generated catch block
					return false;
				}

				   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = true ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
				   //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ ExpectedResult = true ] " + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] " , Configuration.RedColour) );
				 
				 return false;
			} else if (!expectedResult){
				
				 String   ObjectId = getObjectid(Object);
				   try {
					if(Object.contains("NAME=")){
						   
							if ( driver.findElements(By.name(ObjectId)).size()!=0){
								
								System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								//TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.RedColour));
								return false;
							}
							 
						   }else if(Object.contains("ID=")){
							   
							   if ( driver.findElements(By.id(ObjectId)).size()!=0){
								   
								   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.RedColour));
									
									return false;
								}
								 
							   
						   }else if(Object.contains("")){
							   
							   if ( driver.findElements(By.xpath(ObjectId)).size()!=0){
								  
								   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
								   //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyExist]" + " [ ExpectedResult = false ] " + " [ VerifyExist = true ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.RedColour));
									
									return false;
								}
								 
						   }
				} catch (Exception e) {
					
					  System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = false ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
					  //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ ExpectedResult = false ] " + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour));
					// TODO Auto-generated catch block
					return true;
				}

				   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = false ] " +  " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
				   //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ ExpectedResult = false ] " + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] ", Configuration.GreenColour));
				 
				 return true;
			}
			 
			   System.out.println(" [ Method = verifyExist ] " + " [ ExpectedResult = " + expectedResult + " ] " + " [ VerifyExist = false ] " +  " [ " + variableName +  " ] " + " [ Object = " +  Object + " ] ");
			   //TestLog.log(LogStatus.INFO, testLogActionMessageString(" [ Method = verifyExist]" + " [ ExpectedResult = " + expectedResult + " ] " + " [ VerifyExist = false ] "  + " [ " + variableName  + " ] " + " [ Object = " +  Object + " ] " , Configuration.RedColour));
			 
			 return false;
		 }
		 
		 
		 
		 
		 /*
		  * Author : Arpan Saini
		  * Purpose: To get the selected  drop down value in a String 
		  * */
		 
		 public String getSelectedDropDownText(String Object , String variableName){
			
			 Select dropdown  = null;
			 String   ObjectId = getObjectid(Object);
			   try {
				if(Object.contains("NAME=")){
					   
					dropdown = new Select(driver.findElement(By.name(ObjectId)));
					String SelectedDropDownText = dropdown.getFirstSelectedOption().getText();
					
					System.out.println("[ Method = getSelectedDropDownText ] "  + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
					//TestLog.log(LogStatus.PASS, " [ Method = getSelectedDropDownText ] " + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
			        return SelectedDropDownText;
						 
					   }else if(Object.contains("ID=")){
						   
						   dropdown = new Select(driver.findElement(By.id(ObjectId)));
						   String SelectedDropDownText = dropdown.getFirstSelectedOption().getText();
						   System.out.println("[ Method = getSelectedDropDownText ] "  + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
						   //TestLog.log(LogStatus.PASS, " [ Method = getSelectedDropDownText ] " + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
					       return SelectedDropDownText;
							 
						   
					   }else if(Object.contains("")){
						   
						   dropdown = new Select(driver.findElement(By.xpath(ObjectId)));
						   String SelectedDropDownText = dropdown.getFirstSelectedOption().getText();
						   System.out.println("[ Method = getSelectedDropDownText ] "  + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
						   //TestLog.log(LogStatus.PASS, " [ Method = getSelectedDropDownText ] " + " [ getSelectedDropDownText = true ] "  + " [ " + variableName + " = " +  SelectedDropDownText + " ] " + " [ Object = " +  Object + " ] ");
						   return SelectedDropDownText;
							 
					   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				
				
				System.out.println("[ Method = getSelectedDropDownText ] "  + " [ getSelectedDropDownText = false ] "  + " [ " + variableName + " = " +  null + " ] " + " [ Object = " +  Object + " ] ");
				//TestLog.log(LogStatus.FAIL, " [ Method = getSelectedDropDownText ] "   + " [ getSelectedDropDownText = false ] " + " [ " + variableName + " = " +  null + " ] " + " [ Object = " +  Object + " ] ");
				e.printStackTrace();
				return null;
			}
			 
			 return null;
			 
			 
		 }
		 
		 /*
		  * Author : Arpan Saini
		  * Purpose: To get the all the drop down values in a String 
		  * */
		 
		 public String getDropDownText(String Object , String variableName){
				
			
			 String   ObjectId = getObjectid(Object);
			   try {
				if(Object.contains("NAME=")){
					   
				   String	DropDownText = driver.findElement(By.name(ObjectId)).getText();
					System.out.println(" [ Method = getDropDownText ] "  + " [ getDropDownText = true ] " + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
				    //TestLog.log(LogStatus.PASS, " [ Method = getDropDownText ] " + " [ getDropDownText = true ] "  + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
			        return DropDownText;
						 
					   }else if(Object.contains("ID=")){
						   
						   String	DropDownText = driver.findElement(By.id(ObjectId)).getText();
						   System.out.println(" [ Method = getDropDownText ] "  + " [ getDropDownText = true ] " + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
						    //TestLog.log(LogStatus.PASS, " [ Method = getDropDownText ] " + " [ getDropDownText = true ] "  + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
					                return DropDownText;
						   
						   
					   }else if(Object.contains("")){
						   
						   String	DropDownText = driver.findElement(By.xpath(ObjectId)).getText();
						   System.out.println(" [ Method = getDropDownText ] "  + " [ getDropDownText = true ] " + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
						    //TestLog.log(LogStatus.PASS, " [ Method = getDropDownText ] " + " [ getDropDownText = true ] "  + " [ " + variableName + " = " + DropDownText + " ] " + " [ Object = " +  Object + " ] ");
					         return DropDownText;
						   
							 
					   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(" [ Method = getDropDownText ] "  + " [ getDropDownText = false ] "  + " [ " + variableName + " = " + null + " ] " + " [ Object = " +  Object + " ] ");
				 //TestLog.log(LogStatus.FAIL, "[ Method = getDropDownText ] "   + " [ getDropDownText = false ] " + " [ " + variableName + " = " + null + " ] " + " [ Object = " +  Object + " ] ");
			 	e.printStackTrace();
				return null;
			}
			 
			   System.out.println(" [ Method = getDropDownText ] "  + " [ getDropDownText = false ] "  + " [ " + variableName + " = " + null + " ] " + " [ Object = " +  Object + " ] ");
			   //TestLog.log(LogStatus.FAIL, " [ Method = getDropDownText ] "  + " [ getDropDownText = false ] "  + " [ " + variableName + " = " + null + " ] " + " [ Object = " +  Object + " ] ");
			 return null;
			 
			 
		 } 
		 
		 
		 public boolean verifyText(String actualText , String expectedText , String variableName , Boolean ExpectedResult){
				
		    if(ExpectedResult) {
		    	
		    	if (actualText.equals(expectedText)){
					 
					 System.out.println("[ Method = verifyText ]" + " [ Actual Result = true ] " + " [ Expected Result = true ] "  + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
					 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] " + " [ Actual Result = true ] " + " [ Expected Result = true ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.GreenColour));
					 
					 return true;
					 
				 }else {
					 
					 System.out.println(" [ Method = verifyText ] "  + " [ Actual Result = false ] " + " [ Expected Result = true ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
					 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] " + " [ Actual Result = false ] " + " [ Expected Result = true ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.RedColour));
					 
					 return false;
				 }
		    	
		    }else {
		    	
		    	if (actualText.equals(expectedText)){
					 
					 System.out.println("[ Method = verifyText ]" + " [ Actual Result = true ] " + " [ Expected Result = false ] "  + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
					 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] " + " [ Actual Result = true ] " + " [ Expected Result = false ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.RedColour));
					 
					 return false;
					 
				 }else {
					 
					 System.out.println(" [ Method = verifyText ] " + " [ Actual Result = false ] " + " [ Expected Result = false ] "  + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
					 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] "  + " [ Actual Result = false ] " + " [ Expected Result = false ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.GreenColour));
					 
					 return true;
				 }
		    	
		    }
			 
			 
			 
		 }
		 
		 public boolean verifyText(String actualText , String expectedText , String variableName){
				
			 if (actualText.equals(expectedText)){
				 
				 System.out.println("[ Method = verifyText ]" + " [ verifyText = true ] "  + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
				 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] " + " [ verifyText = true ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.GreenColour));
				 
				 return true;
				 
			 }else {
				 
				 System.out.println(" [ Method = verifyText ] " + " [ verifyText = false ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ");
				 //TestLog.log(LogStatus.INFO, testLogActionMessageString("[ Method = verifyText ] " + " [ verifyText = false ] "   + " [ " + variableName + " Expected Value = " + expectedText + " ] "  + " [ " + variableName + " Actual Value = " + actualText + " ] ", Configuration.RedColour));
				 
				 return false;
			 }
			 
			 
		 }
		 
		 /*
		  * Author  : Arpan Saini
		  * Purpose :  Will Return you the Titil of the Current Page
		  * */
	  	 public String getTitleOfThePage(){
			 
	  		 try {
				String titleOfThePage = driver.getTitle();
				System.out.println(" [ Method = getTitleOfThePage ] " + " [ Title Found = true ] "  + " [ Actual Title Of The Page = " + driver.getTitle() + " ] ");
				//TestLog.log(LogStatus.PASS, " [ Method = getTitleOfThePage]" + " [ Title Found = true ] "   + " [ Actual Title Of The Page = " + driver.getTitle() + " ] " );
				 return titleOfThePage;
			} catch (Exception e) { 
				
				 System.out.println(" [ Method = getTitleOfThePage ] " + " [ Title Found = false ] "   + " [ Actual Title Of The Page = " + null + " ] ");
				 //TestLog.log(LogStatus.FAIL, " [ Method = getTitleOfThePage ] " + " [ Title Found = false ] "   + " [ Actual Title Of The Page = " + null + " ] " );
				e.printStackTrace();
				 return null;
			}
			
		    	
		    	
		    }
		 
		 
	  	 public void takeScreenShot(){
	  		 
	  		 Date date = new Date();
	       	 String ScreenShoteFileName =	date.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".png";
	       	 String Filepath = System.getProperty("user.dir") + Configuration.ScreenshotLocation + ScreenShoteFileName;
	  	  	java.io.File srcFile =   ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  		 try {
				org.apache.commons.io.FileUtils.copyFile(srcFile, new java.io.File(Filepath));
			} catch (IOException e) {
				e.printStackTrace();
			}
	  		 
	  		 //TestLog.log(LogStatus.INFO, TestLog.addScreenCapture(Filepath));
	  	 }
	  	 
	  	 
	     public String getSystemDate(){
	    	
	    	
	    	 String systemdate = driver.findElement(By.xpath("//*[@id='header1']/div[2]/li[2]")).getText();
	    	 systemdate =	 systemdate.substring(5);
			  return systemdate;
	    	 
	     }
	     
	     
	     
	         
	     
	     public Boolean verifyActionMessage(String actualActionMessage , String expectedActionMessage){
	    	 
    	    
    	   	 
    	   	 if(actualActionMessage.contains(expectedActionMessage)){
    		
    	   		 //TestLog.log(LogStatus.PASS, testLogActionMessageString(" [ Method = verifyActionMessage ] " + " [ Actual Contains Expected = true ] "  + " [ Actual Action Message  = " + actualActionMessage  + " ] " + " [ Expected Action Message  = " + expectedActionMessage  + " ] " , Configuration.GreenColour) );
    		     return true;
    	   	 }   else {
    	   		 
    	   		 //TestLog.log(LogStatus.FAIL, testLogActionMessageString(" [ Method = verifyActionMessage ] " + " [ Actual Contains Expected = false ] "  + " [ Actual Action Message  = " + actualActionMessage  + " ] " + " [ Expected Action Message  = " + expectedActionMessage  + " ] " , Configuration.RedColour) );
    		     return false;
    	   		 
    	   	 }
    		
     }
	     
	     
    public void Alert(String actiononAlert){
    	
    	if(isAlertPresent()){
    	  
    	  String AlertText = driver.switchTo().alert().getText();
    	
       if(actiononAlert.equals("Accept")) {	
    
    	   driver.switchTo().alert().accept();
    	   //TestLog.log(LogStatus.INFO, " [ Method = Alert ] " + " [ Alert Accepted = true ] "  + " [ Alert Text  = " + AlertText  + " ] " );
    	   
       }else if(actiononAlert.equals("Dismiss")){
    	 
    	 
    	   driver.switchTo().alert().dismiss();
    	   //TestLog.log(LogStatus.INFO, " [ Method = Alert ] " + " [ Alert Dismissed = true ] "  + " [ Alert Text  = " + AlertText  + " ] " );
       }
    	}	
     }
	 
    public boolean isAlertPresent() 
  
    { 
        try 
        { 
            driver.switchTo().alert(); 
            
            return true; 
        }   // try 
        catch (Exception e) 
        { 
            return false; 
        }   // catch 
    
    }
	     
      public void clickUsingJavaScriptExecutor(String scriptName, String variableName){
    	  
    	  
    	  
    	  try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
			  javascriptExecutor.executeScript(scriptName);
			  //TestLog.log(LogStatus.PASS, " [ Method = clickUsingJavaScriptExecutor ] " + " [ " +  variableName + " ] " +  " [ Clicked = true ] "  + " [ Java Script Name  = " + scriptName  + " ] "  );
		} catch (Exception e) {
			  //TestLog.log(LogStatus.FAIL, " [ Method = clickUsingJavaScriptExecutor ] "  + " [ " +  variableName + " ] " + " [ Clicked = false ] "  + " [ Java Script Name  = " + scriptName  + " ] " );
			e.printStackTrace();
		}
    	  
      }
    
	     
		 
 /****************************************************************************Core Java Methods ***********************************************************************/ 
		 
		 
			/*
			 * Author : Arpan Saini
			 * Purpose : To replace something in actual string with some other String
			 * */
		 
		 public String getReplacedString(String Acutal , String Replace){
				                                     
				String FinalString = Acutal.replace("[!commontext]", Replace);
				return FinalString;
				
			}
		 
		 
	     /*
	      * Author : Arpan Saini
	      * Purpose : To get the x month anniversary date from the date passed as argument for Future date add months in Positive integer to get the pastdate add the months in negative Integer
	      * 
	      * */
	    public String getXMonthAnniversaryDate(String Date , int Months){
		
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	            cal.add(Calendar.MONTH, Months);
	            Date dt1 = cal.getTime();
	            return sdf.format(dt1);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null;
	        }
		
	    }
	     
	    /*
	     * Author : Arpan Saini
	     * Purpose : To get the x Days anniversary date from the date passed as argument for Future date add days in Positive integer to get the past date add the days in negative Integer
	     * 
	     * */
	    
	    
	    public String getXdaysAnniversaryDate(String Date , int days){
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	            cal.add(Calendar.DAY_OF_MONTH, days);
	            Date dt1 = cal.getTime();
	            return sdf.format(dt1);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null;
	        }
		
	    }
	    
	    
	    /*
	     * Author : Arpan Saini
	     * Purpose : To get the x Year anniversary date from the date passed as argument for Future date add Years in Positive integer to get the past date add the Year in negative Integer
	     * 
	     * */
	    
	    
	    public String getXYearAnniversaryDate(String Date , int years){
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	            cal.add(Calendar.YEAR, years);
	            Date dt1 = cal.getTime();
	            return sdf.format(dt1);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return null;
	        }
		
	    }
	    
	    
	    
	    /*
	     * Author : Arpan Saini
	     * Purpose : To get the x Year from current the year of argument Date  
	     * */
	    
	    
	    public String getXYearFromCurrentYear(String Date , int years){
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	           
	            int FinalYear =  cal.get(Calendar.YEAR);
	           
	            FinalYear = FinalYear + years;
	            String finalYear =   String.valueOf(FinalYear);
	            return finalYear;
	         
	        } catch (Exception e) {
	         
	        	e.printStackTrace();
	            return null;
	        }
		
	    }
	    
	    
	    /*
	     * Author : Arpan Saini
	     * Purpose : To get the x Months from current the year of argument Date  
	     * */
	    
	    
	    public String getXMonthsFromCurrentMonth(String Date , int Months){
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	           
	            int FinalMonth =  cal.get(Calendar.MONTH);
	           
	            FinalMonth = FinalMonth + Months;
	            String finalMonth =   String.valueOf(FinalMonth);
	            return finalMonth;
	         
	        } catch (Exception e) {
	         
	        	e.printStackTrace();
	            return null;
	        }
		
	    }
	    
	    
	    /*
	     * Author : Arpan Saini
	     * Purpose : To get the x Year from current the year of argument Date  
	     * */
	    
	    
	    public String getXDaysFromCurrentDay(String Date , int Days){
	    	
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            Calendar cal = Calendar.getInstance();
	            Date dt =   sdf.parse(Date);
	            cal.setTime(dt);
	           
	            int FinalDay =  cal.get(Calendar.DAY_OF_MONTH);
	           
	            FinalDay = FinalDay + Days;
	            String finalDay =   String.valueOf(FinalDay);
	            return finalDay;
	         
	        } catch (Exception e) {
	         
	        	e.printStackTrace();
	            return null;
	        }
		
	    }
	    
	    
	    /*
	     * Input eg , Miniumum = 1000000000L , Max Vaue 9999999999L then it will return the value between 10000000000 < x < 9999999999
	     * 
	     * */
	    
	    public static String getRandomNumber(long MinimumNumber , long maxium){
	 	   
	 	   Random random = new Random();
	 	   
	 	   long randomNumber =  Math.abs(random.nextLong() % (maxium - MinimumNumber) + maxium);
           String randomString =  Long.toString(randomNumber);
           
           int Length = randomString.length();
           if(Length == 9){
        	   
        	   return randomString + "1";
           }else if(Length == 10){
	 	   
        	   return randomString ;
           }else
	               	return randomString.substring(1, 11);
	 	    }
	 
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
				
		  
				 public String testLogActionMessageString(String Message , String Color){
						
		        	 if(Color.equals("green"))
			         return "<p><span style='font-weight:bold; color:green; font-size:120%'>" + Message + "</span></p>" ;
		        	 else if(Color.equals("red"))
		        	 return "<p><span style='font-weight:bold; color:red; font-size:120%'>" + Message + "</span></p>" ;
		        	 else if(Color.equals("blue"))
			         return "<p><span style='font-weight:bold; color:blue; font-size:120%'>" + Message + "</span></p>" ;
		        	 
		        	 return "<p><span style='font-weight:bold; color:white; font-size:120%'>" + Message + "</span></p>" ;
		     
					}
	    
}

