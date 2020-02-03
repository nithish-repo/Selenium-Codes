package week2Asignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) {
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
        driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Nithish");
        driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
        WebDriverWait wait= new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
        //Thread.sleep(4000);
        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
        System.out.println(driver.getTitle());
        driver.findElementByLinkText("Edit").click();
        driver.findElementByXPath("(//input[@name='companyName'])[2]").clear();
        driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("Accenture");
        driver.findElementByXPath("//input[@value='Update']").click();
        String str1=driver.findElementById("viewLead_companyName_sp").getText();
        if(str1.contains("Accenture"))
        {
        	System.out.println("Changesconfirmed");
        }
        driver.close();
        
	}

}
