package resources;

import javax.swing.*;
import java.awt.*;

public class ImageResource {
    public static ImageIcon p1 = new ImageIcon("resouces/pictures/草方块.PNG");
    public static ImageIcon p1Plus = change(p1, 0.2);
    public static ImageIcon p2 = new ImageIcon("resouces/pictures/苦力怕贴图.PNG");
    public static ImageIcon p2Plus = change(p2, 0.11);
    public static ImageIcon p3 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p3Plus = change(p3, 0.06);
    public static ImageIcon p4 = new ImageIcon("resouces/pictures/贴图史蒂夫.png");
    public static ImageIcon p4Plus = change(p4, 0.08);
    public static ImageIcon p5 = new ImageIcon("resouces/pictures/草方块.PNG");
    public static ImageIcon p5Plus = change(p5, 0.2);
    public static ImageIcon p6 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p6Plus = change(p6, 0.11);
    public static ImageIcon p7 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p7Plus = change(p7, 0.06);
    public static ImageIcon p8 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p8Plus = change(p8, 0.08);
    public static ImageIcon p9 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p9Plus = change(p9, 0.2);
    public static ImageIcon p10 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p10Plus = change(p10, 0.11);
    public static ImageIcon p11 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p11Plus = change(p11, 0.06);
    public static ImageIcon p12 = new ImageIcon("resouces/pictures/钻石.PNG");
    public static ImageIcon p12Plus = change(p12, 0.08);

    /**
     * 用于调整图片的大小，以进行适当的贴图
     *
     * @param picture
     * @param rate
     * @return
     */
    public static ImageIcon change(ImageIcon picture, double rate) {
        int width = (int) (picture.getIconWidth() * rate);
        int height = (int) (picture.getIconHeight() * rate);
        Image pic = picture.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon pic2 = new ImageIcon(pic);
        return pic2;
    }
}
