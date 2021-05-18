package Music;

import java.applet.AudioClip;

import java.io.*;

import java.applet.Applet;

import java.awt.Frame;

import java.net.MalformedURLException;

import java.net.URL;

public class BombedMusic extends Frame {
    public static String imagePath = System.getProperty("user.dir") + "/Music/";

    public BombedMusic() {
        try {
            URL cb;
            File f = new File("E:\\我的世界音乐及音效资源\\点击后的音效\\点到雷.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
