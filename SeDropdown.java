package week2day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeDropdown {
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
        driver.findElementByLinkText("Leads").click();
        driver.findElementByLinkText("Create Lead").click();
        driver.findElementById("createLeadForm_companyName").sendKeys("Test Leaf");
        driver.findElementById("createLeadForm_firstName").sendKeys("Jaya Nithish");
        driver.findElementById("createLeadForm_lastName").sendKeys("K G");
        WebElement Idstore=driver.findElementById("createLeadForm_dataSourceId");
        Select dropdown= new Select(Idstore);
        dropdown.selectByVisibleText("Employee");
        WebElement Marketing=driver.findElementByName("marketingCampaignId");
        Select dropdown1=new Select(Marketing);
        dropdown1.selectByValue("9001");
        WebElement Industry=driver.findElementByName("industryEnumId");
        Select dropdown2= new Select(Industry);
        List <WebElement> alloptions=dropdown2.getOptions();
        dropdown2.selectByIndex(alloptions.size()-2);
        WebElement Ownership=driver.findElementById("createLeadForm_ownershipEnumId");
        Select dropdown3= new Select(Ownership);
        dropdown3.selectByIndex(4);
        WebElement Country=driver.findElementById("createLeadForm_generalCountryGeoId");
        Select dropdown4=new Select(Country);
        dropdown4.selectByVisibleText("India"); 
        driver.findElementByClassName("smallSubmit").click();
        String x= new String(driver.getTitle());
        System.out.println(x);
        
        
        
        
	}

}
