package selectMode;


import ModeOfGame.NewGame;
import minesweeper.SingleGame;
import openWindow.InitialWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class set1 extends JFrame implements ActionListener, MouseListener {

    public static set1 set1;

    private JTextField xCountText;
    private JTextField yCountText;
    private JTextField mineText;
//    private JTextField turnsText;

    private JButton loginButton;
    private JButton single;
    private JButton backButton;
    private JLabel xCountLabel;
    private JLabel yCountLabel;
    private JLabel mineLabel;
//    private JLabel turnsLabel;

    private int xCount;
    private int yCount;
    private int mineNum;
    private int turnsNum;

    public set1() {
        set1 = this;

        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        xCountLabel = new JLabel("棋盘大小x");
        xCountLabel.setBounds(10, 100, 90, 35);
        xCountLabel.setForeground(Color.BLACK);
        xCountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(xCountLabel);

        xCountText = new JTextField();
        xCountText.setBounds(120, 100, 150, 35);
        xCountText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        xCountText.setOpaque(false);
        xCountText.setBorder(null);
        xCountText.addMouseListener(this);
        this.add(xCountText);

        yCountLabel = new JLabel("棋盘大小y");
        yCountLabel.setBounds(10, 150, 90, 35);
        yCountLabel.setForeground(Color.BLACK);
        yCountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(yCountLabel);

        yCountText = new JTextField();
        yCountText.setBounds(120, 150, 150, 35);
        yCountText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        yCountText.setOpaque(false);
        yCountText.setBorder(null);
        yCountText.addMouseListener(this);
        this.add(yCountText);


        mineLabel = new JLabel("自定义雷数");
        mineLabel.setBounds(10, 200, 90, 35);
        mineLabel.setForeground(Color.BLACK);
        mineLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        this.add(mineLabel);

        mineText = new JTextField();
        mineText.setBounds(120, 200, 150, 35);
        mineText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        mineText.setOpaque(false);
        mineText.setBorder(null);
        mineText.addMouseListener(this);
        this.add(mineText);

        loginButton = new JButton("开启双人");
        loginButton.setFont(new Font("黑体", Font.BOLD, 18));
        loginButton.setBounds(20, 310, 150, 35);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setForeground(Color.BLACK);
        this.add(loginButton);
        loginButton.addActionListener(e -> {
            if (check() == 0) {
                this.xCount = Integer.parseInt(xCountText.getText());
                this.yCount = Integer.parseInt(yCountText.getText());
                this.mineNum = Integer.parseInt(mineText.getText());
                this.turnsNum = ModeSelect.modeSelect.getTurnsNum();
                dispose();
                new NewGame();
            } else if (check() == 1) {
                JOptionPane.showMessageDialog(null, "请输入不超过24的数字", "雷区x设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 2) {
                JOptionPane.showMessageDialog(null, "请输入不超过30的数字", "雷区y设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 3) {
                JOptionPane.showMessageDialog(null, "请输入不超过总格子数一半的数字", "雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 4) {
                JOptionPane.showMessageDialog(null, "x不能超过24，y不能超过30", "雷区x和y设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 5) {
                JOptionPane.showMessageDialog(null, "x不能超过24，雷数不能超过总格子数一半", "雷区x与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 6) {
                JOptionPane.showMessageDialog(null, "y不能超过30，雷数不能超过总格子数一半", "雷区y与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 7) {
                JOptionPane.showMessageDialog(null, "x不能超过24,y不能超过30，雷数不能超过总格子数一半", "雷区x、y与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            }
        });

        single = new JButton("开启单人");
        single.setFont(new Font("黑体", Font.BOLD, 18));
        single.setBounds(200, 310, 150, 35);
        single.setOpaque(false);
        single.setContentAreaFilled(false);
        single.setForeground(Color.BLACK);
        this.add(single);
        single.addActionListener(e -> {
            if (check() == 0) {
                this.xCount = Integer.parseInt(xCountText.getText());
                this.yCount = Integer.parseInt(yCountText.getText());
                this.mineNum = Integer.parseInt(mineText.getText());
                this.turnsNum = ModeSelect.modeSelect.getTurnsNum();
                dispose();
                new SingleGame();
            } else if (check() == 1) {
                JOptionPane.showMessageDialog(null, "请输入不超过24的数字", "雷区x设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 2) {
                JOptionPane.showMessageDialog(null, "请输入不超过30的数字", "雷区y设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 3) {
                JOptionPane.showMessageDialog(null, "请输入不超过总格子数一半的数字", "雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 4) {
                JOptionPane.showMessageDialog(null, "x不能超过24，y不能超过30", "雷区x和y设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 5) {
                JOptionPane.showMessageDialog(null, "x不能超过24，雷数不能超过总格子数一半", "雷区x与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 6) {
                JOptionPane.showMessageDialog(null, "y不能超过30，雷数不能超过总格子数一半", "雷区y与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            } else if (check() == 7) {
                JOptionPane.showMessageDialog(null, "x不能超过24,y不能超过30，雷数不能超过总格子数一半", "雷区x、y与雷数设置不合理", JOptionPane.WARNING_MESSAGE);
            }
        });

        backButton = new JButton("返回");
        backButton.setFont(new Font("黑体", Font.BOLD, 18));
        backButton.setBounds(380, 310, 100, 35);
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

    public int check() {
        int checkIfo = 0;
        int a = Integer.parseInt(xCountText.getText() + "");
        int b = Integer.parseInt(yCountText.getText() + "");
        int c = Integer.parseInt(mineText.getText() + "");
        boolean d = true;//检查xCount是否合理
        boolean e = true;//检查yCount是否合理
        boolean f = true;//检查雷数是否合理
        if (a > 24) {
            d = false;
        }
        if (b > 30) {
            e = false;
        }
        if (c > a * b * 0.5) {
            f = false;
        }
        if (!d && e && f) {
            checkIfo = 1;
        } else if (d && !e && f) {
            checkIfo = 2;
        } else if (d && e && !f) {
            checkIfo = 3;
        } else if (!d && !e && f) {
            checkIfo = 4;
        } else if (!d && e && !f) {
            checkIfo = 5;
        } else if (d && !e && !f) {
            checkIfo = 6;
        } else if (!d && !e && !f) {
            checkIfo = 7;
        }
        return checkIfo;
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
        if (e.getSource() == xCountText) {
            xCountText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        } else if (e.getSource() == yCountText) {
            yCountText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        } else if (e.getSource() == mineText) {
            mineText.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        }
//        else if(e.getSource()==turnsText)
//        {
//            turnsText.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
//        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == xCountText) {
            xCountText.setBorder(null);
        } else if (e.getSource() == yCountText) {
            yCountText.setBorder(null);
        } else if (e.getSource() == mineText) {
            mineText.setBorder(null);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    //这是用来返回设定的每回合每个玩家可以点击的次数的
    //调用该get方法时，请用   set1.set1.getTurnsNum()
    // 强调： 这里的 set1 需要重复两次
    public int getTurnsNum() {
        return turnsNum;
    }
}
