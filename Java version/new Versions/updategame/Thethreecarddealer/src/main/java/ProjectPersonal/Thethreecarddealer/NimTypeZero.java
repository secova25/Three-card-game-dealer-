package ProjectPersonal.Thethreecarddealer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import javafx.util.Pair;

public class NimTypeZero {
	
	
//		//this subclass Node is used to host the three factors that create the card.
//		class Node{
//			private String cardNumber;
//			private String colour;
//			private String suite;
//				
//			//main constructor.
//			Node() {}
//			
//			//customize constructor.
//			Node(String card, String color, String suite) {
//				setCard(card);
//				setColor(color);
//				setSuite(suite);
//			}
//			//these are gets and sets functions
//			public String getCard() { return this.cardNumber; }
//			public String getColor() { return this.colour; }
//			public String getShape() { return this.suite; }
//		
//			public void setCard(String number) { this.cardNumber = number; }
//			public void setColor(String color) { this.colour = color; }
//			public void setSuite(String suite) { this.suite = suite; }
//		}
	//------------------------------------------------------------------------
		
		
	//main constructor.
	//	NimTypeZero(){}
		
//	//All useful variables. 
//	//populating the deck of cards by creating a variable that will store each card.
//	Queue<Node> deck2 = new LinkedList<>();
//	
//	String[] storedeck = new String[40];
//	
//
//	Queue <Pair <String, String>> dealersPosition = new LinkedList<>();
//
//	// these variables will access the players class to store their card seperatly. 
//	String[] player1a = new String[4];
//	String[] player2a = new String[4];
//	String[] player3a = new String[4];
//	String[] player4a = new String[4];
//
//	int[] rounds = { 0,0,0,0 };//used to keep a track of which players won each round.
//
//	//-------------------------------------------------------------------------------
//
//	//--------------------------------Making the proper Deck for distibution section---------------------------- 
//	//this function will populate the deck and shuffle the cards. 
//	 public void makeDeck2() {
//		String[] numbers = { "0","1","2","3" };
//		
//		int w = 0;//used to travel between each value in storedeck.
//		int y = 0; // used to travel between amountCard and dealersPosition;
//		
//		//using this for loop to intitialize storepdeck.
//		for (int q = 0; q < 40; q++) { storedeck[q] = ""; }
//		
//		// this 2d array will display where the cards are at before they are shuffled. 
//		String[][] a = { 
//			{ "0","0","1","1","2","2","3","3" },
//			{ "0","0","1","1","2","2","3","3" },
//			{ "0","0","1","1","2","2","3","3" },
//			{ "0","0","1","1","2","2","3","3" },
//			{ "0","0","1","1","2","2","3","3" }};
//
//		int p = 0;
//
//		//this while loop stores the 2d array into a one d array known as storedeck.
//		while (p < 5) { for (int x = 0; x < 8; x++) { storedeck[w] = a[p][x]; ++w; }p++; }
//		
//		//storing each position that the dealer can be in. 
//		Pair<String,String> a1 = new Pair<>("1", "2");
//		Pair<String,String> b = new Pair<>("2", "3");
//		Pair<String,String> c = new Pair<>("3", "4");
//		Pair<String,String> d = new Pair<>("4", "1");
//		dealersPosition.add(a1);
//		dealersPosition.add(b);
//		dealersPosition.add(c);
//		dealersPosition.add(d);
//		
//	}
//
//	 //this function will only be used to swap each card in the deck
//	 public void flip(int k) {
//	 	//swapping each card.
//		 if (k < 10) {
//			 for (int p = 0; p < 40; p++) {
//				 Random srand = new Random();
//				 int cardrand = srand.nextInt(40);
//				 String s = storedeck[p];
//				 storedeck[p] = storedeck[cardrand];
//				 storedeck[cardrand] = s;
//			 }
//		 }
//	 }
//
//	//this function will swap each card in the deck. 
//	@SuppressWarnings("exports")
//	public Queue<Node> swapcards() {
//		Queue<Node>create = new LinkedList<Node>();;
//		
//		//swapping each card a second time. 
//		flip(0);
//
//		//finalizing the deck that will be used in the card game.
//		for (int i = 0; i < 40; i++) {
//			//determine wither the value stored is a zero, one, two or three.
//			if(storedeck[i].equals("0")){Node temp = new Node(storedeck[i],"clubs","red");create.add(temp);}
//			else if (storedeck[i].equals("1")) {Node temp = new Node(storedeck[i],"diamonds","blue");create.add(temp);}
//			else if (storedeck[i].equals("2")) {Node temp = new Node(storedeck[i],"heats","green");create.add(temp);}
//			else {Node temp = new Node(storedeck[i],"spades","yellow");create.add(temp);}
//		}
//		return create;
//	}
//	//------------------------End of Making the deck section----------------------------------------------
//
//	//------------------------winner Methods' section----------------------------------------------------p
//	//this sub class will help in determining a winner 
//	class pLayer{
//		private String player;
//		private int rowswin;
//		
//		//main construction
//		pLayer(){}
//		
//		pLayer(String player, int wins){
//			setPlayer(player);
//			setRowswin(wins);
//		}
//		
//		//sets and gets.
//		public void setPlayer(String player) {this.player = player;}
//		public void setRowswin(int rowswim) {this.rowswin = rowswin;}
//		public String getPlayer() {return this.player;}
//		public int getRowswin() {return this.rowswin;}
//	}
//	
//	
//	//this function will be use to determine who won each round.
//	void winners(String currentplayer) {
//		//depending on the player that went over nine we can decided who won that round.
//		//rounds[0] = player 1
//		//rounds[1] = player 2
//		//rounds[2] = player 3
//		//rounds[3] = player 4
//		String[] players = { "1","2","3","4" };
//		for (int i = 0; i < 4; i++) { if (!players[i].equals (currentplayer)) { rounds[i] += 1; } }
//	}
//
//	//placing all players in a queue of strings.
//	Queue<String> playerplaced(Queue<pLayer> g) {
//		Queue<String> finalA = new LinkedList<>();
//		while (g.size() > 0) {
//			finalA.add(g.element().player);
//			g.remove();
//		}
//		return finalA;
//	}
//
//	//this function will determine who won.
//	Queue<String> findWinner(int[] rounds) {
//		//
//		Queue<String> onea = new LinkedList<>();
//		
//		//values keeping the size of who received a win for each round. 
//		Queue<pLayer> zero = new LinkedList<>();
//		Queue<pLayer> one = new LinkedList<>();
//		Queue<pLayer> two = new LinkedList<>();
//		Queue<pLayer> three = new LinkedList<>();
//		
//		String[] x = {"1","2","3","4"};
//		
//		//checking each value in rounds to see which number is greater. 	
//		for (int i = 0; i < 4; ++i) {
//			
//			if (rounds[i] == 0) {zero.add(new pLayer(x[i], 1)); }
//			else if (rounds[i] == 1) {one.add(new pLayer(x[i], 1));}
//			else if (rounds[i] == 2) { two.add(new pLayer(x[i], 1));}
//			else { three.add(new pLayer(x[i], 1));}
//		}
//		//check the sizes and store the winner(s) int onea.
//		if (three.size() > 0) {onea = playerplaced(three);}
//		else if (two.size() > 0) { onea = playerplaced(two); }
//		else if (one.size() > 0) { onea = playerplaced(one); }
//		else {onea = playerplaced(zero);}
//
//		return onea;
//	}
//
//	//-----------------------End of the winner functions sections-------------------------------------------------
//
//	//this function will decided what each player will receive.
//	public void playersFaith() {
//		//Amount the card will be drew will alter as each player card get selected.
//		int cda = 0;
//
//		//while looping to deal the cards 
//		while (cda < 4) {
//		
//			player1a[cda] = deck2.element().getCard();
//			deck2.remove();
//			
//			player2a[cda] = deck2.element().getCard();
//			deck2.remove();
//			
//			player3a[cda] = deck2.element().getCard();
//			deck2.remove();
//
//			player4a[cda] = deck2.element().getCard();
//			deck2.remove();
//
//			cda++;
//		}
//
//	} 
//
//	//this function will determine dealers position.
//	String dealerStands(Queue<Pair<String,String>>dealersPosition) {
//		Random srand = new Random();
//		int r = srand.nextInt(4);
//		int i = 0;
//
//		//locating what r selected. 
//		while (i != r) { dealersPosition.remove(); i++; }
//		Pair<String, String> a = dealersPosition.element();
//
//		//removing all other positions that where not removed.
//		while (dealersPosition.size() > 0) { dealersPosition.remove(); }
//		
//		return a.getValue();
//	}
//
//	//this function will keep a track of the next players in the following two rounds.
//	String nextPlayers(String current) {
//		
//		String rnp = "";
//		if (current.equals("1")) {
//			rnp = "2";
//		}
//		else if (current.equals("2")) {
//			rnp = "3";
//		}
//		else if (current.equals("3")) {
//			rnp = "4";
//		}
//		else {
//			rnp = "1";
//		}
//		return rnp;
//	}


// Implement all this in javafx. 	
//	//this function will print the card. DESTROY THIS METHOD.
//	void printCards(String current) {
//		String[] x = { "1","2","3","4" };
//		int k = 0; 
//		//locate the current player.
//		while (x[k] != current) { ++k; }
//
//		//found the current player. 
//		if (k == 1){for (int i = 0; i < 4; i++) {if (player1a[i] != "") { }}}//std::cout << player1a[i] << " "; 
//		else if (k == 2) {for (int i = 0; i < 4; i++) { if (player2a[i] != "") {  } }}//std::cout << player2a[i] << " ";
//		else if (k == 3) { for (int i = 0; i < 4; i++) { if (player3a[i] != "") { } } } //std::cout << player3a[i] << " ";
//		else { for (int i = 0; i < 4; i++) { if (player4a[i] != "") { } } }//std::cout << player4a[i] << " "; 
//		
//	}


