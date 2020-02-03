package week2day1;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeCheckbox {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();
		driver.findElementByXPath("//img[@alt='Checkbox']").click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElementByXPath("(//section[@class='innerblock']//input)[1]").click();
		driver.findElementByXPath("(//section[@class='innerblock']//input)[3]").click();
		driver.findElementByXPath("(//section[@class='innerblock']//input)[4]").click();
		if(driver.findElementByXPath("(//section[@class='innerblock']//input)[6]").isSelected())
			{
			 System.out.println("Selenium is checked");
			};
		driver.findElementByXPath("(//section[@class='innerblock']//input)[8]").click();
		List<WebElement> checkboxes=driver.findElementsByXPath("//input[@type='checkbox']"); 
		for(int i=8;i<14;i++)
		  
		  { checkboxes.get(i).click(); }
		 
		
	}

}
