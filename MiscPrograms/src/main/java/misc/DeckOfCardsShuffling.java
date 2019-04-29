package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DeckOfCardsShuffling {
	
	
	public void deckOfCards(List<Integer> l) {
		
		while(l.size()>1) {
			l.add(l.get(0));
			
			l.remove(0);
			l.remove(0);
		}
		
	}

	public static void main(String args[]) {
		
       List<Integer> l = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
       
       DeckOfCardsShuffling b = new DeckOfCardsShuffling();
       b.deckOfCards(l);
       System.out.println(l);
       
	}
}
