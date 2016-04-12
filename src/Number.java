public enum Number {
	ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8), TEN(9), ELEVEN(10), TWELVE(11), THIRTEEN(12);
	
	private final int code;
	
	private Number(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
}