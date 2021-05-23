package selectMode;

import javax.swing.*;
import java.awt.*;

public class Story1 extends JFrame {
    public static Story1 story1;

    public Story1() {
        story1 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("resouces/pictures/故事1.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story1.getWidth(), story1.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JLabel story11=new JLabel();
        story11.setText("<html>从前有两个小猫猫在开心玩耍时穿越到了我的世界，" +
                "正当它们迷茫时天空中出现了以下游戏规则" +
                "【可通过点击格子获得数字来推测周围格子的状态" +
                "左击点中苦力怕，苦力怕将爆炸并且扣除分数；" +
                "右击点中史蒂夫，史蒂夫注视你，增加一次失误数；" +
                "右击点中钻石，恭喜你，增加一分。" +
                "尽可能的怎加你的分数并且减少你的失误数" +
                "只有胜者才能逃出游戏世界】" +
                "于是它们开始了扫雷...<html>");
        story11.setBounds(30, 0, 570, 360);
        story11.setForeground(Color.BLACK);
        story11.setFont(new Font("楷体", Font.BOLD, 25));
        this.add(story11);

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.setVisible(true);
    }

}
