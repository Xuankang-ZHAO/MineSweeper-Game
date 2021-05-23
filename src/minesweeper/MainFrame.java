package minesweeper;

import components.GridComponent;
import controller.GameController;
import entity.Player;
import openWindow.InitialWindow;
import resources.ImageResource;
import selectMode.*;

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
    private int inputSeconds;
    int seconds;
    JLabel photo = new JLabel();
    JLabel currentPlayer = new JLabel();
    JLabel clickTime = new JLabel();
    JPanel panel = (JPanel) this.getContentPane();
    ImageIcon back;


    //新游戏
    public MainFrame(int xCount, int yCount, int mineCount) {
        mainFrame = this;
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        //下面写的是确定大小的雷区的参数
        this.xCount = xCount;
        this.yCount = yCount;
        this.mineCount = mineCount;
        this.inputSeconds = ModeSelect.modeSelect.getTime();
        this.seconds = inputSeconds;

        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 200, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        Player p1 = new Player(ModeSelect.modeSelect.getPlayerName1(), 0, 0);
        Player p2 = new Player(ModeSelect.modeSelect.getPlayerName2(), 0, 0);

        controller = new GameController(p1, p2);
        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard(p1, p2, xCount, yCount);
        controller.setScoreBoard(scoreBoard);

        if (TopicSelect.topicSelect.getSss() == 1) {
            back = new ImageIcon("resouces/pictures/背景1.jpg");
        } else if (TopicSelect.topicSelect.getSss() == 2) {
            back = new ImageIcon("resouces/pictures/背景2.jpg");
        } else if (TopicSelect.topicSelect.getSss() == 3) {
            back = new ImageIcon("resouces/pictures/背景3.jpg");
        }

        JLabel label = new JLabel(back);
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        panel.add(gamePanel);
        panel.add(scoreBoard);
        button();
        playerUpdate();
        clickTimeUpdate();
        pictureUpdate();
        panel.setOpaque(false);

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

        back = new ImageIcon("resouces/pictures/背景1.jpg");
        JLabel label = new JLabel(back);
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));


        panel.add(gamePanel);
        panel.add(scoreBoard);
        button();
        playerUpdate();
        clickTimeUpdate();
        pictureUpdate();
        panel.setOpaque(false);

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

        //得到雷数
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

        this.inputSeconds = Integer.parseInt(InitialWindow.window.getCopyOfTime().get(1));
        this.seconds = Integer.parseInt(InitialWindow.window.getCopyOfTime().get(0));

        new TopicSelect();
        TopicSelect.topicSelect.setSss(2);


        controller = new GameController();
        GamePanel gamePanel = new GamePanel();
        controller.setGamePanel(gamePanel);
        ScoreBoard scoreBoard = new ScoreBoard();
        controller.setScoreBoard(scoreBoard);

        back = new ImageIcon("resouces/pictures/背景1.jpg");
        JLabel label = new JLabel(back);
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));


        panel.add(gamePanel);
        panel.add(scoreBoard);
        button();
        playerUpdate();
        clickTimeUpdate();
        pictureUpdate();
