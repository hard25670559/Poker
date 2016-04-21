import Poker.Card;
import Poker.Poker;
import ShowHand.GameRule;
import ShowHand.Type;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		Card[] cards1 = {Card.CLUB_ELEVEN, Card.CLUB_ELEVEN, Card.CLUB_THREE, Card.SPADE_ELEVEN, Card.SPADE_TWO};
		Card[] cards2 = {Card.DIAMOND_ONE, Card.CLUB_ELEVEN, Card.CLUB_THREE, Card.SPADE_ELEVEN, Card.SPADE_TWO};
		System.out.println("Is Cards1 bigger then Cards2?\n" + GameRule.compareHighCard(cards1, cards2));
		
		System.out.println();
		
		System.out.println("Cards1:");
		for (Card card : cards1) {
			System.out.println(card);
		}
		
		System.out.println();
		
		System.out.println("Cards2:");
		for (Card card : cards2) {
			System.out.println(card);
		}
	}
}
