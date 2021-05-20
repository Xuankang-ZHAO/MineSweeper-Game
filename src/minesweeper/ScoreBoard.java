package minesweeper;

import components.GridComponent;
import controller.GameController;
import entity.Player;
import openWindow.InitialWindow;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * 此类的对象是一个计分板容器，通过传入玩家对象，
 * 可以用update()方法实时更新玩家的分数以及失误数。
 */
public class ScoreBoard extends JPanel {

    Player p1;
    Player p2;

    int[][] playerScores;//记录玩家的分数
    String[] nameList;//记录玩家的名字

    JLabel score1 = new JLabel();
    JLabel score2 = new JLabel();

    /**
     * 通过进行游戏的玩家来初始化计分板。这里只考虑了两个玩家的情况。
     * 如果想要2-4人游戏甚至更多，请自行修改(建议把所有玩家存在ArrayList)~
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public ScoreBoard(Player p1, Player p2, int xCount, int yCount) {
        JLabel scoreBoard = new JLabel("Score Board");
        scoreBoard.setForeground(Color.BLACK);
        scoreBoard.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.add(scoreBoard);

        this.setSize((yCount * GridComponent.gridSize) , 80);
        this.setLocation(0, xCount * GridComponent.gridSize);

        this.p1 = p1;
        this.p2 = p2;

        initialPlayerScores();
        initialNameList();

        this.add(score1);
        this.add(score2);


        this.setLayout(new BoxLayout(this, 1));//target指的是container
        // 实则按照y轴，指定组件应从上到下排列，即为Y_AXIS
        update();
    }


    public ScoreBoard() {
        JLabel scoreBoard = new JLabel("Score Board");
        scoreBoard.setForeground(Color.BLACK);
        scoreBoard.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        this.add(scoreBoard);
        this.setSize((InitialWindow.window.getCopyOfMine().get(0).size() * GridComponent.gridSize), 80);
        this.setLocation(0, InitialWindow.window.getCopyOfMine().size() * GridComponent.gridSize);

        //要把玩家信息（名字，分数，失误数）全部加载
        this.p1 = new Player(InitialWindow.window.getCopyOfName().get(0));
        p1.setScore(InitialWindow.window.getCopyOfScore().get(0).get(0));
        p1.setMistake(InitialWindow.window.getCopyOfScore().get(0).get(1));
        this.p2 = new Player(InitialWindow.window.getCopyOfName().get(1));
        p2.setScore(InitialWindow.window.getCopyOfScore().get(1).get(0));
        p2.setMistake(InitialWindow.window.getCopyOfScore().get(1).get(1));

        readPlayerScores();
        initialNameList();

        this.add(score1);
        this.add(score2);


        this.setLayout(new BoxLayout(this, 1));//target指的是container
        // 实则按照y轴，指定组件应从上到下排列，即为Y_AXIS
        update();
    }

    /**
     * 刷新计分板的数据。
     * 计分板会自动重新获取玩家的分数，并更新显示。
     */

    public void update() {
        score1.setText(String.format("%s : %d score and %d mistake", p1.getUserName(), p1.getScore(), p1.getMistake()));
        score1.setForeground(Color.BLACK);
        score1.setFont(new Font("微软雅黑", Font.PLAIN, 18));

        score2.setText(String.format("%s : %d score and %d mistake", p2.getUserName(), p2.getScore(), p2.getMistake()));
        score2.setForeground(Color.BLACK);
        score2.setFont(new Font("微软雅黑", Font.PLAIN, 18));

    }

    public void initialPlayerScores() {
        this.playerScores = new int[2][2];
        playerScores[0][0] = 0;
        playerScores[0][1] = 0;
        playerScores[1][0] = 0;
        playerScores[1][1] = 0;
    }

    public void readPlayerScores() {
        this.playerScores = new int[2][2];
        playerScores[0][0] = InitialWindow.window.getCopyOfScore().get(0).get(0);
        playerScores[0][1] = InitialWindow.window.getCopyOfScore().get(0).get(1);
        playerScores[1][0] = InitialWindow.window.getCopyOfScore().get(1).get(0);
        playerScores[1][1] = InitialWindow.window.getCopyOfScore().get(1).get(1);

    }

    public void initialNameList() {
        this.nameList = new String[2];
        nameList[0] = p1.getUserName();
        nameList[1] = p2.getUserName();
    }


    public void updatePlayerScores() {
        playerScores[0][0] = p1.getScore();
        playerScores[0][1] = p1.getMistake();
        playerScores[1][0] = p2.getScore();
        playerScores[1][1] = p2.getMistake();
    }

    public int[][] getPlayerScores() {
        return playerScores;
    }

    public String[] getNameList() {
        return nameList;
    }
}
