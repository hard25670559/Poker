package Poker;
/**
 * ���ͤ@�Ƽ��J�P
 * 
 * @author Anonymous
 *
 */
public class Poker {
	private Card[] poker = Card.values();
	private int count = this.poker.length;
	
	/**
	 * ���o�@�i���J�P�A�ñN�P�q�P�襤�R��
	 * 
	 * @return �@�i���J�P
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
	 * ���o�ثe���J�P�`�i��
	 * 
	 * @return ���J�P�`�i��
	 */
	public int getCount() {
		return this.count;
	}
	
	
	/**
	 * �~�P
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
