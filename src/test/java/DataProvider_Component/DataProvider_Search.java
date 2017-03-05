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

public class DataProvider_Search {
	
	@DataProvider(name="dp_InvalidSearch")
	public static Iterator<Object[]> getInvalidSearchdata() throws IOException
	{
		List<Object[]> Obj = flagRowCount("InvalidSearch");
		return Obj.iterator();
		
	}
	
	

	@DataProvider(name="dp_ValidSearch")
	public static Iterator<Object[]> getValidSearchdata() throws IOException
	{
		List<Object[]> Obj = flagRowCount("ValidSearch");
		return Obj.iterator();
		
	}
	
	public static List<Object[]> flagRowCount(String Scriptname) throws IOException
	{
		
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Jan22_BB_Project\\TestData\\TestData.xls");
		HSSFSheet Scenario_Search = xl.Setsheet("Scenario_Search");
		
		int RowCount = xl.getrowcount(Scenario_Search);
		int ColCount = xl.getcolcount(Scenario_Search, 0);
		
		//Create a List of Object array
		List<Object[]> List_Search= new ArrayList<Object[]>();
		
		for(int iRow=1;iRow<=RowCount;iRow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Search, iRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Search, iRow, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(Scriptname)))
			{
				Map<String,String> dsMap= new HashMap<String,String>();
				
				for(int jcol=0;jcol<=ColCount;jcol++)
				{
					
					String Skey = xl.Readvalue(Scenario_Search, 0, jcol);
					String Value = xl.Readvalue(Scenario_Search, iRow, jcol);
					
					dsMap.put(Skey, Value);
					
				}//end of for
				
				Object[] x= new Object[1];
				x[0]=dsMap;
				List_Search.add(x);
				
			}//end of  if
			
		}//end of for
		
		
		return List_Search;
		
		
	}
	

}
