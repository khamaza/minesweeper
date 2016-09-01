package com.miner.GUI;

import com.miner.GeneratorBoard;
import com.miner.MinerLogic;
import com.miner.logic.Easy;
import com.miner.utils.ScreenUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.*;

import static com.miner.Constants.*;

public class Main {
    private static final GUIBoard board = new GUIBoard();
    private static final MinerLogic minerLogic = new Easy();
    private static final GeneratorBoard generatorBoard = new GUIGeneratorBoard();
    private static GUIAction guiAction;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                final JFrame frame = new JFrame();
                frame.setTitle("Java Miner");
                frame.setLayout(new BorderLayout());
                frame.setSize(minerLogic.getRowNumber()*CELL_PADDING + 5, minerLogic.getColumnNumber()*CELL_PADDING + 53);
                frame.add(board, BorderLayout.CENTER);
                frame.setResizable(false);
                ScreenUtils.moveToTheCentre(frame);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        ScreenUtils.closePerform(frame);
                    }
                });

                guiAction = new GUIAction(generatorBoard, board, minerLogic);
                guiAction.initGame();

                JMenuBar menuBar = new JMenuBar();
                initMenuBar(menuBar);
                frame.setJMenuBar(menuBar);
            }
        });
    }

    private static void initMenuBar(JMenuBar menuBar) {
        JMenu gameMenu = new JMenu("Game");

        JMenuItem newGameMenuItem = new JMenuItem("New game");
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiAction.initGame();
            }
        });

        gameMenu.add(newGameMenuItem);
        menuBar.add(gameMenu);
        menuBar.setVisible(true);
    }
}
