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
            File f = new File("F:\\2021年春季学期\\JAVA\\project\\SweepMine-Tiga\\resouces\\MusicUsed\\点到雷.wav");
            cb = f.toURL();
            AudioClip aau;
            aau = Applet.newAudioClip(cb);
            aau.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
