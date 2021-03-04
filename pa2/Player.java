import java.util.*;

/*
 * Player class that play games in the simulator
 */
public class Player {
	protected String name;
	protected int bets;
	protected List<Card> hand;
	protected Deck deck;
	protected int betsThisTerm;
	protected boolean exploided;

	/*
     * A constructor that creates a new player
     */
	public Player(String name, int amount) {
		this.name = name;
		this.bets = amount;
		this.hand = new ArrayList<Card>();
		this.betsThisTerm = 0;
	}

	public String getName() {
		return name;
	}

	public int getBets() {
		return bets;
	}

	public int getBetsThisTerm() {
		return betsThisTerm;
	}

	/*
	 * Get the value of the player's current hand
	 */
	public int getValue() {
		//System.out.println(this.getName() + " getValue " + this.hand + "\n");
		int value = 0;
		boolean containsA = false;

		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			//System.out.println(i);
			//System.out.println(card);
			value += card.getValue();
			containsA |= card.getRank().equals("A");
		}

		if (containsA && value + 10 <= 21) {
			value += 10;
		}

		return value;
	}

	/*
	 * Join the player to the deck
	 */
	public void joinGame(Deck deck) {
		this.deck = deck;
	}

	public String toString() {
		return name + " " + bets;
	}

	/*
	 * Apply the amount change to player's bets
	 */
	public void updateBets(int amount) {
		this.bets += amount;
	}

	/*
	 * clear bets for this round
	 */
	public void clearBetsThisTerm() {
		this.betsThisTerm = 0;
	}

	/*
	 * Player place amount of bets
	 */
	public void placeBets(int amount) {
		this.bets -= amount;
		this.betsThisTerm += amount;
	}

	/*
	 * Insert a card to hand
	 */
	protected void insertCard(Card card) {
		this.hand.add(card);
	}

	/*
	 * Remove all the cards from hand
	 */
	public List<Card> removeCards() {
		List<Card> cards = hand;
		this.hand = new ArrayList<Card>();
		return cards;
	}

	/*
	 * Deal next card from the deck and add it to hand
	 */
	public void dealNextCard() {
		Card card = deck.dealNextCard();
		this.insertCard(card);
		// System.out.println(this.hand + "\n");
	}

	/*
	 * Show the hand
	 */
	public void showHand() {
		System.out.println("Current value: " + this.getValue());
		System.out.printf("Hand: {");

		int size = hand.size();
		for (int i = 0; i < size - 1; i++) {
			System.out.printf(hand.get(i).toString() + ", ");
		}
		
		if (size > 0) {
			System.out.printf(hand.get(size-1).toString());
		}

		System.out.println("}\n");
	}

	/*
	 * check if the player's hand is blackjack
	 */
	public boolean isBLackJack() {
		int size = hand.size();
		boolean blackjack = false;

		if (size == 2 && this.getValue() == 21) {
			blackjack = true;
		}

		return blackjack;
	}
}
