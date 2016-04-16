package RuleFramework;

import Poker.Card;

/**
 * 兩組牌的比較介面
 * 
 * @author Anonymous
 *
 */
public abstract class TypeCompare {
	protected abstract boolean bigger(Card[] cards1, Card[] cards2);
	

}
