package ProjectPersonal.Thethreecarddealer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

import java.io.IOException;
import java.util.Random;
import java.util.Vector;

/**
 * JavaFX App
 */
public class App extends Application {
	CardGuess player = new CardGuess();
	ProbabilityGame player2 = new ProbabilityGame();
	TextField s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
	Button b1,b2,b3,b4, returna, Home, Exit;
	Label n1,n2,n3, card, cardV, cardS, choiceA, choiceS,choiceC,choiceN, info;
	HBox c1,c2,c3,c4,c5,c6,c7;
	VBox con1,con2, con3;
	Image game1,game2, game3, gameBackground,gameBackground2,gameBackground3, scene1;
	ImageView g1, g2,g3,gb1,gb2,gb3,sc1;
	BorderPane startPane,secondPane,thirdPane;
	Scene scene,secondary,third;
	int current,upperbound,lowerbound;

	  
	 public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
    	
    	//Probability Game
        s1 = new TextField();
        b1 = new Button();
        n1 = new Label("Probability Game");
        b1.setGraphic(n1);
        n1.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
        
        //NimTypeZero Game 
    	s2 = new TextField();
    	b2 = new Button();
    	n2 = new Label("Nim Type Zero");
    	b2.setGraphic(n2);
    	n2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
    	
    	//Card Guessing Game.
    	s3 = new TextField();
    	b3 = new Button();
    	n3 = new Label("Card Guessing Game");
    	b3.setGraphic(n3);
    	n3.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: Green;");
    	
    	//Creating startPane screen.
    	c1 = new HBox(b1,b2,b3);
    	
