package week2day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindOppurtunities {

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
        driver.findElementByLinkText("Opportunities").click();
        driver.findElement(By.xpath("//a[text()='Find Opportunities']")).click();
        List<WebElement> table=driver.findElements(By.className("x-grid3-row-table"));
        for(int i=0; i<table.size(); i++)
        {
        	WebElement OppurtunityId= table.get(i);
        	System.out.println(OppurtunityId.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-salesOpportunityId x-grid3-cell-first ']//a")).getText());
        }
        if(driver.getTitle().equals("Find Opportunities | opentaps CRM"))
        {
        	System.out.println("Title of the Page Verified");
        }
        else
        {
        	System.out.println("Title of the Page is incorrect");
        }
        driver.close();

	}

}
