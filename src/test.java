import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		System.out.println(TypeRule.isStraightFlush(Card.CLUB_TWO, Card.CLUB_ONE, Card.CLUB_THREE, Card.CLUB_FOUR, Card.CLUB_FIVE));
	}
}
