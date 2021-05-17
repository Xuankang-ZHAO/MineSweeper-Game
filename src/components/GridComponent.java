package components;

import entity.GridStatus;
import minesweeper.GamePanel;
import minesweeper.MainFrame;
import selectMode.ModeSelect;

import javax.swing.*;
import java.awt.*;


//233
public class GridComponent extends BasicComponent {
    public static int gridSize = 30;//设置格子的尺寸大小
    //public static int count=0;//用于设定回合数

     ImageIcon p2=new ImageIcon("src/pictures/苦力怕贴图.PNG");
     ImageIcon p2PLus=change(p2,0.11);
     ImageIcon p1=new ImageIcon("src/pictures/草方块.PNG");
     ImageIcon p1Plus=change(p1,0.2);
     ImageIcon p3=new ImageIcon("src/pictures/钻石.PNG");
     ImageIcon p3Plus=change(p3,0.06);
     ImageIcon p4=new ImageIcon("src/pictures/贴图史蒂夫.png");
     ImageIcon p4Plus=change(p4,0.08);




    private int xCount=MainFrame.mainFrame.getxCount();
    private int yCount=MainFrame.mainFrame.getyCount();
    private int mineNUm=MainFrame.mainFrame.getMineCount();

    //todo:是否可以设置一个点击次数的变量，以防止第一步就踩雷呢？  addByZXK
    public static int counter;//用于防止第一步踩到雷
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

    @Override
    public void onMouseLeftClicked() {
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if (this.status == GridStatus.Covered) {
            if(counter==0&&value==-1){
                MainFrame.mainFrame.dispose();
                new MainFrame(xCount,yCount,mineNUm);
            }else {
                if (value == -1) {
                    setStatus(GridStatus.Bombed);
                    MainFrame.controller.getOnTurn().addMistake();
                    MainFrame.controller.getOnTurn().costScore();
                } else {
                    GamePanel.gamePanel.openCell(row,col);
                    setStatus(GridStatus.Clicked);
                }
                counter++;
            }
            MainFrame.controller.nextTurn();
        }
        //TODO: 在左键点击一个格子的时候，还需要做什么？
    }

    @Override
    public void onMouseRightClicked() {
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row, col);
        if (this.status == GridStatus.Covered) {
            if (value == -1) {
                setStatus(GridStatus.Flag);
                MainFrame.controller.getOnTurn().addScore();
            } else {
                setStatus(GridStatus.Wrong);
                MainFrame.controller.getOnTurn().addMistake();
                MainFrame.controller.getOnTurn().costScore();
            }
            MainFrame.controller.nextTurn();
        }

        //TODO: 在右键点击一个格子的时候，还需要做什么？
    }

    public void draw(Graphics g) {

        if (this.status == GridStatus.Covered) {
            Image image1=p1Plus.getImage();
            g.drawImage(image1,0,0,image1.getWidth(this),image1.getHeight(this),this);
        }
        if (this.status == GridStatus.Clicked) {

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.setColor(Color.BLACK);
            g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
        }
        if (this.status == GridStatus.Flag) {
            Image image1=p3Plus.getImage();
            g.drawImage(image1,0,0,image1.getWidth(this),image1.getHeight(this),this);
        }
        if (this.status == GridStatus.Bombed) {
            Image image1=p2PLus.getImage();
            g.drawImage(image1,0,0,image1.getWidth(this),image1.getHeight(this),this);

        }
        if (this.status == GridStatus.Wrong) {
            Image image1=p4Plus.getImage();
            g.drawImage(image1,0,0,image1.getWidth(this),image1.getHeight(this),this);

        }
        if (this.status == GridStatus.Show) {
            Image image1=p2PLus.getImage();
            g.drawImage(image1,0,0,image1.getWidth(this),image1.getHeight(this),this);
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

    /**
     * 用于调整图片的大小，以进行适当的贴图
     * @param picture
     * @param rate
     * @return
     */
    public ImageIcon change(ImageIcon picture, double rate){
        int width=(int)(picture.getIconWidth()*rate);
        int height=(int)( picture.getIconHeight()*rate);
        Image pic=picture.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT);
        ImageIcon pic2=new ImageIcon(pic);
        return pic2;
    }




}
