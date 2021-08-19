package ProjectPersonal.Thethreecarddealer;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class NimTypeZero {
	
		//this struct Node is used to host the three factors that create the card.
		class Node {
			private String cardNumber;
			private String color;
			private String suite;
			
			//main construct.
			Node(){}	
			
			//customize constructor.
			Node(String card, String color, String suite) {
				setCard(card);
				setColor(color);
				setSuite(suite);
			}
			
			//these are gets and sets functions
			String getCard() { return cardNumber; }
			String getColor() { return color; }
			String getShape() { return suite; }

			void setCard(String number) {cardNumber = number; }
			void setColor(String color) {color = color; }
			void setSuite(String suite) {suite = suite; }
			
		}

	
		Node card = new Node();
		//main constructor.
		NimTypeZero() {}
		
		//customize constructor.
	
		//these are gets and sets functions
		String getCard() { return card.cardNumber; }
		String getColor() { return card.color; }
		String getShape() { return card.suite; }

		void setCard(String number) {card.cardNumber = number; }
		void setColor(String color) {card.color = color; }
		void setSuite(String suite) {card.suite = suite; }
		
	//------------------------------------------------------------------------

	//All useful variables. 
	//populating the deck of cards by creating a variable that will store each card.
	Queue<Node> deck2 = new  LinkedList<>();
	String[] storedeck = new String[40];

	//used to help store the postion of the dealer. 
	class DealerChoice{
		private String postion1;
		private String postion2;
		
		//main construction.
		DealerChoice() {}
		
		//customize constructor.
		DealerChoice(String postion1, String postion2){
			setPostion1(postion1);
			setPostion2(postion2);
		}
		
		//get and sets function.
		public void setPostion1(String postion1) {postion1 = postion1;}
		public void setPostion2(String postion2) {postion2 = postion2;}
		String  getPostion1() {return postion1;}
		String  getPostion2() {return postion2;}
		
	}
	Queue<DealerChoice> dealersPosition = new LinkedList<>();

	// these variabls will access the players class to store their card seperatly. 
	String[] player1a =  new String[4];
	String[] player2a = new String[4];
	String[] player3a = new String[4];
	String[] player4a = new String[4];

	int[] rounds = { 0,0,0,0 };//used to keep a track of which players won each round.

	//-------------------------------------------------------------------------------

	//--------------------------------Making the proper Deck for distibution section---------------------------- 
	//this function will populate the deck and shuffle the cards. 
	 void makeDeck2() {
		String[] numbers = { "0","1","2","3" };
		
		int w = 0;//used to travel between each value in storedeck.
		int y = 0; // used to traval between amountCard and dealersPosition;
		
		//using this for loop to initulize storepdeck.
		for (int q = 0; q < 40; q++) { storedeck[q] = ""; }
		
		// this 2d array will desplay where the cards are at before they are shuffled. 
		String[][] a = { 
			{ "0","0","1","1","2","2","3","3" },
			{ "0","0","1","1","2","2","3","3" },
			{ "0","0","1","1","2","2","3","3" },
			{ "0","0","1","1","2","2","3","3" },
			{ "0","0","1","1","2","2","3","3" }};

		int p = 0;

		//this while loop stores the 2d array into a one d array known as storedeck.
		while (p < 5) { for (int x = 0; x < 8; x++) { storedeck[w] = a[p][x]; ++w; }p++; }
		
		//storing each position that the deal can be in. 
		dealersPosition.add( new DealerChoice("1", "2"));
		dealersPosition.add(new DealerChoice("2", "3"));
		dealersPosition.add(new DealerChoice("3", "4"));
		dealersPosition.add(new DealerChoice("4", "1"));
	}

	 //this function will only be used to swap each card in the deck
	 void flip(int k) {
	 	//swapping each card.
		 while(k < 10) {
			 for (int p = 0; p < 40; p++) {
				 Random srand = new Random();
				 int x = srand.nextInt();//selects a random card to swap with.
				 String s = storedeck[p];
				 storedeck[p] = storedeck[x];
				 storedeck[x] = s;
			 }
			 k++;
		 }
	 }

	//this function will swap each card in the deck. 
	Queue<Node> swapcards() {
		Queue<Node>create = new LinkedList<>();
		
		//swapping each card a second time. 
		flip(0);

		//finalizing the deck that will be used in the card game.
		for (int i = 0; i < 40; i++) {
			//determine wither the value stored is a zero, one, two or three.
			if(storedeck[i].equals("0")){create.add( new Node(storedeck[i],"clubs","red"));}
			else if (storedeck[i].equals("1")) {create.add(new Node(storedeck[i], "diamonds", "blue"));}
			else if (storedeck[i].equals("2")) {create.add(new Node(storedeck[i], "hearts", "green"));}
			else {create.add(new Node(storedeck[i], "spades", "yellow"));}	
		}
		return create;
	}


	//------------------------End of Making the deck section----------------------------------------------

	//------------------------winner Methods' section----------------------------------------------------
	//this function will be use to determine who won each round.
	void winners(String currentplayer) {
		//depending on the player that went over nine we can decided who won that round.
		//rounds[0] = player 1
		//rounds[1] = player 2
		//rounds[2] = player 3
		//rounds[3] = player 4
		String[] players = { "1","2","3","4" };
		for (int i = 0; i < 4; i++) { if (players[i] != currentplayer) { rounds[i] += 1; }}
	}

	//placing all players in a queue of strings.
	Queue<String> playerplaced(Queue<String> g) {
		Queue<String> finala = new LinkedList<>();
		while (g.size() > 0) {
			finala.add(g.element());
			g.remove();
		}
		return finala;
	}

	//this function will determine who won.
	Queue<String> findWinner(int rounds[]) {
		//
		Queue<String> onea = new LinkedList<>();
		
		//values keeping the size of who recieved a win for each round. 
		Queue<String> zero = new LinkedList<>();
		Queue<String> one = new LinkedList<>();
		Queue<String> two = new  LinkedList<>();
		Queue<String> three = new LinkedList<>();
		String[] x = {"1","2","3","4"};
		
		//checking each value in rounds to see which number is greater. 	
		for (int i = 0; i < 4; ++i) {
			
			if (rounds[i] == 0) {zero.add(x[i]);}
			else if (rounds[i] == 1) {one.add(x[i]);}
			else if (rounds[i] == 2) { two.add(x[i]);}
			else { three.add(x[i]);}
		}
		//check the sizes and store the winner(s) int onea.
		if (three.size() > 0) {onea = playerplaced(three);}
		else if (two.size() > 0) { onea = playerplaced(two); }
		else if (one.size() > 0) { onea = playerplaced(one); }
		else {onea = playerplaced(zero);}

		return onea;
	}

	//-----------------------End of the winner functions sections-------------------------------------------------

	//this function will decided what each player will recieve.
	void playersFaith() {
		//Amount the card will be drew will alter as each player card get selected.
		int cda = 0;

		//while looping to deal the cards 
		while (cda < 4) {
		
			player1a[cda] = deck2.element().getCard();
			deck2.remove();
			
			player2a[cda] = deck2.element().getCard();
			deck2.remove();
			
			player3a[cda] = deck2.element().getCard();
			deck2.remove();

			player4a[cda] = deck2.element().getCard();
			deck2.remove();

			cda++;
		}

	} 

	//this function will determine dealers position.
	String dealerStands(Queue<DealerChoice>dealersPosition) {
		Random srand = new Random();;
		int r = srand.nextInt();;
		int i = 0;

		//locating what r selected. 
		while (i != r) { dealersPosition.remove(); i++; }
		String second = dealersPosition.element().postion2;

		//removing all other positions that where not removed.
		while (dealersPosition.size() > 0) { dealersPosition.remove(); }
		
		return second;
	}

	//this function will keep a track of the next players in the following two rounds.
	String nextPlayers(String current) {
		
		String rnp = "";
		if (current == "1") {
			rnp = "2";
		}
		else if (current == "2") {
			rnp = "3";
		}
		else if (current == "3") {
			rnp = "4";
		}
		else {
			rnp = "1";
		}
		return rnp;
	}


	//this function will print the card.
	String[] printCards(String current) {
		String[] x = { "1","2","3","4" };
		int k = 0; 
		//locate the current player.
		while (x[k] != current) { ++k; }

		//found the current player. 
		if (k == 1){return player1a; }
		else if (k == 2) { return player2a;} 
		else if (k == 3) { return player3a; } 
		else { return  player4a; } 
		
	}


	//------------------------Actual Gaming Functions section-----------------------------------------------------

	
	//this method  will help remove each card select. 
	public void lmp (String current, String cardSelect) {
		String[] player = { "1","2","3","4" };
		int k = 0;
		
		while (player[k].equals( current)) { ++k; }
		if (k == 0) { for (int x = 0; x < 4; x++) { if (player1a[x].equals( cardSelect)) { player1a[x] = ""; } } }
		else if (k == 1) { for (int x = 0; x < 4; x++) { if (player2a[x].equals( cardSelect)) { player2a[x] = "";  } } }
		else if (k == 2) { for (int x = 0; x < 4; x++) { if (player3a[x].equals( cardSelect)) { player3a[x] = "";  } } }
		else { for (int x = 0; x < 4; x++) { if (player4a[x].equals(cardSelect)) { player4a[x] = "";  } } }
		
	}
	
	//this method will start the game. 
	public void gameTime() {
		makeDeck2();//make a deck of 40 cards.
		deck2 = swapcards();//making a deck of 40 cards with swapped values. 
		playersFaith();//deals the cards fairly to each player. 
	}
	
	//-------------------------------------End of Actual gaming functions----------------------------------------------------------------

}
