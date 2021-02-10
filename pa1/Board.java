public class Board {  
	private char[][] board;

	public Board() {
        board = new char[3][3];
	}


    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = ' ';
            }
        }
    }


    public boolean makeMove(int row, int col, char currentMove) {
        if (board[row][col] == ' ') {
            board[row][col] = currentMove;
            return true;
        } else {
            return false;
        }
    }


    public boolean checkCurrentWin(char currentMove) {
        boolean isWin = false;

        // check horizontal
        for (int i = 0; i < 3; i++) {
            isWin |= (board[i][0] == currentMove && 
                      board[i][1] == currentMove && 
                      board[i][2] == currentMove);
        }

        // check vertical
        for (int i = 0; i < 3; i++) {
            isWin |= (board[0][i] == currentMove && 
                      board[1][i] == currentMove && 
                      board[2][i] == currentMove);
        }

        // bottom-left to top-right
        isWin |= (board[2][0] == currentMove && 
                  board[1][1] == currentMove && 
                  board[0][2] == currentMove);

        // top-left to bottom-right
        isWin |= (board[0][0] == currentMove && 
                  board[1][1] == currentMove && 
                  board[2][2] == currentMove);

        return isWin;
    }
    

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public void printBoard() {
        System.out.println("+--+--+--+");
        System.out.println("|" + board[0][0] + " |" + board[0][1] + " |" + board[0][2] + " |");
        System.out.println("+--+--+--+");
        System.out.println("|" + board[1][0] + " |" + board[1][1] + " |" + board[1][2] + " |");
        System.out.println("+--+--+--+");
        System.out.println("|" + board[2][0] + " |" + board[2][1] + " |" + board[2][2] + " |");
        System.out.println("+--+--+--+");
    }
}