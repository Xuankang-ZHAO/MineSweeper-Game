
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialWindow extends JFrame implements ActionListener{


    private JButton newButton;
    private JButton getSaveBtn1;
    private JButton getSaveBTn2;
    private JButton cancelButton;
    private JLabel TitleLabel;


    public InitialWindow() {

        this.setSize(900, 600);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        TitleLabel = new JLabel("MyMine");
        TitleLabel.setBounds(360, 70, 200, 55);
        TitleLabel.setForeground(Color.BLACK);
        TitleLabel.setFont(new Font("times new roman", Font.ITALIC, 30));
        this.add(TitleLabel);





        newButton = new JButton("创建新的游戏");
        newButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
        newButton.setBounds(350, 200, 150, 45);
        newButton.setForeground(Color.BLACK);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        this.add(newButton);
        newButton.addActionListener(this);


        getSaveBtn1 = new JButton("进入游戏存档");
        getSaveBtn1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        getSaveBtn1.setBounds(350, 260, 150, 35);
        getSaveBtn1.setForeground(Color.BLACK);
        getSaveBtn1.setOpaque(false);
        getSaveBtn1.setContentAreaFilled(false);
        this.add(getSaveBtn1);
        getSaveBtn1.addActionListener(this);


        getSaveBTn2 = new JButton("进入存档雷场");
        getSaveBTn2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        getSaveBTn2.setBounds(350, 320, 150, 35);
        getSaveBTn2.setForeground(Color.BLACK);
        getSaveBTn2.setOpaque(false);
        getSaveBTn2.setContentAreaFilled(false);
        this.add(getSaveBTn2);
        getSaveBTn2.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("微软雅黑",Font.PLAIN,18));
        cancelButton.setBounds(350, 380, 150, 35);
        cancelButton.setOpaque(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setForeground(Color.BLACK);
        this.add(cancelButton);
        cancelButton.addActionListener(this);
        this.add(new InitialPanel());
        this.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bt=(JButton) e.getSource();
        if(bt.equals(newButton)){
            dispose();
            new NewGame();
        }

        if (e.getSource() == cancelButton) {
            JOptionPane.showMessageDialog(this, "welcome again");
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override

            public void run() {
                new InitialWindow().setVisible(true);

            }

        });
    }



}
