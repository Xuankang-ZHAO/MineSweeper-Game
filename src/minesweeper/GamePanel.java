package minesweeper;

import components.GridComponent;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private GridComponent[][] mineField;//布雷区
    private int[][] chessboard;//棋盘
    private final Random random = new Random();

    /**
     * 初始化一个具有指定行列数格子、并埋放了指定雷数的雷区。
     *
     * @param xCount    count of grid in column
     * @param yCount    count of grid in row
     * @param mineCount mine count
     */
    public GamePanel(int xCount, int yCount, int mineCount) {
        this.setVisible(true);
        this.setFocusable(true);//这个component可以获得焦点
        this.setLayout(null);//布局管理器为空
        this.setBackground(Color.WHITE);//设置面板的背景
        //new todo 是否可以更改背景以获得更好的界面体验？
        this.setSize(GridComponent.gridSize * yCount, GridComponent.gridSize * xCount);

        initialGame(xCount, yCount, mineCount);

        repaint();
    }
    //这个初始化棋盘的方法实际上是在埋雷
    public void initialGame(int xCount, int yCount, int mineCount) {
        mineField = new GridComponent[xCount][yCount];

        generateChessBoard(xCount, yCount, mineCount);

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


    public void generateChessBoard(int xCount, int yCount, int mineCount) {
        //todo: generate chessboard by your own algorithm
        //备注：todo 这是最基本的按照随机数生成雷区的方法，值得注意的是雷的数量mineCount并没有用到，即这个算法无法指定雷的数量
        // 如果要自定义雷的数量，甚至对雷的密集程度做出规定，算法就需要改变了
        //还有需要注意的是，这里生成的随机数实则只有-1和^-1两种意义，并不是表示周围9格区域真正有多少的mine
        chessboard = new int[xCount][yCount];
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                // suppose -1 represents mine
                chessboard[i][j] = random.nextInt(10) - 1;
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
