//60 cards in the deck, in order to take a turn you must have a basic pokemon in your hand
//Write a monte carlo simulation; use raw brute force to figure out something interesting 

//What if your deck had exactly 1 pokemon. How many times would you expect to have "Mulligan" 
//in order to have your only pokemon in hand

//What if your deck had 2? etc.

//Write a simulation that shows the expected mulligans at 1-60 pokemons in your deck

//reshuffle 1000 times and find the odd of how many times you have one pokemon
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

public class PokemonCardGame {

	//A deck of cards
	private ArrayList <Card> deck; //This is the constructors job
	private ArrayList <Card> hand;
	
	
	//Initializes the variables 
	public PokemonCardGame() {
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		
		//int deckSize = 60;
		//deck.add(new Pokemon());
		//for(int i = 1; i < deckSize; i++) {
			//deck.add(new Energy());
		//}
	}
	
	//Setting up the deck and filling it with cards
	private void deckSetUp (int pokemonCount) { 
		deck.clear(); 
		//hand. clear(); 
		for (int i = 0; i < pokemonCount; i++) { 
			deck.add (new Pokemon ()); 
			} 
		//int energyCount = 60 - pokemonCount; 
		for (int i = pokemonCount; i < 60; i++) {//<----filling rest of deck with energy until 60 cards reached
		//for (int i = 0; i < energyCount; i++) deck.add(new Energy());
			deck.add(new Energy());
		}
	
	}

	//Method to draw a single random card
	public Card drawCard() {
		Random rng = new Random();
		int cardIndex = rng.nextInt(deck.size()); //Find random card
		//Card drawnCard = deck.get(cardIndex);
		return deck.remove(cardIndex);
		//return drawnCard;
	}
	
	//Method to draw 7 cards then reset hand
	public void drawHand() {
		 hand.clear();
		for(int i = 0; i < 7; i++) {//We're counting to 7
			hand.add(drawCard());
		}
	}
	//public boolean evaulateOpeningHand() {
		//boolean havePokemon = false;
		//for(int i = 0; i < hand.size(); i++) {
			//Card currentCard = hand.get(i);
			//if(currentCard instanceof Pokemon) {
				//return true;
	
	//Method to check if there is a pokemon card in hand
	private boolean hasPokemonInHand() {
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                return true;
			}
		}
		return false;
	}


//make engine for program
public void run() {
	//double trueCount = 0;
	//int amountRun = 1000;
	//for(int i = 0; i<=amountRun; i++) {
		//drawHand();
		//if(evaulateOpeningHand()==true) {
			//trueCount =+ 1;
	
	//Loop to vary number of cards drawn (deck 1-60)
	try (FileWriter csvWriter = new FileWriter("pokemon_Card_results.csv")) {
         csvWriter.append("Pokemon Count,Success Rate\n");
	for (int pokemonCount = 1; pokemonCount <= 60; pokemonCount++) {
        int successfulDraws = 0;//counter for successful draws of 1 pokemon
        for (int i = 0; i < 100000; i++) {
            deckSetUp(pokemonCount);
            drawHand();
            if (hasPokemonInHand()) {//Checks if one pokemon is in hand
                successfulDraws++;
		}
		
	}
        double percentage = (successfulDraws / 100000.0) * 100;
        System.out.println("Pokemon Count: " + pokemonCount + ", Success Rate: " + percentage + "%");
        csvWriter.append(pokemonCount + "," + percentage + "\n");
    }
	//drawHand();
	//System.out.println("Percentage of hands with pokemon: "+(trueCount / amountRun));
	//System.out.println("Has pokemon? " + evaulateOpeningHand());
	
}
	catch (IOException e) {
        e.printStackTrace();//DO CITATIONS
}
}
}


//have loop
//for(loop from 1 to 60) --> Pokemon
//if for example loop is at 3, we'd have looped 3 times and have 3 Pokemon per deck.
//for(loop from whatever we're at (i + 1) to 60) --> Energy
//rest are Energy.
 