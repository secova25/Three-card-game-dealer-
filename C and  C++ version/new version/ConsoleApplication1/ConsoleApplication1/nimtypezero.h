#pragma once
#include<string>
#include<queue>
#include<utility>
#include<array>

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

//this class will host the players.
class players {
private:
	struct cardsHold {
		std::string card1;
		std::string card2;
		std::string card3;
		std::string card4;
	};
public:
	//this variable will help to access the players cards. 
	cardsHold* newplayer = new cardsHold();

	//main constructor.
	players() {}

	//customize constructor.
	players(std::string card1, std::string card2, std::string card3, std::string card4) {
		setCard1(card1);
		setCard2(card2);
		setCard3(card3);
		setCard4(card4);
	}
	//these are gets and sets functions
	std::string getCard1() { return newplayer->card1; }
	std::string getCard2() { return newplayer->card2; }
	std::string getCard3() { return newplayer->card3; }
	std::string getCard4() { return newplayer->card4; }

	void setCard1(std::string card) {newplayer->card1 = card; }
	void setCard2(std::string card) {newplayer->card2 = card; }
	void setCard3(std::string card) {newplayer->card3 = card; }
	void setCard4(std::string card) {newplayer->card4 = card; }

};

//populating the deck of cards by creating a variable that will store each card.
std::queue<NimofCards> deck2;
std::queue<players> player;
std::string storedeck[40];
int amountCard[4] = {0,0,0,0};//used to keep a track on how many 0s,1s,2s,3s are left.
std::queue <std::pair <std::string, std::string>> dealersPosition;


//this function will populate the deck and shuffle the cards. 
 void makeDeck2() {
	std::string numbers[4] = { "0","1","2","3" };
	std::string suites[4] = { "clubs","diamonds","hearts","spades" };
	std::string colour[4] = { "red","blue","green","yellow" };
	int k = 0; //access all the suites and colours.
	int w = 0;//used to travel between each value in storedeck.
	int y = 0; // used to traval between amountCard and dealersPosition;
	
	//using this for loop to initulize storepdeck.
	for (int q = 0; q < 40; q++) { storedeck[q] = ""; }
	
	//creating the deck first.
	for (std::string i : numbers) {
		for (int j = 0; j < 10; j++) {
			deck2.push(NimofCards(i, suites[k], colour[k]));
			storedeck[w] = i;
			w++;
		}
		k++;
	}

	//this for loop will store the amount for each card.
	for (int i = 0; i < 4; i++) {
		amountCard[i] = 10;
	}

	//storing each position that the deal can be in. 
	dealersPosition.push(std::make_pair("1", "2"));
	dealersPosition.push(std::make_pair("2", "3"));
	dealersPosition.push(std::make_pair("3", "4"));
	dealersPosition.push(std::make_pair("4", "1"));
}

//this function will swap each card in the deck. 
std::queue<NimofCards> swapcards() {
	std::queue<NimofCards>create;
	
	//swapping each card. 
	for (int p = 0; p < 40; p++) {
		int cardrand = rand() % 40;//selects a random card to swap with.
		std::string s = storedeck[p];
		storedeck[p] = storedeck[cardrand];
		storedeck[cardrand] = storedeck[p];
	}

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

//this function will keep a track of the card number that was selected.
void cardPicked(std::string card) {
	if (card == "0") { amountCard[0] -= 1; }
	else if (card == "1") { amountCard[1] -= 1; }
	else if (card == "2") { amountCard[2] -= 1; }
	else { amountCard[3] -= 1; }
}

//this function will decided what each player will recieve.
void playersFaith() {
	//Amount the card will be drew will alter as each player card get selected.
	int cda = 0;

	//variables for players
	std::string player1[4] = { "","","","" };
	std::string player2[4] = { "","","","" };
	std::string player3[4] = { "","","","" };
	std::string player4[4] = { "","","","" };

	//while looping to deal the cards 
	while (cda < 4) {
	
		player1[cda] = deck2.front().getCard();
		deck2.pop();
		cardPicked(player1[cda]);

		player2[cda] = deck2.front().getCard();
		deck2.pop();
		cardPicked(player1[cda]);
		
		player3[cda] = deck2.front().getCard();
		deck2.pop();
		cardPicked(player1[cda]);
		
		player4[cda] = deck2.front().getCard();
		deck2.pop();
		cardPicked(player1[cda]);
		
		cda++;
	}

} 

//this function will determine dealers position.
std::string dealerStands() {
	int r = rand() % 4;
	int i = 0;

	//locating what r selected. 
	while (i != r) { dealersPosition.pop(); }
	std::pair<std::string, std::string> a = dealersPosition.front();

	//removing all other positions that where not removed.
	while (dealersPosition.size() > 0) { dealersPosition.pop(); }
	
	return a.first;
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

//this function will keep the values per each round. 
void gameplay(int round, std::string currentplayer, int count,std::string value) {
	if (count > 9) {
		if (round == 3) { return; }
		else {
			std::string x = "";
			std::string nplayer = nextPlayers(currentplayer);
			std::cout << "Player: " << nplayer << " select your value that you are going to use next.\n";
			//include the cards that are remaining for the players to see.
			//make sure to remove each card that was used. Best way to do this is
			//make a lambda function that will help remove each card select. 
			cin >> x;
			count += std::stoi(x);
			gameplay((round + 1),nplayer,count , x);
			//add a variable that states who wins each round. 
		}
	}

	else {
		std::string x = "";
		std::string nplayer = nextPlayers(currentplayer);
		std::cout << "Player: " << nplayer << " select your value that you are going to use next.\n";
		//include the cards that are remaining for the players to see.
		//make sure to remove each card that was used. Best way to do this is
		//make a lambda function that will help remove each card select. 
		cin >> x;
		count += std::stoi(x);
		gameplay((round + 1), nplayer, count, x);
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
	int round = 0;
	
	//this variable is used to determine who starts the game.
	std::string PTTL = dealerStands();
	std::string nextPlayer = nextPlayers(PTTL);

	std::cout << "Player: " << PTTL << " will start the game.\n" << "Than the player to the right will go next.\n";
	
	//create a function that will find the next  player  for the other two rounds.
	
	std::cout << "Player: " << PTTL << "Which card will you select first...\n";
	std::string k;
	std::cin >> k;
	
	//call the remove function to remove the first players card. 

	// create a function that will keep a track of each round of values submited.
	gameplay(0, PTTL, 0, k);

	//using the variable cout the winner of the game and challenge all other loosers to a game. 

}
