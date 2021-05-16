package selectMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TopicSelect extends JFrame implements ActionListener, MouseListener {
    public static TopicSelect topicSelect;
    private JButton Topic1;
    private JButton Topic2;
    private JButton Topic3;

    public static int sss = 0;//没有实际含义，只是为了根据点击不同的按钮来决定不同的modeSelect界面背景。

    public TopicSelect() {
        topicSelect = this;
        this.setSize(600, 400);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        Topic1 = new JButton("主题1");
        Topic1.setFont(new Font("黑体", Font.BOLD, 18));
        Topic1.setBounds(250, 120, 90, 35);
        Topic1.setOpaque(false);
        Topic1.setContentAreaFilled(false);
        Topic1.setForeground(Color.BLACK);
        this.add(Topic1);
        Topic1.addActionListener(e -> {
            sss = 1;//下同，给sss赋值区分不同主题
            dispose();
            new ModeSelect();
        });

        Topic2 = new JButton("主题2");
        Topic2.setFont(new Font("黑体", Font.BOLD, 18));
        Topic2.setBounds(250, 170, 90, 35);
        Topic2.setOpaque(false);
        Topic2.setContentAreaFilled(false);
        Topic2.setForeground(Color.BLACK);
        this.add(Topic2);
        Topic2.addActionListener(e -> {
            sss = 2;
            dispose();
            new ModeSelect();
        });

        Topic3 = new JButton("主题3");
        Topic3.setFont(new Font("黑体", Font.BOLD, 18));
        Topic3.setBounds(250, 220, 90, 35);
        Topic3.setOpaque(false);
        Topic3.setContentAreaFilled(false);
        Topic3.setForeground(Color.BLACK);
        this.add(Topic3);
        Topic3.addActionListener(e -> {
            sss = 3;
            dispose();
            new ModeSelect();
        });
        this.add(new Background1());
        this.setVisible(true);

    }

    public static int getSss() {
        return sss;
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

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
