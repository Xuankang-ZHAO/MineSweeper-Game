import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(16,30,99);
            mainFrame.setVisible(true);

        });
        /*JFrame window=new JFrame();
        ImageIcon background=new ImageIcon("F:\\2021年春季学期\\JAVA\\project\\MineSweeper-Demo\\src\\pictures\\我的世界.PNG");
        Image copyBackground=background.getImage();
        window.setIconImage(copyBackground);
        window.add(mainFrame);
        window.setVisible(true);
        window.setSize(666,666);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */

    }
}
