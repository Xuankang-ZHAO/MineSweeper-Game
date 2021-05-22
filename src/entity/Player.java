package entity;

import selectMode.ModeSelect;

import java.util.Random;

public class Player {
    private static Random ran = new Random();

    private String userName;
    private int score;
    private int mistake;

    /**
     * 通过特定名字初始化一个玩家对象。
     *
     * @param userName 玩家的名字
     */
    //读档时根据存储读档
    public Player(String userName,int score,int mistake) {
        this.userName = userName;
        this.score=score;
        this.mistake=mistake;
    }

    /**
     * 通过默认名字初始化一个玩家对象。
     */
    public Player() {
        this.userName = "*" + (ran.nextInt(90) + 10);
    }

    /**
     * 为玩家加一分。
     */
    public void addScore() {

        this.score++;
    }

    /**
     * 为玩家扣一分。
     */
    public void costScore() {

        this.score--;
    }

    /**
     * 为玩家增加一次失误数。
     */
    public void addMistake() {
        this.mistake++;
    }


    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    public int getMistake() {
        return mistake;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }
}
