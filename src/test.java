import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		System.out.println(TypeRule.isFullHouse(Card.CLUB_ONE, Card.CLUB_EIGHT, Card.HEART_FOUR, Card.SPADE_ONE, Card.CLUB_FOUR));
	}
}
