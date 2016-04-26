package ShowHand;

import Poker.Card;
import Poker.Number;
import Poker.Suit;
import RuleFramework.TypeCompare;

public final class GameRule extends TypeCompare{
	
	/**
	 * 兩組牌作比較，前者為比較者，後者為被比較者
	 * 如果比較者的牌型大於被比較者就回傳true，否則回傳false
	 * 
	 * @param cards1	比較者
	 * @param cards2	被比較者
	 * 
	 * @return 回傳牌型是否大於被比較者
	 */
	public static boolean isBigger(Card[] cards1, Card[] cards2) {
		return new GameRule().bigger(cards1, cards2);
	}
	
	
	@Override
	protected boolean bigger(Card[] cards1, Card[] cards2) {
		//將牌組轉換成牌型
		Type type3 = TypeRule.getType(cards1);
		Type type4 = TypeRule.getType(cards2);
		
		if (type3.getCode() != type4.getCode())	//如果牌型不一樣就能直接比較大小
			return type3.getCode() < type4.getCode();
		else {
			boolean bigger = false;
			
			//先將牌組排序過後，比較好做寫流程判斷
			cards1 = TypeRule.typeSort(cards1);
			cards2 = TypeRule.typeSort(cards2);
			
			switch (type3) {
				case STRAIGHT_FLUSH:
					bigger = GameRule.compareStraightFlush(cards1, cards2);
					break;
				case FOUR_OF_A_KIND:
					bigger = GameRule.compareFourOfAKind(cards1, cards2);
					break;
				case FULL_HOUSE:
					bigger = GameRule.compareFullHouse(cards1, cards2);
					break;
				case FLUSH:
					bigger = GameRule.compareFluse(cards1, cards2);
					break;
				case STRAIGHT:
					bigger = GameRule.compareStraight(cards1, cards2);
					break;
				case THREE_OF_A_KIND:
					bigger = GameRule.compareThreeOfAKind(cards1, cards2);
					break;
				case TWO_PAIRS:
					bigger = GameRule.compareTwoPairs(cards1, cards2);
					break;
				case ONE_PAIR:
					bigger = GameRule.compareOnePair(cards1, cards2);
					break;
				case HIGH_CARD:
					bigger = GameRule.compareHighCard(cards1, cards2);
					break;
			}
			return bigger;
		}
	}
	
	/**
	 * 兩張牌之間大小比較
	 * card1點數要是比card2大，救回傳WIN
	 * card1點數要是比card2小，救回傳LOSE
	 * card1點數要是跟card2一樣，救回傳DRAW
	 * 
	 * @param card1	第一章牌
	 * @param card2	第二章牌
	 * @return	返回輸贏狀態
	 */
	public static Status numberCompare(Card card1, Card card2) {
		Status status = Status.WIN;
		
		if (card1.getNumber() == Number.TWO || card1.getNumber() == Number.ONE) {
			if (card1.getNumber() == Number.TWO) {
				if (card2.getNumber() != Number.TWO) {
					status = Status.WIN;
				} else {
					status = Status.DRAW;
				}
			} else {
				if (card2.getNumber() == Number.TWO) {
					status = Status.LOSE;
				} else if (card2.getNumber() == Number.ONE) {
					status = Status.DRAW;
				} else {
					status = Status.WIN;
				}
			}
		} else {
			if (card1.getNumber() == card2.getNumber()) {
				status = Status.DRAW;
			} else if (card1.getNumber().getCode() > card2.getNumber().getCode()) {
				status = Status.WIN;
			} else {
				status = Status.LOSE;
			}
		}
		
		return status;
	}
	
	public static boolean compareHighCard(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		
		
		return isBigger;
	}

	public static boolean compareOnePair(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	/**
	 * 判斷兩組TwoPairs哪一個比較大？
	 * cards1比cards2大就回傳true，反之則船false
	 * 
	 * @param cards1	牌組一
	 * @param cards2	牌組二
	 * 
	 * @return	回傳cards1是否比cards2大
	 */
	public static boolean compareTwoPairs(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		switch (GameRule.numberCompare(cards1[0], cards2[0])) {
			case WIN:
				isBigger = true;
				break;
			case LOSE:
				isBigger = false;
				break;
			case DRAW:
				switch (GameRule.numberCompare(cards1[2], cards2[2])) {
					case WIN:
						isBigger = true;
						break;
					case LOSE:
						isBigger = false;
						break;
					case DRAW:
						switch (GameRule.numberCompare(cards1[4], cards2[4])) {
							case WIN:
								isBigger = true;
								break;
							case LOSE:
								isBigger = false;
								break;
							case DRAW:
								isBigger = (cards1[0].getSuit() == Suit.SPADE || cards1[1].getSuit() == Suit.SPADE) ? true : false;
								break;
						}
						break;
				}
				break;
		}
		
		return isBigger;
	}

	public static boolean compareThreeOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareStraight(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFluse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFullHouse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareFourOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareStraightFlush(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static void main(String[] args) {
		
		
//		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
