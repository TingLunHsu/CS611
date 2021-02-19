import java.util.*;

public class TicTacToe extends BoardBasedGame {  
	HashMap<Player, String> markMap;
	/*
     * A constructor that creates a TicTacToe that inherit BoardBasedGame
     * with empty board of given specific board size
     */
	public TicTacToe(Player playerA, Player playerB, int boardHeight, int boardWidth) {
		super(playerA, playerB, boardHeight, boardWidth);
		this.markMap = markMap = new HashMap<Player, String>();
		markMap.put(playerA, "O");
		markMap.put(playerB, "X");
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
		Mark mark = new Mark(markMap.get(currentPlayer));

		board.placeItemOnCell(row, col, mark);
	}

	/*
	 * Check if win by connect horizontally
	 */
	private boolean horizontalWin(String mark) {
		boolean isWin = false;

		for (int i = 0; i < board.getHeight(); i++) {
        	boolean rowConnect = true;
        	for (int j = 0; j < board.getWidth(); j++) {
            	rowConnect &= board.getCell(i, j).toString().equals(mark);
            }

            isWin |= rowConnect;
        }

        return isWin;
	}

	/*
	 * Check if win by connect vertically
	 */
	private boolean verticalWin(String mark) {
		boolean isWin = false;

        for (int i = 0; i < board.getWidth(); i++) {
        	boolean colConnect = true;
        	for (int j = 0; j < board.getHeight(); j++) {
            	colConnect &= board.getCell(j, i).toString().equals(mark);
            }

            isWin |= colConnect;
        }

        return isWin;
	}

	/*
	 * Check if win by connect bottom-left to top-right
	 */
	private boolean connectUpSlope(String mark) {
		boolean connectUp = true;

        for (int i = 0; i < board.getHeight(); i++) {
        	connectUp &= board.getCell(board.getHeight() - i - 1, i).toString().equals(mark);
        }

        return connectUp;
	}

	/*
	 * Check if win by connect top-left to bottom-right
	 */
	private boolean connectDownSlope(String mark) {
        boolean connectDown = true;

        for (int i = 0; i < board.getHeight(); i++) {
        	connectDown &= board.getCell(i, i).toString().equals(mark);
        }

        return connectDown;
	}

	/*
	 * Check if the current player wins
	 */
	protected boolean checkWin() {
        boolean isWin = false;

        String mark = markMap.get(currentPlayer);

        // check horizontal
        isWin |= this.horizontalWin(mark);

        // check vertical
        isWin |= this.verticalWin(mark);

        // bottom-left to top-right
        isWin |= this.connectUpSlope(mark);

        // top-left to bottom-right
        isWin |= this.connectDownSlope(mark);

        return isWin;
    }
}