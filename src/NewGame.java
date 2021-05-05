import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;

public class NewGame extends JFrame {
    public NewGame() {
        super("NewGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame mainFrame = new MainFrame(16, 30, 99);
        mainFrame.setVisible(true);
        pack();
        setVisible(true);
    }
}
