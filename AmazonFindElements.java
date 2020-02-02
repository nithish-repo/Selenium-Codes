package week2day2;



import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonFindElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElementById("twotabsearchtextbox").sendKeys("USI punching bag",Keys.ENTER);
		driver.findElementByXPath("(//label)[6]/i").click();
		List<WebElement> baglist=driver.findElementsByXPath("//span[@class='a-size-base-plus a-color-base a-text-normal']");
		System.out.println(baglist.size());
		for(int i=0;i<baglist.size();i++)
		{
			System.out.println(baglist.get(i).getText());
		}
        driver.close();
	}

}
