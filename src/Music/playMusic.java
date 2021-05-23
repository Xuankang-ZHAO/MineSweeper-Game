package Music;

import javax.sound.sampled.*;
import java.io.File;

public class playMusic {
    static boolean flag = true;

    public playMusic() {// 背景音乐播放
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File("resouces/MusicUsed/Minecraft.wav"));
            AudioFormat aif = ais.getFormat();
            final SourceDataLine sdl;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, aif);
            sdl = (SourceDataLine) AudioSystem.getLine(info);
            sdl.open(aif);
            sdl.start();
            FloatControl fc = (FloatControl) sdl.getControl(FloatControl.Type.MASTER_GAIN);
            // value可以用来设置音量，从0-2.0
            double value = 2;
            float dB = (float) (Math.log(value == 0.0 ? 0.0001 : value) / Math.log(10.0) * 20.0);
            fc.setValue(dB);
            int nByte = 0;
            int writeByte = 0;
            final int SIZE = 1024 * 64;
            byte[] buffer = new byte[SIZE];
            while (nByte != -1) {// 判断 播放/暂停 状态
                if (flag) {
                    nByte = ais.read(buffer, 0, SIZE);
                    sdl.write(buffer, 0, nByte);
                } else {
                    nByte = ais.read(buffer, 0, 0);
                }
            }
            sdl.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

