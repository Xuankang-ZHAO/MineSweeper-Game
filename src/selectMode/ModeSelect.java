package selectMode;

import ModeOfGame.NewGame;
import ModeOfGame.NewGameOfThreeMode;
import openWindow.InitialWindow;
import selectWindow.Background1;
import selectWindow.set1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ModeSelect extends JFrame implements ActionListener, MouseListener {
    public static selectMode.ModeSelect modeSelect;
    private JButton primary;
    private JButton medium;
    private JButton senior;
    private JButton user_defined;
    private JButton backButton;

    private JTextField turnsText1;
    private JTextField turnsText2;
    private JTextField turnsText3;

    private int xCount;
    private int yCount;
    private int mineNum;
    private int turnsNum1;
    private int turnsNum2;
    private int turnsNum3;

    public ModeSelect() {
        modeSelect = this;
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        turnsText1 = new JTextField();
        turnsText1.setBounds(120, 100, 150, 35);
        turnsText1.setOpaque(false);
        turnsText1.setBorder(null);
        turnsText1.addMouseListener(this);
        this.add(turnsText1);

        primary = new JButton("初级");
        primary.setFont(new Font("黑体", Font.BOLD, 18));
        primary.setBounds(10, 100, 90, 35);
        primary.setOpaque(false);
        primary.setContentAreaFilled(false);
        primary.setForeground(Color.BLACK);
        this.add(primary);
        primary.addActionListener(e -> {
            this.xCount = 9;
            this.yCount = 9;
            this.mineNum = 10;
            this.turnsNum1 = Integer.parseInt(turnsText1.getText());
            dispose();
            new NewGameOfThreeMode();
        });


        turnsText2 = new JTextField();
        turnsText2.setBounds(120, 150, 150, 35);
        turnsText2.setOpaque(false);
        turnsText2.setBorder(null);
        turnsText2.addMouseListener(this);
        this.add(turnsText2);

        medium = new JButton("中级");
        medium.setFont(new Font("黑体", Font.BOLD, 18));
        medium.setBounds(10, 150, 90, 35);
        medium.setOpaque(false);
        medium.setContentAreaFilled(false);
        medium.setForeground(Color.BLACK);
        this.add(medium);
        medium.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 16;
            this.mineNum = 40;
            this.turnsNum2 = Integer.parseInt(turnsText2.getText());
            dispose();
            new NewGameOfThreeMode();
        });


        turnsText3 = new JTextField();
        turnsText3.setBounds(120, 200, 150, 35);
        turnsText3.setOpaque(false);
        turnsText3.setBorder(null);
        turnsText3.addMouseListener(this);
        this.add(turnsText3);

        senior = new JButton("高级");
        senior.setFont(new Font("黑体", Font.BOLD, 18));
        senior.setBounds(10, 200, 90, 35);
        senior.setOpaque(false);
        senior.setContentAreaFilled(false);
        senior.setForeground(Color.BLACK);
        this.add(senior);
        senior.addActionListener(e -> {
            this.xCount = 16;
            this.yCount = 30;
            this.mineNum = 99;
            this.turnsNum3 = Integer.parseInt(turnsText3.getText());
            dispose();
            new NewGameOfThreeMode();
        });


        user_defined = new JButton("自定义级别");
        user_defined.setFont(new Font("黑体", Font.BOLD, 18));
        user_defined.setBounds(10, 250, 150, 35);
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
    public int getTurnsNum1() {
        return turnsNum1;
    }
    public int getTurnsNum2() {
        return turnsNum2;
    }
    public int getTurnsNum3() {
        return turnsNum3;
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
        if (e.getSource() == turnsText1) {
            turnsText1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
        if (e.getSource() == turnsText2) {
            turnsText2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
        if (e.getSource() == turnsText3) {
            turnsText3.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == turnsText1) {
            turnsText1.setBorder(null);
        }
        if (e.getSource() == turnsText2) {
            turnsText2.setBorder(null);
        }
        if (e.getSource() == turnsText3) {
            turnsText3.setBorder(null);
        }
    }
}



