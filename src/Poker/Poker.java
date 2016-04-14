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
	
	/**
	 * ���Ӥj�p�ƧǡA�p���b�e�A�j���b��
	 * �z�L��w�ƧǪk
	 * 
	 * @param cards	�Q�ާ@���P��
	 * @return	��^�@�ӱƧǧ����}�C
	 */
	public static Card[] numberSort(Card... cards) {
		Card card_tmp = null;	//�p�G�۾F��ȥ��������ɡA�һݥΨ쪺�Ȧs
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
	 * �N�@�յP�Ӫ�����
	 * 
	 * @param cards �Q�ާ@���}�C
	 * @return ��^�@�Ӥ����������P��
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
	
	public static Card[] typeSort() {
		return null;
	}
}
