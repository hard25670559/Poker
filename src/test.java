import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		System.out.println(TypeRule.isTwoPairs(Card.CLUB_ONE, Card.DIAMOND_FOUR, Card.CLUB_THREE, Card.SPADE_ONE, Card.CLUB_FOUR));
	}
}
