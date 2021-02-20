import java.util.*;

public abstract class ConnectBasedGame extends BoardBasedGame {
	public ConnectBasedGame(Player playerA, Player playerB, int boardHeight, int boardWidth) {
		super(playerA, playerB, boardHeight, boardWidth);
	}

	/*
	 * Check if the same mark connect
	 */
	protected boolean connectedHorizontal(char mark, int threshold) {
		int maxConnected = 0;

		for (int i = 0; i < board.getHeight(); i++) {
			int numConnected = 0;

			for (int j = 0; j < board.getWidth(); j++) {
				Character cell = (Character) board.getCell(i, j);
				if (cell != null && cell.equals(mark)) {
                    numConnected++;
					maxConnected = Math.max(maxConnected, numConnected);
				} else {
					numConnected = 0;
				}
			}
		}

		return maxConnected >= threshold;
	}

	/*
	 * Check if win by connect vertically
	 */
	protected boolean connectedVertical(char mark, int threshold) {
		int maxConnected = 0;

		for (int j = 0; j < board.getWidth(); j++) {
			int numConnected = 0;

			for (int i = 0; i < board.getHeight(); i++) {
				Character cell = (Character) board.getCell(i, j);
				if (cell != null && cell.equals(mark)) {
					numConnected++;
					maxConnected = Math.max(maxConnected, numConnected);
				} else {
					numConnected = 0;
				}
			}
		}

		return maxConnected >= threshold;
	}

	/*
	 * Check if win by connect bottom-left to top-right
	 */
	protected boolean connectedUpSlope(char mark, int threshold) {
		int maxConnected = 0;

		int row = threshold - 1;
		int col = 0;

		// System.out.println("up");
		while (true) {
			int i = row;
			int j = col;
			int numConnected = 0;

			while (i >= 0 && j < board.getWidth()) {
				// System.out.println(i + " " + j);
				Character cell = (Character) board.getCell(i, j);
				if (cell != null && cell.equals(mark)) {
					numConnected++;
					maxConnected = Math.max(maxConnected, numConnected);
				} else {
					numConnected = 0;
				}

				i--;
				j++;
			}

			if (row < board.getHeight() - 1) {
				row++;
			} else if (col < board.getWidth() - threshold) {
				col++;
			} else {
				break;
			}
		}

		return maxConnected >= threshold;
	}

	/*
	 * Check if win by connect top-left to bottom-right
	 */
	protected boolean connectedDownSlope(char mark, int threshold) {
		int maxConnected = 0;

		int row = Math.max(board.getHeight() - threshold, 0);
		int col = 0;

		// System.out.println("down");
		while (true) {
			int i = row;
			int j = col;
			int numConnected = 0;

			while (i < board.getHeight() && j < board.getWidth()) {
				// System.out.println(i + " " + j);
				Character cell = (Character) board.getCell(i, j);
				if (cell != null && cell.equals(mark)) {
					numConnected++;
					maxConnected = Math.max(maxConnected, numConnected);
				} else {
					numConnected = 0;
				}

				i++;
				j++;
			}

			if (row > 0) {
				row--;
			} else if (col < board.getWidth() - threshold) {
				col++;
			} else {
				break;
			}
		}

		return maxConnected >= threshold;
	}
}