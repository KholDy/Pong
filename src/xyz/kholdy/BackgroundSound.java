package xyz.kholdy;

import javazoom.jl.decoder.JavaLayerException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BackgroundSound implements Runnable {
    private FileInputStream path;
    private javazoom.jl.player.Player playMP3;

    @Override
    public void run() {
        try {
            path = new FileInputStream("res/1.mp3");
            playMP3 = new javazoom.jl.player.Player(path);
            playMP3.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }
}
