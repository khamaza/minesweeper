package com.miner.GUI;

import com.miner.GeneratorBoard;
import com.miner.MinerLogic;
import com.miner.logic.Easy;
import com.miner.utils.ScreenUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.miner.Constants.*;

public class Main {
    private static final JPanel controlPanel = new JPanel();
    private static final GUIBoard board = new GUIBoard();
    private static final MinerLogic minerLogic = new Easy();
    private static final GeneratorBoard generatorBoard = new GUIGeneratorBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Java Miner");
                frame.setLayout(new BorderLayout());
                frame.setSize(minerLogic.getRowNumber()*CELL_PADDING + 5, minerLogic.getColumnNumber()*CELL_PADDING + 100);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.setResizable(false);
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());

                final JButton generate = new JButton("Start a new game!");
                generate.addActionListener(
                        new GUIAction(
                                generatorBoard, board, minerLogic
                        )
                );

                controlPanel.add(generate);
                ScreenUtils.moveToTheCentre(frame);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        ScreenUtils.closePerform(frame);
                    }
                });
                frame.setVisible(true);
            }
        });
    }
}
