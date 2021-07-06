#pragma once
#include<string>
#include <vector>

//You will have 52 deck of cards and the object of the game is to give the user
// a percentage of what is the chances of picking a random card with a specific
//suite, color, number, and/or shape. 

//class creation 
class DeckofCards {
private:
	char cardnumber;
	std::string color;
	std::string shape;

public:
	//constructor
	DeckofCards() {
		cardnumber = 'a';
		color = "";
		shape = ""; 
	}

	//these are gets and sets functions
	char getCard() { return cardnumber; }
	std::string getColor() { return color; }
	std::string getShape() { return shape; }

	void setCard(char number) { this->cardnumber = number; }
	void setColor(std::string color) { this->color = color; }
	void setShape(std::string shape) { this->shape = shape; }

};

//delcaring a variable to access the class.
std::vector<DeckofCards> deck;

//making the deck of cards.
//quick note just wanted to inform you that diamonds and clubs are black
// and hearts and spades are red. 
void makeDeck() {
	//these variables are used to store the values, colours and suites per each card.
	char number[13] = { 'A','K','Q','J','2','3','4', '5', '6', '7', '8', '9', '10' };
	std::string suites[4] = { "diamonds", "clubs", "hearts", "spades" };
	DeckofCards p;

	//using for loops and if statements to create the virtual card deck.
	for (std::string i:suites) {

		//if its a diamonds or clubs recall they are black.
		if((i == "diamonds") || (i == "clubs")){
			for (char j : number) {
				p.setCard(j);
				p.setColor("black");
				p.setShape(i);
				deck.push_back(p);
			}
		}
		else {
			for (char j : number) {
				p.setCard(j);
				p.setColor("red");
				p.setShape(i);
				deck.push_back(p);
			}
		}
		
	}
	 
}

//this function will help in calculate probability.
double prob(int x) {
	if (x == 1) { return 1.0; }
	else {
		return(x * prob(x - 1));
	}
	return 0.0;
}


//this function is used primarly to find out what is the chance of selecting
// a random card regardless of color, number, and/or shape.
std::vector<string> selectCard(char card, std::string suite) {
	std::vector<string> a;
	int i = 0; 

	//locating the selected card from the 52 cards
	while (i < deck.size()) {
		if ((deck[i].getCard() == card) &&(deck[i].getShape() == suite)) { 
			a.push_back(to_string(card));
			a.push_back(suite);
			
			//making the probabilty of selecting the same card calculation.
			double x = (1.0 / 52.0);
			a.push_back(to_string(x));
			
			//making the probabilty of selecting the same suite calculation.
			double y = (12.0 / 52.0);
			a.push_back(to_string(y));
			
			//making the probabilty of selecting the same colour calculation.
			double z = (25.0 / 52.0);
			a.push_back(to_string(z));
		}
	}
	return a;
}

//this function is used to determine what is the chance of picking a card with 
// a specific suite, color, number, and/or shape. Two of the three will be
//selected.
double selectCard2() { return 0.0; }

//this function will be used primarly to find out a card with a specific
//suite, color and number. All three will be selected here. 
double selectCard3() { return 0.0; }