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
	private static boolean isStraightFlush(Card... cards) {
		return TypeRule.isStraight(cards) && TypeRule.isFlush(cards);
	}
	
	/**
	 * �P�_�O�_���P��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	private static boolean isFlush(Card... cards) {
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
	private static boolean isStraight(Card... cards) {
		cards = Poker.numberSort(cards);	//���N�P�շ��I�ƱƧ�
		
		if (cards[0].getNumber() == Number.ONE && cards[1].getNumber() == Number.TEN) {	//�P�_�O�_��A 10 11 12 13
			return (cards[2].getNumber() == Number.ELEVEN) && (cards[3].getNumber() == Number.TWELVE) && (cards[4].getNumber() == Number.THIRTEEN);
		} else {
			int oneDifference  = 0;	//�۾F�O�_�ۮt�@���ռ�
			for (int i=0 ; i<cards.length ; i++) {
				if (i!=4) {
					if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 1)
						oneDifference++;
				}
			}
			return oneDifference == 4;	//�p�G�۾F�t�@���|�աA�ΥN�����l
		}
		
	}
	/**
	 * �P�_�O�_�����
	 * 
	 * @return �^�ǬO�Χ_
	 */
	private static boolean isTwoPairs(Card... cards) {
		cards = Poker.numberSort(cards);	//���N�P�շ��I�ƱƧ�
		return false;
	}
	
	/**
	 * �P�_�O�_���@��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	private static boolean isOnePair(Card... cards) {
		cards = Poker.numberSort(cards);	//���N�P�շ��I�ƱƧ�
		
		int sameCount  = 0;	//�۾F�O�_�ۮt�s���ռ�
		for (int i=0 ; i<cards.length ; i++) {
			if (i!=4) {
				if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 0)
					sameCount++;
			}
		}
		return sameCount == 1;	//�p�G�۾F�t�s����աA�ΥN�����
		
	}
	
	
	/**
	 * �P�_�O�_���T��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	private static boolean isThreeOfAkind(Card... cards) {
		cards = Poker.numberSort(cards);	//�N�P�շ��I�ƱƧ�
		int same = 0;
		
		for (Card card : cards) {
			for (int index=0 ; index<cards.length ; index++) {
				if (card.getNumber() == cards[index].getNumber()) {
					same++;
				}
			}
			if (same != 3)
				same = 0;
			else
				break;
		}
		
		return isFullHouse(cards) ? false : same == 3;	//�p�G�P�_����Ī�A�N���O�T��
	}
	
	/**
	 * �P�_�O�_���K��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	private static boolean isFourOfAKind(Card... cards) {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<cards.length ; index++) {
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
	
	/**
	 * �P�_�O�_����Ī
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�O�Χ_
	 */
	private static boolean isFullHouse(Card...cards) {
		cards = Poker.numberSort(cards);
		//�ƧǹL��A�p�G�O����Ī�P���A�P�ժ��զX�Y���e�T�i���T�����i����l�Ϊ̫e��i����l���i�����l�A�ҥH�u���ˬd�O�_���e���i�H�~���I��
		Card[] check = {cards[0], cards[4]};
		
		for (Card card : cards) {
			if (!(check[0].getNumber() == card.getNumber() || check[1].getNumber() == card.getNumber()))
				return false;
		}
		
		return true;
	}
	
	/**
	 * �P�_�O�_�����P
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�O�_�����P
	 */
	private static boolean isHighCard(Card... cards) {
		//�p�G���O��L����P�էY�����P
		return !(TypeRule.isStraightFlush(cards) || TypeRule.isFlush(cards) || TypeRule.isStraight(cards) || TypeRule.isTwoPairs(cards) || TypeRule.isOnePair(cards) || TypeRule.isThreeOfAkind(cards) || TypeRule.isFourOfAKind(cards) || TypeRule.isFullHouse(cards));
	}
	
	/**
	 * ��J�P�ի��X�P��
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��X�P��
	 */
	public static Type getType(Card... cards) {
		Type anser = null;
		
		if (TypeRule.isHighCard(cards))
			anser =  Type.HIGH_CARD;
		if (TypeRule.isOnePair(cards))
			return Type.ONE_PAIR;
		if (TypeRule.isStraightFlush(cards))
			return Type.STRAIGHT_FLUSH;
		if (TypeRule.isStraight(cards))
			return Type.STRAIGHT;
		if (TypeRule.isFlush(cards))
			return Type.FLUSH;
		if (TypeRule.isFullHouse(cards))
			return Type.FULL_HOUSE;
		if (TypeRule.isThreeOfAkind(cards))
			return Type.THREE_OF_A_KIND;
		if (TypeRule.isTwoPairs(cards))
			return Type.TWO_PAIRS;
		if (TypeRule.isOnePair(cards))
			return Type.ONE_PAIR;
		
		return anser;
	}
}
