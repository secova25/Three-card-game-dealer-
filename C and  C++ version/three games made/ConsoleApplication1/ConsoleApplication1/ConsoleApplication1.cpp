// ConsoleApplication1.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include "Propabilities.h"
#include "nimtypezero.h"
#include "CardGuess.h"

using namespace std;

void probperdiction(std::string card, std::string suite) {
   std::vector< std::string> results;
    
    //calling the function playerchoice from the Propabilities.h file.
    //the if statement will replace the nones for a random card in the deck.
    //while the else will find the players card and then send out the results.
    if (card == "none"){results = playerchoice("0", card,suite);}
    else {results = playerchoice("1", card, suite);}
    
    //determinig if anything is stored in results
    if (results.size() > 0) {
        std::cout << "Your card is:\n" << results[0] << " " << results[1];
        std::cout << "\n The probability of choosing the same card again\n" << " after placing it back into the deck is:\n" << results[2] << "%";
        std::cout << "\n The probability of choosing the same suite is:\n" << results[3] << "%";
        std::cout << "\n The probability of choosing the same color is:\n" << results[4] << "%";
        std::cout << "\n The probability of choosing the same number is:\n" << results[5] << "%";
        
        //Asking if they want to try a different card. 
        std::cout << "\n Would you like to pick another card?\n" << "Select 1 for yes and 0 to exit.\n";
        std::string userinput;
        cin >> userinput;
        if (userinput == "1") {
            std::cout << "If so type in the the card number exactly how it is shown from:\n " << "A,K,Q,J,2,3,4,5,6,7,8,9,10.\n" << "You can type none if you choose not to select a card number.";
            std::string userinput2;
            std::cin >> userinput2;

            if (userinput2 == "none") { probperdiction("none", "none"); }
            else {
                std::cout << "Know type in the suite you want your card to be.\n" << "You may select from:\n" << "diamonds, clubs, hearts or spades.\n" << "Please type it the way it is seen on the list thank you.\n";
                std::string userinput3;
                std::cin >> userinput3;
                probperdiction(userinput2, userinput3);
            }
        }
        else { return; }
    }
    else { 
        std::cout << "Failure to start due to either a wrong selection of type card or suite please try again.\n"; 
        
        //allowing the user to try again.
        std::cout << "Type in the the card number exactly how it is shown from:\n " << "A,K,Q,J,2,3,4,5,6,7,8,9,10.\n" << "You can type none if you choose not to select a card number.";
        std::string userinput2;
        std::cin >> userinput2;

        if (userinput2 == "none") { probperdiction("none", "none"); }
        else {
            std::cout << "Know type in the suite you want your card to be.\n" << "You may select from:\n" << "diamonds, clubs, hearts or spades.\n" << "Please type it the way it is seen on the list thank you.\n";
            std::string userinput3;
            std::cin >> userinput3;
            probperdiction(userinput2, userinput3);
        }
    }
}

int main()
{
    string userinput1;//used to determine what game the user wants to play.
    
    //used only if the player has decided to play the probability game and wants
    //to select their own card. 
    string userinput2;
    string userinput3;
    std::cout << "Which game do you want to play?\n" << "Type 1 for the Probability Card game.\n"<< "Type 2 for Nim type 0 game.\n" << "Or type 3 for CardGuess game.\n";
    std::cin >> userinput1;

    if (userinput1 == "1") {
        std::cout << "Would you like to select your own card  ?\n "<< "If so type in the the card number exactly how it is shown from:\n "<< "A,K,Q,J,2,3,4,5,6,7,8,9,10.\n" << "You can type none if you choose not to select a card number.\n";
        std::cin >> userinput2;
        if (userinput2 == "none") { probperdiction("none", "none"); }
        else {
            std::cout << "Know type in the suite you want your card to be.\n" << "You may select from:\n" << "diamonds, clubs, hearts or spades.\n"<<"Please type it the way it is seen on the list thank you.\n";
            std::cin >> userinput3;
            probperdiction(userinput2, userinput3);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //will be remove after testing perposes.
    else if (userinput1 == "3") { gameStarter(); }
    else { timeToplay(); }
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
