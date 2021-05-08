package ModeOfGame;

import minesweeper.MainFrame;

import javax.swing.*;
import selectWindow.set1;

public class NewGame extends JFrame {
    public NewGame() {
        super("ModeOfGame.NewGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame mainFrame = new MainFrame(set1.set1.getxCount(),set1.set1.getyCount(), set1.set1.getMineNum());
        mainFrame.setVisible(true);
        pack();
        setVisible(true);
    }
}
