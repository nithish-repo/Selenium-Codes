package week3day2Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import week3day1Assignments.BrowserSuperClass;

public class Frames {

	public static void main(String[] args) {
		BrowserSuperClass urlobj=new BrowserSuperClass();
		urlobj.openbrowser("Chrome", "http://leafground.com/pages/frame.html");
		urlobj.driver.switchTo().frame(urlobj.driver.findElement(By.xpath("//iframe[@src='default.html']")));
		urlobj.driver.findElementByXPath("//button[text()='Click Me']").click();
		urlobj.driver.switchTo().defaultContent();
		urlobj.driver.switchTo().frame(urlobj.driver.findElement(By.xpath("//iframe[@src='page.html']")));
		urlobj.driver.switchTo().frame(urlobj.driver.findElement(By.id("frame2")));
		urlobj.driver.findElementByXPath("//button[text()='Click Me']").click();
		urlobj.driver.switchTo().defaultContent();
		List<WebElement> count=urlobj.driver.findElementsByTagName("iframe");
		System.out.println(count.size());
		urlobj.driver.close();
		

	}

}
