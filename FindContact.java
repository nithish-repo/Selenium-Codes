package week2Asignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FindContact {

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
        driver.findElementByLinkText("Find Contacts").click();
        driver.findElementByXPath("//span[text()='Email']").click();
        driver.findElementByName("emailAddress").sendKeys("nithish@gmail.com");
        driver.findElementByXPath("//button[text()='Find Contacts']").click();
        Thread.sleep(5000);
        driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName '])[1]//a").click();
        System.out.println(driver.findElementById("viewContact_firstName_sp").getText());
        driver.findElementByXPath("//a[text()='Edit']").click();
        WebElement Marketing=driver.findElementById("addMarketingCampaignForm_marketingCampaignId");
        Select dpdown= new Select(Marketing);
        dpdown.selectByValue("9000");
        driver.findElement(By.xpath("//input[@value='Add']")).click();
        driver.findElement(By.name("departmentName")).sendKeys("Selenium Automation Testing");
        driver.findElement(By.xpath("//input[@value='Update']")).click();
        String str=driver.findElementById("viewContact_marketingCampaigns_sp").getText();
        if(str.contains("eCommerce Site Internal Campaign"))
        {
        	System.out.println("Updated Marketing Campaign verified");
        	System.out.println(driver.getTitle());
        	driver.close();
        }
	}

}
