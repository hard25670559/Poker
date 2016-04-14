package ShowHand;

import Poker.Card;
import Poker.Number;
import Poker.Poker;

public final class TypeRule {
	
	/**
	 * �P�_�O�_���P�ᶶ
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public static boolean isStraightFlush(Card... cards) {
		return TypeRule.isStraight(cards) && TypeRule.isFlush(cards);
	}
	
	/**
	 * �P�_�O�_���P��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public static boolean isFlush(Card... cards) {
		Card tmp = null;	//��ǼȦs
		
		for (Card card : cards) {
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
	public static boolean isStraight(Card... cards) {
		Card[] sort = Poker.numberSort(cards);
		
		if (sort[0].getNumber() == Number.ONE && sort[1].getNumber() == Number.TEN) {
			return (sort[2].getNumber() == Number.ELEVEN) && (sort[3].getNumber() == Number.TWELVE) && (sort[4].getNumber() == Number.THIRTEEN);
		}
		
		return false;
	}
	
	/**
	 * �P�_�O�_���K��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public static boolean isFourOfAKind(Card... cards) {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<cards.length ; index++) {
			
			System.out.println(index);
			
			if (index == 0) {	//���N�Ĥ@�i��J�Ȧs
				tmp = cards[index];
			} else {
				if (tmp.getNumber() == cards[index].getNumber()) {	//�P�_�۾F���P�O�_�ۦP
					sameCount++;
					if (sameCount == 3){	//���T���ۦP�N�����A�~��]�U�h
						isFourOfAKind = true;
						break;
					}
				} else {
					unsameCount++;
					if (unsameCount == 2) {	//���⦸���ۦP�N�����A�]�U�h
						isFourOfAKind = false;
						break;
					}
				}
				tmp = cards[index];	//�󴫼Ȧs���P�A�~����k�P�_�۾F���P
			}
		}
		return isFourOfAKind;
	}
}
