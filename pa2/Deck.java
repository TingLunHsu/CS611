import java.util.*;

/*
 * A class that hold a deck of blackjack game
 */
public class Deck {
    private Dealer dealer;
    private List<Player> players;
    private List<Card> cards;

    public Deck() {
        this.initializeCards();
        this.players = new ArrayList<Player>();
    }

    /*
     * Shuffle the deck
     */
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    /*
     * Initialize the deck of cards
     */
    private void initializeCards() {
        this.cards = new ArrayList<Card>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                this.cards.add(new Card(Card.SUITS[i], Card.RANKS[j]));
            }
        }

        this.shuffleDeck();
    }

    /*
     * Get the cards back from the players and reshuffle the deck
     */
    public void reinitializeCards() {
        cards.addAll(dealer.removeCards());

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            cards.addAll(player.removeCards());
        }
        this.shuffleDeck();
        //System.out.println(this.cards);
    }

    /*
     * Deal next card 
     */ 
    public Card dealNextCard() {
        Card card = cards.remove(cards.size() - 1);
        // System.out.println(cards);
        return card;
    }

    /*
     * Deal initialize hands to all the people in the game
     */
    public void dealInitialCards() {

        // deal initial cards to dealer
        dealer.dealNextCard();
        dealer.dealNextCard();

        // deal initial cards to player
        for (int i = 0; i < players.size(); i++) {
            players.get(i).dealNextCard();
            players.get(i).dealNextCard();
        }
    }

    /*
     * Add a player to the game
     */
    public void joinPlayer(Player player) {
        this.players.add(player);
        player.joinGame(this);
    }

    /*
     * Add the dealer for the game
     */ 
    public void joinDealer(Dealer dealer) {
        this.dealer = dealer;
        dealer.joinGame(this);
    }

    /*
     * For each player, compare the value with dealer's, and apply the win/loss bets
     */
    public void calculateResult() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            // dealer wins
            if (dealer.largerThan(player)) {
                dealer.updateBets(player.getBetsThisTerm());
                System.out.println("Player " + player.getName() + " lost!");
            // player wins
            } else if (dealer.smallerThan(player)) {
                dealer.updateBets(-player.getBetsThisTerm());
                player.updateBets(2 * player.getBetsThisTerm());
                System.out.println("Player " + player.getName() + " won!");
            // even
            } else {
                player.updateBets(player.getBetsThisTerm());
                System.out.println("Even!");
            }

            System.out.println("The current bets that player " + 
                    player.getName() + " is " + player.getBets());
            
            // clear the player's bet for this term
            player.clearBetsThisTerm();
        }
    }

}
