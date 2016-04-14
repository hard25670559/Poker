package ShowHand;

import Poker.Card;
import Poker.Number;
import Poker.Poker;

public final class TypeRule {
	
	/**
	 * 判斷是否為同花順
	 * 
	 * @return 回傳是或否
	 */
	public static boolean isStraightFlush(Card... cards) {
		return TypeRule.isStraight(cards) && TypeRule.isFlush(cards);
	}
	
	/**
	 * 判斷是否為同花
	 * 
	 * @return 回傳是或否
	 */
	public static boolean isFlush(Card... cards) {
		Card tmp = null;	//基準暫存
		
		for (Card card : cards) {
			if (tmp != null) {
				if (card.getSuit() != tmp.getSuit())
					return false;	//不相同就直接回傳false
			} else {
				tmp = card;	//指定一張作為基準
			}
		}
		
		return true;	//上訴流程跑完即為同花
	}
	
	/**
	 * 判斷是否為順子
	 * 
	 * @return 回傳是或否
	 */
	public static boolean isStraight(Card... cards) {
		cards = Poker.numberSort(cards);
		
		if (cards[0].getNumber() == Number.ONE && cards[1].getNumber() == Number.TEN) {	//判斷是否為A 10 11 12 13
			return (cards[2].getNumber() == Number.ELEVEN) && (cards[3].getNumber() == Number.TWELVE) && (cards[4].getNumber() == Number.THIRTEEN);
		} else {
			int oneDifference  = 0;	//相鄰是否相差1的組數
			for (int i=0 ; i<cards.length ; i++) {
				if (i!=4) {
					if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 1)
						oneDifference++;
				}
			}
			return oneDifference == 4;	//如果相鄰差一為四組，及代表為順子
		}
		
	}
	
	/**
	 * 判斷是否為鐵扇
	 * 
	 * @return 回傳是或否
	 */
	public static boolean isFourOfAKind(Card... cards) {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<cards.length ; index++) {
			
			System.out.println(index);
			
			if (index == 0) {	//先將第一張丟入暫存
				tmp = cards[index];
			} else {
				if (tmp.getNumber() == cards[index].getNumber()) {	//判斷相鄰的牌是否相同
					sameCount++;
					if (sameCount == 3){	//有三次相同就不須再繼續跑下去
						isFourOfAKind = true;
						break;
					}
				} else {
					unsameCount++;
					if (unsameCount == 2) {	//有兩次不相同就不須再跑下去
						isFourOfAKind = false;
						break;
					}
				}
				tmp = cards[index];	//更換暫存的牌，才有辦法判斷相鄰的牌
			}
		}
		return isFourOfAKind;
	}
}
