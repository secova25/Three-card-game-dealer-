#pragma once
#include<string>
#include <map>
#include <iterator>
#include<list>
#include<utility>

//--------------------------Game Functions Sections-----------------------------------------
//this function is the main game starter.
void gameStarter() {
	
	//this variable stored in card will give us access to all the card.
	std::string card[13]{ "A","2","3","4","5","6","7","8","9","10","J","Q","K" };

	//these will be used to seperate the suites by color. 
	std::map<std::string, std::pair<std::string, std::string>> RDsuites;
	RDsuites.insert(std::make_pair("red", std::make_pair("hearts", "spades")));
	RDsuites.insert(std::make_pair("black", std::make_pair("clubs", "diamonds")));

	//this variable places the suites into a pair used for selecting the first and second suite for the specific color. 
	std::pair<std::string, std::string> selectedSuites;

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

	//this lambda will help find the number that the player(s) are thinking of.
	auto cardFound = [](int lowerbound, int upperbound, int currentValue) {
	
		//this while loop will ask the same question over and over again tell the dealer finds the correct number.
		while (lowerbound != currentValue) {
			std::cout
				<< "Is your card value greater then or less then/equal to " << currentValue << "?\n"
				<< "1) Type 1 for greater then.\n"
				<< "2) Type 2 for less then/ equal to.\n";

			std::string x;//store respond
			std::cin >> x;

			//Depending on the player(s) selection determines the alterations for the upperbound and lowerbound.
			 if (x == "1") {
				lowerbound = currentValue;
				currentValue = ((upperbound - currentValue) / 2) + lowerbound;
			}
			else if (x == "2") {
				upperbound = currentValue;
				currentValue = ((currentValue - lowerbound) / 2) + lowerbound;
			}

		}
		return upperbound;
	};

	auto cardNum = cardFound(1, 13, 7);//found card.
	cardNum -= 1;

	//Requesting the color of the card will help find the suites. 
	std::cout
		<< "I believe I got some idea what the card value is.\n"
		<< "But before I can give you my guess I need you to tell me the color of the card.\n"
		<< "Type 1 for red.\n Type 2 for black.\n";

	std::string y;
	std::cin >> y;

	//Figuring out the suite 
	std::pair<std::string, std::string> suites; 
	if (y == "1") { selectedSuites = RDsuites["red"]; }
	else { selectedSuites = RDsuites["black"]; }


	//Taking a guess. 
	std::cout
		<< "I am ready to give you my answer.\n "
		<< "Your card is...\n"
		<< card[cardNum]
		<<" "<< selectedSuites.first << ".\n" << "If this is not your card allow me a second chance.\n" 
		<<"To allow the dealer a second chance, type 1.\n" << " If the dealer was correct type 0.\n";
	std::string z;
	std::cin >> z;
	
	//depending on the player(s) respond will determine the ending cout statements. 
	if (z == "1") {
		std::cout
			<< "I am ready to try again.\n "
			<< "Your card is...\n"
			<< card[cardNum]
			<< " " << selectedSuites.second << ".\n" << "If it is not your card then you must of made a mistake.\n"
			<< "Therefore, I win this round.\n" << "See I knew you where all a bunch of looser(s).\n";
	}
	else if (z == "0") {
		std::cout 
			<< "So, let me see if I got this straight.\n"
			<< "You are pathetic to allow a dealer like myslef to beat you so easily.\n"
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