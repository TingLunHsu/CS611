import java.util.*;

public class TicTacToe {  
	private int scoreO;
	private int scoreX;
	private Board board;
	private char currentPlayer;


	public TicTacToe() {
		board = new Board();
		scoreO = 0;
		scoreX = 0;
	}

	/* play another game */
	private void playAnotherGame() {
		board.initializeBoard();
		currentPlayer = 'O';

		boolean endGame = false;

		while (endGame == false) {
			// print the current board
			this.printBoard();

			// for a client to make a move
			this.makeMove();

			// check if the game ends
			if (board.isFull()) {
				System.out.println("The board is full, no one wins!");
				break;
			}

			if (board.checkCurrentWin(currentPlayer)) {
				System.out.println("Player " + currentPlayer + " wins!");
				if (currentPlayer == 'O') {
					scoreO++;
				}

				if (currentPlayer == 'X') {
					scoreX++;
				}
				break;
			}

			// change player
			this.changePlayer();
		}
	}

	/* for the current player to make a valid move */
	private void makeMove() {
		Scanner sc = new Scanner(System.in);

		int row;
		int col;

		do {
			// ask client for next move
			System.out.printf("Player " + currentPlayer + " Enter your move: ");
			String input = sc.nextLine();
			row = Character.getNumericValue(input.charAt(0)) - 1;
			col = Character.getNumericValue(input.charAt(2)) - 1;
		} while (board.makeMove(row, col, currentPlayer) == false);
	}

	/* change the player */
	private void changePlayer() {
		if (currentPlayer == 'X') {
			currentPlayer = 'O';
		} else {
			currentPlayer = 'X';
		}
	}

	/* print the board */
	private void printBoard() {
		board.printBoard();
	}

	public void startPlaying() {
		Scanner sc = new Scanner(System.in); 

		System.out.println("Hi, welcome to TicTacToe!");

		char c;
		do {
			this.playAnotherGame();

			// ask the client to see whether to start another game
			System.out.printf("Wanna play another game? (Y/N): ");
			c = sc.next().charAt(0); 
		} while ('y' == Character.toLowerCase(c));

		// print the scores in the end
		System.out.println("Score for O: " + scoreO);
		System.out.println("Score for X: " + scoreX);
	}

	/*
	 * Client code, for a client to start playing a TicTacToe game
	 */
    public static void main(String[] args){
    	TicTacToe tictactoe = new TicTacToe();
    	tictactoe.startPlaying();
    }
}