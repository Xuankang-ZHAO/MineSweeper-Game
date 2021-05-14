package selectMode;

import ModeOfGame.NewGameOfThreeMode;
import openWindow.InitialWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ModeSelect extends JFrame implements ActionListener, MouseListener {
    public static ModeSelect modeSelect;
    private JButton primary;
    private JButton medium;
    private JButton senior;
    private JButton user_defined;
    private JButton backButton;
    private JTextField nameText1;
    private JTextField nameText2;
    private JLabel name1;
    private JLabel name2;

    private JTextField turnsText;
    private JLabel turnsLabel;

    private int xCount;
    private int yCount;
    private int mineNum;
    private int turnsNum;
    String playerName1;
    String playerName2;

    public static int numberOfPlayer;

    public ModeSelect() {
        modeSelect = this;
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        name1 = new JLabel("请输入用户1的姓名");
        name1.setBounds(10, 20, 200, 35);
        name1.setForeground(Color.BLACK);
        name1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(name1);

        nameText1 = new JTextField();
        nameText1.setBounds(220, 20, 150, 35);
        nameText1.setOpaque(false);
        nameText1.setBorder(null);
        nameText1.addMouseListener(this);
        this.add(nameText1);

        name2 = new JLabel("请输入用户2的姓名");
        name2.setBounds(10, 70, 200, 35);
        name2.setForeground(Color.BLACK);
        name2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(name2);

        nameText2 = new JTextField();
        nameText2.setBounds(220, 70, 150, 35);
        nameText2.setOpaque(false);
        nameText2.setBorder(null);
        nameText2.addMouseListener(this);
        this.add(nameText2);

        turnsLabel = new JLabel("请输入每回合次数");
        turnsLabel.setBounds(10, 120, 200, 35);
        turnsLabel.setForeground(Color.BLACK);
        turnsLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(turnsLabel);

        turnsText = new JTextField();
        turnsText.setBounds(220, 120, 150, 35);
        turnsText.setOpaque(false);
        turnsText.setBorder(null);
        turnsText.addMouseListener(this);
        this.add(turnsText);

        primary = new JButton("初级");
        primary.setFont(new Font("黑体", Font.BOLD, 18));
        primary.setBounds(250, 170, 90, 35);
        primary.setOpaque(false);
        primary.setContentAreaFilled(false);
        primary.setForeground(Color.BLACK);
        this.add(primary);
        primary.addActionListener(e -> {
            this.xCount = 9;
            this.yCount = 9;
            this.mineNum = 10;
            this.turnsNum = Integer.parseInt(turnsText.getText());
            this.playerName1 = nameText1.getText();
            this.playerName2 = nameText2.getText();
            dispose();
            new NewGameOfThreeMode();
        });


        medium = new JButton("中级");
        medium.setFont(new Font("黑体", Font.BOLD, 18));
        medium.setBounds(250, 220, 90, 35);
        medium.setOpaque(false);
        medium.setContentAreaFilled(false);
        medium.setForeground(Color.BLACK);
        this.add(medium);
        medium.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 16;
            this.mineNum = 40;
            this.turnsNum = Integer.parseInt(turnsText.getText());
            this.playerName1 = nameText1.getText();
            this.playerName2 = nameText2.getText();
            dispose();
            new NewGameOfThreeMode();
        });


        senior = new JButton("高级");
        senior.setFont(new Font("黑体", Font.BOLD, 18));
        senior.setBounds(250, 270, 90, 35);
        senior.setOpaque(false);
        senior.setContentAreaFilled(false);
        senior.setForeground(Color.BLACK);
        this.add(senior);
        senior.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 30;
            this.mineNum = 99;
            this.turnsNum = Integer.parseInt(turnsText.getText());
            this.playerName1 = nameText1.getText();
            this.playerName2 = nameText2.getText();
            dispose();
            new NewGameOfThreeMode();
        });


        user_defined = new JButton("自定义级别");
        user_defined.setFont(new Font("黑体", Font.BOLD, 18));
        user_defined.setBounds(225, 320, 150, 35);
        user_defined.setOpaque(false);
        user_defined.setContentAreaFilled(false);
        user_defined.setForeground(Color.BLACK);
        this.add(user_defined);
        user_defined.addActionListener(e -> {
            this.turnsNum = Integer.parseInt(turnsText.getText());
            this.playerName1 = nameText1.getText();
            this.playerName2 = nameText2.getText();
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

    public String getPlayerName1() { return playerName1; }

    public String getPlayerName2() { return playerName2; }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == turnsText) {
            turnsText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == turnsText) {
            turnsText.setBorder(null);
        }
    }
}



