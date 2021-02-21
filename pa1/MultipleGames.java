import java.util.*;

/*
 * The main class of this directory
 * Allows users to start playing series of games
 */
public class MultipleGames {  
	private Player playerA;
	private Player playerB;

	/*
     * A constructor that initalize a game series between two players
     */
	public MultipleGames() {
		this.playerA = new Player("A");
		this.playerB = new Player("B");
	}


	/*
	 * The main functionality of the games,
	 * players keep playing game after game till they want to exit
	 */
	public void startPlayingGames() {
		Scanner sc = new Scanner(System.in); 

		System.out.println("Hi, welcome to game series!");

		String str;
		int gameindex;

		do {
			// ask what game to play
			while (true) {
				System.out.printf("What do you want to play? Enter 1 for TicTacToe, 2 for Orders and Chaos: ");
				str = sc.nextLine();
				gameindex = Integer.parseInt(str);

				if (1 <= gameindex && gameindex <= 2) {
					break;
				} else{
					System.out.println("Please enter a valid input!");
				}
			};

			// initialize and start the game
			if (gameindex == 1) {
				int size;

				// ask what size of TicTacToe to play
				while (true) {
					System.out.printf("What size of TicTacToe do you want to play? Enter a number from 3 ~ 9: ");
					str = sc.nextLine();
					size = Integer.parseInt(str);

					if (3 <= size && size <= 9) {
						break;
					} else {
						System.out.println("Please enter a valid size!");
					}
				}
				
				TicTacToe ttt = new TicTacToe(playerA, playerB, size, size);
				ttt.startGame();
			} else {
				OrderChaos oc = new OrderChaos(playerA, playerB, 6, 6, 5);
				oc.startGame();
			}

			// Ask whether to start another game
			System.out.printf("Wanna play another game? (Y/N): ");
			str = sc.nextLine();
		} while ('y' == Character.toLowerCase(str.charAt(0)));

		// print the scores in the end
		System.out.println("Score for playerA: " + playerA.getScore());
		System.out.println("Score for playerB: " + playerB.getScore());
	}

	/*
	 * Client code, for a client to start playing a TicTacToe game
	 */
    public static void main(String[] args){
    	MultipleGames games = new MultipleGames();
    	games.startPlayingGames();
    }
}