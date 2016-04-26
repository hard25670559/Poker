import Poker.Card;
import Poker.Poker;
import ShowHand.GameRule;
import ShowHand.Type;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		
		System.out.println(GameRule.numberCompare(Card.CLUB_TWO, Card.CLUB_TWO));
		
		Card[] cards1 = {Card.DIAMOND_ELEVEN, Card.CLUB_ELEVEN, Card.CLUB_TWO, Card.SPADE_THREE, Card.HEART_TWO};
		Card[] cards2 = {Card.CLUB_TWO, Card.HEART_TWO, Card.SPADE_EIGHT, Card.DIAMOND_TWO, Card.CLUB_NINE};
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
