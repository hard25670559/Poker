package ShowHand;

import Poker.Card;
import Poker.Number;
import RuleFramework.CardType;
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
	
	public static boolean compareHighCard(Card[] cards1, Card[] cards2) {
		boolean isBigger = false;
		
		for (int index=0 ; index<cards1.length ; index++) {
			if (cards1[index].getNumber() == Number.TWO || cards1[index].getNumber() == Number.ONE) {
				if (cards1[index].getNumber() == Number.TWO) {			//要是cards2[index]是2的話
					if (cards2[index].getNumber() != Number.TWO) {		//要是cards2[index]不是2的話，就沒有牌會比cards1[index]大
						isBigger =  true;		//cards1比較大
						break;
					}
				}
				if (cards1[index].getNumber() == Number.ONE) {
					if (cards2[index].getNumber() == Number.TWO) {		//唯獨1比二大
						isBigger =  false;		//cards1比較小
						break;
					} else {
						isBigger =  true;		//比2小的就是cards1比較大
						break;
					}
				}
			}
			//以下為普通的牌的三種狀況，分別是A>B A<B A=B，如果A=B就還需要再比對第一張的花色，因為一副牌內部可能會有相同花色
			if (cards1[index].getNumber().getCode() > cards2[index].getNumber().getCode()) {	//A>B case
				isBigger = true;
				break;
			}
			if (cards1[index].getNumber().getCode() < cards2[index].getNumber().getCode()) {	//A<B case
				isBigger = false;	////cards1比較小，所以isBigger = false
				break;
			}
			if (cards1[index].getNumber().getCode() == cards2[index].getNumber().getCode()) {	//A=B case
				if (index==4)
					isBigger = cards1[0].getSuit().getCode() > cards2[0].getSuit().getCode();
			}
			
		}
		
		return isBigger;
	}

	public static boolean compareOnePair(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static boolean compareTwoPairs(Card[] cards1, Card[] cards2) {
		
		return false;
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
