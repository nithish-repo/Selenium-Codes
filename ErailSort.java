package week3day1;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import week3day1Assignments.BrowserSuperClass;

public class ErailSort {

	public static void main(String[] args) {
		BrowserSuperClass url=new BrowserSuperClass();
		url.openbrowser("Chrome", "https://erail.in/");
        url.driver.findElementByXPath("//td[@id='tdDateOnly']/input").click();
        url.driver.findElementById("txtStationFrom").clear();
        url.driver.findElementById("txtStationFrom").sendKeys("MAS", Keys.TAB);
        url.driver.findElementById("txtStationTo").clear();
        url.driver.findElementById("txtStationTo").sendKeys("CBE", Keys.TAB);
        url.driver.findElementById("buttonFromTo").click();
        url.driver.findElementByXPath("//td[@id='tdDateOnly']/input").click();
        WebElement table=url.driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']");
        List<WebElement> rows=table.findElements(By.xpath("//tr[@onmouseout='HideCalendar()']"));
        List<String> Trainnames=new ArrayList<String>();
        for(int i=0;i<rows.size();i++)
        {
         WebElement	row=rows.get(i);
         List<WebElement> secondcolumn=row.findElements(By.tagName("td"));
         Trainnames.add(secondcolumn.get(1).getText().toString());
        }
        System.out.println(Trainnames.size());
        Collections.sort(Trainnames);
        for(String sort : Trainnames)
        {
		System.out.println(sort);
        }
	}

}
