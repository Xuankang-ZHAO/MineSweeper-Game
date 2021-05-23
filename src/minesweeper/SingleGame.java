package minesweeper;

import components.GridComponent;
import openWindow.InitialWindow;
import selectMode.TopicSelect;
import selectMode.set1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SingleGame extends JFrame {
    private int xCount;
    private int yCount;
    private int mineCount;
    private int unopened;
    private int opened;
    private int seconds;
    private ImageIcon back;
    JPanel panel = (JPanel) this.getContentPane();
    public static SingleGame singleGame;
    Timer timer;
    JButton button1;
    JButton button2;
    JButton button3;


    public SingleGame(){
        singleGame=this;
        this.xCount= set1.set1.getxCount();
        this.yCount=set1.set1.getyCount();
        this.mineCount=set1.set1.getMineNum();
        this.unopened=xCount*yCount;
        this.opened=0;
        this.seconds=0;

        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 200, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        SinglePanel singlePanel = new SinglePanel(xCount, yCount, mineCount);

        if (TopicSelect.topicSelect.getSss() == 1) {
            this.back = new ImageIcon("resouces/pictures/背景1.jpg");
        } else if (TopicSelect.topicSelect.getSss() == 2) {
            this.back = new ImageIcon("resouces/pictures/背景2.jpg");
        } else if (TopicSelect.topicSelect.getSss() == 3) {
            this.back = new ImageIcon("resouces/pictures/背景3.jpg");
        }

        JLabel label = new JLabel(back);
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        panel.add(singlePanel);
        panel.setOpaque(false);


        this.button1=new JButton("待开:"+unopened);
        button1.setSize(110,30);
        button1.setLocation(5,singlePanel.getHeight());
        button1.setFocusPainted(false);
        panel.add(button1);

        this.button2=new JButton("已开:"+opened);
        button2.setSize(110,30);
        button2.setLocation(120,singlePanel.getHeight());
        button2.setFocusPainted(false);
        panel.add(button2);

        this.button3=new JButton("用时"+seconds+"s");
        button3.setSize(110,30);
        button3.setLocation(235,singlePanel.getHeight());
        button3.setFocusPainted(false);
        panel.add(button3);


        JButton b1=new JButton("重玩");
        b1.setSize(110,30);
        b1.setLocation(5,singlePanel.getHeight()+button1.getHeight()+5);
        panel.add(b1);
        b1.addActionListener(e -> {
            singlePanel.reGame();
            this.unopened=xCount*yCount;
            this.opened=0;
            this.seconds=0;
            update();
        });

        JButton b2=new JButton("开始界面");
        b2.setSize(110,30);
        b2.setLocation(120,singlePanel.getHeight()+button1.getHeight()+5);
        panel.add(b2);
        b2.addActionListener(e -> {
            this.dispose();
            new InitialWindow();
        });

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                button3.setText("用时"+seconds+"s");
            }
        });
        timer.start();

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    public void stop(){
        timer.stop();
    }

    public int getUnopened() {
        return unopened;
    }

    public void setUnopened(int unopened) {
        this.unopened = unopened;
    }

    public int getOpened() {
        return opened;
    }

    public void setOpened(int opened) {
        this.opened = opened;
    }

    public void update(){
        this.button1.setText("待开"+unopened);
        this.button2.setText("已开"+opened);
    }
}
