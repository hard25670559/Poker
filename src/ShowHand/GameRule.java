package ShowHand;

import RuleFramework.CardType;
import RuleFramework.TypeCompare;

public final class GameRule extends TypeCompare{
	private static GameRule gameRule = new GameRule();
	
	/**
	 * ��յP�@����A�e�̬�����̡A��̬��Q�����
	 * �p�G����̪��P���j��Q����̴N�^��true�A�_�h�^��false
	 * 
	 * @param type1	�����
	 * @param type2	�Q�����
	 * 
	 * @return �^�ǵP���O�_�j��Q�����
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
