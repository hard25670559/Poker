import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		Card[] cards = TypeRule.fourOfAKindSort(Card.CLUB_FIVE, Card.CLUB_EIGHT, Card.DIAMOND_FIVE, Card.HEART_FIVE, Card.SPADE_FIVE);
		for (Card card : cards) {
			System.out.println(card);
		}
		
	}
}
