package minesweeper;


import components.GridComponent;
import controller.GameController;
import entity.Player;
import openWindow.InitialWindow;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public static GameController controller;
    private int xCount;
    private int yCount;
    private int mineCount;
    private ArrayList<ArrayList<Integer>> saveOfMines;
    private int clickTimes=0;



    //新游戏
    public MainFrame(int xCount, int yCount, int mineCount) {
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        //下面写的是确定大小的雷区的参数
        this.xCount = xCount;
        this.yCount = yCount;
        this.mineCount = mineCount;

        this.setTitle("2021 CS102A Project Demo 2");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 20, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        Player p1 = new Player();
        Player p2 = new Player();

        controller = new GameController(p1, p2);
        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, p2, xCount, yCount);
        controller.setScoreBoard(scoreBoard);

        this.add(gamePanel);
        this.add(scoreBoard);


        JButton clickBtn1 = new JButton("存档进度");
        clickBtn1.setSize(100, 20);
        clickBtn1.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn1);
        clickBtn1.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存棋子打开状态
            try {
                controller.writeCurrentDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的当前分数和失误次数
            try {
                controller.writePlayerDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的id(姓名）
            try {
                controller.writePlayerIDToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton clickBtn2 = new JButton("存档雷场");
        clickBtn2.setSize(100, 20);
        clickBtn2.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn2);
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JButton clickBtn3 = new JButton("开始界面");
        clickBtn3.setSize(100, 20);
        clickBtn3.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn3);
        clickBtn3.addActionListener(e -> {
            dispose();
            new InitialWindow();
        });


        JButton clickBtn4 = new JButton("透视雷场");
        clickBtn4.setSize(100, 20);
        clickBtn4.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn4);
        clickBtn4.addActionListener(e -> {
            if(clickTimes==0){
                gamePanel.showMineDirectly();
                clickTimes++;
            }else {
                gamePanel.backGame();
                clickTimes--;
            }
            repaint();
        });


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //读取存储的雷场开始游戏
    public MainFrame(ArrayList<ArrayList<Integer>> saveOfMines) {
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        //下面写的是确定大小的雷区的参数
        this.saveOfMines = saveOfMines;
        this.xCount = saveOfMines.size();
        this.yCount = saveOfMines.get(0).size();

        this.setTitle("2021 CS102A Project Demo 2");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 20, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        Player p1 = new Player();
        Player p2 = new Player();

        controller = new GameController(p1, p2);
        GamePanel gamePanel = new GamePanel(saveOfMines);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, p2, xCount, yCount);
        controller.setScoreBoard(scoreBoard);

        this.add(gamePanel);
        this.add(scoreBoard);


        JButton clickBtn1 = new JButton("存档进度");
        clickBtn1.setSize(100, 20);
        clickBtn1.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn1);
        clickBtn1.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存棋子打开状态
            try {
                controller.writeCurrentDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的当前分数和失误次数
            try {
                controller.writePlayerDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的id(姓名）
            try {
                controller.writePlayerIDToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton clickBtn2 = new JButton("存档雷场");
        clickBtn2.setSize(100, 20);
        clickBtn2.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn2);
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JButton clickBtn3 = new JButton("开始界面");
        clickBtn3.setSize(100, 20);
        clickBtn3.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn3);
        clickBtn3.addActionListener(e -> {
            dispose();
            new InitialWindow();
        });


        JButton clickBtn4 = new JButton("透视雷场");
        clickBtn4.setSize(100, 20);
        clickBtn4.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn4);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //读取游戏存档开始游戏
    public MainFrame() {
        this.setTitle("2021 CS102A Project Demo 2");
        this.setLayout(null);//清空布局管理器
        this.setSize(InitialWindow.window.getCopyOfMine().get(0).size() * GridComponent.gridSize + 20, InitialWindow.window.getCopyOfMine().size()* GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);


        controller = new GameController();
        GamePanel gamePanel = new GamePanel();
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard();
        controller.setScoreBoard(scoreBoard);

        this.add(gamePanel);
        this.add(scoreBoard);


        JButton clickBtn1 = new JButton("存档进度");
        clickBtn1.setSize(100, 20);
        clickBtn1.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn1);
        clickBtn1.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存棋子打开状态
            try {
                controller.writeCurrentDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的当前分数和失误次数
            try {
                controller.writePlayerDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //存玩家们的id(姓名）
            try {
                controller.writePlayerIDToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JButton clickBtn2 = new JButton("存档雷场");
        clickBtn2.setSize(100, 20);
        clickBtn2.setLocation(5, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn2);
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

//           controller.readFileData(fileName);\
            //存档
            //存雷场
            try {
                controller.writeInitialDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JButton clickBtn3 = new JButton("开始界面");
        clickBtn3.setSize(100, 20);
        clickBtn3.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight());
        add(clickBtn3);
        clickBtn3.addActionListener(e -> {
            dispose();
            new InitialWindow();
        });


        JButton clickBtn4 = new JButton("透视雷场");
        clickBtn4.setSize(100, 20);
        clickBtn4.setLocation(110, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn4);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }







}
