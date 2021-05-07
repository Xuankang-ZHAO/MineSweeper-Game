package openWindow;

import ModeOfGame.NewGame;
import ModeOfGame.ReadGame;
import ModeOfGame.ReadMine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class InitialWindow extends JFrame implements ActionListener {
    //在任何地方通过InitialWindow.window获得对象
    public static InitialWindow window;

    private JButton newButton;
    private JButton getSaveBtn1;
    private JButton getSaveBTn2;
    private JButton cancelButton;
    private JLabel TitleLabel;
    private ArrayList<ArrayList<Integer>> copyOfMine;
    private ArrayList<ArrayList<Integer>> copyOfState;
    private ArrayList<ArrayList<Integer>> copyOfScore;
    private ArrayList<String> copyOfName;

    public InitialWindow() {
        window = this;
        this.setSize(900, 600);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);

        TitleLabel = new JLabel("Minemine");
        TitleLabel.setBounds(360, 70, 200, 55);
        TitleLabel.setForeground(Color.BLACK);
        TitleLabel.setFont(new Font("times new roman", Font.ITALIC, 30));
        this.add(TitleLabel);


        newButton = new JButton("创建新的游戏");
        newButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        newButton.setBounds(350, 200, 150, 45);
        newButton.setForeground(Color.BLACK);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        this.add(newButton);
        newButton.addActionListener(this);


        getSaveBtn1 = new JButton("进入游戏存档");
        getSaveBtn1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        getSaveBtn1.setBounds(350, 260, 150, 35);
        getSaveBtn1.setForeground(Color.BLACK);
        getSaveBtn1.setOpaque(false);
        getSaveBtn1.setContentAreaFilled(false);
        this.add(getSaveBtn1);
        getSaveBtn1.addActionListener(this);
        getSaveBtn1.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Input the name you want to read");
            System.out.println("fileName :" + fileName);
            try {
                ArrayList<ArrayList<Integer>> copyOfMine = new ArrayList<>(readInitialDataToFile(fileName));
                this.copyOfMine = copyOfMine;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                ArrayList<ArrayList<Integer>> copyOfState = new ArrayList<>(readInitialDataToFile(fileName + "state"));
                this.copyOfState = copyOfState;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                ArrayList<ArrayList<Integer>> copyOfScore = new ArrayList<>(readInitialDataToFile(fileName + "playerScores"));
                this.copyOfScore = copyOfScore;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            try {
                ArrayList<String> copyOfName = new ArrayList<>(readUserNameToFile(fileName + "playerID"));
                this.copyOfName = copyOfName;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            dispose();
            new ReadGame();
        });


        getSaveBTn2 = new JButton("进入存档雷场");
        getSaveBTn2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        getSaveBTn2.setBounds(350, 320, 150, 35);
        getSaveBTn2.setForeground(Color.BLACK);
        getSaveBTn2.setOpaque(false);
        getSaveBTn2.setContentAreaFilled(false);
        this.add(getSaveBTn2);
        getSaveBTn2.addActionListener(this);
        getSaveBTn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "Input the name you want to read");
            System.out.println("fileName :" + fileName);
            try {
                ArrayList<ArrayList<Integer>> copyOfMine = new ArrayList<>(readInitialDataToFile(fileName));
                this.copyOfMine = copyOfMine;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            dispose();
            new ReadMine();
        });


        cancelButton = new JButton("退出游戏");
        cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
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
        JButton bt = (JButton) e.getSource();
        if (bt.equals(newButton)) {
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


    //读取之前的雷场，需要传入一个参数，以明确读取的名字
    public ArrayList<ArrayList<Integer>> readInitialDataToFile(String name) throws IOException {
        ArrayList<ArrayList<Integer>> readDemo = new ArrayList<>();
        File file = new File("E:\\project 的存档", name);
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        if (file.exists()) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] strings = s.split("\t");
                readDemo.add(new ArrayList());
                for (int i = 0; i < strings.length; i++) {
                    int num = Integer.parseInt(strings[i]);
                    readDemo.get(readDemo.size() - 1).add(i, num);
                }
            }
        }
        bufferedReader.close();
        return readDemo;
    }


    public ArrayList<String> readUserNameToFile(String name) throws IOException {
        ArrayList<String> readDemo = new ArrayList<>();
        File file = new File("E:\\project 的存档", name);
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        if (file.exists()) {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                String[] strings = s.split("\t");
                for (int i=0;i<strings.length;i++){
                    readDemo.add(i,strings[i]);
                }
            }
        }
        bufferedReader.close();
        return readDemo;
    }

    public ArrayList<ArrayList<Integer>> getCopyOfMine() {
        return copyOfMine;
    }

    public ArrayList<ArrayList<Integer>> getCopyOfState() {
        return copyOfState;
    }

    public ArrayList<ArrayList<Integer>> getCopyOfScore() {
        return copyOfScore;
    }

    public ArrayList<String> getCopyOfName() {
        return copyOfName;
    }
}
