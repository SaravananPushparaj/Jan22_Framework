package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Search {
	
	public AppiumDriver driver;
	
	//Second section
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_itemtxtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Invalid_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductCount")
	public WebElement Valid_msg;
	
	
	//first section
	public PageObject_Search(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	//Third section
	
	public void Click_Search()
	{
		Search_txtbox.click();
		
	}
	
	public void Enter_Searchitem(String Value)
	{
		
		Search_itemtxtbox.sendKeys(Value+ "\n");
	}
	
	public String getInvalidResult()
	{
		return Invalid_msg.getText();
	}
	
	public String getValidResult()
	{
		return Valid_msg.getText();
	}
	

}
