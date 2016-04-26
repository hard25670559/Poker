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
					bigger = GameRule.straightFlushCompare(cards1, cards2);
					break;
				case FOUR_OF_A_KIND:
					bigger = GameRule.fourOfAKindCompare(cards1, cards2);
					break;
				case FULL_HOUSE:
					bigger = GameRule.fullHouseCompare(cards1, cards2);
					break;
				case FLUSH:
					bigger = GameRule.fluseCompare(cards1, cards2);
					break;
				case STRAIGHT:
					bigger = GameRule.straightCompare(cards1, cards2);
					break;
				case THREE_OF_A_KIND:
					bigger = GameRule.threeOfAKindCompare(cards1, cards2);
					break;
				case TWO_PAIRS:
					bigger = GameRule.twoPairsCompare(cards1, cards2);
					break;
				case ONE_PAIR:
					bigger = GameRule.onePairCompare(cards1, cards2);
					break;
				case HIGH_CARD:
					bigger = GameRule.highCardCompare(cards1, cards2);
					break;
			}
			return bigger;
		}
	}
	
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
		Status status = Status.WIN;		//��Ĺ���A
		
		if (card1.getNumber() == Number.TWO || card1.getNumber() == Number.ONE) {	//�n�O�P�O2��1
			if (card1.getNumber() == Number.TWO) {		//�n�O�P�O2
				if (card2.getNumber() != Number.TWO) {	//���p��褣�O2
					status = Status.WIN;	//�N�@�wĹ�F
				} else {
					status = Status.DRAW;	//�p�G�O���ܴN�O����
				}
			} else {		//�n�O�P�O1
				if (card2.getNumber() == Number.TWO) {	//���F2�H�~����1�p
					status = Status.LOSE;	//���n�O2�N��F
				} else if (card2.getNumber() == Number.ONE) {	//���D�L�O1
					status = Status.DRAW;		//�̼��I�ƴN�O����
				} else {	//1�M2�H�~��
					status = Status.WIN;	//�NĹ�F
				}
			}
		} else {	//���F1�M2�H�~
			if (card1.getNumber() == card2.getNumber()) {	//�n�O�P���I�ƬۦP
				status = Status.DRAW;		//�N����
			} else if (card1.getNumber().getCode() > card2.getNumber().getCode()) {	//�I�Ƥj�NĹ�F
				status = Status.WIN;
			} else {
				status = Status.LOSE;		//�I�Ƥp�N��F
			}
		}
		
		return status;		//�^�ǿ�Ĺ���A
	}
	
	/**
	 * �P�_��հ��P���@�դ���j
	 * 
	 * @param cards1	�Ĥ@�յP
	 * @param cards2	�ĤG�յP
	 * @return	cards1����j�N�^��true�A�Ϥ��h�^��false
	 */
	public static boolean highCardCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		boolean change = false;		//�P�_���A�O�_����
		
		for (int index=0 ; index<cards1.length && !change ; index++) {	//�@�i�@�i��A�p�G���A���ܴN���ݭn�A��U�h
			switch (GameRule.numberCompare(cards1[index], cards2[index])) {
				case WIN:
					isBigger = true;
					change = true;
					break;
				case LOSE:
					isBigger = false;
					change = true;
					break;
				case DRAW:
					if (index == 4)	//�n�O��F�|�����O����A�N������I�Ƴ̤j�����
						isBigger = cards1[0].getSuit().getCode() < cards2[0].getSuit().getCode();
					break;
			}
		}
		
		return isBigger;
	}

	/**
	 * �P�_���OnePair���@�Ӥ���j�H
	 * cards1��cards2�j�N�^��true�A�Ϥ��h��false
	 * 
	 * @param cards1	�P�դ@
	 * @param cards2	�P�դG
	 * 
	 * @return	�^��cards1�O�_��cards2�j
	 */
	public static boolean onePairCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		switch (GameRule.numberCompare(cards1[0], cards2[0])) {
			case WIN:				//Ĺ�����p
				isBigger = true;
				break;
			case LOSE:				//�骺���p
				isBigger = false;
				break;
			case DRAW:
				switch (GameRule.numberCompare(cards1[2], cards2[2])) {
					case WIN:				//Ĺ�����p
						isBigger = true;
						break;
					case LOSE:				//�骺���p
						isBigger = false;
						break;
					case DRAW:
						switch (GameRule.numberCompare(cards1[3], cards2[3])) {
							case WIN:				//Ĺ�����p
								isBigger = true;
								break;
							case LOSE:				//�骺���p
								isBigger = false;
								break;
							case DRAW:
								switch (GameRule.numberCompare(cards1[4], cards2[4])) {
									case WIN:				//Ĺ�����p
										isBigger = true;
										break;
									case LOSE:				//�骺���p
										isBigger = false;
										break;
									case DRAW:
										//�p�G�̫�@�i�P���I���٬O�@�ˤj�A�N��Ĥ@�չ�l�����A���®�̤���j
										isBigger = (cards1[0].getSuit() == Suit.SPADE || cards1[1].getSuit() == Suit.SPADE) ? true : false;
										break;
								}
								break;
						}
						break;
				}
				break;
		}
		
		return isBigger;
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
	public static boolean twoPairsCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		switch (GameRule.numberCompare(cards1[0], cards2[0])) {	//�P�_�Ĥ@�ӹ�l
			case WIN:				//Ĺ�����p
				isBigger = true;
				break;
			case LOSE:				//�骺���p
				isBigger = false;
				break;
			case DRAW:				//���⪺���p
				switch (GameRule.numberCompare(cards1[2], cards2[2])) {	//�P�_�ĤG�ӹ�l
					case WIN:
						isBigger = true;
						break;
					case LOSE:
						isBigger = false;
						break;
					case DRAW:
						switch (GameRule.numberCompare(cards1[4], cards2[4])) {	//�P�_�̫�@�i�P
							case WIN:
								isBigger = true;
								break;
							case LOSE:
								isBigger = false;
								break;
							case DRAW:
								//�p�G�̫�@�i�P���I���٬O�@�ˤj�A�N��Ĥ@�չ�l�����A���®�̤���j
								isBigger = (cards1[0].getSuit() == Suit.SPADE || cards1[1].getSuit() == Suit.SPADE) ? true : false;
								break;
						}
						break;
				}
				break;
		}
		
		return isBigger;
	}

	/**
	 * �P�_��դT�����Ӥ���j
	 * 
	 * @param cards1	�Ĥ@�յP
	 * @param cards2	�ĤG�յP
	 * @return	�p�Gcards1��cards2�j�N�^��true�A�Ϥ��h�^��false
	 */
	public static boolean threeOfAKindCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = GameRule.numberCompare(cards1[0], cards2[0]) == Status.WIN ? true : false;
		
		return isBigger;
	}

	/**
	 * �P�_��զP����Ӥ���j
	 * 
	 * @param cards1	�Ĥ@�յP
	 * @param cards2	�ĤG�յP
	 * @return	cards1����j�N�^��true�A�Ϥ��h�^��false
	 */
	public static boolean fluseCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = cards1[0].getSuit().getCode() < cards2[0].getSuit().getCode();
		
		return isBigger;
	}

	/**
	 * �P�_��ո�Ī���Ӥ���j
	 * 
	 * @param cards1	�Ĥ@�յP
	 * @param cards2	�ĤG�յP
	 * @return	�p�Gcards1��cards2�j�N�^��true�A�Ϥ��h�^��false
	 */
	public static boolean fullHouseCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = GameRule.numberCompare(cards1[0], cards2[0]) == Status.WIN ? true : false;
		
		return isBigger;
	}
	
	/**
	 * �P�_����K�����Ӥ���j
	 * 
	 * @param cards1	�Ĥ@�յP
	 * @param cards2	�ĤG�յP
	 * @return	�p�Gcards1��cards2�j�N�^��true�A�Ϥ��h�^��false
	 */
	public static boolean fourOfAKindCompare(Card[] cards1, Card[] cards2) {
		boolean isBigger = GameRule.numberCompare(cards1[0], cards2[0]) == Status.WIN ? true : false;
		
		return isBigger;
	}

	public static boolean straightFlushCompare(Card[] cards1, Card[] cards2) {
		
		return false;
	}
	
	public static boolean straightCompare(Card[] cards1, Card[] cards2) {
		
		return false;
	}
	
}
