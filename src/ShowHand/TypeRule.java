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
		return sameCount == 1;	//如果相鄰差零為兩組，及代表為一對
		
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
				if (card.getNumber() == cards[index].getNumber()) {	//看看有沒有一樣的排
					same++;		//發現一樣的排就加一
				}
			}
			if (same != 3)		//如果沒有相同的排就將相同的排的數量歸零
				same = 0;
			else
				break;			//如果相同的排超過三張就直接跳出
		}
		
		return (isFourOfAKind(cards) || isFullHouse(cards)) ? false : same == 3;	//如果判斷為葫蘆或者鐵支，就不是三條
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
	 * 按照規則的點數大小牌續，大在前，小在後
	 * 
	 * @param cards	被操作的牌組
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
	
	/**
	 * 鐵扇的排序，將四張相同的牌排在最前面，剩下的排最後
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個排序完的排組
	 */
	public static Card[] fourOfAKindSort(Card... cards) {
		cards = Poker.numberSort(cards);		//將牌先照點數排序
		
		Card tmp = null;	//放第一章牌的暫存
		if (cards[0].getNumber() != cards[1].getNumber()) {
			for (int index=0 ; index<cards.length ; index++) {
				if (index==0) {
					tmp = cards[0];			//將第一章放入暫存
					cards[0] = cards[1];	//將第二張牌放入第一張牌的位址
				} else {
					if (index == 4) {
						cards[4] = tmp;		//將第一章牌放到最後一張牌的位址
					} else {
						cards[index] = cards[index + 1];	//將下一張牌放到前一張牌的位址
					}
				}
			}
		}
		
		return cards;
	}
	
	/**
	 * 同花順的排序，由小牌到大
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個排序完的牌組
	 */
	public static Card[] straightFlushSort(Card... cards) {
		cards = Poker.numberSort(cards);	//同花順因為花色相同，順序以從numberSort()排序完畢，所以沒有必要再排序一次
		
		return cards;
	}
	
	/**
	 * 葫蘆順序，將條子放前面，將對子放後面
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個排序完的牌組
	 */
	public static Card[] fullHouseSotr(Card... cards) {
		cards = Poker.numberSort(cards);
		
		//葫蘆的牌型經過排序後，不是前有三張後有兩張，要不就是前有兩張後有三張，所以只要知道第二章跟第三張是否是同樣的點數就能判斷是否要排序
		if (cards[1].getNumber()!=cards[2].getNumber()) {
			Card[] pair = {cards[0], cards[1]};		//前兩張一定是為對子，先放到對子暫存內
			Card[] threeOfAKind = {cards[2], cards[3], cards[4]};	//後兩張一定是為條子，先放到暫存內
			
			for (int index=0 ; index<threeOfAKind.length ; index++) {		//將條子放到最前面
				cards[index] = threeOfAKind[index];
			}
			
			for (int index=0 ; index<pair.length ; index++) {		//將對子放到最後面
				cards[index+3] = pair[index];
			}
		}
		
		return cards;
	}
	
	/**
	 * 同花的順序，2>1>13>12>11>10>9>8>7>6>5>4>3，越大的排越前面
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個排序完的排組
	 */
	public static Card[] flushSort(Card... cards) {
		TypeRule.ruleNumberSort(cards);
		
		return cards;
	}
	
	/**
	 * 順子的排序，點數越大的排越後面
	 * 
	 * @param cards	要操作的牌組
	 * @return	回傳排序完的排組
	 */
	public static Card[] straightSort(Card... cards) {
		cards = Poker.numberSort(cards);
		
		return cards;
	}
	
	/**
	 * 三條的排序，條子放前面，後兩張則照大小擺放，大的擺前面，小的百後面
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個排序完的排組
	 */
	public static Card[] threeOfAKindSort(Card... cards) {
		cards = Poker.numberSort(cards);	//先將牌排序
		
		Number num = null;					//判斷條子的點數暫存
		Card[] tmp = null;					//不同牌的暫存
		Card[] threeOfAKind = new Card[3];	//條子的暫存
		
		if ((num = cards[0].getNumber()) == cards[1].getNumber() && num == cards[2].getNumber()) {	//後兩張為不同點數，前三張為條子
			tmp = TypeRule.ruleNumberSort(cards[3], cards[4]);	//做大小排序
			//依序放入暫存
			threeOfAKind[0] = cards[0];
			threeOfAKind[1] = cards[1];
			threeOfAKind[2] = cards[2];
		}
		
		if ((num = cards[1].getNumber()) == cards[2].getNumber() && num == cards[3].getNumber()) {	//第一張和最後一張點數不同，中間三張為條子
			tmp = TypeRule.ruleNumberSort(cards[0], cards[4]);
			threeOfAKind[0] = cards[1];
			threeOfAKind[1] = cards[2];
			threeOfAKind[2] = cards[3];
		}
		
		if ((num = cards[2].getNumber()) == cards[3].getNumber() && num == cards[4].getNumber()) {	//前兩張為不同點數，後三張為條子
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
	 * 依照牌型的排序
	 * 
	 * @param cards	要操作的牌組
	 * @return	返回一個牌敘後的牌組
	 */
	public static Card[] typeSote(Card... cards) {
		Type type = TypeRule.getType(cards);	//先確定牌組是何種牌型
		
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
				TypeRule.ruleNumberSort(cards);		//高牌的排序只需要透過點數的規則牌續即可
				break;
		}
		
		return cards;
	}

	
}
