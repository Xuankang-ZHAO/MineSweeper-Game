package selectMode;

import ModeOfGame.NewGameOfThreeMode;
import openWindow.InitialWindow;
import selectWindow.Background1;
import selectWindow.set1;

import javax.swing.*;
import java.awt.*;


public class ModeSelect extends JFrame {
    public static selectMode.ModeSelect modeSelect;
    private JButton primary;
    private JButton medium;
    private JButton senior;
    private JButton user_defined;
    private JButton backButton;

    private JTextField turnsText;
    private JLabel turnsLabel;

    private int xCount;
    private int yCount;
    private int mineNum;
    private int turnsNum;

    public ModeSelect() {
        modeSelect = this;
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        primary = new JButton("初级");
        primary.setFont(new Font("黑体", Font.BOLD, 18));
        primary.setBounds(250, 100, 90, 35);
        primary.setOpaque(false);
        primary.setContentAreaFilled(false);
        primary.setForeground(Color.BLACK);
        this.add(primary);
        primary.addActionListener(e -> {
            this.xCount = 9;
            this.yCount = 9;
            this.mineNum = 10;
//            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGameOfThreeMode();
        });


        medium = new JButton("中级");
        medium.setFont(new Font("黑体", Font.BOLD, 18));
        medium.setBounds(250, 150, 90, 35);
        medium.setOpaque(false);
        medium.setContentAreaFilled(false);
        medium.setForeground(Color.BLACK);
        this.add(medium);
        medium.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 16;
            this.mineNum = 40;
//            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGameOfThreeMode();
        });

        senior = new JButton("高级");
        senior.setFont(new Font("黑体", Font.BOLD, 18));
        senior.setBounds(250, 200, 90, 35);
        senior.setOpaque(false);
        senior.setContentAreaFilled(false);
        senior.setForeground(Color.BLACK);
        this.add(senior);
        senior.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 30;
            this.mineNum = 99;
//            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGameOfThreeMode();
        });

        user_defined = new JButton("自定义级别");
        user_defined.setFont(new Font("黑体", Font.BOLD, 18));
        user_defined.setBounds(225, 250, 150, 35);
        user_defined.setOpaque(false);
        user_defined.setContentAreaFilled(false);
        user_defined.setForeground(Color.BLACK);
        this.add(user_defined);
        user_defined.addActionListener(e -> {
            dispose();
            new set1();
        });

        backButton = new JButton("返回");
        backButton.setFont(new Font("黑体", Font.BOLD, 18));
        backButton.setBounds(450, 350, 100, 35);
        backButton.setOpaque(false);
        backButton.setContentAreaFilled(false);
        backButton.setForeground(Color.BLACK);
        this.add(backButton);
        backButton.addActionListener(e -> {
            dispose();
            new InitialWindow();
        });
        this.add(new Background1());
        this.setVisible(true);
    }

    //这是用来返回设定的每回合每个玩家可以点击的次数的
    //调用该get方法时，请用   set1.set1.getTurnsNum()
    // 强调： 这里的 set1 需要重复两次
    public int getTurnsNum() {
        return turnsNum;
    }

    public int getxCount() {
        return xCount;
    }

    public int getyCount() {
        return yCount;
    }

    public int getMineNum() {
        return mineNum;
    }
}



