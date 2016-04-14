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
	
	public Card[] numberSort(Card... cards) {
		Card[] tmp = new Card[cards.length];	//���s��P�ƦC���Ȧs
		Card[] residueCard = null;		//���X�̤j���X�P�A�����N�Ѿl���Ʃ�J�o�Ȧs
		for (int c=0 ; c<cards.length ; c++) {
			int max = 0;	//�̤j���X�Ȧs�A�w�]0
			Card max_card = null;	//��̤j���X�P���Ȧs
			residueCard = new Card[cards.length-(c+1)];	//�ݯd���P�Ȧs��@
			for (int index=0 ; index<cards.length-c ; index++) {
				if (max < cards[index].getNumber().getCode()) {	//�P���X��max�j�N��max�������P���X
					max = cards[index].getNumber().getCode();	//���o�̤j�P���X
					max_card = cards[index];	//�N�̤j���P�s��Ȧs���̫�@�Ӧ�}�h
				}
			}
			
			//�N�ѤU���P�A��h�Ȧs�A�H�K�U�����
			for (int index=0 ; index<cards.length-c-1 ; index++) {
				System.out.println("index." + index);
				
//				if (cards[index] != max_card)	//�p�G�n�O�M�̤j���P�@�˪��ܴN���L
//					residueCard[index] = cards[index];
			}
			
			tmp[(cards.length-c)-1] = max_card;
			System.out.println("max." + max);
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		TypeRule r = new TypeRule(Card.CLUB_ONE, Card.CLUB_TWO, Card.CLUB_EIGHT, Card.CLUB_FIVE, Card.CLUB_THIRTEEN);
		
		for (Card card : r.numberSort(Card.CLUB_ONE, Card.CLUB_TWO, Card.CLUB_THREE, Card.CLUB_FIVE, Card.CLUB_FOUR))
			System.out.println(card);
		
//		System.out.println(r.isFourOfAKind());
		
	}
	

}
