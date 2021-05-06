package ModeOfGame;

import minesweeper.MainFrame;
import openWindow.InitialWindow;

import javax.swing.*;

import java.util.ArrayList;


public class ReadMine extends JFrame  {

    private ArrayList<ArrayList<Integer>> mapOfMine;
    public ReadMine(){
        super("ModeOfGame.ReadMine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mapOfMine= InitialWindow.window.getCopyOfMine();
        MainFrame mainFrame=new MainFrame(mapOfMine);
        mainFrame.setVisible(true);
        pack();
        setVisible(true);
    }
}
