package ShowHand;

import Poker.Card;
import RuleFramework.CardType;
import RuleFramework.TypeCompare;

public final class GameRule extends TypeCompare{
	
	/**
	 * 兩組牌作比較，前者為比較者，後者為被比較者
	 * 如果比較者的牌型大於被比較者就回傳true，否則回傳false
	 * 
	 * @param type1	比較者
	 * @param type2	被比較者
	 * 
	 * @return 回傳牌型是否大於被比較者
	 */
	public static boolean isBigger(CardType type1, CardType type2) {
		return new GameRule().bigger(type1, type2);
	}
	
	
	@Override
	protected boolean bigger(CardType type1, CardType type2) {
		
		if (type1.getCode() != type2.getCode())
			return type1.getCode() < type2.getCode();
		else {
			boolean bigger = false;
			
			switch ((Type)type1) {
				case STRAIGHT_FLUSH:
					bigger = this.compareStraightFlush((Type)type1, (Type)type2);
					break;
				case FOUR_OF_A_KIND:
					bigger = this.compareFourOfAKind((Type)type1, (Type)type2);
					break;
				case FULL_HOUSE:
					bigger = this.compareFullHouse((Type)type1, (Type)type2);
					break;
				case FLUSH:
					bigger = this.compareFluse((Type)type1, (Type)type2);
					break;
				case STRAIGHT:
					bigger = this.compareStraight((Type)type1, (Type)type2);
					break;
				case THREE_OF_A_KIND:
					bigger = this.compareThreeOfAKind((Type)type1, (Type)type2);
					break;
				case TWO_PAIRS:
					bigger = this.compareTwoPairs((Type)type1, (Type)type2);
					break;
				case ONE_PAIR:
					bigger = this.compareOnePair((Type)type1, (Type)type2);
					break;
				case HIGH_CARD:
					bigger = this.compareHighCard((Type)type1, (Type)type2);
					break;
			}
			return bigger;
		}
	}
	
	private boolean compareHighCard(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareOnePair(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareTwoPairs(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareThreeOfAKind(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareStraight(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareFluse(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareFullHouse(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareFourOfAKind(Type type1, Type type2) {
		
		return false;
	}

	private boolean compareStraightFlush(Type type1, Type type2) {
		
		return false;
	}

	public static void main(String[] args) {
		
		
		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
