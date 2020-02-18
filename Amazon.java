package projectDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Disable all browser notifications
		ChromeOptions obj = new ChromeOptions();
		obj.addArguments("--disable-notifications");
		//Launching URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus 7 pro mobiles", Keys.ENTER);
		System.out.println(driver.findElementByXPath("(//span[@class='a-price-whole'])[1]").getText());
		driver.findElementByXPath("//img[@alt='OnePlus 7 Pro (Nebula Blue, 8GB RAM, Fluid AMOLED Display, 256GB Storage, 4000mAH Battery)']").click();
		Set<String> multiple=driver.getWindowHandles();
		List<String> getwindow= new ArrayList<String>(multiple);
		driver.switchTo().window(getwindow.get(1));
		System.out.println(driver.findElementById("acrCustomerReviewText").getText());
		driver.findElementByXPath("//input[@value='Add to Cart']").click();
		//driver.switchTo().frame(driver.findElement(by))
		//driver.findElementByXPath("//div[@class='a-box-inner a-alert-container']/h4").getText();
		Thread.sleep(10000);
		System.out.println(driver.findElementByXPath("(//h4[@class='a-alert-heading'])[3]").getText());
		
		  if(driver.findElementByXPath("(//h4[@class='a-alert-heading'])[3]").getText().toString().equals("Added to Cart")) 
		  {
		  Thread.sleep(3000);
		  driver.findElementByXPath("(//input[@class='a-button-input'])[5]").click();
		  System.out.println(driver.getTitle());
		  driver.findElementByXPath("//input[@id='continue']").click();
		  Thread.sleep(2000);
		  if(driver.findElementByXPath("//div[@id='auth-email-missing-alert']").getText().toString().contains("Enter your email or mobile phone number"))
		  {
			  System.out.println("Verified");
			  driver.quit();
		  }
			
			  else { System.out.println("Not Verified"); driver.quit(); }
			 
		  }
		 
		

	}

}
