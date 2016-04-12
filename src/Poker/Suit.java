package Poker;
public enum Suit {
	SPADE(0), HEART(1), CLUB(2), DIAMOND(3);
	
	private final int code;
	
	private Suit(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
}