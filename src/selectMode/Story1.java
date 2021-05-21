package selectMode;

import javax.swing.*;

public class Story1 extends JFrame {
    public static Story1 story1;

    public Story1() {
        story1 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("resouces/pictures/背景1.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story1.getWidth(), story1.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);
    }

}
