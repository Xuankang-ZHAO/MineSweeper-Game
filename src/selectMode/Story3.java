package selectMode;

import javax.swing.*;
import java.awt.*;

public class Story3 extends JFrame {
    public static Story3 story3;

    public Story3() {
        story3 = this;
        this.setLayout(null);//清空布局管理器
        this.setTitle("游戏情节");
        this.setSize(650, 400);
        this.setLocationRelativeTo(null);
        ImageIcon back = new ImageIcon("resouces/pictures/背景3.jpg");
        JLabel label = new JLabel(back);
        JPanel panel = (JPanel) this.getContentPane();
        this.getLayeredPane().setLayout(null);
        label.setBounds(0, 0, story3.getWidth(), story3.getHeight());
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        JLabel story33=new JLabel();
        story33.setText("<html>从前一只奋斗鸭和一直摸鱼鸭在开心玩耍时穿越到了我的世界，" +
                "正当它们迷茫时天空中出现了以下游戏规则" +
                "【可通过点击格子获得数字来推测周围格子的状态" +
                "左击点中苦力怕，苦力怕将爆炸并且扣除分数；" +
                "右击点中史蒂夫，史蒂夫注视你，增加一次失误数；" +
                "右击点中钻石，恭喜你，增加一分。" +
                "尽可能的怎加你的分数并且减少你的失误数" +
                "只有胜者才能逃出游戏世界】" +
                "于是它们开始了扫雷...<html>");
        story33.setBounds(30, 0, 570, 360);
        story33.setForeground(Color.BLACK);
        story33.setFont(new Font("楷体", Font.BOLD, 25));
        this.add(story33);

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.setVisible(true);
    }

}
