import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		Card[] cards = TypeRule.twoPairsSort(Card.CLUB_FIVE, Card.CLUB_ONE, Card.DIAMOND_ONE, Card.HEART_FIVE, Card.CLUB_SEVEN);
		for (Card card : cards) {
			System.out.println(card);
		}
		
	}
}
