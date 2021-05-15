package entity;

import selectMode.ModeSelect;

import java.util.Random;

public class Player {
    private static Random ran = new Random();

    private String userName;
    private int score = 0;
    private int mistake = 0;

    /**
     * 通过特定名字初始化一个玩家对象。
     *
     * @param userName 玩家的名字
     */
    //读档时根据存储读档
    public Player(String userName) {
        this.userName = userName;
    }

    /**
     * 通过默认名字初始化一个玩家对象。
     */
    public Player() {
//        if (ModeSelect.modeSelect.getPlayerName1() == null) {
//            this.userName = "User#" + (ran.nextInt(9000) + 1000);
//        }
//        if (ModeSelect.modeSelect.getPlayerName2() == null) {
//            this.userName = "User#" + (ran.nextInt(9000) + 1000);
//        }
        //todo:这段代码什么意思？我暂时舍弃了这个构造方法，选择带有姓名的构造方法
        if (ModeSelect.numberOfPlayer == 0) {
            this.userName = "User#" + ModeSelect.modeSelect.getPlayerName1();
            ModeSelect.numberOfPlayer++;
        } else if (ModeSelect.numberOfPlayer != 0) {
            this.userName = "User#" + ModeSelect.modeSelect.getPlayerName2();
        }
    }

    /**
     * 为玩家加一分。
     */
    public void addScore() {

        score++;
    }

    /**
     * 为玩家扣一分。
     */
    public void costScore() {
        score--;
    }

    /**
     * 为玩家增加一次失误数。
     */
    public void addMistake() {
        mistake++;
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
