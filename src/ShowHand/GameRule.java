package ShowHand;

import Poker.Card;
import Poker.Number;
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
			cards1 = TypeRule.typeSort(cards1);
			cards2 = TypeRule.typeSort(cards2);
			
			switch (type3) {
				case STRAIGHT_FLUSH:
					bigger = GameRule.compareStraightFlush(cards1, cards2);
					break;
				case FOUR_OF_A_KIND:
					bigger = GameRule.compareFourOfAKind(cards1, cards2);
					break;
				case FULL_HOUSE:
					bigger = GameRule.compareFullHouse(cards1, cards2);
					break;
				case FLUSH:
					bigger = GameRule.compareFluse(cards1, cards2);
					break;
				case STRAIGHT:
					bigger = GameRule.compareStraight(cards1, cards2);
					break;
				case THREE_OF_A_KIND:
					bigger = GameRule.compareThreeOfAKind(cards1, cards2);
					break;
				case TWO_PAIRS:
					bigger = GameRule.compareTwoPairs(cards1, cards2);
					break;
				case ONE_PAIR:
					bigger = GameRule.compareOnePair(cards1, cards2);
					break;
				case HIGH_CARD:
					bigger = GameRule.compareHighCard(cards1, cards2);
					break;
			}
			return bigger;
		}
	}
	
	public static boolean compareHighCard(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		for (int index=0 ; index<cards1.length ; index++) {
			if (cards1[index].getNumber() == Number.TWO || cards1[index].getNumber() == Number.ONE) {
				if (cards1[index].getNumber() == Number.TWO) {			//�n�Ocards2[index]�O2����
					if (cards2[index].getNumber() != Number.TWO) {		//�n�Ocards2[index]���O2���ܡA�N�S���P�|��cards1[index]�j
						isBigger =  true;		//cards1����j
						break;
					}
				}
				if (cards1[index].getNumber() == Number.ONE) {
					if (cards2[index].getNumber() == Number.TWO) {		//�߿W1��G�j
						isBigger =  false;		//cards1����p
						break;
					} else {
						isBigger =  true;		//��2�p���N�Ocards1����j
						break;
					}
				}
			}
			//�H�U�����q���P���T�ت��p�A���O�OA>B A<B A=B�A�p�GA=B�N�ٻݭn�A���Ĥ@�i�����A�]���@�ƵP�����i��|���ۦP���
			if (cards1[index].getNumber().getCode() > cards2[index].getNumber().getCode()) {	//A>B case
				isBigger = true;
				break;
			}
			if (cards1[index].getNumber().getCode() < cards2[index].getNumber().getCode()) {	//A<B case
				isBigger = false;	////cards1����p�A�ҥHisBigger = false
				break;
			}
			if (cards1[index].getNumber().getCode() == cards2[index].getNumber().getCode()) {	//A=B case
				if (index==4)
					isBigger = cards1[0].getSuit().getCode() > cards2[0].getSuit().getCode();
			}
			
		}
		
		return isBigger;
	}

	public static boolean compareOnePair(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareTwoPairs(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareThreeOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareStraight(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFluse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFullHouse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFourOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareStraightFlush(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static void main(String[] args) {
		
		
//		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
