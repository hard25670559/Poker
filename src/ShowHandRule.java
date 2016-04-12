enum ShowHandType {
	STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIRS, ONE_PAIR, HIGH_CARD;
	
	private Card[] cards = new Card[5];
	
	
	public ShowHandType getType(Card[] cards) {
		return ShowHandType.FLUSH;
	}
	
}

class test {
	public static void main(String[] args) {
		
	}
}
