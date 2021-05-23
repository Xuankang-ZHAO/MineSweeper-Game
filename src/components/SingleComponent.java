package components;

import Music.BombedMusic;
import Music.ClickedMusic;
import Music.FlagMusic;
import Music.WrongMusic;
import entity.GridStatus;
import minesweeper.SingleGame;
import minesweeper.SinglePanel;
import resources.ImageResource;
import selectMode.TopicSelect;

import javax.swing.*;
import java.awt.*;

public class SingleComponent extends BasicComponent{

    public static int gridSize = 35;
    private int row;//格子的横坐标
    private int col;//格子的纵坐标
    private int value;//用于记住该component下标记是雷或者探测得到的雷数的数字
    private GridStatus status = GridStatus.Covered;//初始默认打开状态都是覆盖
    private int content = 0;
    public static int counter;//用于防止第一步踩到雷


    public SingleComponent(int x, int y, int num){
        this.setSize(gridSize, gridSize);//设置component组件的大小
        this.row = x;//记住component所在的行
        this.col = y;//记住component所在的列
        this.value = num;//记住该component下标记是雷或者探测得到的雷数的数字

    }
    @Override
    public void onMouseLeftClicked() {
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);

        if(this.status==GridStatus.Covered){
            if (counter == 0 && value == -1) {
                SingleGame.singleGame.dispose();
                SingleGame s=new SingleGame();
                s.setVisible(true);
            }else {
                if(value==-1){
                    setStatus(GridStatus.Bombed);
                    SingleGame.singleGame.update();
                    SingleGame.singleGame.stop();
                    JOptionPane.showMessageDialog(null, "您点中了苦力怕，请重新开始游戏", "提示", JOptionPane.PLAIN_MESSAGE);
                    new BombedMusic();
                }else {
                    new ClickedMusic();
                    SinglePanel.singlePanel.openCellForSingle(row,col);
                    setStatus(GridStatus.Clicked);
                    SingleGame.singleGame.update();

                }
                counter++;
            }
        }
    }

    @Override
    public void onMouseRightClicked() {
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row, col);
        if (this.status == GridStatus.Covered){
            if(value==-1){
                setStatus(GridStatus.Flag);
                SingleGame.singleGame.update();
                new FlagMusic();
            }else {
                setStatus(GridStatus.Wrong);
                SingleGame.singleGame.update();
                SingleGame.singleGame.stop();
                JOptionPane.showMessageDialog(null, "标记错误，请重新开始游戏", "提示", JOptionPane.PLAIN_MESSAGE);
                new WrongMusic();
            }
            counter++;
        }

    }

    public void draw(Graphics g) {
        if (TopicSelect.topicSelect.getSss() == 1) {
            if (this.status == GridStatus.Clicked) {
                g.setColor(Color.WHITE);
                g.fill3DRect(0, 0, getWidth() - 1, getHeight() - 1,true);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Covered) {
                Image image1 = ImageResource.p1Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
            if (this.status == GridStatus.Bombed) {
                Image image1 = ImageResource.p2Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Flag) {
                Image image1 = ImageResource.p3Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
            if (this.status == GridStatus.Wrong) {
                Image image1 = ImageResource.p4Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Show) {
                Image image1 = ImageResource.p2Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
        } else if (TopicSelect.topicSelect.getSss() == 2) {
            if (this.status == GridStatus.Clicked) {
                g.setColor(Color.WHITE);
                g.fill3DRect(0, 0, getWidth() - 1, getHeight() - 1,true);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Covered) {
                Image image1 = ImageResource.p5Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
            if (this.status == GridStatus.Bombed) {
                Image image1 = ImageResource.p6Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Flag) {
                Image image1 = ImageResource.p7Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }

            if (this.status == GridStatus.Wrong) {
                Image image1 = ImageResource.p8Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Show) {
                Image image1 = ImageResource.p6Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
        } else if (TopicSelect.topicSelect.getSss() == 3) {
            if (this.status == GridStatus.Clicked) {
                g.setColor(Color.WHITE);
                g.fill3DRect(0, 0, getWidth() - 1, getHeight() - 1,true);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
            if (this.status == GridStatus.Covered) {
                Image image1 = ImageResource.p9Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
            if (this.status == GridStatus.Bombed) {
                Image image1 = ImageResource.p10Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Flag) {
                Image image1 = ImageResource.p11Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
            if (this.status == GridStatus.Wrong) {
                Image image1 = ImageResource.p12Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);

            }
            if (this.status == GridStatus.Show) {
                Image image1 = ImageResource.p10Plus.getImage();
                g.drawImage(image1, 0, 0, image1.getWidth(this), image1.getHeight(this), this);
            }
        }
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

    //每次改变一个格子都需要重新绘制这个格子
    public void setStatus(GridStatus status) {
        this.status = status;
        repaint();
    }
}
