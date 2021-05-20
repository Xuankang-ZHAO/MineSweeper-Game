package minesweeper;


import components.GridComponent;
import controller.GameController;
import entity.Player;
import openWindow.InitialWindow;
import selectMode.ModeSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    public static GameController controller;
    private int xCount;
    private int yCount;
    private int mineCount;
    private ArrayList<ArrayList<Integer>> saveOfMines;
    private int clickTimes = 0;
    public static MainFrame mainFrame;
    public static int inputSeconds = ModeSelect.modeSelect.getTime();
    int seconds = inputSeconds;

    //新游戏
    public MainFrame(int xCount, int yCount, int mineCount) {
        mainFrame = this;
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        //下面写的是确定大小的雷区的参数
        this.xCount = xCount;
        this.yCount = yCount;
        this.mineCount = mineCount;

        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 200, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        Player p1 = new Player(ModeSelect.modeSelect.getPlayerName1());
        Player p2 = new Player(ModeSelect.modeSelect.getPlayerName2());

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
        //clickBtn1.setLocation(gamePanel.getWidth(),  gamePanel.getHeight()+scoreBoard.getHeight()+10);
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
        //clickBtn2.setLocation(gamePanel.getWidth(), gamePanel.getHeight()+scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
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
            if (clickTimes == 0) {
                gamePanel.showMineDirectly();
                clickTimes++;
            } else {
                gamePanel.backGame();
                clickTimes--;
            }
            repaint();
        });


        JLabel time = new JLabel(seconds + "s left");
        time.setSize(100, 20);
        time.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight());
        //time.setOpaque(true);
        time.setBorder(BorderFactory.createLineBorder(Color.RED));
        time.setFont(new Font("粗体", Font.PLAIN, 20));
        add(time);

        JLabel currentPlayer = new JLabel();
        currentPlayer.setText(String.format("Current player:%s", controller.getOnTurn().getUserName()));
        currentPlayer.setSize(200, 35);
        currentPlayer.setLocation(gamePanel.getWidth() + 10, 20);
        currentPlayer.setForeground(Color.BLACK);
        currentPlayer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        add(currentPlayer);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0) {
                    seconds--;
                }
                time.setText(seconds + "s left");
            }
        });
        JButton clickBtn5 = new JButton("开始计时");
        clickBtn5.setSize(100, 20);
        clickBtn5.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn5);
        clickBtn5.addActionListener(e -> {
            timer.start();
        });


        //this.setVisible(true);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //读取存储的雷场开始游戏
    public MainFrame(ArrayList<ArrayList<Integer>> saveOfMines) {
        mainFrame = this;
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        //下面写的是确定大小的雷区的参数
        this.saveOfMines = saveOfMines;
        this.xCount = saveOfMines.size();
        this.yCount = saveOfMines.get(0).size();

        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 200, xCount * GridComponent.gridSize + 200);
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
        clickBtn4.addActionListener(e -> {
            if (clickTimes == 0) {
                gamePanel.showMineDirectly();
                clickTimes++;
            } else {
                gamePanel.backGame();
                clickTimes--;
            }
            repaint();
        });

        JLabel time = new JLabel(seconds + "s left");
        time.setSize(100, 20);
        time.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight());
        //time.setOpaque(true);
        time.setBorder(BorderFactory.createLineBorder(Color.RED));
        time.setFont(new Font("粗体", Font.PLAIN, 20));
        add(time);

        JLabel currentPlayer = new JLabel();
        currentPlayer.setText(String.format("Current player:%s", controller.getOnTurn().getUserName()));
        currentPlayer.setSize(200, 35);
        currentPlayer.setLocation(gamePanel.getWidth() + 10, 20);
        currentPlayer.setForeground(Color.BLACK);
        currentPlayer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        add(currentPlayer);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0) {
                    seconds--;
                }
                time.setText(seconds + "s left");
            }
        });
        JButton clickBtn5 = new JButton("开始计时");
        clickBtn5.setSize(100, 20);
        clickBtn5.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn5);
        clickBtn5.addActionListener(e -> {
            timer.start();
        });


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //读取游戏存档开始游戏
    public MainFrame() {
        mainFrame = this;
        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(InitialWindow.window.getCopyOfMine().get(0).size() * GridComponent.gridSize + 200, InitialWindow.window.getCopyOfMine().size() * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        this.xCount = InitialWindow.window.getCopyOfMine().size();
        this.yCount = InitialWindow.window.getCopyOfMine().get(0).size();
        int tempCount = 0;
        for (int i = 0; i < InitialWindow.window.getCopyOfMine().size(); i++) {
            for (int j = 0; j < InitialWindow.window.getCopyOfMine().get(0).size(); j++) {
                if (InitialWindow.window.getCopyOfMine().get(i).get(j) == -1) {
                    tempCount++;
                }
            }
        }
        this.mineCount = tempCount;


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
        clickBtn4.addActionListener(e -> {
            if (clickTimes == 0) {
                gamePanel.showMineDirectly();
                clickTimes++;
            } else {
                gamePanel.backGame();
                clickTimes--;
            }
            repaint();
        });

        JLabel time = new JLabel(seconds + "s left");
        time.setSize(100, 20);
        time.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight());
        //time.setOpaque(true);
        time.setBorder(BorderFactory.createLineBorder(Color.RED));
        time.setFont(new Font("粗体", Font.PLAIN, 20));
        add(time);

        JLabel currentPlayer = new JLabel();
        currentPlayer.setText(String.format("Current player:%s", controller.getOnTurn().getUserName()));
        currentPlayer.setSize(200, 35);
        currentPlayer.setLocation(gamePanel.getWidth() + 10, 20);
        currentPlayer.setForeground(Color.BLACK);
        currentPlayer.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        add(currentPlayer);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0) {
                    seconds--;
                }
                time.setText(seconds + "s left");
            }
        });
        JButton clickBtn5 = new JButton("开始计时");
        clickBtn5.setSize(100, 20);
        clickBtn5.setLocation(225, gamePanel.getHeight() + scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        add(clickBtn5);
        clickBtn5.addActionListener(e -> {
            timer.start();
        });


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public int getxCount() {
        return xCount;
    }

    public int getyCount() {
        return yCount;
    }

    public int getMineCount() {
        return mineCount;
    }

    public static GameController getController() {
        return controller;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public static int getInputSeconds() {
        return inputSeconds;
    }
}
