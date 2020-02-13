package week3day1;

public class Callfunction {

	public static void main(String[] args) {
		Mobile number= new CallMobile();
		String contacts="Nithish1";
		long number1=number.searchcontacts(contacts);
		number.dial(number1);
		int time=10;
		char cut=number.speak(time);
		number.hangcall(cut);
		System.out.println("call is done");
		
		

	}

}
