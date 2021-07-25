#pragma once
#include<string>
#include <map>
#include <iterator>
#include<list>
#include<utility>


//This class is the start of the HashTable.
class HashTable {
private:
	
	//this list is used to store all cards in the deck of 52; 
	std::map<std::string, std::string> suite1;//stores the color with suite1. 
	std::map<std::string, std::string> suite2;//stores the color with suite2.
public:
	//constructor for HashTable
	HashTable() {}

	//sets and gets functions.
	void setSuite1(std::map<std::string,std::string> suite) { this->suite1 = suite; }
	void setSuite2(std::map<std::string,std::string> suite) { this->suite2 = suite; }
	std::string getSuite1(std::string color) { return this->suite1[color]; }
	std::string getSuite2(std::string color) { return this->suite2[color]; }

};

HashTable p;

//this function will populate deck3.
void makeDeck3() {
	std::map<std::string, std::string>suiteOne;
	std::map<std::string, std::string>suiteTwo;
	//populating the suites maps.
	suiteOne.insert(std::make_pair("red", "heart"));
	suiteOne.insert(std::make_pair("black", "clubs"));
	suiteOne.insert(std::make_pair("red", "spades"));
	suiteOne.insert(std::make_pair("black", "diamonds"));
	
	//calling p to set color1, color2, suites1 and suites2.
	p.setSuite1(suiteOne);
	p.setSuite2(suiteTwo);

}

//--------------------------Game Functions Sections-----------------------------------------

//this function will determine the suites from the color.
std::pair<std::string, std::string> suiteSelect(std::string color) {
	std::pair<std::string,std::string >suites;
	if (color == "red") { suites = std::make_pair(p.getSuite1(color),p.getSuite2(color)); }
	else if (color == "black") { suites = std::make_pair(p.getSuite1(color), p.getSuite2(color)); }
	else {
		std::cout
			<< "Are you really that dum.\n"
			<< "All you had to do was choose black or red and type it how you see it.\n"
			<< "This is not brain surgery.\n"
			<< "Try again and do not get me mad.\n";
		std::string y;
		std::cin >> y;
		suites = suiteSelect(y);
	}
	return suites;
}

//this function is will determine the users number. 
int reviewNum(int lowerbound, int upperbound,int currentValue) {
	int CardNum = 0;
	std::cout 
		<< "Is your card value greater then or less then/equal to " << currentValue << "?\n"
		<< "1) Type 1 for greater then.\n" 
		<< "2) Type 2 for less then/ equal to.\n";

	std::string x;
	std::cin >> x;
	
	//Depending on the player(s) selection determines the alterations for the upperbound and lowerbound.
	if (lowerbound == currentValue) { CardNum = upperbound; }

	else if (x == "1") { 
		lowerbound = currentValue;
		currentValue = ((upperbound - currentValue) / 2) + lowerbound;
		reviewNum(lowerbound, upperbound, currentValue);
	}
	else if (x == "2") {
		upperbound = currentValue;
		currentValue = ((currentValue - lowerbound) / 2) + lowerbound;
		reviewNum(lowerbound, upperbound, currentValue);
	}
	else { 
		std::cout << "Can you not read...\n" << "Either 1 or 2 its not hard.\n" << "Try again and this time think before you answer.\n"; 
		reviewNum(lowerbound, upperbound, currentValue);
	}
	return CardNum;
}


//this function is the main game starter.
void gameStarter() {
	
	makeDeck3();//making the deck.
	std::string card[13]{ "A","2","3","4","5","6","7","8","9","10","J","Q","K" };
	
	//The welcoming screen
	std::cout 
		<< "Ok let me explain the game so a novice like you can under stand it easily.\n"
		<< "I have a regular deck of 52 cards.\n "
		<< "Your job is to picture one card, together not seperate, and I will try to guess your card.\n"
		<<"To make things intresting, I have converted each card with a special value.\n"
		<<"The values are:\n"
		<<"2 through 10 will be the value shown on the card.\n "<< " While A = 1, J = 11, Q = 12 and K = 13.\n"
		<<"These values ar none negotiable.\n"
		<<"So, choose your card and lets begin the game.\n";
	
	int x = reviewNum(1, 13, 7) - 1;//this will store the number value of the card.

	//Requesting the color of the card will help find the suites. 
	std::cout
		<< "I believe I got some idea what the card value is.\n"
		<< "But before I can give you my guess I need you to tell me the color of the card.\n"
		<< "Type 1 for red.\n Type 2 for black.\n";

	std::string y;
	std::cin >> y;

	//Figuring out the suite 
	std::pair<std::string, std::string> suites; 
	if (y == "1") {suites = suiteSelect("red");}
	else { suites = suiteSelect("black"); }


	//Taking a guess. 
	std::cout 
		<< "I am ready to give you my answer.\n "
		<< "Your card is...\n"  
		
		<<" "<< suites.first << ".\n" << "If this is not your card allow me a second chance.\n" 
		<<"To allow the dealer a second chance, type 1.\n" << " If the dealer was correct type 0.\n";
	std::string z;
	std::cin >> z;
	
	//depending on the player(s) respond will determine the ending cout statements. 
	if (z == "1") {
		std::cout
			<< "I am ready to try again.\n "
			<< "Your card is...\n"
			<< card[x]
			<< " " << suites.second << ".\n" << "If it is not your card then you must of made a mistake.\n"
			<< "Therefore, I win this round.\n" << "See I knew you where all a bunch of looser(s).\n";
	}
	else if (z == "0") {
		std::cout 
			<< "So, let me see if I got this straight.\n"
			<< "Not only did you loose the previous game, but you also lost to me.\n"
			<< "You are pathetic and I want you think how a dealer like myslef was able to beat you so easily.\n"
			<< "I do not associate with loosers.\n"
			<<"So, get lost looser!!!";
	}
	else {
		std::cout
			<< "So, you beat me, big deal.\n"
			<< "Your still a looser and I do not associate with losers.\n"
			<< "Get lost you bunch of looser(s).\n";
	}

	std::exit(0);
}