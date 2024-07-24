/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikora;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public final class BoardGUI {
    private final JButton[][] buttons;
    private final Board board;
    private final JPanel boardPanel;
    private int clickNum = 0;
    
    private final NewGameInterface ngi;

    public BoardGUI(int boardSize, NewGameInterface ngi) {
        this.ngi = ngi;
        board = new Board(boardSize);
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(board.getBoardSize(), board.getBoardSize()));
        buttons = new JButton[board.getBoardSize()][board.getBoardSize()];
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                JButton button = new JButton();
                //gombok, és színük beállítása
                if((i == 1 && (j == 1 || j == 3)) || (i == 3 && (j == 1 || j == 3))){
                    button.addActionListener(new ButtonListener(i, j));
                    button.setBackground(Color.GREEN);
                }
                //órák, és színük beaállítása
                if ((i==0 && j==0) || (i==0 && j==2) || (i==0 && j==4) || (i==2 && j==0) || (i==2 && j==2) || (i==2 && j==4) || (i==4 && j==0) || (i==4 && j==2) || (i==4 && j==4)){
                    button.setBackground(Color.YELLOW);
                }
                button.setPreferredSize(new Dimension(70, 70));
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }
        refresh();
    }

    public void refresh() {
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                Field field = board.get(i, j);
                JButton button = buttons[i][j];
                if ((i==0 && j==0) || (i==0 && j==2) || (i==0 && j==4) || (i==2 && j==0) || (i==2 && j==2) || (i==2 && j==4) || (i==4 && j==0) || (i==4 && j==2) || (i==4 && j==4)){
                    button.setText(String.valueOf(field.getNumber()));
                }
            }
        }
        if (board.isOver()) {
            int res = JOptionPane.showOptionDialog(null, "You have won in " + clickNum + " step(s)!", "Congratulations!", JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(res == 0){
                ngi.newGame();
            }
        }
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    class ButtonListener implements ActionListener {

        private final int x;
        private final int y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //top left button
            if (x == 1 && y == 1) {
                clickNum++;
                board.get(0, 0).setNumber(board.get(0, 0).getNumber() == 12 ? 1 : board.get(0, 0).getNumber() + 1);
                board.get(0, 2).setNumber(board.get(0, 2).getNumber() == 12 ? 1 : board.get(0, 2).getNumber() + 1);
                board.get(2, 0).setNumber(board.get(2, 0).getNumber() == 12 ? 1 : board.get(2, 0).getNumber() + 1);
                board.get(2, 2).setNumber(board.get(2, 2).getNumber() == 12 ? 1 : board.get(2, 2).getNumber() + 1);
                refresh();
            }
            //top right button
            if (x == 1 && y == 3) {
                clickNum++;
                board.get(0, 2).setNumber(board.get(0, 2).getNumber() == 12 ? 1 : board.get(0, 2).getNumber() + 1);
                board.get(0, 4).setNumber(board.get(0, 4).getNumber() == 12 ? 1 : board.get(0, 4).getNumber() + 1);
                board.get(2, 2).setNumber(board.get(2, 2).getNumber() == 12 ? 1 : board.get(2, 2).getNumber() + 1);
                board.get(2, 4).setNumber(board.get(2, 4).getNumber() == 12 ? 1 : board.get(2, 4).getNumber() + 1);
                refresh();
            }
            //bottom left button
            if (x == 3 && y == 1) {
                clickNum++;
                board.get(2, 0).setNumber(board.get(2, 0).getNumber() == 12 ? 1 : board.get(2, 0).getNumber() + 1);
                board.get(2, 2).setNumber(board.get(2, 2).getNumber() == 12 ? 1 : board.get(2, 2).getNumber() + 1);
                board.get(4, 0).setNumber(board.get(4, 0).getNumber() == 12 ? 1 : board.get(4, 0).getNumber() + 1);
                board.get(4, 2).setNumber(board.get(4, 2).getNumber() == 12 ? 1 : board.get(4, 2).getNumber() + 1);
                refresh();
            }
            //bottom right button
            if (x == 3 && y == 3) {
                clickNum++;
                board.get(2, 2).setNumber(board.get(2, 2).getNumber() == 12 ? 1 : board.get(2, 2).getNumber() + 1);
                board.get(2, 4).setNumber(board.get(2, 4).getNumber() == 12 ? 1 : board.get(2, 4).getNumber() + 1);
                board.get(4, 2).setNumber(board.get(4, 2).getNumber() == 12 ? 1 : board.get(4, 2).getNumber() + 1);
                board.get(4, 4).setNumber(board.get(4, 4).getNumber() == 12 ? 1 : board.get(4, 4).getNumber() + 1);
                refresh();
            }
        }
    }
}
