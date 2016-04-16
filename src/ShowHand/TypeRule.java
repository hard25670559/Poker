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
	private static boolean isStraightFlush(Card... cards) {
		return TypeRule.isStraight(cards) && TypeRule.isFlush(cards);
	}
	
	/**
	 * 判斷是否為同花
	 * 
	 * @return 回傳是或否
	 */
	private static boolean isFlush(Card... cards) {
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
	private static boolean isStraight(Card... cards) {
		cards = Poker.numberSort(cards);	//先將牌組照點數排序
		
		if (cards[0].getNumber() == Number.ONE && cards[1].getNumber() == Number.TEN) {	//判斷是否為A 10 11 12 13
			return (cards[2].getNumber() == Number.ELEVEN) && (cards[3].getNumber() == Number.TWELVE) && (cards[4].getNumber() == Number.THIRTEEN);
		} else {
			int oneDifference  = 0;	//相鄰是否相差一的組數
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
	 * 判斷是否為兩對
	 * 
	 * @return 回傳是或否
	 */
	private static boolean isTwoPairs(Card... cards) {
		cards = Poker.numberSort(cards);	//先將牌組照點數排序
		return false;
	}
	
	/**
	 * 判斷是否為一對
	 * 
	 * @return 回傳是或否
	 */
	private static boolean isOnePair(Card... cards) {
		cards = Poker.numberSort(cards);	//先將牌組照點數排序
		
		int sameCount  = 0;	//相鄰是否相差零的組數
		for (int i=0 ; i<cards.length ; i++) {
			if (i!=4) {
				if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 0)
					sameCount++;
			}
		}
		return sameCount == 1;	//如果相鄰差零為兩組，及代表為兩對
		
	}
	
	
	/**
	 * 判斷是否為三條
	 * 
	 * @return 回傳是或否
	 */
	private static boolean isThreeOfAkind(Card... cards) {
		cards = Poker.numberSort(cards);	//將牌組照點數排序
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
		
		return isFullHouse(cards) ? false : same == 3;	//如果判斷為葫蘆，就不是三條
	}
	
	/**
	 * 判斷是否為鐵扇
	 * 
	 * @return 回傳是或否
	 */
	private static boolean isFourOfAKind(Card... cards) {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<cards.length ; index++) {
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
	
	/**
	 * 判斷是否為葫蘆
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回是或否
	 */
	private static boolean isFullHouse(Card...cards) {
		cards = Poker.numberSort(cards);
		//排序過後，如果是為葫蘆牌型，牌組的組合即為前三張為三條後兩張為對子或者前兩張為對子後兩張為條子，所以只需檢查是否有前後兩張以外的點數
		Card[] check = {cards[0], cards[4]};
		
		for (Card card : cards) {
			if (!(check[0].getNumber() == card.getNumber() || check[1].getNumber() == card.getNumber()))
				return false;
		}
		
		return true;
	}
	
	/**
	 * 判斷是否為高牌
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回是否為高牌
	 */
	private static boolean isHighCard(Card... cards) {
		//如果不是其他任何牌組即為高牌
		return !(TypeRule.isStraightFlush(cards) || TypeRule.isFlush(cards) || TypeRule.isStraight(cards) || TypeRule.isTwoPairs(cards) || TypeRule.isOnePair(cards) || TypeRule.isThreeOfAkind(cards) || TypeRule.isFourOfAKind(cards) || TypeRule.isFullHouse(cards));
	}
	
	/**
	 * 輸入牌組後輸出牌型
	 * 
	 * @param cards	要操作的牌組
	 * @return	輸出牌型
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
