import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		System.out.println(TypeRule.isStraightFlush(Card.CLUB_TEN, Card.CLUB_TWELVE, Card.CLUB_ELEVEN, Card.CLUB_TWELVE, Card.CLUB_THIRTEEN));
	}
}
