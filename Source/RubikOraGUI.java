/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikora;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Rimóczi Loránd EOH12I
 */
public class RubikOraGUI {
    private JFrame frame;
    private BoardGUI boardGUI;

    private final int INITIAL_BOARD_SIZE = 5;
    
    //interface példányosítás, newGame felülírás
    private NewGameInterface ngi = new NewGameInterface(){
        @Override public void newGame(){
            if(boardGUI != null) {
                frame.getContentPane().remove(boardGUI.getBoardPanel());
                boardGUI = new BoardGUI(5, ngi);
                frame.getContentPane().add(boardGUI.getBoardPanel(),
                            BorderLayout.CENTER);
                frame.pack();
            }
        }
    };

    public RubikOraGUI() {
        frame = new JFrame("Rubik óra");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boardGUI = new BoardGUI(INITIAL_BOARD_SIZE, ngi);
        frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem newMenuItem = new JMenuItem("New");
        gameMenu.add(newMenuItem);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().remove(boardGUI.getBoardPanel());
                boardGUI = new BoardGUI(5, ngi);
                frame.getContentPane().add(boardGUI.getBoardPanel(),
                            BorderLayout.CENTER);
                frame.pack();
                }
            });
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}

