package ShowHand;

import java.util.Arrays;

import Poker.Card;

public class TypeRule {
	private Card[] cards = new Card[5];
	
	public TypeRule(Card... cards) {
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
		Card[] tmp = new Card[this.cards.length];
		int[] num_tmp = new int[this.cards.length];
		
		for (int index=0 ; index<this.cards.length ; index++) {
			num_tmp[index] = this.cards[index].getNumber().getCode();
		}
		
		Arrays.sort(num_tmp);
			
		
		return false;
	}
	
	/**
	 * �P�_�O�_���K��
	 * 
	 * @return �^�ǬO�Χ_
	 */
	public boolean isFourOfAKind() {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<this.cards.length ; index++) {
			
			System.out.println(index);
			
			if (index == 0) {	//���N�Ĥ@�i��J�Ȧs
				tmp = this.cards[index];
			} else {
				if (tmp.getNumber() == this.cards[index].getNumber()) {	//�P�_�۾F���P�O�_�ۦP
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
				tmp = this.cards[index];	//�󴫼Ȧs���P�A�~����k�P�_�۾F���P
			}
		}
		return isFourOfAKind;
	}
	
	public Card[] suitSort(Card... cards) {
		
		return null;
	}
	
	
	/**
	 * ���Ӥj�p�ƧǡA�p���b�e�A�j���b��
	 * �z�L��w�ƧǪk
	 * 
	 * @param cards	�Q�ާ@���P��
	 * @return	��^�@�ӱƧǧ����}�C
	 */
	public static Card[] numberSort(Card... cards) {
		Card[] tmp = new Card[cards.length];	//���s��P�ƦC���Ȧs
		Card card_tmp = null;
		for (int i=0 ; i<cards.length ; i++) {
//			System.out.println("i=" + i + "\t");
			for (int j=0 ; j<cards.length-i-1 ; j++) {
				System.out.println("j=" + j + "\tj+i=" + (j+1));
//				if (cards[i].getNumber().getCode() < cards[j+1].getNumber().getCode()) {
//					System.out.println("i=" + i + "\ti+j=" + (j+1));
////					card_tmp = cards[i+1];
////					cards[i] = card_tmp;
////					cards[i+1] = cards[i];
//				}
			}
			System.out.println();
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		for (Card card : TypeRule.numberSort(Card.CLUB_EIGHT, Card.DIAMOND_EIGHT, Card.DIAMOND_FOUR, Card.HEART_FIVE))
			System.out.println(card);
	}
	

}
