package xyz.kholdy;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private JLabel labelGameOver;
    private boolean gameOver = false;

    public GameOver() {
        labelGameOver = new JLabel("Game Over");
        labelGameOver.setBackground(Color.BLACK);
        labelGameOver.setOpaque(true);
        labelGameOver.setForeground(Color.WHITE);
        labelGameOver.setFont(new Font("Old School Adventures", Font.BOLD, 36));
        this.add(labelGameOver);
    }

    public void update() {

    }
}
