package ShowHand;

import java.util.LinkedList;

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
	public static boolean isTwoPairs(Card... cards) {
		cards = Poker.numberSort(cards);	//先將牌組照點數排序
		
		int sameCount  = 0;	//相鄰是否相差零的組數
		
		for (int i=0 ; i<cards.length ; i++) {
			if (i!=4) {
				if (cards[i+1].getNumber().getCode() - cards[i].getNumber().getCode() == 0) {
					sameCount++;
				} else {
					sameCount--;
				}
			}
		}
		return sameCount == 0;	//如果相鄰差零為兩組，及代表為兩對
		
	}
	
	/**
	 * 判斷是否為一對
	 * 
	 * @return 回傳是或否
	 */
	public static boolean isOnePairs(Card... cards) {
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
