package com.rahul.jv.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfile {
	private By userProfile;
	//=By.xpath("//span[@class=\"navbar-current-user\"]");
	private By editProfile;
	//=By.xpath("//a[@href=\"/current_user/profile\"]");
	private By clickEditLnk;
	//=By.xpath("//a[@class=\"bodySmall edit-btn btn \"]");
	
	private By changeName;
	//=By.xpath("//input[@id=\"edit-user-name\"]");
	By saveBtn;
	//=By.name("button");
	WebDriver driver;

	public EditProfile(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void setuserProfile() {
		userProfile=By.xpath("//span[@class=\"navbar-current-user\"]");
		
	}
	public WebElement getuserProfile() {
		
		return driver.findElement(userProfile);
	}
	

		public void seteditProfile() {
			editProfile=By.xpath("//a[@href=\"/current_user/profile\"]");
			
		}
		public WebElement geteditProfile() {
			
			return driver.findElement(editProfile);
		}
		
		
		public void setclickEditLnk() {
			clickEditLnk=By.xpath("//a[@class=\"bodySmall edit-btn btn \"]");
			
		}
		public WebElement getclickEditLnk() {
			
			return driver.findElement(clickEditLnk);
		}
		
		
		
		public void setchangeName() {
			changeName=By.xpath("//input[@id=\"edit-user-name\"]");
		}
		public WebElement getchangeName() {
			
			return driver.findElement(changeName);
		}
		
		public void setsaveBtn() {
			saveBtn=By.id("submit-btn");
		}
		public WebElement getsaveBtn() {
			
			return driver.findElement(saveBtn);
		}
	
	

}
