package week3day1Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserSuperClass implements BrowserInterface{

	public RemoteWebDriver driver;
	@Override
	public void openbrowser(String browser, String url) {
				
		if(browser=="Chrome")
		{
		    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		    driver=new ChromeDriver();
		}
		if(browser=="Firefox")
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/geckodriver_64 bit.exe");
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

}
