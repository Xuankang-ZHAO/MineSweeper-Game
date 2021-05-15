package controller;

import components.GridComponent;
import entity.GridStatus;
import minesweeper.GamePanel;
import entity.Player;
import minesweeper.ScoreBoard;
import openWindow.InitialWindow;
import selectMode.ModeSelect;
import selectMode.set1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class GameController {

    private Player p1;
    private Player p2;

    int playerNUm;
    ArrayList<Player> playerList;

    private Player onTurn;


    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;

    //新游戏时初始化游戏的游戏控制器
    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
        this.onTurn = p1;
    }

    //读取游戏存档状态时的游戏控制器
    public GameController() {
        this.p1 = new Player(InitialWindow.window.getCopyOfName().get(0));
        this.p2 = new Player(InitialWindow.window.getCopyOfName().get(1));
        this.onTurn = new Player(InitialWindow.window.getCopyOfName().get(2));
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
     * <p>
     * (目前这里没有每个玩家进行n回合的计数机制的，请自行修改完成哦~）
     */
    public void nextTurn() {
        if (onTurn == p1 && GridComponent.count < ModeSelect.modeSelect.getTurnsNum() - 1) {
            GridComponent.count++;
            onTurn = p1;
        } else if (onTurn == p1 && GridComponent.count >= ModeSelect.modeSelect.getTurnsNum() - 1) {
            if (GridComponent.count == ModeSelect.modeSelect.getTurnsNum() - 1) {
                EndGame();
            }//结束游戏or转换turn
            onTurn = p2;
            GridComponent.count = 0;
        } else if (onTurn == p2 && GridComponent.count < ModeSelect.modeSelect.getTurnsNum() - 1) {
            GridComponent.count++;
            onTurn = p2;
        } else if (onTurn == p2 && GridComponent.count >= ModeSelect.modeSelect.getTurnsNum() - 1) {
            if (GridComponent.count == ModeSelect.modeSelect.getTurnsNum() - 1) {
                EndGame();
            }//结束游戏or转换turn
            onTurn = p1;
            GridComponent.count = 0;
        }
        System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        scoreBoard.update();//回合结束更新分数表，用于游戏界面上的语句显示
        gamePanel.updateCurrentState();//回合结束更新棋子们的打开状态
        scoreBoard.updatePlayerScores();//回合结束更新玩家的分数和失误次数表，用于存档
        //TODO: 在每个回合结束的时候，还需要做什么 (例如...检查游戏是否结束？)
    }

    public void EndGame() {
        int coveredMine = 0;
        int bombedMine = 0;
        for (int i = 0; i < gamePanel.getxCount(); i++) {
            for (int j = 0; j < getGamePanel().getyCount(); j++) {
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

    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
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

    //该存档用于存玩家名称
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
        fileWriter.close();
    }
}
