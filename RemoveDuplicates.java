package week3day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str="PayPal India";
		int i,j,count=0;
        char[] charArray=str.toCharArray();
        Set<Character> charSet= new TreeSet<Character>();
        Set<Character> dupcharSet= new TreeSet<Character>();
        for(i=0; i<charArray.length; i++)
        {
        	   
        	   charSet.add(charArray[i]);
        	
        }
        for(Character setprint : charSet)
        {
        	for(i=0; i<charArray.length; i++)
        	{
        		if(setprint.equals(charArray[i]))
        		{
        			dupcharSet.add(charArray[i]);
            	}
           	}
        	
        }
        for (Character setprint : dupcharSet)
        {
        	System.out.print(setprint);
        }
        System.out.println();
        for (Character setprint : charSet)
        {
        	System.out.print(setprint);
        }
        
        List<Character> charList=new ArrayList<Character>(charSet);
        List<Character> dupcharList=new ArrayList<Character>(dupcharSet);
       
        for(int k=0; k<dupcharList.size();k++)
        {
        	for(i=0; i<charList.size();i++)
        	{
        		if(dupcharList.get(k).equals(charList.get(i)))
        		{
        			charList.remove(i);
        			i--;
        		}
        	}
        }
        for(i=0;i<charList.size();i++)
        {
        	
        	System.out.println(charList.get(i));
        	
        }
	}

}
