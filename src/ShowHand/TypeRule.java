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
		return sameCount == 1;	//�p�G�۾F�t�s����աA�ΥN���@��
		
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
				if (card.getNumber() == cards[index].getNumber()) {	//�ݬݦ��S���@�˪���
					same++;		//�o�{�@�˪��ƴN�[�@
				}
			}
			if (same != 3)		//�p�G�S���ۦP���ƴN�N�ۦP���ƪ��ƶq�k�s
				same = 0;
			else
				break;			//�p�G�ۦP���ƶW�L�T�i�N�������X
		}
		
		return (isFourOfAKind(cards) || isFullHouse(cards)) ? false : same == 3;	//�p�G�P�_����Ī�Ϊ��K��A�N���O�T��
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
	 * ���ӳW�h���I�Ƥj�p�P��A�j�b�e�A�p�b��
	 * 
	 * @param cards	�Q�ާ@���P��
	 * @return
	 */
	public static Card[] ruleNumberSort(Card... cards) {
		cards = Poker.numberSort(cards);
		
		Card[] card_tmp = new Card[cards.length];
		int index = 0;
		
		for (int i=0 ; i<cards.length ; i++) {
			if (cards[i].getNumber() == Number.TWO) {
				
				card_tmp[index] = cards[i];
				index++;
			}
		}
		
		for (int i=0 ; i<cards.length ; i++) {
			if (cards[i].getNumber() == Number.ONE) {
				card_tmp[index] = cards[i];
				index++;
			}
		}
		
		int last = cards.length - index;
		
		for (int i=0 ; i<last ; i++) {
			card_tmp[index] = cards[cards.length - (i+1)];
			index++;
		}
		
		return card_tmp;
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
	
	/**
	 * �K�����ƧǡA�N�|�i�ۦP���P�Ʀb�̫e���A�ѤU���Ƴ̫�
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӱƧǧ����Ʋ�
	 */
	public static Card[] fourOfAKindSort(Card... cards) {
		cards = Poker.numberSort(cards);		//�N�P�����I�ƱƧ�
		
		Card tmp = null;	//��Ĥ@���P���Ȧs
		if (cards[0].getNumber() != cards[1].getNumber()) {
			for (int index=0 ; index<cards.length ; index++) {
				if (index==0) {
					tmp = cards[0];			//�N�Ĥ@����J�Ȧs
					cards[0] = cards[1];	//�N�ĤG�i�P��J�Ĥ@�i�P����}
				} else {
					if (index == 4) {
						cards[4] = tmp;		//�N�Ĥ@���P���̫�@�i�P����}
					} else {
						cards[index] = cards[index + 1];	//�N�U�@�i�P���e�@�i�P����}
					}
				}
			}
		}
		
		return cards;
	}
	
	/**
	 * �P�ᶶ���ƧǡA�Ѥp�P��j
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӱƧǧ����P��
	 */
	public static Card[] straightFlushSort(Card... cards) {
		cards = Poker.numberSort(cards);	//�P�ᶶ�]�����ۦP�A���ǥH�qnumberSort()�Ƨǧ����A�ҥH�S�����n�A�ƧǤ@��
		
		return cards;
	}
	
	/**
	 * ��Ī���ǡA�N���l��e���A�N��l��᭱
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӱƧǧ����P��
	 */
	public static Card[] fullHouseSotr(Card... cards) {
		cards = Poker.numberSort(cards);
		
		//��Ī���P���g�L�Ƨǫ�A���O�e���T�i�ᦳ��i�A�n���N�O�e����i�ᦳ�T�i�A�ҥH�u�n���D�ĤG����ĤT�i�O�_�O�P�˪��I�ƴN��P�_�O�_�n�Ƨ�
		if (cards[1].getNumber()!=cards[2].getNumber()) {
			Card[] pair = {cards[0], cards[1]};		//�e��i�@�w�O����l�A������l�Ȧs��
			Card[] threeOfAKind = {cards[2], cards[3], cards[4]};	//���i�@�w�O�����l�A�����Ȧs��
			
			for (int index=0 ; index<threeOfAKind.length ; index++) {		//�N���l���̫e��
				cards[index] = threeOfAKind[index];
			}
			
			for (int index=0 ; index<pair.length ; index++) {		//�N��l���̫᭱
				cards[index+3] = pair[index];
			}
		}
		
		return cards;
	}
	
	/**
	 * �P�᪺���ǡA2>1>13>12>11>10>9>8>7>6>5>4>3�A�V�j���ƶV�e��
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӱƧǧ����Ʋ�
	 */
	public static Card[] flushSort(Card... cards) {
		TypeRule.ruleNumberSort(cards);
		
		return cards;
	}
	
	/**
	 * ���l���ƧǡA�I�ƶV�j���ƶV�᭱
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	�^�ǱƧǧ����Ʋ�
	 */
	public static Card[] straightSort(Card... cards) {
		cards = Poker.numberSort(cards);
		
		return cards;
	}
	
	/**
	 * �T�����ƧǡA���l��e���A���i�h�Ӥj�p�\��A�j���\�e���A�p���ʫ᭱
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӱƧǧ����Ʋ�
	 */
	public static Card[] threeOfAKindSort(Card... cards) {
		cards = Poker.numberSort(cards);	//���N�P�Ƨ�
		
		Number num = null;					//�P�_���l���I�ƼȦs
		Card[] tmp = null;					//���P�P���Ȧs
		Card[] threeOfAKind = new Card[3];	//���l���Ȧs
		
		if ((num = cards[0].getNumber()) == cards[1].getNumber() && num == cards[2].getNumber()) {	//���i�����P�I�ơA�e�T�i�����l
			tmp = TypeRule.ruleNumberSort(cards[3], cards[4]);	//���j�p�Ƨ�
			//�̧ǩ�J�Ȧs
			threeOfAKind[0] = cards[0];
			threeOfAKind[1] = cards[1];
			threeOfAKind[2] = cards[2];
		}
		
		if ((num = cards[1].getNumber()) == cards[2].getNumber() && num == cards[3].getNumber()) {	//�Ĥ@�i�M�̫�@�i�I�Ƥ��P�A�����T�i�����l
			tmp = TypeRule.ruleNumberSort(cards[0], cards[4]);
			threeOfAKind[0] = cards[1];
			threeOfAKind[1] = cards[2];
			threeOfAKind[2] = cards[3];
		}
		
		if ((num = cards[2].getNumber()) == cards[3].getNumber() && num == cards[4].getNumber()) {	//�e��i�����P�I�ơA��T�i�����l
			tmp = TypeRule.ruleNumberSort(cards[0], cards[1]);
			threeOfAKind[0] = cards[2];
			threeOfAKind[1] = cards[3];
			threeOfAKind[2] = cards[4];
		}
		
		for (int index=0 ; index<threeOfAKind.length ; index++) {
			cards[index] = threeOfAKind[index];
		}
		
		cards[3] = tmp[0];
		cards[4] = tmp[1];
		
		return cards;
		
	}
	
	/**
	 * �̷ӵP�����Ƨ�
	 * 
	 * @param cards	�n�ާ@���P��
	 * @return	��^�@�ӵP�ԫ᪺�P��
	 */
	public static Card[] typeSote(Card... cards) {
		Type type = TypeRule.getType(cards);	//���T�w�P�լO��صP��
		
		switch (type) {
			case STRAIGHT_FLUSH:
				TypeRule.straightFlushSort(cards);
				break;
			case FOUR_OF_A_KIND:
				TypeRule.fourOfAKindSort(cards);
				break;
			case FULL_HOUSE:
				TypeRule.fullHouseSotr(cards);
				break;
			case FLUSH:
				TypeRule.flushSort(cards);
				break;
			case STRAIGHT:
				TypeRule.straightFlushSort(cards);
				break;
			case THREE_OF_A_KIND:
				TypeRule.threeOfAKindSort(cards);
				break;
			case TWO_PAIRS:
				break;
			case ONE_PAIR:
				break;
			case HIGH_CARD:
				TypeRule.ruleNumberSort(cards);		//���P���Ƨǥu�ݭn�z�L�I�ƪ��W�h�P��Y�i
				break;
		}
		
		return cards;
	}

	
}
