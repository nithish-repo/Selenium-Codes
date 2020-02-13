package week3day2;

import java.io.File;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import week3day1Assignments.BrowserSuperClass;

public class HandleWindows {

	public static void main(String[] args) throws Exception {
		BrowserSuperClass urlobj=new BrowserSuperClass();
		urlobj.openbrowser("Chrome", "https://www.irctc.co.in/nget/train-search");
		urlobj.driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		urlobj.driver.findElementByLinkText("Contact Us").click();
		Set<String> mulwindows=urlobj.driver.getWindowHandles();
		List<String> convert= new ArrayList<String>(mulwindows);
		System.out.println(urlobj.driver.switchTo().window(convert.get(1)).getTitle());
		File src=urlobj.driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/img1.jpg");
		FileUtils.copyFile(src, dest);
		urlobj.driver.switchTo().window(convert.get(0));
		urlobj.driver.close();
		
	}

}
