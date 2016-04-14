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
	
	public Card[] numberSort(Card... cards) {
		Card[] tmp = new Card[cards.length];	//重新把牌排列的暫存
		Card[] residueCard = null;		//取出最大號碼牌，必須將剩餘的排放入這暫存
		for (int c=0 ; c<cards.length ; c++) {
			int max = 0;	//最大號碼暫存，預設0
			Card max_card = null;	//放最大號碼牌的暫存
			residueCard = new Card[cards.length-(c+1)];	//殘留的牌暫存實作
			for (int index=0 ; index<cards.length-c ; index++) {
				if (max < cards[index].getNumber().getCode()) {	//牌號碼比max大就把max替換成牌號碼
					max = cards[index].getNumber().getCode();	//取得最大牌號碼
					max_card = cards[index];	//將最大的牌存到暫存的最後一個位址去
				}
			}
			
			//將剩下的牌，放去暫存，以便下次比對
			for (int index=0 ; index<cards.length-c-1 ; index++) {
				System.out.println("index." + index);
				
//				if (cards[index] != max_card)	//如果要是和最大的牌一樣的話就跳過
//					residueCard[index] = cards[index];
			}
			
			tmp[(cards.length-c)-1] = max_card;
			System.out.println("max." + max);
		}
		
		return tmp;
	}
	
	public static void main(String[] args) {
		TypeRule r = new TypeRule(Card.CLUB_ONE, Card.CLUB_TWO, Card.CLUB_EIGHT, Card.CLUB_FIVE, Card.CLUB_THIRTEEN);
		
		for (Card card : r.numberSort(Card.CLUB_ONE, Card.CLUB_TWO, Card.CLUB_THREE, Card.CLUB_FIVE, Card.CLUB_FOUR))
			System.out.println(card);
		
//		System.out.println(r.isFourOfAKind());
		
	}
	

}
