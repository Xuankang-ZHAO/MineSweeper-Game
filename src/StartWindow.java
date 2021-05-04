import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame implements ActionListener {
    private JButton j1;
    private JButton j2;
    private JButton j3;

    public StartWindow(){
        super("开始界面");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(300,400);
        this.setBackground(new Color(244,183,113));

        JPanel jPanel=new JPanel();
        jPanel.setSize(400,200);
        jPanel.setLayout(new GridLayout(3,1));
        jPanel.setOpaque(false);//让panel透明

        j1=new JButton("创建新的游戏");
        j1.setSize(100,40);
        j1.addActionListener(this);
        j2=new JButton("进入游戏存档");
        j2.setSize(100,40);
        j2.addActionListener(this);
        j3=new JButton("进入存档雷场");
        j3.setSize(100,40);
        j3.addActionListener(this);

        jPanel.add(j1);
        jPanel.add(j2);
        jPanel.add(j3);

        this.add(jPanel);
        this.setVisible(true);

        pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt=(JButton) e.getSource();
        if(bt.equals(j1)){
            dispose();

            new NewGame();
        }
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run() {
                new StartWindow().setVisible(true);

            }

        });
    }
}
