package selectMode;

import javax.swing.*;
import java.awt.*;

public class Story2 extends JFrame {
    public static Story2 story2;

    public Story2() {
        story2 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("F:\\2021年春季学期\\JAVA\\project\\SweepMine-Tiga\\resouces\\pictures\\背景2.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story2.getWidth(), story2.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JLabel story22=new JLabel();
        story22.setText("从前有两个小狗狗");
        story22.setBounds(30, 70, 570, 330);
        story22.setForeground(Color.WHITE);
        story22.setFont(new Font("楷体", Font.BOLD, 25));
        this.add(story22);

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.setVisible(true);
    }

}
