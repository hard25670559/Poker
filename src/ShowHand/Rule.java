package ShowHand;

import Poker.Card;

public class Rule {
	private Card[] cards = new Card[5];
	
	public Rule(Card... cards) {
		this.cards = cards;
	}
	
	private Type test() {
		for (int i=0 ; i<this.cards.length ; i++) {
			
		}
		
		return Type.FLUSH;
	}
	
	public static void main(String[] args) {
		Rule r = new Rule(Card.CLUB_EIGHT, Card.HEART_EIGHT, Card.DIAMOND_EIGHT, Card.SPADE_EIGHT, Card.DIAMOND_SIX);
		
		System.out.println(r.test());
		
	}
	

}
