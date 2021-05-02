package minesweeper;

import components.GridComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private GridComponent[][] mineField;
    private int[][] chessboard;
    private final Random random = new Random();
    private int xCount;
    private int yCount;
    private int mineCount;

    /**
     * 初始化一个具有指定行列数格子、并埋放了指定雷数的雷区。
     *
     * @param xCount    count of grid in column
     * @param yCount    count of grid in row
     * @param mineCount mine count
     */
    //注意：xCount代表行数，yCount代表列数
    public GamePanel(int xCount, int yCount, int mineCount) {
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setSize(GridComponent.gridSize * yCount, GridComponent.gridSize * xCount);

        initialGame(xCount, yCount, mineCount);

        repaint();
    }

    public void initialGame(int xCount, int yCount, int mineCount) {
        mineField = new GridComponent[xCount][yCount];

        generateChessBoard(xCount, yCount, mineCount);//初始化棋盘

        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                GridComponent gridComponent = new GridComponent(i, j);
                gridComponent.setContent(chessboard[i][j]);
                gridComponent.setLocation(j * GridComponent.gridSize, i * GridComponent.gridSize);
                mineField[i][j] = gridComponent;
                this.add(mineField[i][j]);
            }
        }
    }

    //不同棋盘大小对应不同数量的雷
    public int findBoardSize(int xCount, int yCount, int mineCount) {
        if (xCount == 9 && yCount == 9)
            return 10;
        if (xCount == 16 && yCount == 16)
            return 40;
        if (xCount == 16 && yCount == 30)
            return 99;
        else {
            if (xCount <= 24 && yCount <= 30 && mineCount <= (xCount * yCount) / 2) {
                return mineCount;
            } else {
                System.out.print("The size is invalid,please input again");
                //这里的语句后续可能会更改
                return 0;
            }
        }
    }

    public void generateChessBoard(int xCount, int yCount, int mineCount) {
        //todo: generate chessboard by your own algorithm
        chessboard = new int[xCount][yCount];//定义棋盘大小
        int count = 0;
        //埋下指定数量的雷数
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                if (count <= findBoardSize(xCount, yCount, mineCount)) {
                    chessboard[i][j] = -1;
                    count++;
                }
            }
        }
        //计算周边雷的数量
        for (int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(data[i][j]==LeiCode){
                    continue;
                }
                int tempCount=0;
                if(i>0&&j>0&&data[i-1][j-1]==LeiCode){
                    tempCount++;
                }
                if(i>0&&data[i-1][j]==LeiCode){
                    tempCount++;
                }
                if(i>0&&j<COL-1&&data[i-1][j+1]==LeiCode){
                    tempCount++;
                }
                if(j>0&&data[i][j-1]==LeiCode){
                    tempCount++;
                }
                if(j<COL-1&&data[i][j+1]==LeiCode){
                    tempCount++;
                }
                if(i<ROW-1&&j>0&&data[i+1][j-1]==LeiCode){
                    tempCount++;
                }
                if(i<ROW-1&&data[i+1][j]==LeiCode){
                    tempCount++;
                }
                if(i<ROW-1&&j<COL-1&&data[i+1][j+1]==LeiCode){
                    tempCount++;
                }
                data[i][j]=tempCount;
            }
        }
        resetMine(xCount,yCount);
        //如果打乱后出现9雷，重新洗牌直至无9雷，赋值
        while (checkMine(xCount, yCount)){
            resetMine(xCount,yCount);
        }
    }


    public boolean checkMine(int xCount, int yCount) {
        //检查雷的分布
        //找9个雷的情况
        boolean check = false;
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                int count = 0;
                if (chessboard[i][j] == -1) {
                    count++;
                }
                if (j - 1 >= 0 && chessboard[i][j - 1] == -1) {
                    count++;
                }
                if (j + 1 < yCount && chessboard[i][j + 1] == -1) {
                    count++;
                }
                if (i - 1 >= 0 && chessboard[i - 1][j] == -1) {
                    count++;
                }
                if (i + 1 < xCount && chessboard[i + 1][j] == -1) {
                    count++;
                }
                if (i - 1 >= 0 && j - 1 >= 0 && chessboard[i - 1][j - 1] == -1) {
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < yCount && chessboard[i - 1][j + 1] == -1) {
                    count++;
                }
                if (i + 1 < xCount && j - 1 >= 0 && chessboard[i + 1][j - 1] == -1) {
                    count++;
                }
                if (i + 1 < xCount && j + 1 < yCount && chessboard[i + 1][j + 1] == -1) {
                    count++;
                }
                if (count == 9) {//有9雷是true；
                    check=true;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        return check;//没有9雷false；
        // 暂时还没有满足用户第一次点到雷的情况
    }

    public void resetMine(int xCount, int yCount) {
        while (this.checkMine(xCount, yCount)) {//有9雷
            //以下用洗牌算法防止雷区过度密集
            //对每一行重新洗牌 i在外层，j在内层
            for (int i = xCount - 1; i >= 0; i--) {
                for (int j = yCount - 1; j > 0; j--) {
                    int a = random.nextInt(j - 1);//小心数组越界！！！
                    int rem = chessboard[i][a];
                    chessboard[i][a] = chessboard[i][j];//得记住之前的数啊，是交换！！！
                    chessboard[i][j] = rem;
                }
            }
            //对每一列重新洗牌，i在内，j在外
            for (int j = yCount - 1; j >= 0; j--) {
                for (int i = xCount - 1; i >0; i--) {
                    int b = random.nextInt(i - 1);
                    int rem=chessboard[b][j];
                    chessboard[b][j] = chessboard[i][j];
                    chessboard[i][j]=rem;
                }
            }

        }
    }

    /**
     * 获取一个指定坐标的格子。
     * 注意请不要给一个棋盘之外的坐标哦~
     *
     * @param x 第x列
     * @param y 第y行
     * @return 该坐标的格子
     */
    public GridComponent getGrid(int x, int y) {
        try {
            return mineField[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
