package week2day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

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
        driver.findElementByLinkText("Create Account").click();
        driver.findElementByXPath("//input[@id='accountName']").sendKeys("Nithish");
        driver.findElementByName("description").sendKeys("Selenium Automation Tester");
        driver.findElementByXPath("//input[@name='groupNameLocal']").sendKeys("JN");
        driver.findElementByXPath("(//input[@class='inputBox'])[4]").sendKeys("TBD");
        driver.findElementByXPath("(//input[@class='inputBox'])[5]").sendKeys("2345000");
        driver.findElementByName("industryEnumId").sendKeys("Computer Software");
        WebElement Ownership=driver.findElementByName("ownershipEnumId");
        Select drop1= new Select(Ownership);
        drop1.selectByVisibleText("S-Corporation");
        WebElement Source=driver.findElementById("dataSourceId");
        Select drop2= new Select(Source);
        drop2.selectByValue("LEAD_EMPLOYEE");
        WebElement Marketing=driver.findElementById("marketingCampaignId");
        Select drop3= new Select(Marketing);
        drop3.selectByIndex(6);
        WebElement State=driver.findElementByName("generalStateProvinceGeoId");
        Select drop4= new Select(State);
        drop4.selectByValue("TX");
        driver.findElementByXPath("//input[@value='Create Account']").click();
	}

}
