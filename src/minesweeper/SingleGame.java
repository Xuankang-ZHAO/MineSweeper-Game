package minesweeper;

import components.GridComponent;
import openWindow.InitialWindow;
import selectMode.TopicSelect;
import selectMode.set1;

import javax.swing.*;
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


    public SingleGame(){
        singleGame=this;
        this.xCount= set1.set1.getxCount();
        this.yCount=set1.set1.getyCount();
        this.mineCount=set1.set1.getMineNum();
        this.unopened=xCount*yCount;
        this.opened=0;

        this.setTitle("我的世界联名扫雷");
        this.setLayout(null);//清空布局管理器
        this.setSize(yCount * GridComponent.gridSize + 200, xCount * GridComponent.gridSize + 200);
        this.setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount);

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

        panel.add(gamePanel);
        panel.setOpaque(false);


        JLabel label1=new JLabel("待开:"+unopened);
        label1.setSize(110,30);
        label1.setLocation(5,gamePanel.getHeight());
        panel.add(label1);

        JLabel label2=new JLabel("已开:"+opened);
        label2.setSize(110,30);
        label2.setLocation(120,gamePanel.getHeight());
        panel.add(label2);

        JLabel label3=new JLabel("用时"+seconds+"s");
        label3.setSize(110,30);
        label3.setLocation(235,gamePanel.getHeight());
        panel.add(label3);

        JButton b1=new JButton("重玩");
        b1.setSize(110,30);
        b1.setLocation(5,gamePanel.getHeight()+label1.getHeight()+5);
        panel.add(b1);
        b1.addActionListener(e -> {
            GamePanel.gamePanel.reGame();
            unopened=xCount*yCount;
            opened=0;
            seconds=0;
        });

        JButton b2=new JButton("开始界面");
        b2.setSize(110,30);
        b2.setLocation(120,gamePanel.getHeight()+label.getHeight()+5);
        panel.add(b2);
        b2.addActionListener(e -> {
            this.dispose();
            new InitialWindow();
        });

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
            }
        });
        timer.start();

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
    public void minus(){
        unopened--;
    }
    public void plus(){
        opened++;
    }
    public void stop(){
        timer.stop();
    }

}
