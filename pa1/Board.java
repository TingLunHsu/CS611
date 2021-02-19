/*
 * A board class that can be used to play any 2D board-based game
 */

public class Board {
    private int height;
    private int width;
	private Cell[][] board;

    /*
     * Construct a empty board
     */
	public Board(int height, int width) {
        this.height = height;
        this.width = width;
        board = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = new Cell();
            }
        }
	}

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell getCell(int row, int col) {
        //System.out.println(row + " " + col);
        return board[row][col];
    }

    /*
     * Clear all the cells on the board
     */
    public void clearBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.board[i][j].clearItem();
            }
        }
    }

    /*
     * Check if the cell is empty
     */
    public boolean isEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    /*
     * Place an item on the cell
     */
    public void placeItemOnCell(int row, int col, Object item) {
        board[row][col].placeItem(item);
    }


    /*
     * Return whether the board is full
     */
    public boolean isFull() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.board[i][j].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    /*
     * Print a single horizon line for this board
     */
    private void printHorizonLine() {
        for (int j = 0; j < width; j++) {
            System.out.print("+--");
        }
        System.out.println("+");
    }

    /*
     * Print the board
     */
    public void printBoard() {

        for (int i = 0; i < height; i++) {
            this.printHorizonLine();

            for (int j = 0; j < width; j++) {
                System.out.print("|" + board[i][j] + " ");
            }

            System.out.println("|");
        }

        this.printHorizonLine();
    }
}