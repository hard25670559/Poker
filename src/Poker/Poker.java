package Poker;

/**
 * 產生一副撲克牌
 * 
 * @author Anonymous
 *
 */
public class Poker {
	private Card[] poker = Card.values();
	private int count = this.poker.length;
	
	/**
	 * 取得一張撲克牌，並將牌從牌堆中刪除
	 * 
	 * @return 一張撲克牌
	 */
	public Card getCard() {
		Card card = this.poker[this.count - 1];
		this.count--;
		
		Card[] tmp = new Card[this.count];
		for (int index=0 ; index<this.poker.length-1 ; index++) {
			tmp[index] = this.poker[index]; 
		}
		
		this.poker = tmp;
		return card;
	}
	
	/**
	 * 取得目前撲克牌總張數
	 * 
	 * @return 撲克牌總張數
	 */
	public int getCount() {
		return this.count;
	}
	
	
	/**
	 * 洗牌
	 */
	public void shuffle() {
		Card[] tmp = new Card[this.poker.length];
		for (int i=0 ; i<this.poker.length ; i++) {
			int index = (int) (Math.random() * this.poker.length);
			if (tmp[index] == null) {
				tmp[index] = this.poker[i];
			} else {
				i--;
			}
		}
		
		this.poker = tmp;
	}
	
	/**
	 * 按照大小排序，小的在前，大的在後
	 * 透過氣泡排序法
	 * 
	 * @param cards	被操作的牌組
	 * @return	返回一個排序完的陣列
	 */
	public static Card[] numberSort(Card... cards) {
		Card card_tmp = null;	//如果相鄰兩值必須互換時，所需用到的暫存
		for (int i=0 ; i<cards.length ; i++) {
			for (int j=0 ; j<cards.length-i-1 ; j++) {
				if (cards[j].getNumber().getCode() > cards[j+1].getNumber().getCode()) {
					card_tmp = cards[j+1];
					cards[j+1] = cards[j];
					cards[j] = card_tmp;
				}
			}
		}
		return cards;
	}
	
	
	
	/**
	 * 將一組牌照花色分類
	 * 
	 * @param cards 被操作的陣列
	 * @return 返回一個分類完成的牌組
	 */
	public Card[] suitSort(Card... cards) {
		Card[] anser = new Card[cards.length];
		for (Suit suit : Suit.values()) {
			for (int index=0 ; index<cards.length ; index++) {
				if (suit == cards[index].getSuit()) {
					anser[index] = cards[index];
				}
			}
		}
		
		return anser;
	}
}
