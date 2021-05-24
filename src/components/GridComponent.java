package components;

import Music.BombedMusic;
import Music.ClickedMusic;
import Music.FlagMusic;
import Music.WrongMusic;
import entity.GridStatus;
import minesweeper.GamePanel;
import minesweeper.MainFrame;
import imResources.ImageResource;
import selectMode.TopicSelect;

import java.awt.*;

public class GridComponent extends BasicComponent {
    public static GridComponent gridComponent;

    public static int gridSize = 35;//设置格子的尺寸大小
    //public static int count=0;//用于设定回合数
    private int xCount = MainFrame.mainFrame.getxCount();
    private int yCount = MainFrame.mainFrame.getyCount();
    private int mineNUm = MainFrame.mainFrame.getMineCount();

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
            if (counter == 0 && value == -1) {
                MainFrame.mainFrame.dispose();
                MainFrame m=new MainFrame(xCount, yCount, mineNUm);
                m.setVisible(true);
                m.getController().setCount(-1);
            } else {
                if (value == -1) {
                    setStatus(GridStatus.Bombed);
                    new BombedMusic();
                    //MainFrame.controller.getOnTurn().addMistake();
                    MainFrame.controller.getOnTurn().costScore();
                } else {
                    new ClickedMusic();
                    GamePanel.gamePanel.openCell(row, col);
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
                new FlagMusic();
                MainFrame.controller.getOnTurn().addScore();
            } else {
                setStatus(GridStatus.Wrong);
                new WrongMusic();
                System.out.println("打印1");
                MainFrame.controller.getOnTurn().addMistake();
                MainFrame.controller.getOnTurn().costScore();
            }
            counter++;

            MainFrame.controller.nextTurn();
        }

        //TODO: 在右键点击一个格子的时候，还需要做什么？
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