//        panel.add(currentPlayer);
//        panel.add(clickTime);
//        if (controller.getRecord() == 1) {
//            Image playerPhoto1 = ImageResource.playerPhoto1Plus.getImage();
//            ImageIcon afterChange = changeImage(150, 230, playerPhoto1, true);
//            photo.setIcon(afterChange);
//            photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
//            panel.add(photo);
//        } else if (controller.getRecord() == 2) {
//            Image playerPhoto2 = ImageResource.playerPhoto2Plus.getImage();
//            ImageIcon afterChange = changeImage(150, 230, playerPhoto2, true);
//            photo.setIcon(afterChange);
//            photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
//            panel.add(photo);
//        }
        panel.setOpaque(false);


        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void playerUpdate() {
        currentPlayer.setText(String.format("Current player:%s", controller.getOnTurn().getUserName()));
        currentPlayer.setBackground(Color.white);
        currentPlayer.setOpaque(true);
        currentPlayer.setSize(150, 35);
        currentPlayer.setLocation(GamePanel.gamePanel.getWidth() + 10, 20);
        currentPlayer.setForeground(Color.BLACK);
        currentPlayer.setFont(new Font("times new roman", Font.PLAIN, 20));
        panel.add(currentPlayer);
    }

    public void clickTimeUpdate() {
        clickTime.setText(String.format("已单击次数:%s", controller.getCount()));
        clickTime.setBackground(Color.white);
        clickTime.setOpaque(true);
        clickTime.setSize(150, 35);
        clickTime.setLocation(GamePanel.gamePanel.getWidth() + 10, 270);
        clickTime.setForeground(Color.BLACK);
        clickTime.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(clickTime);
    }

    public void pictureUpdate() {
        if (TopicSelect.topicSelect.getSss() == 1) {
            if(controller.getOnTurn()== controller.getP1()){
                Image playerPhoto1 = ImageResource.playerPhoto1Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto1, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            } else if (controller.getOnTurn()== controller.getP2()) {
                Image playerPhoto2 = ImageResource.playerPhoto2Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto2, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            }
        } else if (TopicSelect.topicSelect.getSss() == 2) {
            if (controller.getOnTurn()== controller.getP1()) {
                Image playerPhoto3 = ImageResource.playerPhoto3Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto3, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            } else if (controller.getOnTurn()== controller.getP2()) {
                Image playerPhoto4 = ImageResource.playerPhoto4Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto4, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            }
        } else if (TopicSelect.topicSelect.getSss() == 3) {
            if (controller.getOnTurn()== controller.getP1()) {
                Image playerPhoto5 = ImageResource.playerPhoto5Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto5, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            } else if (controller.getOnTurn()== controller.getP2()) {
                Image playerPhoto6 = ImageResource.playerPhoto6Plus.getImage();
                ImageIcon afterChange = changeImage(150, 230, playerPhoto6, true);
                photo.setIcon(afterChange);
                photo.setBounds(GamePanel.gamePanel.getWidth() + 10, 30, 150, 230);
                panel.add(photo);
            }
        }
    }


    private static ImageIcon changeImage(int cWidth, int cHeight, Image image, boolean isRatio) {
        //将图片等比缩放到容器矩形内
        ImageIcon imageIcon = new ImageIcon(image);
        //默认值 强制拉伸
        int showWidth = cWidth;
        int showHeight = cHeight;

        //等比缩放
        if (isRatio) {
            //获得 原宽和原高
            int oriWidth = imageIcon.getIconWidth();
            int oriHeight = imageIcon.getIconHeight();

            if (1.0 * oriWidth / oriHeight >= 1.0 * cWidth / cHeight) {
                //图片比较宽
                showHeight = showWidth * oriHeight / oriWidth;
            } else {
                //图片比较长
                showWidth = showHeight * oriWidth / oriHeight;
            }
        }
        Image scaledInstance = imageIcon.getImage().getScaledInstance(showWidth, showHeight, Image.SCALE_DEFAULT);
        ImageIcon pic = new ImageIcon(scaledInstance);
        return pic;
    }


    public void button() {
        JButton clickBtn1 = new JButton("存档进度");
        clickBtn1.setSize(100, 20);
        clickBtn1.setLocation(5, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight());
        //clickBtn1.setLocation(gamePanel.getWidth(),  gamePanel.getHeight()+scoreBoard.getHeight()+10);
        panel.add(clickBtn1);
        clickBtn1.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

            //controller.readFileData(fileName);\
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
            try {
                controller.writeTimeDataToFile(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


        JButton clickBtn2 = new JButton("存档雷场");
        clickBtn2.setSize(100, 20);
        clickBtn2.setLocation(5, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight() + clickBtn1.getHeight() + 5);
        //clickBtn2.setLocation(gamePanel.getWidth(), gamePanel.getHeight()+scoreBoard.getHeight() + clickBtn1.getHeight() + 5);
        panel.add(clickBtn2);
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Name your game archive");
            System.out.println("fileName :" + fileName);

            //controller.readFileData(fileName);
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
        clickBtn3.setLocation(110, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight());
        panel.add(clickBtn3);
        clickBtn3.addActionListener(e -> {
            dispose();
            new InitialWindow();
        });


        JButton clickBtn4 = new JButton("透视雷场");
        clickBtn4.setSize(100, 20);
        clickBtn4.setLocation(110, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight() + clickBtn1.getHeight() + 5);
        panel.add(clickBtn4);
        clickBtn4.addActionListener(e -> {
            if (clickTimes == 0) {
                GamePanel.gamePanel.showMineDirectly();
                clickTimes++;
            } else {
                GamePanel.gamePanel.backGame();
                clickTimes--;
            }
            repaint();
        });


        JLabel time = new JLabel(seconds + "s left");
        time.setBackground(Color.white);
        time.setOpaque(true);
        time.setSize(100, 20);
        time.setLocation(225, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight());
        //time.setOpaque(true);
//        time.setBorder(BorderFactory.createLineBorder(Color.RED));
        time.setFont(new Font("粗体", Font.PLAIN, 20));
        panel.add(time);

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
        clickBtn5.setLocation(225, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight() + clickBtn1.getHeight() + 5);
        panel.add(clickBtn5);
        clickBtn5.addActionListener(e -> {
            timer.start();
            playerUpdate();
        });

        JButton clickBtn6 = new JButton("重玩");
        clickBtn6.setSize(100, 20);
        clickBtn6.setLocation(340, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight());
        panel.add(clickBtn6);
        clickBtn6.addActionListener(e -> {
            GamePanel.gamePanel.reGame();
            ScoreBoard.scoreBoard.reScore();
            getController().reControl();
            playerUpdate();
        });

        JButton story = new JButton("游戏情节");
        story.setSize(100, 20);
        story.setLocation(340, GamePanel.gamePanel.getHeight() + controller.getScoreBoard().getHeight() + clickBtn1.getHeight() + 5);
        panel.add(story);
        story.addActionListener(e -> {
            if (TopicSelect.topicSelect.getSss() == 1) {
                new Story1();
            } else if (TopicSelect.topicSelect.getSss() == 2) {
                new Story2();
            } else if (TopicSelect.topicSelect.getSss() == 3) {
                new Story3();
            }
        });

        JLabel round = new JLabel();
        round.setText(String.format("每回合点击次数:%s", ModeSelect.modeSelect.getTurnsNum()));
        round.setBackground(Color.white);
        round.setOpaque(true);
        round.setSize(150, 35);
        round.setLocation(GamePanel.gamePanel.getWidth() + 10, 320);
        round.setForeground(Color.BLACK);
        round.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        panel.add(round);


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

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getInputSeconds() {
        return inputSeconds;
    }

    public static GameController getController() {
        return controller;
    }


}
