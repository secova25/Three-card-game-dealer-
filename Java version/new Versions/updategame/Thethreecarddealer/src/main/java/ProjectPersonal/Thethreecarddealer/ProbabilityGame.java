package ProjectPersonal.Thethreecarddealer;

import java.util.Random;
import java.util.Vector;

public class ProbabilityGame {
	
	//A class that will create Deck of 52. 
	 public class DeckofCards{
		 //this class stores Card number, color and suite or shape. 
		 private class Node{
			String cardnumber;
			String color;
			String shape;
			
			//constructor
			Node(){}
		}
		public Node card = new Node();
		
		//main constructor
		DeckofCards(){}
		
		//customize constructor.
		DeckofCards(String card, String color, String shape){
			setCard(card);
			setColor(color);
			setShape(shape);
		}
		
		//these are gets and sets functions.
		public String getCard() {return card.cardnumber;}
		public String getColor() {return card.color;}
		public String getShape() {return card.shape;}
		
		public void setCard(String number) { card.cardnumber = number; }
		public void setColor(String color) { card.color = color; }
		public void setShape(String shape) { card.shape = shape; }
		
	}//end of class DeckofCards
	 
	 //declaring a variable to access the class.
	 Vector<DeckofCards> deck;
	 
	 //making the deck of cards.
	 public void makeDeck() {
		 
		 	deck = new Vector<DeckofCards>();
			//these variables are used to store the values, colours and suites per each card.
			String[] number = { "A","K","Q","J","2","3","4", "5", "6", "7", "8", "9", "10" };
			String[] suites = { "diamonds", "clubs", "hearts", "spades" };
			
			

			//using for loops and if statements to create the virtual card deck.
			for (String i:suites) {
				
				//if its a diamonds or clubs recall they are black.
				if((i == "diamonds") || (i == "clubs")){
					for (String j : number) {
						 deck.add(new DeckofCards(j,"black",i));
					}
				}
				else {
					for (String j : number) {
						deck.add(new DeckofCards(j, "red", i));
					}
				}
				
			}
			 
		}//end of the makeDeck()
	
	 
	 
	//this function will help in calculate probability.
	 private double prob(int x) {
	 	if (x == 1) { return 1.0; }
	 	else {return(x * prob(x - 1));}
	 }


	 //this function is used primarily to find out what is the chance of selecting
	 // a random card regardless of color, number, and/or shape.
	 public Vector<String> selectCard(String card, String suite) {
	 	Vector<String> a = new Vector<String>(); 

	 	//locating the selected card from the 52 cards
	 	for (int i = 0; i < 52; i++) {
	 		if ((deck.get(i).getCard().equals(card)) && (deck.get(i).getShape().equals(suite))) { 
	 			a.add(card);
	 			a.add(suite);
	 			
	 			//making the probability of selecting the same card calculation.
	 			double x = (1.0 / 52.0) * 100;
	 			a.add(String.valueOf(x));
	 			
	 			//making the probabilty of selecting the same suite calculation.
	 			double y = (12.0 / 51.0) * 100;
	 			a.add(String.valueOf(y));
	 			
	 			//making the probabilty of selecting the same colour calculation.
	 			double z = (25.0 / 51.0) * 100;
	 			a.add(String.valueOf(z));

	 			//making the probabilty of selecting the same number calculation.
	 			double b = (3.0 / 51.0) * 100;
	 			a.add(String.valueOf(b));
	 		}

	 	}
	 	return a;
	 }
	 //to get the deck ventra.
	 Vector<DeckofCards> getDeck(){return this.deck;}

}
