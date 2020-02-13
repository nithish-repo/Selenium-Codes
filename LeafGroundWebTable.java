package week3day1Assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LeafGroundWebTable {

	public static void main(String[] args) {
		BrowserSuperClass url= new BrowserSuperClass();
		url.openbrowser("Chrome", "http://www.leafground.com/pages/table.html");
		WebElement table= url.driver.findElementById("table_id");
		List<WebElement> rows= table.findElements(By.tagName("tr"));
        List<WebElement> columncount=rows.get(1).findElements(By.tagName("td"));
        //List<WebElement> column3=rows.get(2).findElements(By.tagName("td"));
        System.out.println(rows.size());
        System.out.println(columncount.size());
        List<String> progress= new ArrayList<String>();
        for(int i=0; i<rows.size();i++)
        {
        	if(rows.get(i).getText().contains("Learn to interact with Elements"))
        	{
        		List<WebElement> column= rows.get(i).findElements(By.tagName("td"));
        		System.out.println(column.get(1).getText());
        	}
        }
        for(int i=1; i<rows.size();i++)
        {
        	
        		List<WebElement> column1= rows.get(i).findElements(By.tagName("td"));
        		progress.add(column1.get(1).getText().toString().replaceAll("%", ""));
        	
        }
        List<Integer> newList = progress.stream()
				.map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
        
        Integer minvalue=Collections.min(newList);
        System.out.println(minvalue);
       for(int i=0;i<newList.size();i++)
       {
    	   if(minvalue==(newList.get(i)))
    	   {
    		   i++;
    		   List<WebElement> column2= rows.get(i).findElements(By.tagName("td"));
       		   column2.get(2).findElement(By.name("vital")).click();
       		   break;
    	   }
    	   
       }
        
        
	}

}
