package ShowHand;

import Poker.Card;

public class Rule {
	private Card[] cards = new Card[5];
	
	public Rule(Card... cards) {
		this.cards = cards;
	}
	
	/**
	 * �P�_�O�_���P�ᶶ
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public boolean isStraightFlush() {
		return this.isStraight() && this.isFlush();
	}
	
	/**
	 * �P�_�O�_���P��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public boolean isFlush() {
		Card tmp = null;	//��ǼȦs
		
		for (Card card : this.cards) {
			if (tmp != null) {
				if (card.getSuit() != tmp.getSuit())
					return false;	//���ۦP�N�����^��false
			} else {
				tmp = card;	//���w�@�i�@�����
			}
		}
		
		return true;	//�W�D�y�{�]���Y���P��
	}
	
	/**
	 * �P�_�O�_�����l
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public boolean isStraight() {
		
		
		
		return true;
	}
	
	/**
	 * �P�_�O�_���K��
	 * 
	 * @return �^�ǬO�Χ_
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
