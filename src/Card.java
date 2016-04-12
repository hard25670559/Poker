public enum Card {
	SPADE_ONE(Suit.SPADE, Number.ONE), SPADE_TWO(Suit.SPADE, Number.TWO), SPADE_THREE(Suit.SPADE, Number.THREE), SPADE_FOUR(Suit.SPADE, Number.FOUR), SPADE_FIVE(Suit.SPADE, Number.FIVE), SPADE_SIX(Suit.SPADE, Number.SIX), SPADE_SEVEN(Suit.SPADE, Number.SEVEN), SPADE_EIGHT(Suit.SPADE, Number.EIGHT), SPADE_NINE(Suit.SPADE, Number.NINE), SPADE_TEN(Suit.SPADE, Number.TEN), SPADE_ELEVEN(Suit.SPADE, Number.ELEVEN), SPADE_TWELVE(Suit.SPADE, Number.TWELVE), SPADE_THIRTEEN(Suit.SPADE, Number.THIRTEEN), 
	HEART_ONE(Suit.HEART, Number.ONE), HEART_TWO(Suit.HEART, Number.TWO), HEART_THREE(Suit.HEART, Number.THREE), HEART_FOUR(Suit.HEART, Number.FOUR), HEART_FIVE(Suit.HEART, Number.FIVE), HEART_SIX(Suit.HEART, Number.SIX), HEART_SEVEN(Suit.HEART, Number.SEVEN), HEART_EIGHT(Suit.HEART, Number.EIGHT), HEART_NINE(Suit.HEART, Number.NINE), HEART_TEN(Suit.HEART, Number.TEN), HEART_ELEVEN(Suit.HEART, Number.ELEVEN), HEART_TWELVE(Suit.HEART, Number.TWELVE), HEART_THIRTEEN(Suit.HEART, Number.THIRTEEN), 
	CLUB_ONE(Suit.CLUB, Number.ONE), CLUB_TWO(Suit.CLUB, Number.TWO), CLUB_THREE(Suit.CLUB, Number.THREE), CLUB_FOUR(Suit.CLUB, Number.FOUR), CLUB_FIVE(Suit.CLUB, Number.FIVE), CLUB_SIX(Suit.CLUB, Number.SIX), CLUB_SEVEN(Suit.CLUB, Number.SEVEN), CLUB_EIGHT(Suit.CLUB, Number.EIGHT), CLUB_NINE(Suit.CLUB, Number.NINE), CLUB_TEN(Suit.CLUB, Number.TEN), CLUB_ELEVEN(Suit.CLUB, Number.ELEVEN), CLUB_TWELVE(Suit.CLUB, Number.TWELVE), CLUB_THIRTEEN(Suit.CLUB, Number.THIRTEEN), 
	DIAMOND_ONE(Suit.DIAMOND, Number.ONE), DIAMOND_TWO(Suit.DIAMOND, Number.TWO), DIAMOND_THREE(Suit.DIAMOND, Number.THREE), DIAMOND_FOUR(Suit.DIAMOND, Number.FOUR), DIAMOND_FIVE(Suit.DIAMOND, Number.FIVE), DIAMOND_SIX(Suit.DIAMOND, Number.SIX), DIAMOND_SEVEN(Suit.DIAMOND, Number.SEVEN), DIAMOND_EIGHT(Suit.DIAMOND, Number.EIGHT), DIAMOND_NINE(Suit.DIAMOND, Number.NINE), DIAMOND_TEN(Suit.DIAMOND, Number.TEN), DIAMOND_ELEVEN(Suit.DIAMOND, Number.ELEVEN), DIAMOND_TWELVE(Suit.DIAMOND, Number.TWELVE), DIAMOND_THIRTEEN(Suit.DIAMOND, Number.THIRTEEN);
	
	private final Suit suit;
	private final Number number;
	
	private Card(Suit suit, Number number) {
		this.suit = suit;
		this.number = number;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
		
	public Number getNumber() {
		return this.number;
	}
		
}