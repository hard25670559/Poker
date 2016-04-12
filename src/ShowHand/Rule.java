package ShowHand;

import Poker.Card;

public class Rule {
	private Card[] cards = new Card[5];
	
	public Rule(Card... cards) {
		this.cards = cards;
	}
	
	/**
	 * 判斷是否為同花順
	 * 
	 * @return 回傳是或否
	 */
	public boolean isStraightFlush() {
		return this.isStraight() && this.isFlush();
	}
	
	/**
	 * 判斷是否為同花
	 * 
	 * @return 回傳是或否
	 */
	public boolean isFlush() {
		Card tmp = null;	//基準暫存
		
		for (Card card : this.cards) {
			if (tmp != null) {
				if (card.getSuit() != tmp.getSuit())
					return false;	//不相同就直接回傳false
			} else {
				tmp = card;	//指定一張作為基準
			}
		}
		
		return true;	//上訴流程跑完即為同花
	}
	
	/**
	 * 判斷是否為順子
	 * 
	 * @return 回傳是或否
	 */
	public boolean isStraight() {
		
		
		
		return true;
	}
	
	/**
	 * 判斷是否為鐵扇
	 * 
	 * @return 回傳是或否
	 */
	public boolean isFourOfAKind() {
		
		
		
		return true;
	}
	
	public static void main(String[] args) {
//		Rule r = new Rule(Card.CLUB_EIGHT, Card.HEART_EIGHT, Card.DIAMOND_EIGHT, Card.SPADE_EIGHT, Card.DIAMOND_SIX);
//		Rule r = new Rule(Card.CLUB_EIGHT, Card.DIAMOND_FOUR, Card.DIAMOND_EIGHT, Card.DIAMOND_SIX, Card.DIAMOND_TEN);
		Rule r = new Rule(Card.DIAMOND_TWELVE, Card.DIAMOND_FOUR, Card.DIAMOND_EIGHT, Card.DIAMOND_SIX, Card.DIAMOND_TEN);
		
		System.out.println(r.isFlush());
		
	}
	

}
