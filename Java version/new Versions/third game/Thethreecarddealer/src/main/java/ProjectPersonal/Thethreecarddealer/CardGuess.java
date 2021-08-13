package ProjectPersonal.Thethreecarddealer;
import javafx.util.Pair;
import java.util.Scanner;

public class CardGuess {
	String[] card = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
	private int lowerbound,upperbound,current;
	//constructor
	CardGuess(){
		setLowerbound(1);
		setUpperbound(13);
		setCurrent(7);
	}
	
	//Sets and gets functions.
	public void setLowerbound(int lowerbound) {this.lowerbound = lowerbound;}
	public void setUpperbound(int upperbound) {this.upperbound = upperbound;}
	public void setCurrent(int current) {this.current = current;}
	
	public int getLowerbound() {return this.lowerbound;}
	public int getUpperbound() {return this.upperbound;}
	public int getCurrent() {return this.current;}
//--------------------------------------------------------------	
	//find a card value.
	public void FindCard(String temp) {
		
			
			//Depending on the player(s) selection determines the alterations for the upperbound and lowerbound.
			 if (temp.equals("1")) {
				setLowerbound( getCurrent());
				setCurrent( ((getUpperbound() - getCurrent()) / 2) + getLowerbound());
			}
			else if (temp.equals("2")) {
				setUpperbound(getCurrent());
				setCurrent( ((getCurrent() - getLowerbound()) / 2) + getLowerbound());
			}

		
		
	}
//----------------------------------------------------------------------------	
	
}
