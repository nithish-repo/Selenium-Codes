package projectDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.chrome.ChromeOptions;

public class ZoomCar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launching URL
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[@href='/chennai/search']").click();
		WebElement pickup=driver.findElementByClassName("component-popular-locations");
		List<WebElement> location=pickup.findElements(By.tagName("div"));
		location.get(2).click();
		driver.findElementByXPath("//button[@class='proceed']").click();
		//WebElement tommodate=driver.findElement(By.className("days"));
		//List<WebElement> date=
		String str=driver.findElement(By.xpath("(//div[@class='days']/div)[2]")).getText().toString().trim();
		System.out.println(str);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[@class='days']/div)[2]"))));
		driver.findElement(By.xpath("(//div[@class='days']/div)[2]")).click();
		WebElement timeList=driver.findElementByClassName("vue-slider-piecewise");
		List<WebElement> time=timeList.findElements(By.tagName("li"));
		String time1=time.get(12).getText().toString();
		System.out.println(time1);
		time.get(12).click();
		//System.out.println(date.get(1));
		//date.get(2).click();
		driver.findElementByXPath("//button[@class='proceed']").click();
		Date date = new Date(); // Get the current date
		DateFormat sdf = new SimpleDateFormat("dd"); //Get only the date (and not month, year, time etc)
		String today = sdf.format(date); // Get today's date
		int tomorrow = Integer.parseInt(today)+1; // Convert to integer and add 1 to it
		System.out.println(tomorrow); // Print tomorrow's date
		String tomo = Integer.toString(tomorrow);
		if(driver.findElementByXPath("(//div[@class='label time-label'])[1]").getText().toString().contains(tomo))
		{
			driver.findElementByClassName("proceed").click();
		}
		else
		{
			System.out.println("Start date is incorrect");
		}
		List<WebElement> priceList=driver.findElementsByXPath("//div[@class='price']");
		List<WebElement>  bookCar=driver.findElementsByName("book-now");
		List<String> priceConvert= new ArrayList<String>();
		for(int i=0; i<priceList.size();i++)
		{
	         priceConvert.add(priceList.get(i).getText().toString().replaceAll("[^0-9]", "").trim());
	         System.out.println(priceConvert.get(i));
		}
		List<Integer> max = new ArrayList<Integer>();
		for(String maximum : priceConvert)
		{
			int i=Integer.parseInt(maximum);
			max.add(i);
		}
		
		Integer j=Collections.max(max);
		System.out.println(j);
		for(int i=0; i<priceList.size();i++)
		{
			if(j.equals(max.get(i)))
			{
				bookCar.get(i).click();
				driver.close();
			}
		}
		

	}

}
