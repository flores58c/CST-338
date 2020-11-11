package casino;

import java.util.Scanner;

public class Assig2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		
		
		//s1.toString();
		System.out.println(getBet());
		
		
		
		
		
	}
	static int getBet() {
		int rValue = 0;
		int dummy;
		Scanner input = new Scanner(System.in);
		
		
		while(rValue>100 || rValue <=0) {
			
			System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
			
			dummy = rValue = input.nextInt();
			
			if(dummy ==0) {
				System.out.println("byyyyyyyyyyye");
				break;
			}else if(rValue>100 || rValue <=0) {
				System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
				
				rValue = input.nextInt();
			}
		}
		
		return rValue;
	}
	
	public static ThreeString pull()
	{
		ThreeString pulled = new ThreeString();
		return pulled;
	}
	
	
	//ThreeString pull() {
		ThreeString s1 = new ThreeString();
		
//	}
		// formula for random number in between a range 
		//Math.random() * (max - min + 1) + min
		// 1000 - 1 + 1 + 1 == 1001
		private static String randString() {
			String word = " ";
			int rand = (int) Math.random()*(1001);
			if(rand <= 500) {
				word = "space";
			}
			if(rand > 500 && rand <= 750) {
				word = "cherries";
			}
			
			return word;
		}
}

class ThreeString{



	private String string1;
	private String string2;
	private String string3;
	
	final int MAX_LEN = 20;
	static final int MAX_PULLS = 40;
	static int[] pullWinnings = new int[MAX_PULLS];
	static int numPulls = 0;
	
	ThreeString()
	{
		string1 = " ";
		string2 = " ";
		string3 = " ";
	}
	
	private boolean validString( String str ) {
		if(str != null &&  str.length() <= MAX_LEN)
		{
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return (string1 + string2 + string3);
	}
	
	public String getString1()
	{
		return string1;
	}

	public boolean setString1(String string1)
	{
		this.string1 = string1;
		return validString(string1);
	}

	public String getString2()
	{
		return string2;
	}

	public boolean setString2(String string2)
	{
		this.string2 = string2;
		return validString(string2);
	}

	public String getString3()
	{
		return string3;
	}

	public boolean setString3(String string3)
	{
		this.string3 = string3;
		return validString(string3);
	}
	
	public boolean saveWinnings(int winnings) {
		//saveWinnings() will return a boolean according to whether there was space to save the incoming value of winnings
		if(numPulls < MAX_PULLS) {
			pullWinnings[numPulls]=winnings;
			numPulls++;
			return true;
		}
		else {
			return false;
	}
	}
			
	
	String toStringWinnings() {
		int total = 0; 
		for(int i = 0; i< MAX_PULLS; i++) {
			total += pullWinnings[i];
		}
		return Integer.toString(total);
	}
}