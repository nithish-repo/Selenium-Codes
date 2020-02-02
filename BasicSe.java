package week2day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSe {

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
        driver.findElementByClassName("smallSubmit").click();
        String x= new String(driver.getTitle());
        System.out.println(x);
        
        
        
        
	}

}
