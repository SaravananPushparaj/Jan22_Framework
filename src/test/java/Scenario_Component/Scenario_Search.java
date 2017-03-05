package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	public static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();	
	
	@Test(dataProvider="dp_InvalidSearch" , dataProviderClass=DataProvider_Component.DataProvider_Search.class, groups={"smoke"})
	public void testInvalidSearch(Map Search) throws IOException, InterruptedException
	{
		
		String TC_ID = Search.get("TC_ID").toString();
		String Order_Set = Search.get("Order_Set").toString();
		String Search_Item = Search.get("Search_Item").toString();
		String Exp_Result = Search.get("Exp_Result").toString();
		
				
		Start_Server();
		Init_app();
		
		log.info("Executing the Testcase " +TC_ID + " Order set is "+Order_Set);
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox, 20);
		BS_Pob.Click_Search();
		
		Explicit_wait(BS_Pob.Search_itemtxtbox, 20);
		BS_Pob.Enter_Searchitem(Search_Item);
		
		Explicit_wait(BS_Pob.Invalid_msg, 20);
		String Actual_Result = BS_Pob.getInvalidResult();
				
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
	}

	
	
	@Test(dataProvider="dp_ValidSearch" , dataProviderClass=DataProvider_Component.DataProvider_Search.class, groups={"regression"})
	public void testValidSearch(Map Search) throws IOException, InterruptedException
	{
		
		String TC_ID = Search.get("TC_ID").toString();
		String Order_Set = Search.get("Order_Set").toString();
		String Search_Item = Search.get("Search_Item").toString();
		String Exp_Result = Search.get("Exp_Result").toString().replace(".0", "");
		
		Start_Server();
		Init_app();
		
		log.info("Executing the Testcase " +TC_ID + " Order set is "+Order_Set);
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox, 20);
		BS_Pob.Click_Search();
				
		Explicit_wait(BS_Pob.Search_itemtxtbox, 20);
		BS_Pob.Enter_Searchitem(Search_Item);
		
		Explicit_wait(BS_Pob.Valid_msg, 20);
		String Output = BS_Pob.getValidResult();
		String Actual_Result = Output.replace(" products", "");
		
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
		}
		else
		{
			log.info("Failed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is "+Actual_Result  + "  Expected Result is  " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
		
		
		
		
		
	}
}
