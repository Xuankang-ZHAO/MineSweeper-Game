package components;

import entity.GridStatus;
import minesweeper.MainFrame;
import javax.swing.*;
import java.awt.*;


//233
public class GridComponent extends BasicComponent {
    public static int gridSize = 30;//设置格子的尺寸大小

    //todo:是否可以设置一个点击次数的变量，以防止第一步就踩雷呢？  addByZXK
    private int counter=0;//用于防止第一步踩到雷
    private int row;//格子的横坐标
    private int col;//格子的纵坐标
    private int value;//用于记住该component下标记是雷或者探测得到的雷数的数字

    private GridStatus status = GridStatus.Covered;//初始默认打开状态都是覆盖
    private int content = 0;

    public GridComponent(int x, int y, int num) {
        this.setSize(gridSize, gridSize);//设置component组件的大小
        this.row = x;//记住component所在的行
        this.col = y;//记住component所在的列
        this.value = num;//记住该component下标记是雷或者探测得到的雷数的数字
    }


//test

    @Override
    public void onMouseLeftClicked() {
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if (this.status == GridStatus.Covered) {
            if (value == -1) {
                this.status=GridStatus.Bombed;
                MainFrame.controller.getOnTurn().addMistake();
                MainFrame.controller.getOnTurn().costScore();
            }else {
                this.status = GridStatus.Clicked;
            }
            repaint();
            MainFrame.controller.nextTurn();
        }

        //TODO: 在左键点击一个格子的时候，还需要做什么？
    }

    @Override
    public void onMouseRightClicked() {
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row, col);
        if (this.status == GridStatus.Covered) {
            if (value == -1) {
                this.status = GridStatus.Flag;
                MainFrame.controller.getOnTurn().addScore();
            } else {
                this.status=GridStatus.Wrong;
                MainFrame.controller.getOnTurn().addMistake();
                MainFrame.controller.getOnTurn().costScore();
            }
            repaint();
            MainFrame.controller.nextTurn();
        }

        //TODO: 在右键点击一个格子的时候，还需要做什么？
    }

    public void draw(Graphics g) {

        if (this.status == GridStatus.Covered) {
            g.setColor(Color.CYAN);//覆盖的时候是蓝绿色
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            //其实是fill rectangular
        }
        if (this.status == GridStatus.Clicked) {

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Flag) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.GREEN);
            g.drawString("F", getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Bombed) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.YELLOW);
            g.drawString("B", getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Wrong) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.RED);
            g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        /*if(this.status==GridStatus.Show){
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0,0,getWidth()-1,getHeight()-1);
            g.setColor(new Color(244,183,113));
            g.drawString(Integer.toString(content),getWidth()/2 -5,getHeight()/2 +5);
        }*/
    }




    public void setContent(int content) {
        this.content = content;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        draw(g);
    }

    public GridStatus getStatus() {
        return status;
    }

    public void setStatus(GridStatus status) {
        this.status = status;
    }
}
