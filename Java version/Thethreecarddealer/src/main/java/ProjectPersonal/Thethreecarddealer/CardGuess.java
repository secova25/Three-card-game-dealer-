package ProjectPersonal.Thethreecarddealer;
import javafx.util.Pair;
import java.util.Scanner;

public class CardGuess {
	String[] card = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
	
	//constructor
	CardGuess(){}
		
	//find a card value.
	int FindCard(int lowerbound, int upperbound, int currentValue) {
		
		Scanner x = new Scanner(System.in);// used to get the user respond.
		String temp = "";
		
		//this while loop will ask the same question over and over again tell the dealer finds the correct number.
		while (lowerbound != currentValue) {
			
			System.out.print( "Is your card value greater then or less then/equal to " + currentValue + "?\n");
			System.out.print( "1) Type 1 for greater then.\n"+ "2) Type 2 for less then/ equal to.\n");
			temp = x.nextLine();//stores the users respond.
			x.close();

			//Depending on the player(s) selection determines the alterations for the upperbound and lowerbound.
			 if (temp.equals("1")) {
				lowerbound = currentValue;
				currentValue = ((upperbound - currentValue) / 2) + lowerbound;
			}
			else if (temp.equals("2")) {
				upperbound = currentValue;
				currentValue = ((currentValue - lowerbound) / 2) + lowerbound;
			}

		}
		return upperbound;
		
	}
	
	//Main function for the game play. 
	public void GamerStarter(){
	Pair<String, String> red = new Pair<>("Hearts","Spades");
	Pair<String, String> black = new Pair<>("Diamond","Clubs");
	
	//The welcoming screen.
	System.out.println( "Ok let me explain the game so a novice like you can under stand it easily.");
	System.out.println("I have a regular deck of 52 cards.");
	System.out.println("Your job is to picture one card, together not seperate, and I will try to guess your card.");
	System.out.println("To make things intresting, I have converted each card with a special value.");
	System.out.println("The values are:\n");
	System.out.println("2 through 10 will be the value shown on the card.");
	System.out.println( " While A = 1, J = 11, Q = 12 and K = 13.");
	System.out.println("These values ar none negotiable.");
	System.out.println("So, choose your card and lets begin the game.");
	
	int CardFound = FindCard(1, 13, 7);
	CardFound -=1;
	
	Scanner o = new Scanner(System.in);
	
	//Requesting the color of the card will help find the suites. 
	System.out.print( "I believe I got some idea what the card value is.\n");
	System.out.print( "But before I can give you my guess I need you to tell me the color of the card.\n");
	System.out.print( "Type 1 for red.\n Type 2 for black.\n");
	String y = o.nextLine();
	o.close();

	//Figuring out the suite 
	Pair<String, String> suites; 
	if (y.equals("1")) { suites = red; }
	else { suites = black; }


	//Taking a guess. 
	
	System.out.print( "I am ready to give you my answer.\n ");
	System.out.print("Your card is...\n");
	System.out.print(card[CardFound]+" "+ suites.getKey()+ ".\n"); 
	System.out.print("If this is not your card allow me a second chance.\n");
	System.out.print("To allow the dealer a second chance, type 1.\n" + " If the dealer was correct type 0.\n");
	
	Scanner p = new Scanner(System.in);
	
	String z = p.nextLine();
	p.close();	
	
	//depending on the player(s) respond will determine the ending cout statements. 
	if (z.equals("1")) {
	
			System.out.print( "I am ready to try again.\n ");
			System.out.print( "Your card is...\n");
			System.out.print(card[CardFound] + " " + suites.getValue() + ".\n");
			System.out.print( "If it is not your card then you must of made a mistake.\n");
			System.out.print( "Therefore, I win this round.\n" + "See I knew you where all a bunch of looser(s).\n");
		}
		else if (z == "0") {
			System.out.print("So, let me see if I got this straight.\n");
			System.out.print("You are pathetic to allow a dealer like myslef to beat you so easily.\n");
			System.out.print( "I do not associate with loosers.\n"+"So, get lost looser!!!");
		}
		else {
			
			System.out.print("So, you beat me, big deal.\n" + "Your still a looser and I do not associate with losers.\n"+ "Get lost you bunch of looser(s).\n");
		}

	}
}
