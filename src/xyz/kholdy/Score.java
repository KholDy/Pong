package xyz.kholdy;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Score extends JPanel {
    Font SuperRetroM54Font;
    Font sizedFont;
    File file;

    private JLabel labelScore;

    private int rightPlayer;
    private int leftPlayer;

    public Score() {
        try {
            file = new File("res/Old School Adventures.ttf");
            SuperRetroM54Font = Font.createFont(Font.PLAIN, file);
            sizedFont = SuperRetroM54Font.deriveFont(20f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        labelScore = new JLabel(leftPlayer + " : " + rightPlayer);
        labelScore.setBackground(Color.BLACK);
        labelScore.setOpaque(true);
        labelScore.setForeground(Color.WHITE);
        labelScore.setFont(sizedFont);

        this.add(labelScore);
    }

    public void update(char ch) {
        if (ch == 'r') {
            labelScore.setText(leftPlayer + " : " + (rightPlayer++));
            if (rightPlayer >= 10) {
                rightPlayer = 0;
            }
        }

        if (ch == 'l') {
            labelScore.setText((leftPlayer++) + " : " + rightPlayer);
            if (leftPlayer >= 10) {
                leftPlayer = 0;
            }
        }
    }
}
