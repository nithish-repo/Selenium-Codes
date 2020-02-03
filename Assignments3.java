package week2Asignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignments3 {

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
        driver.findElementByXPath("(//a[@class='x-tab-right'])[2]").click();
        driver.findElementByName("phoneNumber").sendKeys("9003187314");
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(5000);
        //WebDriverWait wait= new WebDriverWait(driver, 1000);
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]")));
        String str=driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]").getText();
        driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a)[1]").click();
        driver.findElementByLinkText("Delete").click();
        driver.findElementByLinkText("Find Leads").click();
        driver.findElementByName("id").sendKeys(str);
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        if(driver.findElementByXPath("//div[text()='No records to display']").getText().equals("No records to display"))
        {
        	System.out.println("This message confirms the successful deletion");
        }
        driver.close();

	}

}
