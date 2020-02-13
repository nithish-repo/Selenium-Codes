package week3day2;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import week3day1Assignments.BrowserSuperClass;

public class IRCTC {

	public static void main(String[] args) {
		BrowserSuperClass url= new BrowserSuperClass();
		url.openbrowser("Chrome", "https://www.irctc.co.in/");
		url.driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
		Set<String> tabs=url.driver.getWindowHandles();
		List<String> tab= new LinkedList<String>(tabs);
		url.driver.switchTo().window(tab.get(1));
		System.out.println(url.driver.getTitle());
		url.driver.switchTo().window(tab.get(0)).close();
		url.driver.switchTo().window(tab.get(1));
	    System.out.println(url.driver.findElementByXPath("//a[@class='mr-2 d-inline font-weight-bold']").getText());
        url.driver.close();
        
	}

}
