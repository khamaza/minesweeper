package com.miner.impl.GUI;

import com.miner.interfaces.GeneratorBoard;
import com.miner.interfaces.MinerLogic;
import com.miner.logic.Easy;
import com.miner.logic.Hard;
import com.miner.logic.Normal;
import com.miner.utils.ScreenUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.miner.Constants.*;

public class Main {
    private static GUIBoard board = new GUIBoard();
    private static MinerLogic minerLogic = new Easy();
    private static final GeneratorBoard generatorBoard = new GUIGeneratorBoard();
    private static GUIAction guiAction;
    private static JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                frame = new JFrame();
                frame.setTitle("Java Miner");
                frame.setLayout(new BorderLayout());
                Main.resizeScreen();
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

    private static void resizeScreen() {
        if (frame!=null) {
            frame.setSize(minerLogic.getRowNumber()*CELL_PADDING + 5, minerLogic.getColumnNumber()*CELL_PADDING + 53);
        }
    }

    private static void initMenuBar(JMenuBar menuBar) {
        JMenu gameMenu = new JMenu("Game");

        JMenu newGameMenu = new JMenu("New game");

        JMenuItem newEasyGame = new JMenuItem("easy");
        newEasyGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minerLogic = new Easy();
                Main.resizeScreen();
                board.removeMouseListener(guiAction);
               // guiAction = null;
               // board=null;
                guiAction = new GUIAction(generatorBoard, board, minerLogic);
                guiAction.initGame();
            }
        });
        newGameMenu.add(newEasyGame);

        JMenuItem newNormalGame = new JMenuItem("normal");
        newNormalGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minerLogic = new Normal();
                Main.resizeScreen();
                board.removeMouseListener(guiAction);
                guiAction = new GUIAction(generatorBoard, board, minerLogic);
                guiAction.initGame();
            }
        });
        newGameMenu.add(newNormalGame);

        JMenuItem newHardGame = new JMenuItem("hard");
        newHardGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minerLogic = new Hard();
                Main.resizeScreen();
                board.removeMouseListener(guiAction);
                guiAction = new GUIAction(generatorBoard, board, minerLogic);
                guiAction.initGame();
            }
        });
        newGameMenu.add(newHardGame);

        gameMenu.add(newGameMenu);
        menuBar.add(gameMenu);
        menuBar.setVisible(true);
    }
}
