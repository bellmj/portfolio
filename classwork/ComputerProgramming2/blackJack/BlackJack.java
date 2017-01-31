package blackJack;
import java.util.Scanner;

import cards.*;
/** This class is the logic behind the blackjack game. In order to play the game an object should be created and the play() method should be called 
 * @author Matt Bell
 * @since Feb 25, 2014
 * @status this class appears to work testing has been done but not extensively 
 */
public class BlackJack {
	private Deck deck;
	private Hand dealer;
	private Hand player;
	/**
	 * Creates a blackJack object. It has a deck a dealer and a player
	 */
	public BlackJack(){
		deck = new Deck();
		dealer = new Hand();
		player = new Hand();
	}
	/**
	 * This method is the kickoff method for a game of black jack. It is the only public method. communication with this class is standard in standard out 
	 */
	public void play(){
		welcomeMessage();
		if(hits()){
			showHand(player);
			System.out.println("Sorry you busted");
		}
		else
		results();
	
		for(int i = 0; i < player.getHand().size();i++){
			
		}
		
	}
	/**
	 * this private method displays the results of the black jack game.
	 * @throws InterruptedException 
	 * 
	 */
	private void results(){
		showHand(dealer);
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		while(dealer.valueOfHand()<17){
			dealer.holdCard(deck.getCard());
			System.out.println("Dealer takes a card");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			showHand(dealer);
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(dealer.valueOfHand()>21){
			System.out.println("Dealer busts you win");
		}
		else if(player.valueOfHand() == dealer.valueOfHand()){
			System.out.println("The deals wins all ties ");
		}
		else if(player.valueOfHand() > dealer.valueOfHand() ){
			System.out.println("You win");
		}
		else {
			System.out.println("Dealer wins, you lose");
		}
		
		
		
	}
	/**
	 * this private method asks the player if he wants to hit and responds according displays a message and ends the game if player busts 
	 * @return if the player busted or not.
	 */
	private boolean hits(){
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while(run){
			if(player.valueOfHand() > 21){
				break;
			}
			showHand(player);
			System.out.println("Do you want to hit?(yes, or no)");
			if(scan.nextLine().equalsIgnoreCase("yes")){
				player.holdCard(deck.getCard());
			}
			else{
				run = false;
			}
		}
		scan.close();
		if(player.valueOfHand()>21)
			return true;
		return false;
	}
	/**
	 * takes in a Hand object of the hand to Display as well as the value of said hand  
	 * @param gamer
	 */
	private void showHand(Hand gamer){
		String show = (player == gamer?"You show a ":"Dealer shows a ");
		for(int i = 0; i < gamer.getHand().size();i++){
			if(i < gamer.getHand().size()-1)
			show += "" + gamer.getHand().get(i) + ", " ;
			else
				show += "and a " + gamer.getHand().get(i) + ".";
		}
		System.out.println(show);
		String temp = (player == gamer?"Value of your hand is ":"Value of his hand is ");
		System.out.println(temp+ gamer.valueOfHand());
	}
	/**
	 * this private methods gives the welcome message for the game of blackjack and gives the dealer 2 cards and the player two cards.
	 */
	private void welcomeMessage(){
		System.out.println("Welcome to BlackJack");
		dealer.holdCard(deck.getCard());
		dealer.holdCard(deck.getCard());
		System.out.println("Dealer shows a " + dealer.getHand().get(0));
		player.holdCard(deck.getCard());
		player.holdCard(deck.getCard());
	}
	
	
	

}
