package xyz.kholdy;

import java.awt.Dimension;

import javax.swing.*;

public class PongDrawGUI extends JFrame {
    Thread tSound;

    public PongDrawGUI() {
        JFrame jfr = new JFrame("Pong-KholDy");
        jfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tSound = new Thread(new BackgroundSound());
        //tSound.start(); //Play background sound

        PongPanel p = new PongPanel();
        p.setLayout(null);
        p.addKeyListener(p);
        p.addMouseMotionListener(p);
        p.setFocusable(true);

        jfr.getContentPane().add(p);
        jfr.setSize(new Dimension(800, 600));
        jfr.setResizable(false);

        jfr.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PongDrawGUI();
            }
        });
    }
}