	//------------------------Actual Gaming Functions section-----------------------------------------------------

//	//this function will keep the values per each round. 
//	void gameplay(int round, std::string currentplayer, int count) {
//		
//		//testing to see if has reached over nine. 
//		if (count > 9) {
//			if (round == 3) { return; }
//			else {
//				//check to see if all cards have been used. 
//				
//				//we are starting with a new deck every time so that the players do not complain about cheating. 
//				makeDeck2();//make a deck of 40 cards.
//				deck2 = swapcards();//making a deck of 40 cards with swapped values.
//
//				std::string nplayer = nextPlayers(currentplayer);
//				std::cout << "Player: " << nplayer << " You will start the next round.\n";
//				playersFaith();// redistibuting new cards to each player. 
//				winners(currentplayer);//this function call will state who wins each round.
//				round++;
//				gameplay(round, nplayer, 0);//continous to next round.
//			}
//		}
//
//		else {
//			std::cout << "\nThe count value: " << count << ".\n";
//			std::string nplayer = nextPlayers(currentplayer);
//			if (count == 0) { std::cout << "Player: " << currentplayer << " select your value that you are going to use.\n"; printCards(currentplayer);}
//			else {std::cout << "Player: " << currentplayer << " select your value that you are going to use next.\n"; printCards(nplayer);}
//			
//			//include the cards that are remaining for the players to see.		
//			std::string x = "";
//			std::cin >> x;
//			if (count == 0) { std::cout << "\nPlayer " << currentplayer << " selected: " << x << "\n"; }
//			else { std::cout << "\nPlayer " << currentplayer << " selected: " << x << "\n"; }
//			
//			
//			//this lambda function that will help remove each card select. 
//			auto lmp = [cardSelect = x](std::string current) {
//				std::string player[4] = { "1","2","3","4" };
//				int k = 0;
//				bool change = false;
//				while (player[k] != current) { ++k; }
//				if (k == 0) { for (int x = 0; x < 4; x++) { if (player1a[x] == cardSelect) { player1a[x] = ""; change = true; break; } } }
//				else if (k == 1) { for (int x = 0; x < 4; x++) { if (player2a[x] == cardSelect) { player2a[x] = ""; change = true; break; } } }
//				else if (k == 2) { for (int x = 0; x < 4; x++) { if (player3a[x] == cardSelect) { player3a[x] = ""; change = true; break; } } }
//				else { for (int x = 0; x < 4; x++) { if (player4a[x] == cardSelect) { player4a[x] = ""; change = true; break; } } }
//				return change;
//			}; 
//			bool exchange = false;
//
//			//create a function that will send the current array needed for current player.
//			if (count == 0) { exchange = lmp(currentplayer); }
//			else{ exchange = lmp(currentplayer); }
//
//			if (exchange == true) { count += std::stoi(x);}
//			//else { std::cout << "The card you selected is not in your hand.\nTRY AGAIN!!!"; gameplay(round, currentplayer, count);}
//			gameplay(round , nplayer, count);
//		}
//	}
//
//	//this function will allow the player to play the game.
//	void timeToplay() {
//		std::cout << "Welcome players to Nim Type Zero.\n"
//			<< "Before we begin,let me your dealer, explain the rules.\n"
//			<< "You will each be dealt four cards, from a deck of 40 cards.\n"
//			<< "The object of this game is to be the player who does not go over 9.\n"
//			<< "Any players who go over 9 will not recieve a point.\n"
//			<< "There will be three rounds and at the end of the third round the winnner will be anounced.\n"
//			<< "Since I am unable to see you, I must warn all players...\n"
//			<< "ANY CHEATING WILL AUTOMATICLY END THE GAME!!!\n"
//			<< "Lets us begin the game.\n";
//
//		makeDeck2();//make a deck of 40 cards.
//		deck2 = swapcards();//making a deck of 40 cards with swapped values. 
//		playersFaith();//deals the cards fairly to each player. 
//
//		//this variable is used to determine who starts the game.
//		std::string PTTL = dealerStands(dealersPosition);
//		
//		std::cout << "Player: " << PTTL << "  will start the game.\n" << "Than the player to the right will go next.\n";
//		gameplay(1, PTTL, 0);//this function call will play all three rounds.
//
//		std::queue<std::string> winners = findWinner(rounds);
//		//use std::cout  to display the winner of the game and challenge all other loosers to a game. 
//		if (winners.size() == 4) { std::cout << "Darn a draw want to play again...\n" << "then recompile the program again\n" << "or do not waste my time.\n"; }
//		else {
//			std::cout << "The winner(s) of the game is/are... \n";
//			while (winners.size() > 0) {
//				std::cout << winners.front() << " ";
//				winners.pop();
//			}
//			std::cout << "\nFor all other players who lost..." << "\n I challange you to a game and if you beat me I will increase your score." << "\nWhat do you say,will you accepted my challenge?";
//			std::cout << "\nTo accept the dealers challenge type 1 for yes or 2 for no.\n";
//			std::string t;
//			std::cin >> t;
//
//			if (t == "2") { std::cout << "To bad...\n" << "It does not matter you were propably would of loose to me anyways.\n" << "HAHAHAHA!!!\n"; std::exit(0); }
//			else {
//				std::cout << "Your such a fool to challenge me!\n" << "No matter I know I will win.";
//				// call the function for the third game. 
//				gameStarter();
//			}
//		}

}
