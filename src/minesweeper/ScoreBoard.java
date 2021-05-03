package minesweeper;

import components.GridComponent;
import entity.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * 此类的对象是一个计分板容器，通过传入玩家对象，
 * 可以用update()方法实时更新玩家的分数以及失误数。
 */
public class ScoreBoard extends JPanel {

    Player p1;
    Player p2;


    JLabel score1 = new JLabel();
    JLabel score2 = new JLabel();

    //ImageIcon 史蒂夫=new ImageIcon("史蒂夫.PNG");
    //ImageIcon Steven=change(史蒂夫,0.1);
    //ImageIcon 末影人=new ImageIcon("末影人.PNG");
    //ImageIcon Enderman=change(末影人,0.1);
    /**
     * 通过进行游戏的玩家来初始化计分板。这里只考虑了两个玩家的情况。
     * 如果想要2-4人游戏甚至更多，请自行修改(建议把所有玩家存在ArrayList)~
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public ScoreBoard(Player p1, Player p2, int xCount, int yCount) {

        this.add(new JLabel("Score Board Of Players - "));
        this.setSize((yCount * GridComponent.gridSize)/2, 80);
        //this.setSize(500,500);

        this.setLocation(0, xCount * GridComponent.gridSize);

        this.p1 = p1;
        this.p2 = p2;
        this.add(score1);
        this.add(score2);

        //生成player1的面板
        //JPanel role1=dataOfPlayer(p1);
        //生成player2的面板
        //JPanel role2=dataOfPlayer(p2);

        this.setLayout(new BoxLayout(this, 1));//target指的是container
        // 实则按照y轴，指定组件应从上到下排列，即为Y_AXIS
        //this.setLayout(new FlowLayout());
        //this.add(role1);
        //this.add(role2);

        update();
    }

    /**
     * 刷新计分板的数据。
     * 计分板会自动重新获取玩家的分数，并更新显示。
     */
    /*public JPanel dataOfPlayer(Player p){
        JPanel panelOfPlayer1=new JPanel();
        panelOfPlayer1.setLayout(new GridLayout(4,1));

        JButton imageOfPlayer1=new JButton(史蒂夫);

        panelOfPlayer1.add(imageOfPlayer1);
        JLabel label1=new JLabel(p.getUserName());//name of player1
        JLabel label2=new JLabel("0");//score of player1
        JLabel label3=new JLabel("0");//mistakes of player1

        label1.setOpaque(true);//设置成不透明
        label1.setBackground(Color.WHITE);//背景白色
        label1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));//加一个灰边

        label2.setOpaque(true);//设置成不透明
        label2.setBackground(Color.WHITE);//背景白色
        label2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));//加一个灰边

        label3.setOpaque(true);//设置成不透明
        label3.setBackground(Color.WHITE);//背景白色
        label3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));//加一个灰边

        panelOfPlayer1.add(label1);
        panelOfPlayer1.add(label2);
        panelOfPlayer1.add(label3);

        panelOfPlayer1.setSize(100,300);
        return panelOfPlayer1;
    }*/
    public void update() {
        score1.setText(String.format("%s : %d score  and %d mistake", p1.getUserName(), p1.getScore(), p1.getMistake()));
        score2.setText(String.format("%s : %d score  and %d mistake", p2.getUserName(), p2.getScore(), p2.getMistake()));
    }
    //该方法用于改变贴图时图片的大小
    /*public ImageIcon change(ImageIcon picture,double rate){
        int width=(int)(picture.getIconWidth()*rate);
        int height=(int)( picture.getIconHeight()*rate);
        Image pic=picture.getImage().getScaledInstance(width,height,Image.SCALE_DEFAULT);
        ImageIcon pic2=new ImageIcon(pic);
        return pic2;
    }*/


}
