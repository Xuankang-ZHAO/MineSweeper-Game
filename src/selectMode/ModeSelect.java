package selectMode;

import ModeOfGame.NewGameOfThreeMode;
import openWindow.InitialWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ModeSelect extends JFrame implements ActionListener, MouseListener {
    public static ModeSelect modeSelect;
    private JButton primary;
    private JButton medium;
    private JButton senior;
    private JButton user_defined;
    private JButton backButton;
    private JTextField nameText1;
    private JTextField nameText2;
    private JTextField turnsText;
    private JTextField timeText;
    private JLabel name1;
    private JLabel name2;
    private JLabel turnsLabel;
    private JLabel timeLabel;


    private int xCount;
    private int yCount;
    private int mineNum;
    private int turnsNum;
    private int time;
    String playerName1;
    String playerName2;

    public ModeSelect() {
        modeSelect = this;
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        name1 = new JLabel("请输入用户1的姓名");
        name1.setBounds(10, 20, 160, 35);
        name1.setForeground(Color.BLACK);
        name1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(name1);

        nameText1 = new JTextField();
        nameText1.setBounds(180, 20, 100, 35);
        nameText1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nameText1.setOpaque(false);
        nameText1.setBorder(null);
        nameText1.addMouseListener(this);
        this.add(nameText1);

        name2 = new JLabel("请输入用户2的姓名");
        name2.setBounds(290, 20, 160, 35);
        name2.setForeground(Color.BLACK);
        name2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(name2);

        nameText2 = new JTextField();
        nameText2.setBounds(460, 20, 100, 35);
        nameText2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        nameText2.setOpaque(false);
        nameText2.setBorder(null);
        nameText2.addMouseListener(this);
        this.add(nameText2);

        turnsLabel = new JLabel("请输入每回合单击次数");
        turnsLabel.setBounds(10, 70, 200, 35);
        turnsLabel.setForeground(Color.BLACK);
        turnsLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(turnsLabel);

        turnsText = new JTextField();
        turnsText.setBounds(230, 70, 120, 35);
        turnsText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        turnsText.setOpaque(false);
        turnsText.setBorder(null);
        turnsText.addMouseListener(this);
        this.add(turnsText);
//        turnsText.addKeyListener(new KeyAdapter() {
//            public void keyTyped(KeyEvent e) {
//                int a = e.getKeyChar();
//                String b = turnsText.getText();
//                if (a < 40 || a > 53|| b.length() >= 1) {
//                    e.consume();
//                    JOptionPane.showMessageDialog(null, "请", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
//                }
//                int a = Integer.parseInt(turnsText.getText() + "0");
//                if (a <1) {
//                    e.consume();
//                    JOptionPane.showMessageDialog(null, "请", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        });
        timeLabel = new JLabel("请输入每次点击间隔时间");
        timeLabel.setBounds(10, 120, 200, 35);
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(timeLabel);

        timeText = new JTextField();
        timeText.setBounds(230, 120, 120, 35);
        timeText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        timeText.setOpaque(false);
        timeText.setBorder(null);
        timeText.addMouseListener(this);
        this.add(timeText);


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
            int a = Integer.parseInt(turnsText.getText() + "");
            if (a < 1 || a > 5) {
                JOptionPane.showMessageDialog(null, "请输入数字1-5", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
            } else {
                this.turnsNum = Integer.parseInt(turnsText.getText());
                this.playerName1 = nameText1.getText();
                this.playerName2 = nameText2.getText();
                this.time = Integer.parseInt(timeText.getText());
                dispose();
                new NewGameOfThreeMode();
            }
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
            int a = Integer.parseInt(turnsText.getText() + "");
            if (a < 1 || a > 5) {
                JOptionPane.showMessageDialog(null, "请输入数字1-5", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
            } else {
                this.turnsNum = Integer.parseInt(turnsText.getText());
                this.playerName1 = nameText1.getText();
                this.playerName2 = nameText2.getText();
                this.time = Integer.parseInt(timeText.getText());
                dispose();
                new NewGameOfThreeMode();
            }
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
            int a = Integer.parseInt(turnsText.getText() + "");
            if (a < 1 || a > 5) {
                JOptionPane.showMessageDialog(null, "请输入数字1-5", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
            } else {
                this.turnsNum = Integer.parseInt(turnsText.getText());
                this.playerName1 = nameText1.getText();
                this.playerName2 = nameText2.getText();
                this.time = Integer.parseInt(timeText.getText());
                dispose();
                new NewGameOfThreeMode();
            }
        });


        user_defined = new JButton("自定义级别");
        user_defined.setFont(new Font("黑体", Font.BOLD, 18));
        user_defined.setBounds(225, 320, 150, 35);
        user_defined.setOpaque(false);
        user_defined.setContentAreaFilled(false);
        user_defined.setForeground(Color.BLACK);
        this.add(user_defined);
        user_defined.addActionListener(e -> {
            int a = Integer.parseInt(turnsText.getText() + "");
            if (a < 1 || a > 5) {
                JOptionPane.showMessageDialog(null, "请输入数字1-5", "单击次数设定不合理", JOptionPane.WARNING_MESSAGE);
            } else {
                this.turnsNum = Integer.parseInt(turnsText.getText());
                this.playerName1 = nameText1.getText();
                this.playerName2 = nameText2.getText();
                this.time = Integer.parseInt(timeText.getText());
                dispose();
                new set1();
            }
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
        if (TopicSelect.topicSelect.getSss() == 1) {
            this.add(new Background1());
        } else if (TopicSelect.topicSelect.getSss() == 2) {
            this.add(new Background2());//在这可以换不同背景
        } else if (TopicSelect.topicSelect.getSss() == 3) {
            this.add(new Background3());
        }
        this.setVisible(true);
    }

    //这是用来返回设定的每回合每个玩家可以点击的次数的
    //调用该get方法时，请用   set1.set1.getTurnsNum()
    //强调这里的 set1 需要重复两次
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

    public String getPlayerName1() {
        return playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }

    public int getTime() {
        return time;
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
        if (e.getSource() == turnsText) {
            turnsText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
        if (e.getSource() == nameText1) {
            nameText1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
        if (e.getSource() == nameText2) {
            nameText2.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
        if (e.getSource() == timeText) {
            timeText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == turnsText) {
            turnsText.setBorder(null);
        }
        if (e.getSource() == nameText1) {
            nameText1.setBorder(null);
        }
        if (e.getSource() == nameText2) {
            nameText2.setBorder(null);
        }
        if (e.getSource() == timeText) {
            timeText.setBorder(null);
        }
    }
}



