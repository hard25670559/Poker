import Poker.Card;
import Poker.Poker;
import ShowHand.GameRule;
import ShowHand.Type;
import ShowHand.TypeRule;

public class test {
	public static void main(String[] args) {
		Card[] cards = {Card.DIAMOND_ONE, Card.CLUB_ELEVEN, Card.CLUB_THREE, Card.SPADE_ELEVEN, Card.SPADE_TWO};
		
		Card[] cards1 = {Card.CLUB_ELEVEN, Card.CLUB_ELEVEN, Card.CLUB_THREE, Card.SPADE_ELEVEN, Card.SPADE_TWO};
		Card[] cards2 = {Card.DIAMOND_ONE, Card.CLUB_ELEVEN, Card.CLUB_THREE, Card.SPADE_ELEVEN, Card.SPADE_TWO};
		System.out.println(GameRule.compareHighCard(cards1, cards2));
//		Card[] cards = {Card.DIAMOND_TWO, Card.DIAMOND_ONE, Card.SPADE_SEVEN, Card.DIAMOND_TWELVE, Card.DIAMOND_THIRTEEN};
		Type type = TypeRule.getType(cards);
		Card[] sort = TypeRule.typeSort(cards);
		
		System.out.println("Type:" + type);
		for (Card card : sort) {
			System.out.println(card);
		}
		
	}
}
