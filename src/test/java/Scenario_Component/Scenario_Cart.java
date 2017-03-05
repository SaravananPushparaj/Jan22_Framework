package Scenario_Component;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;

public class Scenario_Cart extends Base_Class {
	
	public static Logger Log= Logger.getLogger(Scenario_Cart.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_AddCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testAddCart(Map Cart) throws IOException, InterruptedException
	{
		
		String TC_ID = Cart.get("TC_ID").toString();
		String Order_Set = Cart.get("Order_Set").toString();
		String Search_Item = Cart.get("Search_Item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob=new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_txtbox, 20);
		BC_Pob.Click_Search();
		
		Explicit_wait(BC_Pob.Search_itemtxtbox, 20);
		BC_Pob.Enter_Searchitem(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 20);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_img, 20);
		BC_Pob.Click_Cartimg();
		
		Explicit_wait(BC_Pob.AddCart_msg, 20);
		String Actual_Result = BC_Pob.getAddCartmsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			Log.info("Passed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
		}
		else
		{
			Log.info("Failed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}
	
	@Test(dataProvider="dp_DeleteCart", dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void testDeleteCart(Map Cart) throws IOException, InterruptedException
	{
		String TC_ID = Cart.get("TC_ID").toString();
		String Order_Set = Cart.get("Order_Set").toString();
		String Search_Item = Cart.get("Search_Item").toString();
		String Exp_Result = Cart.get("Exp_Result").toString();
		
		
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob=new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_txtbox, 20);
		BC_Pob.Click_Search();
		
		Explicit_wait(BC_Pob.Search_itemtxtbox, 20);
		BC_Pob.Enter_Searchitem(Search_Item);
		
		Explicit_wait(BC_Pob.Add_btn, 20);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_img, 20);
		BC_Pob.Click_Cartimg();
		
		Explicit_wait(BC_Pob.Delete_btn, 20);
		BC_Pob.Click_Deletebtn();
		
		Explicit_wait(BC_Pob.Delete_msg, 20);
		String Actual_Result = BC_Pob.getDeletemsg();
		
		if(Actual_Result.equals(Exp_Result))
		{
			Log.info("Passed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
		}
		else
		{
			Log.info("Failed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
			Capture_Screenshot1(TC_ID, Order_Set);
			sAssert.fail("Failed as Actual Result is  "+Actual_Result + "  Expected Result is  " +Exp_Result);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
		
		
	}

}
