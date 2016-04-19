import Poker.Card;
import Poker.Poker;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		Card[] cards = TypeRule.threeOfAKindSort(Card.CLUB_FIVE, Card.CLUB_ONE, Card.CLUB_TWO, Card.HEART_FIVE, Card.SPADE_FIVE);
		for (Card card : cards) {
			System.out.println(card);
		}
		
	}
}
