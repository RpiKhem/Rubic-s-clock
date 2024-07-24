/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikora;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class Board {
    private final Field[][] board;
    private final int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                board[i][j] = new Field();
            }
        }
    }
    
    public boolean isOver() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if ((i==0 && j==0) || (i==0 && j==2) || (i==0 && j==4) || (i==2 && j==0) || (i==2 && j==2) || (i==2 && j==4) || (i==4 && j==0) || (i==4 && j==2) || (i==4 && j==4)){
                    if(board[i][j].getNumber() != 12) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public Field get(int x, int y) {
        return board[x][y];
    }

    public int getBoardSize() {
        return boardSize;
    }
}
