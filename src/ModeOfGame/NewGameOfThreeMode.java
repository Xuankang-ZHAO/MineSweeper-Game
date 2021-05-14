package ModeOfGame;

import minesweeper.MainFrame;
import selectMode.ModeSelect;

import javax.swing.*;

public class NewGameOfThreeMode extends JFrame {
    public NewGameOfThreeMode() {
        super("ModeOfGame.NewGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame mainFrame = new MainFrame(ModeSelect.modeSelect.getxCount(), ModeSelect.modeSelect.getyCount(), ModeSelect.modeSelect.getMineNum());
        mainFrame.setVisible(true);
        pack();
        setVisible(true);
    }
}
