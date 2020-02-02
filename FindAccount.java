package week2day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class FindAccount {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
        driver.findElementByLinkText("CRM/SFA").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByLinkText("Accounts").click();
        driver.findElementByLinkText("Find Accounts").click();
        driver.findElementByXPath("(//input[@name='accountName'])[2]").sendKeys("Credit Limited Account");
        driver.findElementByXPath("(//button[@class='x-btn-text'])[7]").click();
        driver.findElementByLinkText("accountlimit100").click();
        driver.findElementByLinkText("Edit").click();
        if(driver.findElementById("accountName").getAttribute("value").equals("Credit Limited Account"))
        {
        	System.out.println(driver.findElementById("accountName").getAttribute("value"));
        }
        System.out.println(driver.findElementByName("description").getText());
        if(driver.getTitle().equals("Edit Account | opentaps CRM"))
        {
        	System.out.println("Title Verified");
        }
	}

}
