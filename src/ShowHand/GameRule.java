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
			
			switch (type3) {
				case STRAIGHT_FLUSH:
					bigger = this.compareStraightFlush(cards1, cards2);
					break;
				case FOUR_OF_A_KIND:
					bigger = this.compareFourOfAKind(cards1, cards2);
					break;
				case FULL_HOUSE:
					bigger = this.compareFullHouse(cards1, cards2);
					break;
				case FLUSH:
					bigger = this.compareFluse(cards1, cards2);
					break;
				case STRAIGHT:
					bigger = this.compareStraight(cards1, cards2);
					break;
				case THREE_OF_A_KIND:
					bigger = this.compareThreeOfAKind(cards1, cards2);
					break;
				case TWO_PAIRS:
					bigger = this.compareTwoPairs(cards1, cards2);
					break;
				case ONE_PAIR:
					bigger = this.compareOnePair(cards1, cards2);
					break;
				case HIGH_CARD:
					bigger = this.compareHighCard(cards1, cards2);
					break;
			}
			return bigger;
		}
	}
	
	private boolean compareHighCard(Card[] cards1, Card[] cards2) {
		for (int index=0 ; index<cards1.length ; index++) {
			if (!(cards1[index].getNumber() == cards2[index].getNumber())) {	//如果兩張牌點數一樣大，就可能必須再比花色大小
//				if (card.getNumber() == Number.ONE || card.getNumber() == Number.TWO)
//					return true;
//				else
//					return card.getNumber().getCode() > tmp.getNumber().getCode();
			}
		}
		
		return false;
	}

	private boolean compareOnePair(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareTwoPairs(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareThreeOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareStraight(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareFluse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareFullHouse(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareFourOfAKind(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	private boolean compareStraightFlush(Card[] cards1, Card[] cards2) {
		
		return false;
	}

	public static void main(String[] args) {
		
		
//		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
