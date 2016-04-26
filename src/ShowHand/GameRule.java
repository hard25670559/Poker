package ShowHand;

import Poker.Card;
import Poker.Number;
import Poker.Suit;
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
			
			//���N�P�ձƧǹL��A����n���g�y�{�P�_
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
	
	/**
	 * ��i�P�����j�p���
	 * card1�I�ƭn�O��card2�j�A�Ϧ^��WIN
	 * card1�I�ƭn�O��card2�p�A�Ϧ^��LOSE
	 * card1�I�ƭn�O��card2�@�ˡA�Ϧ^��DRAW
	 * 
	 * @param card1	�Ĥ@���P
	 * @param card2	�ĤG���P
	 * @return	��^��Ĺ���A
	 */
	public static Status numberCompare(Card card1, Card card2) {
		Status status = Status.WIN;
		
		if (card1.getNumber() == Number.TWO || card1.getNumber() == Number.ONE) {
			if (card1.getNumber() == Number.TWO) {
				if (card2.getNumber() != Number.TWO) {
					status = Status.WIN;
				} else {
					status = Status.DRAW;
				}
			} else {
				if (card2.getNumber() == Number.TWO) {
					status = Status.LOSE;
				} else if (card2.getNumber() == Number.ONE) {
					status = Status.DRAW;
				} else {
					status = Status.WIN;
				}
			}
		} else {
			if (card1.getNumber() == card2.getNumber()) {
				status = Status.DRAW;
			} else if (card1.getNumber().getCode() > card2.getNumber().getCode()) {
				status = Status.WIN;
			} else {
				status = Status.LOSE;
			}
		}
		
		return status;
	}
	
	public static boolean compareHighCard(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		
		
		return isBigger;
	}

	public static boolean compareOnePair(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	/**
	 * �P�_���TwoPairs���@�Ӥ���j�H
	 * cards1��cards2�j�N�^��true�A�Ϥ��h��false
	 * 
	 * @param cards1	�P�դ@
	 * @param cards2	�P�դG
	 * 
	 * @return	�^��cards1�O�_��cards2�j
	 */
	public static boolean compareTwoPairs(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		switch (GameRule.numberCompare(cards1[0], cards2[0])) {
			case WIN:
				isBigger = true;
				break;
			case LOSE:
				isBigger = false;
				break;
			case DRAW:
				switch (GameRule.numberCompare(cards1[2], cards2[2])) {
					case WIN:
						isBigger = true;
						break;
					case LOSE:
						isBigger = false;
						break;
					case DRAW:
						switch (GameRule.numberCompare(cards1[4], cards2[4])) {
							case WIN:
								isBigger = true;
								break;
							case LOSE:
								isBigger = false;
								break;
							case DRAW:
								isBigger = (cards1[0].getSuit() == Suit.SPADE || cards1[1].getSuit() == Suit.SPADE) ? true : false;
								break;
						}
						break;
				}
				break;
		}
		
		return isBigger;
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
