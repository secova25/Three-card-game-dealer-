#pragma once
#include<string>
#include<vector>
#include<tuple>
#include<utility>

//You will have 52 deck of cards and the object of the game is to give the user
// a percentage of what is the chances of picking a random card with a specific
//suite, color, number, and/or shape. 

//class creation 
class DeckofCards {
private:
	struct Node {
		std::string cardnumber;
		std::string color;
		std::string shape;
		Node() {}
	};
public:
	Node* card = new Node();
	//main constructor.
	DeckofCards() {}

	//customize constructor.
	DeckofCards(std::string card, std::string color, std::string shape) {
		setCard(card);
		setColor(color); 
		setShape(shape);
	}
	//these are gets and sets functions
	std::string getCard() { return card->cardnumber; }
	std::string getColor() { return card->color; }
	std::string getShape() { return card->shape; }

	void setCard(std::string number) { card->cardnumber = number; }
	void setColor(std::string color) { card->color = color; }
	void setShape(std::string shape) { card->shape = shape; }

};

//delcaring a variable to access the class.

std::vector<DeckofCards> deck;

//making the deck of cards.
//quick note just wanted to inform you that diamonds and clubs are black
// and hearts and spades are red. 
void makeDeck() {
	//these variables are used to store the values, colours and suites per each card.
	std::string number[13] = { "A","K","Q","J","2","3","4", "5", "6", "7", "8", "9", "10" };
	std::string suites[4] = { "diamonds", "clubs", "hearts", "spades" };
	
	

	//using for loops and if statements to create the virtual card deck.
	for (std::string i:suites) {
		
		//if its a diamonds or clubs recall they are black.
		if((i == "diamonds") || (i == "clubs")){
			for (std::string j : number) {
				deck.push_back(DeckofCards(j,"black",i));
			}
		}
		else {
			for (std::string j : number) {
				deck.push_back(DeckofCards(j, "red", i));
			}
		}
		
	}
	 
}

//this function will help in calculate probability.
double prob(int x) {
	if (x == 1) { return 1.0; }
	else {return(x * prob(x - 1));}
	return 0.0;
}


//this function is used primarly to find out what is the chance of selecting
// a random card regardless of color, number, and/or shape.
std::vector<std::string> selectCard(std::string card, std::string suite) {
	std::vector<std::string> a; 

	//locating the selected card from the 52 cards
	for (int i = 0; i < 52; i++) {
		if ((deck[i].getCard() == card) &&(deck[i].getShape() == suite)) { 
			a.push_back(card);
			a.push_back(suite);
			
			//making the probabilty of selecting the same card calculation.
			double x = (1.0 / 52.0) * 100;
			a.push_back(std::to_string(x));
			
			//making the probabilty of selecting the same suite calculation.
			double y = (12.0 / 52.0) * 100;
			a.push_back(std::to_string(y));
			
			//making the probabilty of selecting the same colour calculation.
			double z = (25.0 / 52.0) * 100;
			a.push_back(std::to_string(z));
		}

	}
	return a;
}

//this functions sends out the results of the probabilies wither the player
//choose a card or not. 
std::vector<std::string> playerchoice(std::string playerChoose, std::string card, std::string suite) {
	std::vector<std::string> finalSelection;
	int cardplayed = rand() % 52; 
	makeDeck();
	std::cout << "The size of the deck of cards is: "<<deck.size() << "\n";
	if (playerChoose == "0") { finalSelection = selectCard(deck[cardplayed].getCard(), deck[cardplayed].getShape()); }
	else { finalSelection = selectCard(card,suite); }
	return finalSelection;
	}