    	// create a background fill
        BackgroundFill bf = new BackgroundFill(Color.CORNFLOWERBLUE, 
                                      CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(bf);
    	
        //creating a label for directions on selecting a game.
        Label y = new  Label("Select one of the games above.");
        y.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 25pt; -fx-text-fill: green;");
    	
        //Scene background creation.
        scene1 = new Image("Capture.jpg");
    	sc1 = new ImageView(scene1);
    	
    	//Completing a BorderPane.
    	startPane = new BorderPane();
    	startPane.setTop(c1);
    	startPane.setBackground(background);
    	startPane.setCenter(sc1);
    	startPane.setBottom(y);
    	
    	//Probability Game.
		b1.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent a) {
			secondPane = new BorderPane();
			
			//informing the user on what to do.
			info = new Label(" Welcome the Probabilities. Please fill out the form below to select a card.");
			Label info2 = new Label(" If you do not want to select a card, type none into Card Value and then click the Submit button.");
			Label info3 = new Label(" Remember if you are choosing a card, all selections must be filled out.");
			Label info4 = new Label("If you like to return to the main screen to select a different game press the Return Button.");
			Label info5 = new Label();
			VBox q = new VBox(info,info2,info3,info4,info5); 
			
			info.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
			info2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
			info3.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
			info4.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
			
			
			//making the form that will be filled by the player;
			cardV = new Label("Card Value: ");
			s4 = new TextField();
			c2 = new HBox(cardV,s4);
			
			cardS = new Label("Suite:          ");
			s5 = new TextField();
			c3 = new HBox(cardS,s5);
			
			cardV.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: green;");
			cardS.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: green;");
			
			b4 = new Button("Submit");
			returna = new Button ("Return");
			
			HBox t = new HBox(b4,returna);
			con2 = new VBox(c2,c3,t);
			
			//Game will be played here. 
			b4.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent a) {gamePlay1(stage); }});
			
			//returns to the entrance. 
			returna.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent a) {
					stage.setScene(scene);
					stage.show();
				}});

			secondPane.setCenter(con2);
			secondPane.setTop(q);
			secondary = new Scene(secondPane,1000,1000);
			stage.setScene(secondary);
			stage.show();
		
		}});;
    	
		//Nim Type Zero game.
		b2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				stage.setScene(scene);
				stage.show();
			}});;
		
		//Card Guessing game.
		b3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) {
				GamePlay3(stage);
			}});;
			
    	scene = new Scene(startPane, 640, 480);
    	
    	stage.setScene(scene);
        stage.show();
    }

    //this function will play the Probability game. 
    public void gamePlay1(Stage stage) {
    	player2.makeDeck();// making the deck first.
		Vector <String> finalize = new Vector<String>();
		
		Label results = new Label("The size of the deck of cards is: " );
		Label fa = new Label(String.valueOf(player2.getDeck().size()));
		Label space = new Label();
		HBox cam = new HBox(results,fa);
		VBox resspace = new VBox(cam,space);
		
		//this will only be used if the user has select none.
		Random rand = new Random();
		int cardplayed = rand.nextInt(52);
		
		//player's request.
		String cardChoice = s4.getText();
		String suiteChoice = s5.getText();
		
		//test to see if the player choose none.
		if(cardChoice.equals("none")){
			finalize = player2.selectCard(player2.getDeck().get(cardplayed).getCard(),player2.getDeck().get(cardplayed).getShape());
		}
		else {
			finalize = player2.selectCard(cardChoice,suiteChoice);
		}
		
		//print out all information 
		//card and Suite will be shown first.
		Label cardSuitea = new Label("Your card and Suite are: ");
		Label f1 = new Label( finalize.get(0) + " "+ finalize.get(1));
		Label space2 = new Label();
		HBox combine = new HBox(cardSuitea,f1);
		VBox a1 = new VBox(combine, space2);
		
		//Probability of selecting the same card is next.
		Label sameCard = new Label("IF the card was return to the deck,The probability of ");
		Label sameCard2 = new Label("selecting the same card is: ");
		Label f2 = new Label(finalize.get(2));
		Label space3 = new Label();
		HBox combine2 = new HBox(sameCard2,f2);
		VBox b1 = new VBox(sameCard,combine2,space3);
		
		//Probability of selecting a different card with the same suite.
		Label sameSuite = new Label("IF the card was not placed back into the deck. The probability of ");
		Label sameSuite2 = new Label("selecting a diffrenet card with the same suite is: ");
		Label f3 = new Label(finalize.get(3));
		HBox combine3 = new HBox(sameSuite2,f3);
		Label space4 = new Label();
		VBox c1 = new VBox(sameSuite,combine3,space4);
		
		//Probability of selecting a different card with the same color.
		Label sameColor = new Label("IF the card was not placed back into the deck. The probability of ");
		Label sameColor2 = new Label("selecting a diffrenet card with the same color is: ");
		Label f4 = new Label(finalize.get(4));
		HBox combine4 = new HBox(sameColor2,f4);
		Label space5 = new Label();
		VBox d1 = new VBox(sameColor, combine4,space5);
		
		//Probability of selecting a different card with the same number.
		Label sameNum = new Label("IF the card was not placed back into the deck. The probability of ");
		Label sameNum2 = new Label("selecting a diffrenet card with the same suite is: ");
		Label f5 = new Label(finalize.get(5));
		HBox combine5 = new HBox(sameNum2,f5);
		Label space6 = new Label();
		VBox e1 = new VBox(sameNum,combine5, space6);
		
		//if the player wants to select a new card, new game or exit the program.
		Label res = new Label("Here is the results for you chosen card.");
		Label ra1a = new Label("To choose another card click the Return button.");	
		Label r = new Label("IF you want to play a different game press the Home button.");
		Label e = new Label("To exit the game select Exit button.");
		Label space7 = new Label();
		
		//Buttons that are needed. 
		Exit = new Button("Exit");
		Home = new Button("Home");
		Button ra1 = new Button("Return");
		HBox menuBoxes = new HBox(Home,ra1,Exit);
		
		//main VBoxes to be displayed. 
		VBox Top = new VBox(res,r,ra1a,e,space7,menuBoxes);
		VBox Center = new VBox(resspace,a1,b1,c1,d1,e1);
		
		
		//set on actions for all three buttons.
		Home.setOnAction(new EventHandler<ActionEvent>() {public void handle(ActionEvent a) {stage.setScene(scene);stage.show();}});;
		ra1.setOnAction(new EventHandler<ActionEvent>() {public void handle(ActionEvent a) {stage.setScene(secondary);stage.show();}});;
		Exit.setOnAction(new EventHandler<ActionEvent>() {public void handle(ActionEvent a) {System.exit(0);}});;
		
		//set all words to specific color. 
		
		//These are all for the introduction.
		res.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
		ra1a.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
		r.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
		e.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: black;");
		
		//These are for the results presentation.
		results.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		cardSuitea.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameCard.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameCard2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameColor.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameColor2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameSuite.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameSuite2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameColor.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameColor2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameNum.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		sameNum2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: red;");
		
		//These are the answers for probabilities.
		fa.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		f1.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		f2.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		f3.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		f4.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		f5.setStyle("-fx-font-family: Time New Roman; -fx-font-size: 15pt; -fx-text-fill: blue;");
		
		//making the third borderPane for results.
		BorderPane third = new BorderPane();
	
		third.setTop(Top);
		third.setCenter(Center);
		
		
		Scene three = new Scene(third, 1000,1000);
		stage.setScene(three);
		stage.show();
    }
    //This function will allow us to play Card Guess game. 
   public void GamePlay3(Stage stage) {
		//The welcoming screen.
		Label x = new Label ( "Ok let me explain the game so a novice like you can under stand it easily.");
		Label y = new Label ("I have a regular deck of 52 cards.");
		Label z = new Label ("Your job is to picture one card, together not seperate, and I will try to guess your card.");
		Label a1 = new Label("To make things intresting, I have converted each card with a special value.");
		Label b = new Label("The values are: ");
		Label c = new Label ("2 through 10 will be the value shown on the card.");
		Label d = new Label ( " While A = 1, J = 11, Q = 12 and K = 13.");
		Label e = new Label("These values are none negotiable.");
		Label f = new Label ("So, choose your card and lets begin the game.");
		Label ty2 = new Label("Use the Submit button for your responds.");
		Label g = new Label();
		
		VBox ted = new VBox(x,y,z,a1,b,c,d,e,f,ty2,g);//combining the introduction sentances.
		
		//Make two useful buttons.
		Label ty = new Label("If you want to select a new game press the Home button.");
		Label ty1 = new Label("If you want to Exit the game press the Exit button.");
		
		Button Home2 = new Button("Home");
		Button Exit2 = new Button("Exit");
		Button Submitd = new Button("Submit");
		HBox cre = new HBox(Home2,Submitd,Exit2);
		
		//time to play the game.
		
		Label gamep = new Label("Type your responds here.");
		TextField newtxt = new TextField();
		
		//set on actions for all two buttons.
		Home2.setOnAction(new EventHandler<ActionEvent>() {public void handle(ActionEvent a) {stage.setScene(scene);stage.show();}});;
		Exit2.setOnAction(new EventHandler<ActionEvent>() {public void handle(ActionEvent a) {System.exit(0);}});;
		
		
		//Creating the BorderPane for this page.
		BorderPane fa2 = new BorderPane();
		fa2.setTop(cre);
		fa2.setCenter(ted);
		Scene newTrade = new Scene(fa2,1000,1000);
		stage.setScene(newTrade);
		stage.show();
		
   }

}