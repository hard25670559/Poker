package ShowHand;

import Poker.Card;

public class Rule {
	private Card[] cards = new Card[5];
	
	public Rule(Card... cards) {
		this.cards = cards;
	}
	
	/**
	 * 判斷是否為同花
	 * 
	 * @return 回傳是或否
	 */
	private boolean isFlush() {
		boolean allSame = true;
		Card tmp = null;
		for (Card card : this.cards) {
			if (tmp != null) {
				if (card.getSuit() != tmp.getSuit())
					return false;
			} else {
				tmp = card;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
//		Rule r = new Rule(Card.CLUB_EIGHT, Card.HEART_EIGHT, Card.DIAMOND_EIGHT, Card.SPADE_EIGHT, Card.DIAMOND_SIX);
		Rule r = new Rule(Card.CLUB_EIGHT, Card.DIAMOND_FOUR, Card.DIAMOND_EIGHT, Card.DIAMOND_SIX, Card.DIAMOND_TEN);
		
		System.out.println(r.test());
		
	}
	

}
