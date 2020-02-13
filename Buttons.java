package week2Asignments;

import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.findElementById("home").click();
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		System.out.println(driver.findElementByXPath("//button[@id='position']").getLocation());
		System.out.println(driver.findElementById("color").getCssValue("background-color"));
		System.out.println(driver.findElementById("size").getSize());
		

	}

}
