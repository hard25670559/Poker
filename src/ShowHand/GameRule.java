package ShowHand;

import Poker.Card;
import RuleFramework.CardType;
import RuleFramework.TypeCompare;

public final class GameRule extends TypeCompare{
	
	/**
	 * ��յP�@����A�e�̬�����̡A��̬��Q�����
	 * �p�G����̪��P���j��Q����̴N�^��true�A�_�h�^��false
	 * 
	 * @param cards1	�����
	 * @param cards2	�Q�����
	 * 
	 * @return �^�ǵP���O�_�j��Q�����
	 */
	public static boolean isBigger(Card[] cards1, Card[] cards2) {
		return new GameRule().bigger(cards1, cards2);
	}
	
	
	@Override
	protected boolean bigger(Card[] cards1, Card[] cards2) {
		//�N�P���ഫ���P��
		Type type3 = TypeRule.getType(cards1);
		Type type4 = TypeRule.getType(cards2);
		
		if (type3.getCode() != type4.getCode())	//�p�G�P�����@�˴N�ઽ������j�p
			return type3.getCode() < type4.getCode();
		else {
			boolean bigger = false;
			
			switch (type3) {
				case STRAIGHT_FLUSH:
					bigger = this.compareStraightFlush(cards1, cards2);
					break;
				case FOUR_OF_A_KIND:
					bigger = this.compareFourOfAKind(cards1, cards2);
					break;
				case FULL_HOUSE:
					bigger = this.compareFullHouse(cards1, cards2);
					break;
				case FLUSH:
					bigger = this.compareFluse(cards1, cards2);
					break;
				case STRAIGHT:
					bigger = this.compareStraight(cards1, cards2);
					break;
				case THREE_OF_A_KIND:
					bigger = this.compareThreeOfAKind(cards1, cards2);
					break;
				case TWO_PAIRS:
					bigger = this.compareTwoPairs(cards1, cards2);
					break;
				case ONE_PAIR:
					bigger = this.compareOnePair(cards1, cards2);
					break;
				case HIGH_CARD:
					bigger = this.compareHighCard(cards1, cards2);
					break;
			}
			return bigger;
		}
	}
	
	private boolean compareHighCard(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareOnePair(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareTwoPairs(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareThreeOfAKind(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareStraight(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareFluse(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareFullHouse(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareFourOfAKind(Card[] type1, Card[] type2) {
		
		return false;
	}

	private boolean compareStraightFlush(Card[] type1, Card[] type2) {
		
		return false;
	}

	public static void main(String[] args) {
		
		
//		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
