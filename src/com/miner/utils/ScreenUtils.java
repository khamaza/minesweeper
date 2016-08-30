package com.miner.utils;

import javax.swing.*;
import java.awt.*;

public class ScreenUtils {

    public static void moveToTheCentre(Window w){
        Dimension wSize = w.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (screenSize.width - wSize.width)/2;
        int newY = (screenSize.height - wSize.height)/2;
        w.setLocation(newX, newY);
    }

    public static void closePerform(JFrame frame) {
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
