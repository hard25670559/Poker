import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		System.out.println(TypeRule.isHighCard(Card.DIAMOND_TWO, Card.CLUB_TWO, Card.CLUB_THREE, Card.CLUB_FIVE, Card.CLUB_FOUR));
	}
}
