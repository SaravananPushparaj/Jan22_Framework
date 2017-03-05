package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Cart {
	
	public AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/homePageSearchBox")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_itemtxtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnAddToBasket")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/basketimageview")
	public WebElement Cart_img;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Delete_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	
	
	public PageObject_Cart(AppiumDriver driver)
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
		
		
		public void Click_Addbtn()
		{
			Add_btn.click();
			
		}
	
		
		public void Click_Cartimg()
		{
			Cart_img.click();
			
		}
		
		
		public String getAddCartmsg()
		{
			return AddCart_msg.getText();
			
		}
		
		
		public void Click_Deletebtn()
		{
			Delete_btn.click();
			
		}
		
		public String getDeletemsg()
		{
			return Delete_msg.getText();
			
		}
	

}
