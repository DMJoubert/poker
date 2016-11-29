package deck;

import java.util.Collections;
import java.util.Stack;

import poker.*;

public class CardCollection extends Stack<Card> {
	private static final long serialVersionUID = 1L;

	private int high;
	
	public void print() {
		for (Card c : this) {
			System.out.println(c.toString());
		}
		
		System.out.println();
	}
	
	public void shuffle() {
		Collections.shuffle(this);
	}
	
	public void addAllStandard() {
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				Card c = new Card(s, r);
				
				this.push(c);
			}
		}
	}
	
	public CardCollection pop(int num) {
		CardCollection out = new CardCollection();
		
		for (int i = 0; i < num; i++) {
			if (!this.isEmpty()) out.push(this.pop());
			else break;
		}
		
		return out;
	}

	public HandType getHandType() {
        return HandType.FLUSH;
    }

	public static void main(String[] args) {
		CardCollection c = new CardCollection();
		c.addAllStandard();
		
		CardCollection d;
		d = c.pop(5);
		
		d.print();
		System.out.println();
	}
}
