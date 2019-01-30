package medium;

public class Q529Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        // if click == mine, gg
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        // if click == empty, open square and adj squares
        } else if(board[x][y] == 'E') {
            //revealSquare(board, x, y);
            boolean hasMine;


            return board;
        } else {
            return new char[0][0];
        }
    }

/*    private void revealSquare(char[][] board, int x, int y) {
        if(board[x][y] == 'M') {
            board[x][y] = 'X';
        }
    }*/
}
