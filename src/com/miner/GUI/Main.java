package com.miner.GUI;

import com.miner.logic.Easy;
import com.miner.utils.ScreenUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.miner.Constants.*;

public class Main {
    public static final JPanel controlPanel = new JPanel();
    public static final GUIBoard board = new GUIBoard();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("Java Miner");
                frame.setLayout(new BorderLayout());
                frame.setSize(EASY_GAME_COLUMN_COUNT*CELL_PADDING + 5, EASY_GAME_ROW_COUNT*CELL_PADDING + 100);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.setResizable(false);
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());

                final JButton generate = new JButton("Start a new game!");
                generate.addActionListener(
                        new GUIAction(
                                new GUIGeneratorBoard(), board, new Easy()
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
