package week2Asignments;

import java.io.File;
//import java.io.IOException;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import com.google.common.io.Files;

public class CreateContact {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
        driver.findElementByLinkText("CRM/SFA").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByLinkText("Contacts").click();
        driver.findElementByLinkText("Create Contact").click();
        driver.findElementById("firstNameField").sendKeys("JayaNithish");
        driver.findElementById("lastNameField").sendKeys("G");
        driver.findElementById("createContactForm_firstNameLocal").sendKeys("Nithish");
        driver.findElementById("createContactForm_lastNameLocal").sendKeys("G");
        driver.findElementByName("departmentName").sendKeys("IT");
        driver.findElementByName("description").sendKeys("Nothing to say");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("nithish@gmail.com"); WebElement select1 =
		driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dpdown= new Select(select1); dpdown.selectByVisibleText("New York");
		driver.findElementByName("submitButton").click();
		driver.findElementByXPath("//a[text()='Edit']").click();
		driver.findElementById("updateContactForm_description").clear();
		driver.findElementById("updateContactForm_importantNote").sendKeys("Imporatant note to be noted");
        driver.findElementByXPath("//input[@value='Update']").click();
        File src=driver.getScreenshotAs(OutputType.FILE);
        File dest=new File("./Snaps/Contact.jpg");
        FileUtils.copyFile(src, dest);
        if(driver.getTitle().equals("View Contact | opentaps CRM"))
        {
        	System.out.println("Title Verified");
        	driver.close();
        }
        else
        {
        	System.out.println("Title not correct");
        	driver.close();
        }
        

	}

}
