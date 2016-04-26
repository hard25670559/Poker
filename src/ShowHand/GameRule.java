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
		Status status = Status.WIN;		//輸贏狀態
		
		if (card1.getNumber() == Number.TWO || card1.getNumber() == Number.ONE) {	//要是牌是2或1
			if (card1.getNumber() == Number.TWO) {		//要是牌是2
				if (card2.getNumber() != Number.TWO) {	//假如對方不是2
					status = Status.WIN;	//就一定贏了
				} else {
					status = Status.DRAW;	//如果是的話就是平手
				}
			} else {		//要是牌是1
				if (card2.getNumber() == Number.TWO) {	//除了2以外都比1小
					status = Status.LOSE;	//對方要是2就輸了
				} else if (card2.getNumber() == Number.ONE) {	//除非他是1
					status = Status.DRAW;		//依樣點數就是平手
				} else {	//1和2以外的
					status = Status.WIN;	//就贏了
				}
			}
		} else {	//除了1和2以外
			if (card1.getNumber() == card2.getNumber()) {	//要是牌的點數相同
				status = Status.DRAW;		//就平手
			} else if (card1.getNumber().getCode() > card2.getNumber().getCode()) {	//點數大就贏了
				status = Status.WIN;
			} else {
				status = Status.LOSE;		//點數小就輸了
			}
		}
		
		return status;		//回傳輸贏狀態
	}
	
	/**
	 * 判斷兩組高牌哪一組比較大
	 * 
	 * @param cards1	第一組牌
	 * @param cards2	第二組牌
	 * @return	cards1比較大就回傳true，反之則回傳false
	 */
	public static boolean compareHighCard(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		boolean change = false;		//判斷狀態是否改變
		
		for (int index=0 ; index<cards1.length && !change ; index++) {	//一張一張比，如果狀態改變就不需要再比下去
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
					if (index == 4)	//要是比了四次都是平手，就比手邊點數最大的花色
						isBigger = cards1[0].getSuit().getCode() < cards2[0].getSuit().getCode();
					break;
			}
		}
		
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
		
		switch (GameRule.numberCompare(cards1[0], cards2[0])) {	//判斷第一個對子
			case WIN:				//贏的狀況
				isBigger = true;
				break;
			case LOSE:				//輸的狀況
				isBigger = false;
				break;
			case DRAW:				//平手的狀況
				switch (GameRule.numberCompare(cards1[2], cards2[2])) {	//判斷第二個對子
					case WIN:
						isBigger = true;
						break;
					case LOSE:
						isBigger = false;
						break;
					case DRAW:
						switch (GameRule.numberCompare(cards1[4], cards2[4])) {	//判斷最後一張牌
							case WIN:
								isBigger = true;
								break;
							case LOSE:
								isBigger = false;
								break;
							case DRAW:
								//如果最後一張牌的點數還是一樣大，就比第一組對子的花色，有黑桃者比較大
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
	 * 判斷兩組三條哪個比較大
	 * 
	 * @param cards1	第一組牌
	 * @param cards2	第二組牌
	 * @return	如果cards1比cards2大就回傳true，反之則回傳false
	 */
	public static boolean compareThreeOfAKind(Card[] cards1, Card[] cards2) {
		boolean isBigger = GameRule.numberCompare(cards1[0], cards2[0]) == Status.WIN ? true : false;
		
		return isBigger;
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
