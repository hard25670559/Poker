package ShowHand;

import RuleFramework.CardType;

public enum Type implements CardType {
	STRAIGHT_FLUSH(0), FOUR_OF_A_KIND(1), FULL_HOUSE(2), FLUSH(3), STRAIGHT(4), THREE_OF_A_KIND(5), TWO_PAIRS(6), ONE_PAIR(7), HIGH_CARD(8);
	
	private int code;

	private Type(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}
