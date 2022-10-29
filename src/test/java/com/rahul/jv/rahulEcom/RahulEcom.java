package com.rahul.jv.rahulEcom;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rahul.jv.pageObj.EditProfile;
import com.rahul.jv.pageObj.Login;
import com.rahul.jv.utility.ExcelUtils;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class RahulEcom {
	
	static String email="sk.baji3828@gmail.com";
	static String password="Afzal@9966";
	static By userProfile=By.xpath("//span[@class=\"navbar-current-user\"]");
	static String streetAddress="Madhura Nagar";
	static String city="Hydrabad";
	static String pincode="522006";
			

	static WebDriver driver;
	static WebDriverWait wait ;
	static RahulEcom rahul;
	Login log;
	EditProfile profil;
	
	 //Create an object of File class to open xlsx file
    File file;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		 try {
			try {
				rahul=new RahulEcom();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rahul.launchdriver("chromes");
			//river.get(rahul.readPropertie("url"));
			//rahul.login(new Login(driver));
			
			//rahul.editProfileName();
			//driver.navigate().back(); 
			
			// rahul.editAddrase();
			//driver.navigate().back();  98uy69https://attendee.gotowebinar.com/register/7943606899478530317
			//rahul.editeConatct();
			//rahul.close();
		rahul.readPropertie("url");
		
	}
	
	
	//LaunchDriver
	public  void launchdriver(String browser) throws InterruptedException, IOException {
		System.out.println("invoking Driver is "+browser);
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(rahul.readPropertie("url"));
		Thread.sleep(3000);
		 try {
			captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//ExplisitWait
	public  void expWait(By profileby, String condotin){
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		
		if (condotin.contains("visibility")){
		wait.until(ExpectedConditions.visibilityOfElementLocated(profileby));
		}
		
		else if (condotin.contains("ToBeClickable")){
			wait.until(ExpectedConditions.elementToBeClickable(profileby));
			}
		else if (condotin.contains("ToBeSelected")){
			wait.until(ExpectedConditions.elementToBeSelected(profileby));
			}
		
		
	}

	
	//login
	public  void login(Login login) throws IOException {
		/*page
	Elements
		     */
		//log=new Login();
		WebElement loginbutton=driver.findElement(By.xpath("//a[@class=\"theme-btn register-btn\"]"));
		highLightElement(loginbutton);
		loginbutton.click();
		checkTitile("Rahul Shetty Academy");
		
		login.setemailTxt();
		highLightElement(login.getemailTxt());
		login.getemailTxt().sendKeys(rahul.readPropertie("email"));
		//By emailTxt=By.name("email");
		//driver.findElement(emailTxt).sendKeys(rahul.readPropertie("email"));
		//driver.findElement(login.getemailTxt()).sendKeys(rahul.readPropertie("email"));
		
		
		login.setpasswordtxt();
		highLightElement(login.getpasswordtxt());
		login.getpasswordtxt().sendKeys(rahul.readPropertie("password"));
		//driver.findElement(login.getpasswordtxt()).sendKeys(rahul.readPropertie("password"));
		
		login.setsubmitbtn();
	    login.getsubmitbtn().click();
		System.out.println("Login Button Clicked");
		//driver.findElement(login.getsubmitbtn()).click();

		
		//Explisitwait Method
	
		By profileby=By.xpath("//span[@class=\"navbar-current-user\"]");
		expWait(profileby,"visibility");
		System.out.println("ExpWait Exicuted");
		
	
		//Assertion 
		WebElement profileName=driver.findElement(profileby);
		
		String profileTxt=profileName.getText();
		System.out.println("profile Name="+profileTxt);
		
		assertTrue(profileTxt.equals("Shaik Baji"));
		String currentUrl=driver.getCurrentUrl();
		System.out.println("get url"+currentUrl);
		Assert.assertTrue(currentUrl.contains("rahulshettyacadem"));
		 try {
				captureScreenshot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	//EditProfileName
	public  void editProfileName() throws IOException {
		
		/*page name: Profile Elements
	
		By profile  		=By.xpath("//a[@href=\"/current_user/profile\"]");
		By clickEdit 		=By.xpath("//a[@class=\"bodySmall edit-btn btn \"]");
		By changeName		=By.xpath("//input[@id=\"edit-user-name\"]");
		By saveBtn			=By.name("button");
			 
		*/
		
		//Action on element
		profil=new EditProfile(driver);
		
		driver.findElement(userProfile).click();
		
		profil.seteditProfile();
		profil.geteditProfile().click();
		
		profil.setclickEditLnk();
		profil.getclickEditLnk().click();
		
		//Wait condition
		By editNameHeding=By.xpath("//h4[@class=\"heading4 m-b-4-xs\"]");
		expWait(editNameHeding,"visibility");
		
		//Assertion
		String txt=driver.findElement(editNameHeding).getText();
		
		assertTrue(txt.equals("Edit Name"));
		System.out.println(txt);
		
		
	    profil.setchangeName();
		//By changeName=By.xpath("//input[@id=\"edit-user-name\"]");
		
		WebElement fullName=profil.getchangeName();
		fullName.clear();
		fullName.sendKeys(rahul.readPropertie("profileName"));
		
		profil.setsaveBtn();
		profil.getsaveBtn().click();
		System.out.println("Edit Name Compleated");
		
		
	}
	public  void editAddrase() throws Exception {
		/*page Name: Address Elements
		By Adress=By.xpath("//a[@href=\"/current_user/address\"]");
		By cuntryElmnt=By.xpath("//select[@id=\"cardCountry\"]");
		By StreedAdressElmnt=By.xpath("//input[@id=\"billingStreetAddressLine1\"]");
		By AddressLine2Lnk= By.xpath("//div[@role=\"button\"]");
		By AddressLine2wait=By.xpath("//label[@for=\"billingStreetAddressLine2\"]");
		By AddressLine2Txt=By.xpath("//input[@id=\"billingStreetAddressLine2\"]");
	    */
		file =new File(".\\resource\\Address.xlsx");
		ExcelUtils.setExcelFile(file, "billingAddress");
		String cell1 =ExcelUtils.getCellData(1, 1);
		System.out.println("Xcell sheet data;"+cell1);
		
		driver.findElement(userProfile).click();
		
		By Adress=By.xpath("//a[@href=\"/current_user/address\"]");
		By cuntryElmnt=By.xpath("//select[@id=\"cardCountry\"]");
		By StreedAdressElmnt=By.xpath("//input[@id=\"billingStreetAddressLine1\"]");
		By DeliveryAddresscheckBox=By.xpath("//input[@type=\"checkbox\"]");
		
		
		
		driver.findElement(Adress).click();
		WebElement dropElmnt=driver.findElement(cuntryElmnt);
		dropElmnt.click();
		expWait(cuntryElmnt,"visibility");
		System.out.println("country clicked");
		
		//selectFromeDropDown(dropElmnt,"AD");
		System.out.println("country selected");
		// Create object of the Select class
		Select se = new Select(driver.findElement(By.xpath("//select[@id=\"cardCountry\"]")));			
		// Select the option with value 
		se.selectByValue("AD");
		
		driver.findElement(StreedAdressElmnt).sendKeys(streetAddress);
		
		WebElement cityElmnt=driver.findElement(By.id("billingCity"));
		cityElmnt.sendKeys(city);
		
		WebElement pincodElmnt=driver.findElement(By.id("billingPostalCode"));
		pincodElmnt.sendKeys(pincode);
		System.out.println("Pincode enterd");
		
		
		
		//Validate Checkbox isSelected method and click
		
		WebElement DeliveryAddresscheckBoxE = driver.findElement(DeliveryAddresscheckBox);
		boolean isSelected = DeliveryAddresscheckBoxE.isSelected();
				
		//performing click operation if element is not checked
		if(isSelected == false) {
			DeliveryAddresscheckBoxE.click();
		}
		
		By AddressLine2Lnk= By.xpath("//div[@role=\"button\"]");
	
		driver.findElement(AddressLine2Lnk).click();
		
		By AddressLine2wait=By.xpath("//label[@for=\"billingStreetAddressLine2\"]");
		expWait(AddressLine2wait,"visibility");
		
		By AddressLine2Txt=By.xpath("//input[@id=\"billingStreetAddressLine2\"]");
		driver.findElement(AddressLine2Txt).sendKeys(streetAddress);
		
		
		
	
	}
	
	public  void editeConatct() {
		/*page
		Elements
		By contact=By.xpath("//a[@href=\"/current_user/contact\"]");
		By conatctElmnt=By.name("subject");
		By messageElmnt=By.id("student_message");
			 
			     */
		System.out.println("going to enter contact");
		driver.findElement(userProfile).click();
		By contact=By.linkText("Contact");
		
		driver.findElement(contact).click();
		 
		By conatctElmnt=By.name("subject");
		expWait(conatctElmnt,"visibility");
		
		driver.findElement(conatctElmnt).sendKeys("shaikafzal9676@gmail.com");
		System.out.println("Email updated");
		
		By messageElmnt=By.id("student_message");
		WebElement messageElmntTxt =driver.findElement(messageElmnt);
		messageElmntTxt.sendKeys("Hi,"+Keys.ENTER+ "This is shaik Baji");
		System.out.println("Massage updated");
		
		
	
	}
	
	public  void selectFromeDropDown(WebElement dropDownElement ,String value ) {
		Select se = new Select(dropDownElement);
		
		// Select the option with value "6"
		se.selectByValue("value");
		
	}
	
	
	
	public  void checkTitile(String expectedTitle){
		String actualTitile= driver.getTitle();
		assertTrue(actualTitile.equals(expectedTitle));
		
		
	}
	 static void captureScreenshot() throws IOException {
		  Date d =new Date();

	        String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		  File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(screenshot, new File (".\\reports\\"+fileName));
		  System.out.println("Successfully Take screen shot of:"+fileName);
		  
		  
	  }
	
	
	


	public String readPropertie(String  useData) throws IOException {
		FileReader reader=new FileReader(".\\resource\\config.properties"); 
        Properties props=new Properties(); 
        props.load(reader);
        String actulData=props.getProperty(useData);
        System.out.println(actulData);
        return actulData;
	}
	
	public void highLightElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	    try {
	        Thread.sleep(1000);
	    } catch (InterruptedException e) {
	        System.out.println(e.getMessage());
	    } 

	    js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);  
	}

	public  void close() {
		System.out.println("closing driver");
		driver.close();
	}

}
