package casino;

import java.util.Scanner;
   //Chris Flores
   //Assign2 Casino
public class Assig2
{
   // main instantiates a ThreeString object and asks user for bet
   // additionally the object is used in multiplier function after to get 
   //winnings. If user enters 0 or reaches 40 the program ends.
   public static void main(String[] args)
   {
   ThreeString s1 = new ThreeString();
   
   int bet = 1;
   
   while(bet !=0) {
   bet = getBet();
      
   if(bet == 0)
   {
   System.out.print(s1.toStringWinnings());
   }
   else {
   s1 = pull();
   int multiplier = getPayMultiplier(s1);
   int winnings = bet*multiplier;
   display(s1, winnings);
   s1.saveWinnings(winnings);
   if(s1.numPulls == s1.MAX_PULLS) {
   System.out.print(s1.toStringWinnings());
   break;
   }
   }
   }
   }
   // gets the bet value by the user between 1-100
   static int getBet() {
   int rValue = 0;
   int dummy;
   Scanner input = new Scanner(System.in);
   
   while(rValue>100 || rValue <= 0) {      
   System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
   dummy = rValue = input.nextInt();
      
   if(dummy ==0) {
   System.out.println("Bye come try again later!");
   break;
   }else if(rValue>100 || rValue <=0) {
   System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
   rValue = input.nextInt();
   }
   }
   return rValue;
   }
   // multiplier based on order given to us in prompt
   static int getPayMultiplier (ThreeString thePull) {
   int multiplier = 0;
   String string1 = thePull.getString1();
   String string2 = thePull.getString2();
    String string3 = thePull.getString3();
   //if the strings equal each other 
   if(string1.equals(string2) && string1.equals(string3))
   {
   if(string1 == "cherries" && string2 == "cherries" && string3 == "cherries")
   {      
   multiplier = 30;
   }
   else if(string1 == "BAR" && string2 == "BAR" && string3 == "BAR")
   {
   multiplier = 50;
   }
   else if(string1 == "7" && string2 == "7" && string3 == "7")
   {
   multiplier = 100;
   }
   else
   multiplier = 0;
   }
   //if the first two are cherries only or no multiplier
   else if(string1.equals(string2) && !string1.equals(string3))
   {
   if(string1 == "cherries" && string2 == "cherries")
   {
   multiplier = 15;
   }
   else
   multiplier = 0;
   }
   //if you get cherries in the first slot
   else if(!string1.equals(string2))
   {
   if(string1 == "cherries")
   {
   multiplier = 5;
   }
   else
   multiplier = 0;
   }
   return multiplier;
   }
   
   // displays the winnings if you win on a bet
   static void display (ThreeString thePull, int winnings ) {
   int multiplier = getPayMultiplier(thePull);
   System.out.println(thePull.toString());
   if(multiplier != 0) {
   System.out.println("Congrats you won " + winnings);
   }
   else {
   System.out.println("Nothing this time. You might have better luck "
   + "next time. ");
      }
   }
   public static ThreeString pull()
   {
   ThreeString pulled = new ThreeString();
   pulled.getString1();
   pulled.setString1(randString());
   pulled.getString2();
   pulled.setString2(randString());
   pulled.getString3();
   pulled.setString3(randString());
   
   return pulled;
   }
   
   
   
   // formula for random number in between a range 
   //Math.random() * (max - min + 1) + min
   // 1000 - 1 + 1 + 1 == 1001
   // Probabilities given for the String
   private static String randString() {
   String word = " ";
   int rand = (int) (Math.random()*(1000));
   if(rand <= 500) {
   word = "space";
   }
   else if(rand > 500 && rand <= 750) {
   word = "cherries";
   }
   else if(rand>751 && rand<=875) {
   word = "BAR";
   }
   else {
   word = "7";
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
   //This function makes sure there is a string
   private boolean validString( String str ) {
   if(str != null &&  str.length() <= MAX_LEN)
   {
      return true;
   }else {
      return false;
   }
   }
   // this prints the values for the strings that were given randomly
   public String toString() {
   return (string1+ " " + string2 + " " + string3);
   }
   
   public String getString1()
   {
   return string1;
   }
   // getters and setters for three string
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
   //saveWinnings() will return a boolean according to whether there+
   //was space to save the incoming value of winnings
   if(numPulls < MAX_PULLS) {
   pullWinnings[numPulls]=winnings;
   numPulls++;
   return true;
   }
   else {
   return false;
   }
   }
      
   //This function returns both a string array of winnings and its total.
   String toStringWinnings() {
   int total = 0; 
   String array = " ";
   for(int i = 0; i< numPulls; i++) {
   total += pullWinnings[i];
   array += Integer.toString(pullWinnings[i]) + " ";
   //System.out.print(pullWinnings[i] + " ");
   }
   return  (array + "\nYour total is:" + Integer.toString(total));
   }
}

/*
How much would you like to bet (1 - 100) or 0 to quit?
22
BAR space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
22
cherries 7 space
Congrats you won 110
How much would you like to bet (1 - 100) or 0 to quit?
22
cherries BAR cherries
Congrats you won 110
How much would you like to bet (1 - 100) or 0 to quit?
22
space BAR cherries
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
22
space space cherries
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
22
cherries 7 space
Congrats you won 110
How much would you like to bet (1 - 100) or 0 to quit?
33
space BAR space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
33
cherries space BAR
Congrats you won 165
How much would you like to bet (1 - 100) or 0 to quit?
33
space cherries BAR
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
555
How much would you like to bet (1 - 100) or 0 to quit?
66
cherries cherries space
Congrats you won 990
How much would you like to bet (1 - 100) or 0 to quit?
66
7 space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
7 cherries BAR
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
space space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
7 space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
7 cherries 7
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
space cherries space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
space space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
cherries cherries 7
Congrats you won 990
How much would you like to bet (1 - 100) or 0 to quit?
66
space space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
space BAR 7
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
66
space space space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
33
space cherries space
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
33
BAR space BAR
Nothing this time. You might have better luck next time. 
How much would you like to bet (1 - 100) or 0 to quit?
33
cherries cherries BAR
Congrats you won 495
How much would you like to bet (1 - 100) or 0 to quit?
0
Bye come try again later!
 0 110 110 0 0 110 0 165 0 990 0 0 0 0 0 0 0 990 0 0 0 0 0 495 
Your total is:2970
*/