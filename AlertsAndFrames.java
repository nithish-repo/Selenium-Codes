package week3day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import week3day1Assignments.BrowserSuperClass;

public class AlertsAndFrames {

	public static void main(String[] args) {
		BrowserSuperClass urlobj=new BrowserSuperClass();
		urlobj.openbrowser("Chrome", "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		urlobj.driver.switchTo().frame("iframeResult");
		urlobj.driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert=urlobj.driver.switchTo().alert();
		String value="Nithish";
		alert.sendKeys(value);
		alert.accept();
		String str2=urlobj.driver.findElement(By.id("demo")).getText().toString();
		if(str2.contains(value))
		{
			System.out.println(str2);
		}
		else
		{
			System.out.println("User cancelled the prompt.");
		}
		urlobj.driver.switchTo().defaultContent();
        urlobj.driver.findElementByXPath("//button[text()='Run »']").click();
	}

}
