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
	 * ���ӳW�h���I�Ƥj�p�P��A�j�b�e�A�p�b��
	 * 
	 * @param cards	�Q�ާ@���P��
	 * @return
	 */
	public static Card[] ruleNumberSort(Card... cards) {
		cards = Poker.numberSort(cards);
		
		Card[] card_tmp = new Card[cards.length];
		int index = 0;
		
		for (int i=0 ; i<cards.length ; i++) {
			if (cards[i].getNumber() == Number.TWO) {
				
				card_tmp[index] = cards[i];
				index++;
			}
		}
		
		for (int i=0 ; i<cards.length ; i++) {
			if (cards[i].getNumber() == Number.ONE) {
				card_tmp[index] = cards[i];
				index++;
			}
		}
		
		int last = cards.length - index;
		
		for (int i=0 ; i<last ; i++) {
			card_tmp[index] = cards[cards.length - (i+1)];
			index++;
		}
		
		return card_tmp;
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
