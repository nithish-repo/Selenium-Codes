package week3day2Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import week3day1Assignments.BrowserSuperClass;

public class Windows {

	public static void main(String[] args) throws Exception {
		BrowserSuperClass urlobj=new BrowserSuperClass();
		urlobj.openbrowser("Chrome", "http://leafground.com/pages/Window.html");
		urlobj.driver.findElementById("home").click();
		urlobj.driver.findElementByXPath("//button[text()='Open Multiple Windows']").click();
		urlobj.driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windows1=urlobj.driver.getWindowHandles();
		List<String> windows1get= new ArrayList<String>(windows1);
		System.out.println(windows1get.size());
		for(int i=1; i<windows1.size();i++)
		{
			urlobj.driver.switchTo().window(windows1get.get(i));
			urlobj.driver.close();
		}
		
		urlobj.driver.switchTo().window(windows1get.get(0));
        urlobj.driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
        Thread.sleep(5000);
        Set<String> windows=urlobj.driver.getWindowHandles();
		List<String> windowsget= new ArrayList<String>(windows);
		System.out.println(windowsget.size());
		for(int i=0; i<windows.size();i++)
		{
			urlobj.driver.switchTo().window(windowsget.get(i));
			urlobj.driver.close();
		}
        
	}

}