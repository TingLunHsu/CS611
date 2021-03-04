import java.util.*;

/*
 * Simulator of a blackjack game
 */
public class Simulator {  
	/*
	 * The main functionality of the games,
	 * players keep playing game after game till they want to exit
	 */
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in); 

		System.out.println("Hi, welcome to BlackJack!");


		// initialize the deck
		Deck deck = new Deck();

		// initailzie player/dealer
		Player player = new Player("A", 10000); // can add more player here if needed
		Dealer dealer = new Dealer("Dealer", 10000);

		// join the deck
		deck.joinDealer(dealer);
		deck.joinPlayer(player);

		String str;
		int amount;

		do {
			// player place bets
			while (true) {
				System.out.printf("How much do you want to bet? Choose a integer between 1 and " + player.getBets() + ": ");
				str = sc.nextLine();
				amount = Integer.parseInt(str);

				if (1 <= amount && amount <= player.getBets()) {
					break;
				} else{
					System.out.println("Please put a valid bet!");
				}
			};
			player.placeBets(amount);

			// initialize cards for player(s)
			deck.dealInitialCards();

			// show dealer's hand
			dealer.showDealerHand();

			// TODO: implement split
			// TODO: implement double

			// deal
			do {
				// print player's hand
				player.showHand();

				if (player.getValue() == 21) {
					break;
				}

				// ask whether the player want to deal another card
				while(true) {
					System.out.printf("Hit(H), Stand(S) or Double(D)? Please enter H/S/D: ");
					str = sc.nextLine();
					Character c = Character.toLowerCase(str.charAt(0));
					if ('h' == c || 's' == c || 'd' == c) {
						break;
					} else {
						System.out.println("Please enter a valid decision!");
					}
				};

				// hit
				if ('h' == Character.toLowerCase(str.charAt(0))) {
					player.dealNextCard();
					if (player.getValue() > 21) {
						player.showHand();
						System.out.println("Exceed 21, lose!");
					}
				// stand
				} else if ('s' == Character.toLowerCase(str.charAt(0))) {
					break;
				// double
				} else if ('d' == Character.toLowerCase(str.charAt(0))) {
					// place the same bets as initial amount to double the bets
					player.placeBets(amount);

					player.dealNextCard();
					player.showHand();
					if (player.getValue() > 21) {
						System.out.println("Exceed 21, lose!");
					}
					break;
				}
			} while (player.getValue() <= 21);

			// dealer's term
			dealer.deal();

			// compare score and apply gain/loss
			deck.calculateResult();

			// get the cards back from the players and reshuffle the deck
		   	deck.reinitializeCards();

			// end the game if player lose all the money
			if (player.getBets() == 0) {
				System.out.println("You lost, bye.");
				break;
			}

			// ask whether to start another game
			System.out.printf("Wanna play another round? (Y/N): ");
			str = sc.nextLine();
		} while ('y' == Character.toLowerCase(str.charAt(0)));

		// print the scores in the end
		System.out.println("Remaining bets for" + player.getName() + ": " + player.getBets());
		System.out.println("Remaining bets for" + dealer.getName() + ": " + dealer.getBets());
    }
}