import Poker.Card;
import Poker.Poker;

public class test {
	public static void main(String[] args) {
		for(Card card :Poker.numberSort(Card.CLUB_ONE, Card.CLUB_NINE, Card.CLUB_TEN, Card.CLUB_ELEVEN, Card.CLUB_TWELVE, Card.CLUB_THIRTEEN)) {
			System.out.println(card);
		}
	}
}
