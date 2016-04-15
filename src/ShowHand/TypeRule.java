package ShowHand;

import java.util.LinkedList;

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
	public static boolean isTwoPairs(Card... cards) {
		cards = Poker.numberSort(cards);	//���N�P�շ��I�ƱƧ�
		
		int sameCount  = 0;	//�۾F�O�_�ۮt�s���ռ�
		
		for (int i=0 ; i<cards.length ; i++) {
			if (i!=4) {
				if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 0) {
					sameCount++;
				} else {
					sameCount--;
				}
			}
		}
		return sameCount == 0;	//�p�G�۾F�t�s����աA�ΥN�����
		
	}
	
	/**
	 * �P�_�O�_���@��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public static boolean isOnePairs(Card... cards) {
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
	public static boolean isThreeOfAkind(Card... cards) {
		cards = Poker.numberSort(cards);
		LinkedList<Card> threeOfAkind = new LinkedList<>();
		
		for (Card c : cards) {
			for (Card tmp : cards) {
				System.out.print( c.getNumber() + " == " + tmp.getNumber() + " = " + (c.getNumber() == tmp.getNumber()) + "\t");
				
				if (c.getNumber() == tmp.getNumber()) {
					threeOfAkind.push(tmp);
				}
			}
			if (threeOfAkind.size() != 3)
				threeOfAkind.clear();
			else
				break;
			System.out.println();
		}
		
		return threeOfAkind.size() == 3;
		
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
