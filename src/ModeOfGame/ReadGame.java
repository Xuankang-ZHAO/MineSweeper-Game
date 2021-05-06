package ModeOfGame;

import minesweeper.MainFrame;
import openWindow.InitialWindow;

import javax.swing.*;
import java.util.ArrayList;

public class ReadGame extends JFrame {
    private ArrayList<ArrayList<Integer>> dataOfMine;
    private ArrayList<ArrayList<Integer>> dataOfState;
    private ArrayList<ArrayList<Integer>> dataOfScore;
    private ArrayList<ArrayList<String>> dataOfName;

    public ReadGame(){
        super("ModeOfGame.ReadGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dataOfMine= InitialWindow.window.getCopyOfMine();
        this.dataOfState=InitialWindow.window.getCopyOfState();
        this.dataOfScore=InitialWindow.window.getCopyOfScore();
        this.dataOfName=InitialWindow.window.getCopyOfName();
        MainFrame mainFrame=new MainFrame(dataOfMine);//暂时用读取雷场的版本代替
        mainFrame.setVisible(true);
        pack();
        setVisible(true);

    }
}
