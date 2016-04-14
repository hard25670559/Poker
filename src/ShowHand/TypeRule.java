package ShowHand;

import java.util.Arrays;

import Poker.Card;

public class TypeRule {
	private Card[] cards = new Card[5];
	
	public TypeRule(Card... cards) {
		this.cards = cards;
	}
	
	/**
	 * 判斷是否為同花順
	 * 
	 * @return 回傳是或否
	 */
	public boolean isStraightFlush() {
		return this.isStraight() && this.isFlush();
	}
	
	/**
	 * 判斷是否為同花
	 * 
	 * @return 回傳是或否
	 */
	public boolean isFlush() {
		Card tmp = null;	//基準暫存
		
		for (Card card : this.cards) {
			if (tmp != null) {
				if (card.getSuit() != tmp.getSuit())
					return false;	//不相同就直接回傳false
			} else {
				tmp = card;	//指定一張作為基準
			}
		}
		
		return true;	//上訴流程跑完即為同花
	}
	
	/**
	 * 判斷是否為順子
	 * 
	 * @return 回傳是或否
	 */
	public boolean isStraight() {
		Card[] tmp = new Card[this.cards.length];
		int[] num_tmp = new int[this.cards.length];
		
		for (int index=0 ; index<this.cards.length ; index++) {
			num_tmp[index] = this.cards[index].getNumber().getCode();
		}
		
		Arrays.sort(num_tmp);
			
		
		return false;
	}
	
	/**
	 * 判斷是否為鐵扇
	 * 
	 * @return 回傳是或否
	 */
	public boolean isFourOfAKind() {
		Card tmp = null;
		int sameCount = 0;
		int unsameCount = 0;
		boolean isFourOfAKind = false;
		for (int index=0 ; index<this.cards.length ; index++) {
			
			System.out.println(index);
			
			if (index == 0) {	//先將第一張丟入暫存
				tmp = this.cards[index];
			} else {
				if (tmp.getNumber() == this.cards[index].getNumber()) {	//判斷相鄰的牌是否相同
					sameCount++;
					if (sameCount == 3){	//有三次相同就不須再繼續跑下去
						isFourOfAKind = true;
						break;
					}
				} else {
					unsameCount++;
					if (unsameCount == 2) {	//有兩次不相同就不須再跑下去
						isFourOfAKind = false;
						break;
					}
				}
				tmp = this.cards[index];	//更換暫存的牌，才有辦法判斷相鄰的牌
			}
		}
		return isFourOfAKind;
	}
	
	public Card[] suitSort(Card... cards) {
		
		return null;
	}
	
	
	/**
	 * 按照大小排序，小的在前，大的在後
	 * 透過氣泡排序法
	 * 
	 * @param cards	被操作的牌組
	 * @return	返回一個排序完的陣列
	 */
	public static Card[] numberSort(Card... cards) {
		Card[] tmp = new Card[cards.length];	//重新把牌排列的暫存
		Card card_tmp = null;
		for (int i=0 ; i<cards.length ; i++) {
//			System.out.println("i=" + i + "\t");
			for (int j=0 ; j<cards.length-i-1 ; j++) {
				System.out.println("j=" + j + "\tj+i=" + (j+1));
//				if (cards[i].getNumber().getCode() < cards[j+1].getNumber().getCode()) {
//					System.out.println("i=" + i + "\ti+j=" + (j+1));
////					card_tmp = cards[i+1];
////					cards[i] = card_tmp;
////					cards[i+1] = cards[i];
//				}
			}
			System.out.println();
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		for (Card card : TypeRule.numberSort(Card.CLUB_EIGHT, Card.DIAMOND_EIGHT, Card.DIAMOND_FOUR, Card.HEART_FIVE))
			System.out.println(card);
	}
	

}
