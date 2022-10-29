package com.rahul.jv.rahulEcom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
	/* public static void main(String[] args) {
    System.out.println("Hello World!");
    
    System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://semantic-ui.com/examples/login");
    WebElement user= driver.findElement(By.name("email"));
    WebElement psword= driver.findElement(By.name("password"));
    WebElement loin= driver.findElement(By.xpath("//div[@class=\"ui fluid large teal submit button\"]"));
    user.sendKeys("user1");
    psword.sendKeys("pass1");
    loin.click();*/
    

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://toolsqa.com/automation-practice-table");
		
		//Here we are storing the value from the cell in to the string variable
		String sCellValue = driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[2]")).getText();
		System.out.println(sCellValue);
		
		// Here we are clicking on the link of first row and the last column
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[1]/td[6]/a")).click();        
		System.out.println("Link has been clicked otherwise an exception would have thrown");
		driver.close();
	}

  }
  
    
    
    
    
    
    