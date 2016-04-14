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
	
}
