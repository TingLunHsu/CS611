import java.util.*;

/*
 * OrderChaos class that extends ConnectBasedGame for play to play Order and Chaos
 */
public class OrderChaos extends ConnectBasedGame {
	private int threshold;
	/*
     * A constructor that creates a Order and Chaos that inherit ConnectedBasedGame
     * with empty board of given specific board size
     */
	public OrderChaos(Player playerA, Player playerB, int boardHeight, int boardWidth, int threshold) {
		super(playerA, playerB, boardHeight, boardWidth);
		this.threshold = threshold;
	}

	/*
	 * For the current player to make a valid move
	 */
	protected void makeMove() {
		Scanner sc = new Scanner(System.in);

		// ask which mark to put
		String input;
		char mark;
		while (true) {
			System.out.printf("Which mark do you want to use? (O/X):");
			input = sc.nextLine();
			mark = input.charAt(0);
			if (mark == 'O' || mark == 'X') {
				break;
			} else{
				System.out.println("Please enter a valid input!");
			}
		};

		int row;
		int col;

		// ask client for next move
		// player can exit the loop only after making a valid move
		while (true) {
			System.out.println("***For example, to put the mark at row 2, col 3, enter: 2,3***");
			if (currentPlayer == playerA) {
				System.out.printf("Player " + currentPlayer + " - Order Enter your move: ");
			} else {
				System.out.printf("Player " + currentPlayer + " - Chaos Enter your move: ");
			}

			input = sc.nextLine();
			row = Character.getNumericValue(input.charAt(0)) - 1;
			col = Character.getNumericValue(input.charAt(2)) - 1;

			// check if the move is valid
			if (0 > row || row >= board.getHeight()) {
				System.out.printf("Invalid row! Please enter a row from %d to %d\n", 1, board.getHeight());
				continue;
			}

			if (0 > col || col >= board.getWidth()) {
				System.out.printf("Invalid column! Please enter a column from %d to %d\n", 1, board.getWidth());
				continue;
			}

			if (!board.isEmpty(row, col)) {
				System.out.println("This cell is not empty!");
				continue;
			}

			break;
		}

		// place the mark
		board.placeItemOnCell(row, col, mark);
	}

	/*
	 * Check if there's a connected line
	 */
	protected boolean connected(char mark, int thres) {
		boolean isWin = false;

        // check horizontal
        isWin |= this.connectedHorizontal(mark, thres);

        // check vertical
        isWin |= this.connectedVertical(mark, thres);

        // bottom-left to top-right
        isWin |= this.connectedUpSlope(mark, thres);

        // top-left to bottom-right
        isWin |= this.connectedDownSlope(mark, thres);

        return isWin;
	}

	/*
	 * Check if the current player wins
	 */
	protected boolean checkWin(Player player) {
		if (player == playerA) {
			return this.connected('O', threshold) || this.connected('X', threshold);
	    } else {
	    	return board.isFull();
	    }
    }
}