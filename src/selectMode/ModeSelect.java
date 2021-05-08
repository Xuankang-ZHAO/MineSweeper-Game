package selectMode;

import ModeOfGame.NewGame;
import openWindow.InitialWindow;
import selectWindow.set1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ModeSelect extends JFrame {
    public static selectMode.ModeSelect modeSelect;
    private JButton primary;
    private JButton medium;
    private JButton senior;
    private JButton user_defined;

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
            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGame();
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
            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGame();
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
            this.turnsNum = Integer.parseInt(turnsText.getText());
            dispose();
            new NewGame();
        });

        user_defined = new JButton("自定义级别");
        user_defined.setFont(new Font("黑体", Font.BOLD, 18));
        user_defined.setBounds(250, 250, 90, 35);
        user_defined.setOpaque(false);
        user_defined.setContentAreaFilled(false);
        user_defined.setForeground(Color.BLACK);
        this.add(user_defined);
        user_defined.addActionListener(e -> {
            dispose();
            new set1();
        });
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
    public int getTurnsNum() {
        return turnsNum;
    }
}
