
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoginPanel  extends JPanel {
    private Image image;
    public LoginPanel()
    {
        try {
            image= ImageIO.read(new File("src/pictures/背景.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image,0,0,900,600,null);
    }
}



