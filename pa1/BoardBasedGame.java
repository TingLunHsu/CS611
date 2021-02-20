import java.util.*;
/*
 * A abstract class that represent a board based game
 * that contains a board and two players
 */
public abstract class BoardBasedGame {
	protected Board board;
	protected Player playerA;
	protected Player playerB;
	protected Player currentPlayer;

	/*
     * A constructor that creates a new board based game
     * with empty board of given specific board size
     */
	public BoardBasedGame(Player playerA, Player playerB, int boardHeight, int boardWidth) {
		this.board = new Board(boardHeight, boardWidth);
		this.playerA = playerA;
		this.playerB = playerB;
	}

	/*
	 * Start playing this round of game
	 */
	public void startGame() {
		currentPlayer = playerA;

		while (true) {
			// print the current board
			this.printBoard();

			// for a client to make a move
			this.makeMove();

			// check if the game ends
			if (this.checkWin(playerA)) {
				this.printBoard();
				System.out.println("Player " + playerA + " wins!");
				playerA.incrementScore();
				break;
			} else if (this.checkWin(playerB)){
				this.printBoard();
				System.out.println("Player " + playerB + " wins!");
				playerB.incrementScore();
				break;
			} else if (board.isFull()) {
				this.printBoard();
				System.out.println("The board is full, no one wins!");
				break;
			}

			// change player
			this.changePlayer();
		}
	}

	/* 
	 * For the current player to make a valid move
	 */
	abstract protected void makeMove();

	/* 
	 * For the current player to make a valid move
	 */
	abstract protected boolean checkWin(Player player);

	/*
	 * Change the player
	 */
	protected void changePlayer() {
		if (currentPlayer == playerA) {
			currentPlayer = playerB;
		} else {
			currentPlayer = playerA;
		}
	}

	/*
	 * Print the board
	 */
	protected void printBoard() {
		board.printBoard();
	}
}