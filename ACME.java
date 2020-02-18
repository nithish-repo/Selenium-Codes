package projectDay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACME {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com", Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(1000);
		WebElement mouse=driver.findElementByXPath("//button[text()=' Vendors']");
		WebElement search=driver.findElementByXPath("//a[text()='Search for Vendor']");
		Actions builder=new Actions(driver);
		builder.moveToElement(mouse).perform();
		Thread.sleep(2000);
		builder.click(search).perform();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElement(By.id("buttonSearch")).click();
		WebElement table=driver.findElementByClassName("table");
		List<WebElement> data=table.findElements(By.tagName("tr"));
		WebElement secondrow=data.get(1);
		List<WebElement> country=secondrow.findElements(By.tagName("td"));
		System.out.println(country.get(4).getText());
		driver.findElementByXPath("//a[text()='Log Out']").click();
		driver.close();

	}

}
