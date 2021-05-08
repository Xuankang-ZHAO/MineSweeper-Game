package selectWindow;


import ModeOfGame.NewGame;
import openWindow.InitialWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class set1 extends JFrame implements ActionListener,MouseListener {

    public static set1 set1;

    private JTextField xCountText;
    private JTextField yCountText;
    private JTextField mineText;

    private JButton loginButton;
    private JButton backButton;
    private JLabel xCountLabel;
    private JLabel yCountLabel;
    private JLabel mineLabel;

    private int xCount;
    private int yCount;
    private int mineNum;

    public set1() {
        set1=this;

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
        xCountText.setFont(new Font("微软雅黑",Font.PLAIN,16));
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
        mineText.setOpaque(false);
        mineText.setBorder(null);
        mineText.addMouseListener(this);
        this.add(mineText);


        loginButton = new JButton("开启");
        loginButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
        loginButton.setBounds(20, 250, 100, 35);
        loginButton.setForeground(Color.BLACK);
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        this.add(loginButton);
        loginButton.addActionListener(e -> {
            this.xCount=Integer.parseInt(xCountText.getText());
            this.yCount=Integer.parseInt(yCountText.getText());
            this.mineNum=Integer.parseInt(mineText.getText());
            dispose();
            new NewGame();
        });

        backButton = new JButton("返回");
        backButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
        backButton.setBounds(150, 250, 100, 35);
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
        if(e.getSource()==xCountText)
        {
            xCountText.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        }else if(e.getSource()==yCountText)
        {
            yCountText.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        }else if(e.getSource()==mineText)
        {
            mineText.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        }

    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==xCountText)
        {
            xCountText.setBorder(null);
        }else if(e.getSource()==yCountText)
        {
            yCountText.setBorder(null);
        }else if(e.getSource()==mineText){
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
}
