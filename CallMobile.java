package week3day1;

public class CallMobile implements Mobile{

	@Override
	public long searchcontacts(String contacts) {
		switch (contacts) {
		case "Nithish":
			return 759811956;
		
		case "Nithish1":
			return 978816678;
     
		default:
			return 943319568;
			
		}
		
	}

	@Override
	public void dial(long number) {
		System.out.println(number);
		
	}

	@Override
	public char speak(int time) {
		
		for(int i=0; i>time;i++);
		{
			System.out.println("Ongoing call");
		}
		return 'c';
		
	}

	@Override
	public void hangcall(char cut) {
		if(cut=='c')
		System.out.println("Hang up the call");
	}

}
