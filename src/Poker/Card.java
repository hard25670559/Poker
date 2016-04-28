package Poker;
public enum Card {
	SPADE_ONE(Suit.SPADE, Number.ONE, 0), SPADE_TWO(Suit.SPADE, Number.TWO, 1), SPADE_THREE(Suit.SPADE, Number.THREE, 2), SPADE_FOUR(Suit.SPADE, Number.FOUR, 3), SPADE_FIVE(Suit.SPADE, Number.FIVE, 4), SPADE_SIX(Suit.SPADE, Number.SIX, 5), SPADE_SEVEN(Suit.SPADE, Number.SEVEN, 6), SPADE_EIGHT(Suit.SPADE, Number.EIGHT, 7), SPADE_NINE(Suit.SPADE, Number.NINE, 8), SPADE_TEN(Suit.SPADE, Number.TEN, 9), SPADE_ELEVEN(Suit.SPADE, Number.ELEVEN, 10), SPADE_TWELVE(Suit.SPADE, Number.TWELVE, 11), SPADE_THIRTEEN(Suit.SPADE, Number.THIRTEEN, 12), 
	HEART_ONE(Suit.HEART, Number.ONE, 13), HEART_TWO(Suit.HEART, Number.TWO, 14), HEART_THREE(Suit.HEART, Number.THREE, 15), HEART_FOUR(Suit.HEART, Number.FOUR, 16), HEART_FIVE(Suit.HEART, Number.FIVE, 17), HEART_SIX(Suit.HEART, Number.SIX, 18), HEART_SEVEN(Suit.HEART, Number.SEVEN, 19), HEART_EIGHT(Suit.HEART, Number.EIGHT, 20), HEART_NINE(Suit.HEART, Number.NINE, 21), HEART_TEN(Suit.HEART, Number.TEN, 22), HEART_ELEVEN(Suit.HEART, Number.ELEVEN, 23), HEART_TWELVE(Suit.HEART, Number.TWELVE, 24), HEART_THIRTEEN(Suit.HEART, Number.THIRTEEN, 25), 
	CLUB_ONE(Suit.CLUB, Number.ONE, 26), CLUB_TWO(Suit.CLUB, Number.TWO, 27), CLUB_THREE(Suit.CLUB, Number.THREE, 28), CLUB_FOUR(Suit.CLUB, Number.FOUR, 29), CLUB_FIVE(Suit.CLUB, Number.FIVE, 30), CLUB_SIX(Suit.CLUB, Number.SIX, 31), CLUB_SEVEN(Suit.CLUB, Number.SEVEN, 32), CLUB_EIGHT(Suit.CLUB, Number.EIGHT, 33), CLUB_NINE(Suit.CLUB, Number.NINE, 34), CLUB_TEN(Suit.CLUB, Number.TEN, 35), CLUB_ELEVEN(Suit.CLUB, Number.ELEVEN, 36), CLUB_TWELVE(Suit.CLUB, Number.TWELVE, 37), CLUB_THIRTEEN(Suit.CLUB, Number.THIRTEEN, 38), 
	DIAMOND_ONE(Suit.DIAMOND, Number.ONE, 39), DIAMOND_TWO(Suit.DIAMOND, Number.TWO, 40), DIAMOND_THREE(Suit.DIAMOND, Number.THREE, 41), DIAMOND_FOUR(Suit.DIAMOND, Number.FOUR, 42), DIAMOND_FIVE(Suit.DIAMOND, Number.FIVE, 43), DIAMOND_SIX(Suit.DIAMOND, Number.SIX, 44), DIAMOND_SEVEN(Suit.DIAMOND, Number.SEVEN, 45), DIAMOND_EIGHT(Suit.DIAMOND, Number.EIGHT, 46), DIAMOND_NINE(Suit.DIAMOND, Number.NINE, 47), DIAMOND_TEN(Suit.DIAMOND, Number.TEN, 48), DIAMOND_ELEVEN(Suit.DIAMOND, Number.ELEVEN, 49), DIAMOND_TWELVE(Suit.DIAMOND, Number.TWELVE, 50), DIAMOND_THIRTEEN(Suit.DIAMOND, Number.THIRTEEN, 51);
	
	private final Suit suit;
	private final Number number;
	private final int code;
	
	private Card(Suit suit, Number number, int code) {
		this.suit = suit;
		this.number = number;
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
		
	public Number getNumber() {
		return this.number;
	}
	
	public static void main(String[] args) {
		for (Card card : Card.values()) {
			System.out.println(card);
		}
	}
	
}