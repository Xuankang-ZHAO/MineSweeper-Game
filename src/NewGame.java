import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JFrame {
    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {//这个好像和线程有关
            MainFrame mainFrame = new MainFrame(16,30,99);
            mainFrame.setVisible(true);
        });

    }*/

    public NewGame() {
        super("NewGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame mainFrame = new MainFrame(16, 30, 99);
        mainFrame.setVisible(true);
        pack();
        setVisible(true);
    }
}
