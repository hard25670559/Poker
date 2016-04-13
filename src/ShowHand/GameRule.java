package ShowHand;

import RuleFramework.CardType;
import RuleFramework.TypeCompare;

public final class GameRule extends TypeCompare{
	private static GameRule gameRule = new GameRule();
	
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
		return GameRule.gameRule.bigger(type1, type2);
	}

	@Override
	protected boolean bigger(CardType type1, CardType type2) {
		return ((Type)type1).getCode() < ((Type)type2).getCode();
	}
	
	public static void main(String[] args) {
		System.out.println(GameRule.isBigger(Type.STRAIGHT_FLUSH, Type.FOUR_OF_A_KIND));
	}
	
}
