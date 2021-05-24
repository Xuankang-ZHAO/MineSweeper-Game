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
        story22.setText("<html>从前有一只小鸡和一头小牛在开心玩耍时穿越到了我的世界，" +
                "正当它们迷茫时天空中出现了以下游戏规则" +
                "【可通过点击格子获得数字来推测周围格子的状态" +
                "左击点中苦力怕，苦力怕将爆炸并且扣除分数；" +
                "右击点中史蒂夫，史蒂夫注视你，增加一次失误数；" +
                "右击点中钻石，恭喜你，增加一分。" +
                "尽可能的怎加你的分数并且减少你的失误数" +
                "只有胜者才能逃出游戏世界】" +
                "于是它们开始了扫雷...<html>");
        story22.setBounds(30, 0, 570, 360);
        story22.setForeground(Color.BLACK);
        story22.setFont(new Font("楷体", Font.BOLD, 25));
        this.add(story22);

        panel.setOpaque(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.setVisible(true);
    }

}
