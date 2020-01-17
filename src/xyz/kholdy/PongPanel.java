package xyz.kholdy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

/********************************************************************************************************************************/
public class PongPanel extends JPanel implements KeyListener, MouseMotionListener {
    private Player player;
    private Player player2;
    private Ball ball;
    private Score score;
    private GameOver gameOver;

    Timer timer;
    Timer timer2;
    int delay = 33;

    public PongPanel() {
        player = new Player(0, 240, 6, 60);
        player2 = new Player(786, 240, 6, 60);

        score = new Score();
        score.setBounds(367, 0, 60, 34);
        score.setBackground(Color.BLACK);
        this.add(score);

        ball = new Ball(player, player2, score, 400, 300, 10);

        setBackground(Color.BLACK);
        timer = new Timer(delay, new BallListener());
        timer.start();
    }

    public void paintComponent(Graphics canvas) {
        super.paintComponent(canvas);

        for (int i = 46; i < 530; i += 30) {
            new Grid(396, i, 2, 25).draw(canvas);
        }
        player.draw(canvas);
        player2.draw(canvas);
        ball.draw(canvas);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            player2.update(-30);
            repaint();    //Перерисовка холста
        }

        if (e.getKeyCode() == e.VK_DOWN) {
            player2.update(30);
            repaint();    //Перерисовка холста
        }

        if (e.getKeyCode() == e.VK_S) {
            ball.restart();
            repaint();
        }

        if (e.getKeyCode() == e.VK_R) {
            ball.restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        player2.update(e.getY());
        repaint();
    }

    private class BallListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ball.update();
            repaint();
        }
    }
}
