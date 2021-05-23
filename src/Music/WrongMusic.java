package Music;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WrongMusic extends Frame {
    public static String imagePath = System.getProperty("user.dir") + "/Music/";
    public WrongMusic() {
        try {
            URL cb;
            File f = new File("resouces/MusicUsed/点击错误扣血.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}