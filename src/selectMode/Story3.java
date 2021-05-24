package selectMode;

import javax.swing.*;
import java.awt.*;

public class Story3 extends JFrame {
    public static Story3 story3;

    public Story3() {
        story3 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("resouces/pictures/背景3.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story3.getWidth(), story3.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JLabel story33=new JLabel();
        story33.setText("从前有两个小老鼠");
        story33.setBounds(30, 70, 570, 330);
        story33.setForeground(Color.WHITE);
        story33.setFont(new Font("楷体", Font.BOLD, 25));
        this.add(story33);

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.setVisible(true);
    }

}
