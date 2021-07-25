#pragma once
#include<string>
#include<queue>
#include<utility>
#include<array>
#include "CardGuess.h"

//creating the class to host a deck of cards. 
class NimofCards {
private:
	//this struct Node is used to host the three factors that create the card.
	struct Node {
		std::string cardNumber;
		std::string colour;
		std::string suite;
	};

public:
	Node* card = new Node();
	//main constructor.
	NimofCards() {}
	
	//customize constructor.
	NimofCards(std::string card, std::string color, std::string shape) {
		setCard(card);
		setColor(color);
		setShape(shape);
	}
	//these are gets and sets functions
	std::string getCard() { return card->cardNumber; }
	std::string getColor() { return card->colour; }
	std::string getShape() { return card->suite; }

	void setCard(std::string number) { card->cardNumber = number; }
	void setColor(std::string color) { card->colour = color; }
	void setShape(std::string shape) { card->suite = shape; }
};
//------------------------------------------------------------------------

//All useful variables. 
//populating the deck of cards by creating a variable that will store each card.
std::queue<NimofCards> deck2;
std::string storedeck[40];
int CardsLeft[4] = { 4,4,4,4 };//use to keep a track on how many cards are left. 

std::queue <std::pair <std::string, std::string>> dealersPosition;

// these variabls will access the players class to store their card seperatly. 
std::string player1a[4];
std::string player2a[4];
std::string player3a[4];
std::string player4a[4];

int rounds[4] = { 0,0,0,0 };//used to keep a track of which players won each round.

//-------------------------------------------------------------------------------

//--------------------------------Making the proper Deck for distibution section---------------------------- 
//this function will populate the deck and shuffle the cards. 
 void makeDeck2() {
	std::string numbers[4] = { "0","1","2","3" };
	
	int w = 0;//used to travel between each value in storedeck.
	int y = 0; // used to traval between amountCard and dealersPosition;
	
	//using this for loop to initulize storepdeck.
	for (int q = 0; q < 40; q++) { storedeck[q] = ""; }
	
	// this 2d array will desplay where the cards are at before they are shuffled. 
	std::string a[5][8] = { 
		{ "0","0","1","1","2","2","3","3" },
		{ "0","0","1","1","2","2","3","3" },
		{ "0","0","1","1","2","2","3","3" },
		{ "0","0","1","1","2","2","3","3" },
		{ "0","0","1","1","2","2","3","3" }};

	int p = 0;

	//this while loop stores the 2d array into a one d array known as storedeck.
	while (p < 5) { for (int x = 0; x < 8; x++) { storedeck[w] = a[p][x]; ++w; }p++; }
	
	//storing each position that the deal can be in. 
	dealersPosition.push(std::make_pair("1", "2"));
	dealersPosition.push(std::make_pair("2", "3"));
	dealersPosition.push(std::make_pair("3", "4"));
	dealersPosition.push(std::make_pair("4", "1"));
}

 //this function will only be used to swap each card in the deck
 void flip(int k) {
 	//swapping each card.
	 if (k < 10) {
		 for (int p = 0; p < 40; p++) {
			 std::srand(std::time(NULL));
			 int cardrand = rand() % 40;//selects a random card to swap with.
			 std::string s = storedeck[p];
			 storedeck[p] = storedeck[cardrand];
			 storedeck[cardrand] = s;
		 }
	 }
 }

//this function will swap each card in the deck. 
std::queue<NimofCards> swapcards() {
	std::queue<NimofCards>create;
	
	//swapping each card a second time. 
	flip(0);

	//finalizing the deck that will be used in the card game.
	for (int i = 0; i < 40; i++) {
		//determine wither the value stored is a zero, one, two or three.
		if(storedeck[i] == "0"){create.push(NimofCards(storedeck[i], "clubs", "red"));}
		else if (storedeck[i] == "1") {create.push(NimofCards(storedeck[i], "diamonds", "blue"));}
		else if (storedeck[i] == "2") {create.push(NimofCards(storedeck[i], "hearts", "green"));}
		else {create.push(NimofCards(storedeck[i], "spades", "yellow"));}	
	}
	return create;
}
//------------------------End of Making the deck section----------------------------------------------

