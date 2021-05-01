package controller;

import minesweeper.GamePanel;
import entity.Player;
import minesweeper.ScoreBoard;

import java.io.*;
import java.util.ArrayList;


public class GameController {

    private Player p1;
    private Player p2;

    private Player onTurn;

    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;

    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
        this.onTurn = p1;
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
        if (onTurn == p1) {
            onTurn = p2;
        } else if (onTurn == p2) {
            onTurn = p1;
        }
        System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
        scoreBoard.update();
        //TODO: 在每个回合结束的时候，还需要做什么 (例如...检查游戏是否结束？)

    }


    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */
    public Player getOnTurnPlayer() {
        return onTurn;
    }


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


    /* public void readFileData(String fileName) {
         //todo: read date from file

     }

     public void writeDataToFile(String fileName){
         //todo: write data into file
     }*/
    public  ArrayList<ArrayList<Integer>> readFileData() throws IOException {
        ArrayList<ArrayList<Integer>> readDemo = new ArrayList<>();
        File file = new File("F:\\save.txt");
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        if (file.exists()) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] strings = s.split("\t");
                readDemo.add(new ArrayList());
                for (int i = 0; i < strings.length; i++) {
                    int num = Integer.parseInt(strings[i]);
                    readDemo.get(readDemo.size() - 1).add(i, num);
                }
            }
        }
        bufferedReader.close();
        return readDemo;
    }

    //存档,传入一个arraylist，其中元素为Integer 形式的二维数组，以代表棋盘的状态
    //todo:传入一个参数，以明确这是要存哪个档
    public  void saveFileData(ArrayList<ArrayList<Integer>> demo) throws IOException {
        File file = new File("F:\\save.txt");
        if (file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        for (int i = 0; i < demo.size(); i++) {
            for (int j = 0; j < demo.get(i).size(); j++) {
                fileWriter.write(demo.get(i).get(j) + "\t");
            }
            fileWriter.write("\r\n");
        }
        fileWriter.close();
    }

}
