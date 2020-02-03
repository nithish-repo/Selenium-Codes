package week2Asignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Assignments4 {

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
        driver.findElementByLinkText("Leads").click();
        driver.findElementByLinkText("Find Leads").click();
        driver.findElementByXPath("(//a[@class='x-tab-right'])[3]").click();
        driver.findElementByName("emailAddress").sendKeys("babu@testleaf.com");
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(5000);
        String Name=driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[1]").getText();
        driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]").click();
        driver.findElementByLinkText("Duplicate Lead").click();
        if(driver.getTitle().contains("Duplicate Lead"))
        {
        	System.out.println("Title Verified");
        }
        driver.findElementByXPath("//input[@value='Create Lead']").click();
        if(driver.findElementById("viewLead_firstName_sp").getText().equals(Name))
        {
        	System.out.println("Name Verified");
        }
        driver.close();        
        
        
	}

}
