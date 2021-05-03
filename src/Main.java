import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {//这个好像和线程有关
            MainFrame mainFrame = new MainFrame(16,30,99);
            mainFrame.setVisible(true);
        });

    }
}
