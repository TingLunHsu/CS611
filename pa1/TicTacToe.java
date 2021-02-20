import java.util.*;

public class TicTacToe extends ConnectBasedGame {  
	HashMap<Player, Character> markMap;
	/*
     * A constructor that creates a TicTacToe that inherit ConnectedBasedGame
     * with empty board of given specific board size
     */
	public TicTacToe(Player playerA, Player playerB, int boardHeight, int boardWidth) {
		super(playerA, playerB, boardHeight, boardWidth);
		this.markMap = markMap = new HashMap<Player, Character>();
		markMap.put(playerA, 'O');
		markMap.put(playerB, 'X');
	}

	/*
	 * For the current player to make a valid move
	 */
	protected void makeMove() {
		Scanner sc = new Scanner(System.in);

		int row;
		int col;

		// Player can exit the loop only after making a valid move
		while (true) {
			// ask client for next move
			System.out.printf("Player " + currentPlayer + " Enter your move: ");
			String input = sc.nextLine();
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
		char mark = markMap.get(currentPlayer);
		board.placeItemOnCell(row, col, mark);
	}

	/*
	 * Check if the current player wins
	 */
	protected boolean checkWin(Player player) {
        boolean isWin = false;

        char mark = markMap.get(player);

        // check horizontal
        isWin |= this.connectedHorizontal(mark, board.getWidth());

        // check vertical
        isWin |= this.connectedVertical(mark, board.getHeight());

        // bottom-left to top-right
        isWin |= this.connectedUpSlope(mark, board.getHeight());

        // top-left to bottom-right
        isWin |= this.connectedDownSlope(mark, board.getHeight());

        return isWin;
    }
}