//------------------------winner functions' section----------------------------------------------------
//this function will be use to determine who won each round.
void winners(std::string currentplayer) {
	//depending on the player that went over nine we can decided who won that round.
	//rounds[0] = player 1
	//rounds[1] = player 2
	//rounds[2] = player 3
	//rounds[3] = player 4

	if (currentplayer == "1") {
		rounds[1] += rounds[1];
		rounds[2] += rounds[2];
		rounds[3] += rounds[3];
	}
	else if (currentplayer == "2") {
		rounds[0] += rounds[0];
		rounds[2] += rounds[2];
		rounds[3] += rounds[3];
	}
	else if (currentplayer == "3") {
		rounds[0] += rounds[0];
		rounds[1] += rounds[1];
		rounds[3] += rounds[3];

	}
	else {
		rounds[0] += rounds[0];
		rounds[1] += rounds[1];
		rounds[2] += rounds[2];
	}
	return;
}

//placing all placers in a queue of strings.
std::queue<std::string> playerplaced(std::queue<std::pair<std::string, int>> g) {
	std::queue<std::string> final;
	while (g.size() > 0) {
		final.push(g.front().first);
		g.pop();
	}
	return final;
}

//this function will determine who won.
std::queue<std::string> findWinner(int rounds[4]) {
	//
	std::queue<std::string> onea;
	//values keeping the size of who recieved a win for each round. 
	std::queue<std::pair<std::string,int>> zero;
	std::queue<std::pair<std::string,int>> one;
	std::queue<std::pair<std::string, int>> two;
	std::queue<std::pair<std::string, int>> three;
	std::string x[4] = {"1","2","3","4"};
	
	//checking each value in rounds to see which number is greater. 	
	for (int i = 0; i < 4; ++i) {
		
		if (rounds[i] == 0) {zero.push(std::make_pair(x[i], 1)); }
		else if (rounds[i] == 1) {one.push(std::make_pair(x[i], 1));}
		else if (rounds[i] == 2) { two.push(std::make_pair(x[i], 1));}
		else { three.push(std::make_pair(x[i], 1));}
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
	
		player1a[cda] = deck2.front().getCard();
		deck2.pop();
		
		player2a[cda] = deck2.front().getCard();
		deck2.pop();
		
		player3a[cda] = deck2.front().getCard();
		deck2.pop();

		player4a[cda] = deck2.front().getCard();
		deck2.pop();

		cda++;
	}

} 

//this function will determine dealers position.
std::string dealerStands(std::queue<std::pair<std::string,std::string>>dealersPosition) {
	std::srand(std::time(NULL));
	int r = rand() % 4;
	int i = 0;

	//locating what r selected. 
	while (i != r) { dealersPosition.pop(); i++; }
	std::pair<std::string, std::string> a = dealersPosition.front();

	//removing all other positions that where not removed.
	while (dealersPosition.size() > 0) { dealersPosition.pop(); }
	
	return a.second;
}

