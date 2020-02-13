package week3day1;

import java.util.ArrayList;
import java.util.List;

public class List1 {

	public static void main(String[] args) {
		List<String> teamnames=new ArrayList<String>();
		teamnames.add("Nithish");
		teamnames.add("Sai");
		teamnames.add("Sachin");
		teamnames.add("Abhishek");
		teamnames.add("varadhu");
		for(int i=0; i<teamnames.size();i++)
		{
			System.out.println(teamnames.get(i));
		}
		
		for(int i=0; i<teamnames.size();i++)
		{
			if(teamnames.get(i).toString().startsWith("S"))
			{
			teamnames.remove(i);
			i--;
			}
		}
		System.out.println("*******************************");
		for(int i=0; i<teamnames.size();i++)
		{
			System.out.println(teamnames.get(i));
		}

	}

}
