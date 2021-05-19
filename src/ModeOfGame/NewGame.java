package ModeOfGame;

import minesweeper.MainFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import selectMode.set1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class NewGame {
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public NewGame() {
        int LOAD_WIDTH = 455;
        int LOAD_HEIGHT = 295;
        JFrame jf = new JFrame("测试进度条");
        jf.setMinimumSize(new Dimension(LOAD_WIDTH, LOAD_HEIGHT));
        // 创建标签,并在标签上放置一张图片
        ImageIcon p = new ImageIcon("resouces/pictures/苦力怕爆炸.gif");
        ImageIcon pPLus = change(p, 0.9, 0.35);
        JLabel label = new JLabel(pPLus);
        label.setBounds(0, 0, 455, 280);
        //创建进度条
        JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        //获取处进度条内置的数据模型对象
        BoundedRangeModel model = bar.getModel();

        GridBagLayout gridBagLayout = new GridBagLayout(); //实例化布局对象
        jf.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();//实例化这个对象用来对组件进行管理
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        //设置进度条的属性
        bar.setStringPainted(true);
        bar.setBorderPainted(true);
        // 设置进度条的前景色
        bar.setForeground(new Color(0, 210, 40));
        // 设置进度条的背景色
        bar.setBackground(Color.RED);
        bar.setBounds(0, 280, 405, 20);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagLayout.setConstraints(label, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(bar, gridBagConstraints);

        jf.add(label);
        jf.add(bar);


        jf.setLocation((WIDTH - LOAD_WIDTH) / 2, (HEIGHT - LOAD_HEIGHT) / 2);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        //开启子线程
        SimulaterActivity simulaterActivity = new SimulaterActivity(bar.getMaximum());
        new Thread(simulaterActivity).start();

        //MainFrame mainFrame = new MainFrame(set1.set1.getxCount(), set1.set1.getyCount(), set1.set1.getMineNum());
        //设置一个定时任务
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //读取线程任务对象的当前完成量，设置给进度条
                int current = simulaterActivity.getCurrent();
                model.setValue(current);
            }
        });
        timer.start();
        AtomicReference<MainFrame> mainFrame = new AtomicReference<>();
        //监听进度条的任务变化
        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = model.getValue();
                if (value == simulaterActivity.getAmount()) {
                    timer.stop();
                    jf.dispose();
                    mainFrame.get().setVisible(true);
                }
            }
        });
        new Thread(()->{
            mainFrame.set(new MainFrame(set1.set1.getxCount(), set1.set1.getyCount(), set1.set1.getMineNum()));
        }).start();

    }

    private class SimulaterActivity implements Runnable {
        //记录任务总量
        private int amount;

        //记录当前任务的完成量
        private volatile int current;

        public SimulaterActivity(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        @Override
        public void run() {
            //子线程的任务  模拟耗时操作
            while (current < amount) {
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }

        }
    }

    public static ImageIcon change(ImageIcon picture, double rate1, double rate2) {
        int width = (int) (picture.getIconWidth() * rate1);
        int height = (int) (picture.getIconHeight() * rate2);
        Image pic = picture.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon pic2 = new ImageIcon(pic);
        return pic2;
    }


}


