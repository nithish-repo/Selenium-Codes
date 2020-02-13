package week3day1Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClearTrip {

	public static void main(String[] args) throws Exception{
		
		BrowserSuperClass urlobj=new BrowserSuperClass();
		urlobj.openbrowser("Chrome", "https://www.cleartrip.com/");
		urlobj.driver.findElementById("RoundTrip").click();
		urlobj.driver.findElement(By.id("FromTag")).sendKeys("Chennai", Keys.TAB);
		urlobj.driver.findElementById("ToTag").sendKeys("New York",Keys.TAB);
		urlobj.driver.findElementById("DepartDate").click();
		WebElement DateTable=urlobj.driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> DateTable1=DateTable.findElements(By.className("calendar"));
		//System.out.println(DateTable1.size());
	    WebElement FirstDateTable=DateTable1.get(0);
	    List<WebElement> FirstDateRow= FirstDateTable.findElements(By.tagName("tr"));
	    WebElement FirstDate=FirstDateRow.get(5);
	    List<WebElement> DateColumns=FirstDate.findElements(By.xpath("//td[@data-handler='selectDay']")); 
	    //System.out.println(DateColumns.size());
		DateColumns.get(0).click(); 
		urlobj.driver.findElement(By.id("ReturnDate")).click();
		WebElement DateTable2=urlobj.driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> DateTable3=DateTable2.findElements(By.className("calendar"));
		//System.out.println(DateTable1.size());
	    WebElement FirstDateTable2=DateTable3.get(0);
		Thread.sleep(1000);
		List<WebElement> FirstDateRow2=FirstDateTable2.findElements(By.tagName("tr")); 
		WebElement FirstDate2=FirstDateRow2.get(5); 
		List<WebElement> DateColumns2=FirstDate2.findElements(By.xpath("//td[@data-handler='selectDay']"));
		//WebDriverWait wait=new WebDriverWait(urlobj.driver, 10000);
	    //wait.until(ExpectedConditions.elementToBeSelected(DateColumns.get(1)));
		DateColumns2.get(1).click();
		WebElement Adults=urlobj.driver.findElementById("Adults");
		Select Dropdown1=new Select(Adults);
		Dropdown1.selectByIndex(1);
		WebElement Childrens=urlobj.driver.findElementById("Childrens");
		Select Dropdown2=new Select(Childrens);
		Dropdown2.selectByIndex(1);
		WebElement Infants=urlobj.driver.findElementById("Infants");
		Select Dropdown3=new Select(Infants);
		Dropdown3.selectByIndex(1);
		urlobj.driver.findElementById("MoreOptionsLink").click();
		urlobj.driver.findElementById("Class").click();
		urlobj.driver.findElementByName("airline").sendKeys("Emirates", Keys.TAB);
		urlobj.driver.findElementById("SearchBtn").click();
	}

}
