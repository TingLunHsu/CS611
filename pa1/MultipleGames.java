import java.util.*;

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

		System.out.println("Hi, welcome to TicTacToe!");

		char c;
		do {
			// Ask what game to play
			System.out.printf("What do you want to play? Enter 1 for TicTacToe, 2 for Orders and Chaos: ");
			c = sc.next().charAt(0);
			BoardBasedGame ttt;
			if (c == '1') {
				System.out.printf("What size of TicTacToe do you want to play? Enter a number from 3 ~ 9: ");
				c = sc.next().charAt(0);
				int size = Character.getNumericValue(c);
				ttt = new TicTacToe(playerA, playerB, size, size);
			} else if (c == '2') {
				ttt = new TicTacToe(playerA, playerB, 3, 3);
			} else {
				ttt = new TicTacToe(playerA, playerB, 3, 3);
			}

			// start this game
			ttt.startGame();

			// Ask whether to start another game
			System.out.printf("Wanna play another game? (Y/N): ");
			c = sc.next().charAt(0); 
		} while ('y' == Character.toLowerCase(c));

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