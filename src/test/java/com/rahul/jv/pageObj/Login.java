package com.rahul.jv.pageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Login {
	private By emailTxt;
	//=By.name("email");
	private By passwordtxt;
	//=By.name("password");
	private By submitbtn;
	//=By.name("commit");
	private By profileby;
	//=By.xpath("//span[@class=\"navbar-current-user\"]");
	WebDriver driver;
	

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	
	}

	public WebElement getemailTxt() {
		
		return driver.findElement(emailTxt);
		
	}
    public void setemailTxt() {
	emailTxt=By.name("email");
		
	}
    public WebElement getpasswordtxt() {
		
		return driver.findElement(passwordtxt);
		
	}
    public void setpasswordtxt() {
    	passwordtxt=By.name("password");
		
	}
    
    /*Example for set from xl sheet
    public void setpasswordt(String bymetd, String value) {
    	
    	if(bymetd.equals("name"))
    	{
    		passwordtxt=By.name(value);
    		
    	}
    	else if(bymetd.equals("xath"))
    	{
    		passwordtxt=By.xpath(value);
    		
    	}
    	else if(bymetd.equals("id"))
    	{
    		passwordtxt=By.id(value);
    		
    	}
		
		
	}*/

public WebElement getsubmitbtn() {
	
	return driver.findElement(submitbtn);
	
}
public void setsubmitbtn() {
	submitbtn=By.name("commit");
	
}

public WebElement getprofileby() {
	
	return driver.findElement(profileby);
	
	
}
public void setprofileby() {
	profileby=By.xpath("//span[@class=\"navbar-current-user\"]");
	
}


}
