package controller;

import components.GridComponent;
import entity.GridStatus;
import minesweeper.GamePanel;
import entity.Player;
import minesweeper.MainFrame;
import minesweeper.ScoreBoard;
import openWindow.InitialWindow;
import selectMode.ModeSelect;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class GameController {

    private Player p1;
    private Player p2;

    int playerNUm;
    private ArrayList<Player> playerList;

    private Player onTurn;


    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;

    private int turns;//玩家们约定几个回合一次交换
    private int count;////当前玩家正处于turns的第几个回合
    private int record;//记录当前玩家

    //新游戏时初始化游戏的游戏控制器
    //双人模式下的constructor
    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
        this.onTurn = p1;
        this.turns = ModeSelect.modeSelect.getTurnsNum();
        this.count = 0;
        GridComponent.counter = 0;
    }

    //读取游戏存档状态时的游戏控制器
    public GameController() {
        this.p1 = new Player(InitialWindow.window.getCopyOfName().get(0));
        this.p2 = new Player(InitialWindow.window.getCopyOfName().get(1));
        this.onTurn = new Player(InitialWindow.window.getCopyOfName().get(2));
        this.count = Integer.parseInt(InitialWindow.window.getCopyOfName().get(3));
        this.turns = Integer.parseInt(InitialWindow.window.getCopyOfName().get(4));
        GridComponent.counter = Integer.parseInt(InitialWindow.window.getCopyOfName().get(5));
    }

    //todo:多人模式？
    public GameController(int playerNUm) {
        this.playerNUm = playerNUm;
        this.playerList = new ArrayList<>(playerNUm);
        this.onTurn = playerList.get(0);
    }

    /**
     * 初始化游戏。在开始游戏前，应先调用此方法，给予游戏必要的参数。
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public void init(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.onTurn = p1;

        //TODO: 在初始化游戏的时候，还需要做什么？
    }

    /**
     * 进行下一个回合时应调用本方法。
     * 在这里执行每个回合结束时需要进行的操作。
     */
    public void nextTurn() {
        //这段啥都不影响，就是为了换头像用的!
        if (onTurn == p1) {
            record = 1;
        } else if (onTurn == p2) {
            record = 2;
        }
        MainFrame.mainFrame.playerUpdate();
        //之上
        if (MainFrame.mainFrame.getSeconds() > 0) {
            if (onTurn == p1 && count < turns - 1) {
                count++;
                onTurn = p1;
            } else if (onTurn == p1 && count >= turns - 1) {
                if (count == turns - 1) {
                    EndGame();
                }//结束游戏or转换turn
                MainFrame.mainFrame.setSeconds(MainFrame.mainFrame.getInputSeconds());
                onTurn = p2;
                count = 0;
            } else if (onTurn == p2 && count < turns - 1) {
                count++;
                onTurn = p2;
            } else if (onTurn == p2 && count >= turns - 1) {
                if (count == turns - 1) {
                    EndGame();
                }//结束游戏or转换turn
                MainFrame.mainFrame.setSeconds(MainFrame.mainFrame.getInputSeconds());
                onTurn = p1;
                count = 0;
            }
            //todo:这个流程控制器和根据倒计时的时间强制转换还有点问题
            System.out.println("正常转换");
        }

        if (MainFrame.mainFrame.getSeconds() == 0) {
            if (onTurn == p1) {
                onTurn = p2;
                System.out.println("now it is"+p2.getUserName()+"turn"+"时间到了强制转换");
            }else {
                onTurn = p1;
                System.out.println("now it is"+p1.getUserName()+"turn"+"时间到了强制转换");
            }
            count = 0;
            MainFrame.mainFrame.setSeconds(MainFrame.mainFrame.getInputSeconds());
        }
        System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        scoreBoard.update();//回合结束更新分数表，用于游戏界面上的语句显示
        gamePanel.updateCurrentState();//回合结束更新棋子们的打开状态
        scoreBoard.updatePlayerScores();//回合结束更新玩家的分数和失误次数表，用于存档

    }

    public void EndGame() {
        int coveredMine = 0;
        int bombedMine = 0;
        for (int i = 0; i < gamePanel.getxCount(); i++) {
            for (int j = 0; j < gamePanel.getyCount(); j++) {
                //检查未揭晓的雷数
                if (gamePanel.getChessboard()[i][j] == -1 && gamePanel.getMineField()[i][j].getStatus() == GridStatus.Covered) {
                    coveredMine++;
                }
                //检查揭晓的雷数
                if (gamePanel.getChessboard()[i][j] == -1 && gamePanel.getMineField()[i][j].getStatus() == GridStatus.Bombed
                        || gamePanel.getMineField()[i][j].getStatus() == GridStatus.Flag || gamePanel.getMineField()[i][j].getStatus() == GridStatus.Wrong) {
                    bombedMine++;
                }
            }
        }
        int a = 0;
        if (p1.getScore() > p2.getScore() && p1.getScore() - p2.getScore() > coveredMine) {
            a = 1;
            System.out.println("The winner is p1.");
        } else if (p2.getScore() > p1.getScore() && p2.getScore() - p1.getScore() > coveredMine) {
            a = 2;
            System.out.println("The winner is p2.");
        }
        if (bombedMine == gamePanel.getMineCount() && p1.getScore() == p2.getScore()) {
            if (p1.getMistake() < p2.getMistake()) {
                a = 1;
                System.out.println("The winner is p1.");
            }
            if (p2.getMistake() < p1.getMistake()) {
                a = 2;
                System.out.println("The winner is p2.");
            }
            if (p1.getMistake() == p2.getMistake()) {
                a = 3;
                System.out.println("The game ended in a tie.");
            }
        }
        if (a == 1) {
            JOptionPane.showMessageDialog(null, "The winner is p1.", "Congratulations", JOptionPane.PLAIN_MESSAGE);
            new InitialWindow();
        } else if (a == 2) {
            JOptionPane.showMessageDialog(null, "The winner is p2.", "Congratulations", JOptionPane.PLAIN_MESSAGE);
            new InitialWindow();
        } else if (a == 3) {
            JOptionPane.showMessageDialog(null, "The game ended in a tie.", "Congratulations", JOptionPane.PLAIN_MESSAGE);
            new InitialWindow();
        }
    }


    public Player getOnTurn() {
        return onTurn;
    }

    public int getRecord() {
        return record;
    }

    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //存档,传入一个arraylist，其中元素为Integer 形式的二维数组，以代表棋盘的状态
    //todo:传入一个参数，以明确这是要存哪个档
    //该存档用于存雷场
    public void writeInitialDataToFile(String s) throws IOException {
        File file = new File("E:\\project 的存档", s);
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < gamePanel.getxCount(); i++) {
            for (int j = 0; j < gamePanel.getyCount(); j++) {
                fileWriter.write(gamePanel.getChessboard()[i][j] + "\t");
            }
            fileWriter.write("\r\n");
        }
        fileWriter.close();
    }

    //该存档用于存点击状态
    public void writeCurrentDataToFile(String s) throws IOException {
        File file = new File("E:\\project 的存档", s + "state");
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < gamePanel.getxCount(); i++) {
            for (int j = 0; j < gamePanel.getyCount(); j++) {
                fileWriter.write(gamePanel.getCurrentState()[i][j] + "\t");
            }
            fileWriter.write("\r\n");
        }
        fileWriter.close();
    }

    //该存档用于存玩家分数
    public void writePlayerDataToFile(String s) throws IOException {
        File file = new File("E:\\project 的存档", s + "playerScores");
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < scoreBoard.getPlayerScores().length; i++) {
            for (int j = 0; j < 2; j++) {//因为目前只有分数和失误次数两个数据需要考虑
                fileWriter.write(scoreBoard.getPlayerScores()[i][j] + "\t");
            }
            fileWriter.write("\r\n");
        }
        fileWriter.close();
    }

    /**
     * 该存档用于存玩家名称以及当前玩家名称以及当前玩家所处的第几回合以及玩家们约定的几个回合交换以及避免首发触雷的counter
     * @param s
     * @throws IOException
     */
    public void writePlayerIDToFile(String s) throws IOException {
        File file = new File("E:\\project 的存档", s + "playerID");
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < scoreBoard.getNameList().length; i++) {
            fileWriter.write(scoreBoard.getNameList()[i] + "\t");
        }
        fileWriter.write(onTurn.getUserName() + "\t");
        String s1 = Integer.toString(count);
        fileWriter.write(s1 + "\t");
        String s2 = Integer.toString(turns);
        fileWriter.write(s2 + "\t");
        String s3 = Integer.toString(GridComponent.counter);
        fileWriter.write(s3 + "\t");
        fileWriter.close();
    }

    /**
     * 该方法用于存计时器数据，第一个存的是当前的时间，第二个存的是约定的时间
     * @param s
     * @throws IOException
     */
    public void writeTimeDataToFile(String s) throws IOException {
        File file = new File("E:\\project 的存档", s + "time");
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(MainFrame.mainFrame.getSeconds() + "\t");
        fileWriter.write(MainFrame.mainFrame.getInputSeconds()+"\t");
        fileWriter.close();
    }
}