//this function will keep a track of the next players in the following two rounds.
std::string nextPlayers(std::string current) {
	
	std::string rnp = "";
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
void printCards(std::string current) {
	std::string x[4] = { "1","2","3","4" };
	int k = 0; 
	//locate the current player.
	while (x[k] != current) { ++k; }

	//found the current player. 
	if (k == 1){for (int i = 0; i < 4; i++) {if (player1a[i] != "") { std::cout << player1a[i] << " "; }}}
	else if (k == 2) {for (int i = 0; i < 4; i++) { if (player2a[i] != "") { std::cout << player2a[i] << " "; } }}
	else if (k == 3) { for (int i = 0; i < 4; i++) { if (player3a[i] != "") { std::cout << player3a[i] << " "; } } }
	else { for (int i = 0; i < 4; i++) { if (player4a[i] != "") { std::cout << player4a[i] << " "; } } }
	
}


//------------------------Actual Gaming Functions section-----------------------------------------------------

//this function will keep the values per each round. 
void gameplay(int round, std::string currentplayer, int count) {
	
	//testing to see if has reached over nine. 
	if (count > 9) {
		if (round == 3) { return; }
		else {
			//check to see if all cards have been used. 
			
			//we are starting with a new deck every time so that the players do not complain about cheating. 
			makeDeck2();//make a deck of 40 cards.
			deck2 = swapcards();//making a deck of 40 cards with swapped values.

			std::string nplayer = nextPlayers(currentplayer);
			std::cout << "Player: " << nplayer << " You will start the next round.\n";
			playersFaith();// redistibuting new cards to each player. 
			winners(currentplayer);//this function call will state who wins each round.
			round++;
			gameplay(round, nplayer, 0);//continous to next round.
		}
	}

	else {
		std::cout << "\nThe count value: " << count << ".\n";
		std::string nplayer = nextPlayers(currentplayer);
		if (count == 0) { std::cout << "Player: " << currentplayer << " select your value that you are going to use.\n"; printCards(currentplayer);}
		else {std::cout << "Player: " << currentplayer << " select your value that you are going to use next.\n"; printCards(nplayer);}
		
		//include the cards that are remaining for the players to see.		
		std::string x = "";
		std::cin >> x;
		if (count == 0) { std::cout << "\nPlayer " << currentplayer << " selected: " << x << "\n"; }
		else { std::cout << "\nPlayer " << currentplayer << " selected: " << x << "\n"; }
		
		
		//this lambda function that will help remove each card select. 
		auto lmp = [cardSelect = x](std::string current) {
			std::string player[4] = { "1","2","3","4" };
			int k = 0;
			bool change = false;
			while (player[k] != current) { ++k; }
			if (k == 0) { for (int x = 0; x < 4; x++) { if (player1a[x] == cardSelect) { player1a[x] = ""; change = true; break; } } }
			else if (k == 1) { for (int x = 0; x < 4; x++) { if (player2a[x] == cardSelect) { player2a[x] = ""; change = true; break; } } }
			else if (k == 2) { for (int x = 0; x < 4; x++) { if (player3a[x] == cardSelect) { player3a[x] = ""; change = true; break; } } }
			else { for (int x = 0; x < 4; x++) { if (player4a[x] == cardSelect) { player4a[x] = ""; change = true; break; } } }
			return change;
		}; 
		bool exchange = false;

		//create a function that will send the current array needed for current player.
		if (count == 0) { exchange = lmp(currentplayer); }
		else{ exchange = lmp(currentplayer); }

		if (exchange == true) { count += std::stoi(x);}
		//else { std::cout << "The card you selected is not in your hand.\nTRY AGAIN!!!"; gameplay(round, currentplayer, count);}
		gameplay(round , nplayer, count);
	}
}

//this function will allow the player to play the game.
void timeToplay() {
	std::cout << "Welcome players to Nim Type Zero.\n"
		<< "Before we begin,let me your dealer, explain the rules.\n"
		<< "You will each be dealt four cards, from a deck of 40 cards.\n"
		<< "The object of this game is to be the player who does not go over 9.\n"
		<< "Any players who go over 9 will not recieve a point.\n"
		<< "There will be three rounds and at the end of the third round the winnner will be anounced.\n"
		<< "Since I am unable to see you, I must warn all players...\n"
		<< "ANY CHEATING WILL AUTOMATICLY END THE GAME!!!\n"
		<< "Lets us begin the game.\n";

	makeDeck2();//make a deck of 40 cards.
	deck2 = swapcards();//making a deck of 40 cards with swapped values. 
	playersFaith();//deals the cards fairly to each player. 

	//this variable is used to determine who starts the game.
	std::string PTTL = dealerStands(dealersPosition);
	
	std::cout << "Player: " << PTTL << "  will start the game.\n" << "Than the player to the right will go next.\n";
	gameplay(1, PTTL, 0);//this function call will play all three rounds.

	std::queue<std::string> winners = findWinner(rounds);
	//use std::cout  to display the winner of the game and challenge all other loosers to a game. 
	if (winners.size() == 4) { std::cout << "Darn a draw want to play again...\n" << "then recompile the program again\n" << "or do not waste my time.\n"; }
	else {
		std::cout << "The winner(s) of the game is/are... \n";
		while (winners.size() > 0) {
			std::cout << winners.front() << " ";
			winners.pop();
		}
		std::cout << "\nFor all other players who lost..." << "\n I challange you to a game and if you beat me I will increase your score." << "\nWhat do you say,will you accepted my challenge?";
		std::cout << "\nTo accept the dealers challenge type 1 for yes or 2 for no.\n";
		std::string t;
		std::cin >> t;

		if (t == "2") { std::cout << "To bad...\n" << "It does not matter you were propably would of loose to me anyways.\n" << "HAHAHAHA!!!\n"; std::exit(0); }
		else {
			std::cout << "Your such a fool to challenge me!\n" << "No matter I know I will win.";
			// call the function for the third game. 
			gameStarter();
		}
	}
}
//-------------------------------------End of Actual gaming functions----------------------------------------------------------------
