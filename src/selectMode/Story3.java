package selectMode;

import javax.swing.*;

public class Story3 extends JFrame {
    public static Story3 story3;

    public Story3() {
        story3 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("resouces/pictures/背景1.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story3.getWidth(), story3.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}
