package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<Object[]> getAddCarttestdata() throws IOException
	{
		
		List<Object[]> Obj = flagRowCount("AddCart");
		return Obj.iterator();
		
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<Object[]> getDeleteCarttestdata() throws IOException
	{
		
		List<Object[]> Obj = flagRowCount("DeleteCart");
		return Obj.iterator();
		
	}
	
	
	public static List<Object[]> flagRowCount(String Scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Jan22_BB_Project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		int ColCount = xl.getcolcount(Scenario_Cart, 0);
		
		List<Object[]> List_Cart=new ArrayList<Object[]>();
		
		for(int iRow=1;iRow<=RowCount;iRow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Cart, iRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, iRow, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(Scriptname)))
			{
				Map<String,String> dcMap=new HashMap<String,String>();
				
				for(int jCol=0;jCol<=ColCount;jCol++)
				{
					
					String Skey = xl.Readvalue(Scenario_Cart, 0, jCol);
					String Value = xl.Readvalue(Scenario_Cart, iRow, jCol);
					
					dcMap.put(Skey, Value);
					
					
				}//end of col for loop
				
				Object[] x= new Object[1];
				x[0]=dcMap;
				List_Cart.add(x);
				
				
			}//end of if 
			
		}//end of for loop of row
		
		
		return List_Cart;
		
		
	}
	
	
	
	
	

}
