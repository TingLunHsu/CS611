/*
 * Dealer class that play games in the simulator
 */
public class Dealer extends Player{
    /*
     * A constructor that creates a new player
     */
    public Dealer(String name, int amount) {
		super(name, amount);
	}

    /*
     * Show the initial hand
     */
    public void showDealerHand() {
        System.out.println("Dealer's hand: {Unknown, " + hand.get(1) + "}");
    }

    /*
     * Dealer continues to hit till the value >= 17
     */
    public void deal() {
        while (this.getValue() < 17) {
            System.out.println("Dealer's hand:");
            this.showHand();
            this.dealNextCard();
        }

        System.out.println("Dealer's hand:");
        this.showHand();
    }

    /*
     * Whether the dealer's value is larger than the player
     */
    public boolean largerThan(Player player) {
        //boolean isLarger = false;

        int playerValue = player.getValue();
        int dealerValue = this.getValue();
        boolean isPlayerBlackJack = player.isBLackJack();
        boolean isDealerBlackJack = this.isBLackJack();

        if (playerValue > 21) {
            return true;
        } else if (dealerValue > 21) {
            return false;
        } else if (playerValue < dealerValue || (!isPlayerBlackJack && isDealerBlackJack)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * dealer's value is small than the player
     */
    public boolean smallerThan(Player player) {
        int playerValue = player.getValue();
        int dealerValue = this.getValue();
        boolean isPlayerBlackJack = player.isBLackJack();
        boolean isDealerBlackJack = this.isBLackJack();

        if (playerValue > 21) {
            return false;
        } else if (dealerValue > 21) {
            return true;
        } else if (playerValue > dealerValue || (isPlayerBlackJack && !isDealerBlackJack)) {
            return true;
        } else {
            return false;
        }
    }
}
