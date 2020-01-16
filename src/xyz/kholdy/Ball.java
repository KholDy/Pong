package xyz.kholdy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
    private final int xMIN = 10;
    private final int yMIN = -6;
    private final int MAX_SPEED = 11;

    private int x;
    private int y;
    private int size;
    private int xSpeed, ySpeed;
    private Player player_one;
    private Player player_two;
    private Score score;
    Random rand;

    public Ball(Player p1, Player p2, Score sc, int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.player_one = p1;
        this.player_two = p2;
        this.score = sc;
        rand = new Random();
        //xSpeed = rand.nextInt(MAX_SPEED * 2 + 1)- MAX_SPEED;
        //ySpeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
        xSpeed = (int) (Math.random() * MAX_SPEED) + xMIN;
        ySpeed = (int) (Math.random() * MAX_SPEED) + yMIN;
    }

    public void update() {
        if (xSpeed == 0) {
            //xSpeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
            xSpeed = (int) (Math.random() * MAX_SPEED) + xMIN;
        }
        if (ySpeed == 0) {
            //ySpeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
            ySpeed = (int) (Math.random() * MAX_SPEED) + yMIN;
        }

        x += xSpeed;
        y += ySpeed;

        //Отскок от края экрана
        if (x - (size / 2) <= 0 || x + (size / 2) >= 800) {
            xSpeed = -xSpeed;
        }
        if (y - (size / 2) <= 0 || y + (size / 2) >= 570) {
            ySpeed = -ySpeed;
        }

        //Столкновение рокетки и мяча player-1
        if (x <= player_one.getX() && (y <= player_one.getY() + 60 && y >= player_one.getY())) xSpeed = -xSpeed;
        //if(x < player.getX()) xSpeed = 0; ySpeed = 0;

        //Столкновение рокетки и мяча player-2
        if (x >= player_two.getX() && (y <= player_two.getY() + 60 && y >= player_two.getY())) xSpeed = -xSpeed;

        //Вброс мяча если один из игроков его пропустил
        if (x <= 5) {
            score.update('r');
            restart();
            x = 400;
            y = 300;
        }

        if (x >= 795) {
            score.update('l');
            restart();
            x = 400;
            y = 300;
        }
    }

    /***************************************************Restart game*****************************************************/
    public void restart() {
        x = 400;
        y = 300;
        //xSpeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
        //ySpeed = rand.nextInt(MAX_SPEED * 2 + 1) - MAX_SPEED;
        xSpeed = (int) (Math.random() * MAX_SPEED) + xMIN;
        ySpeed = (int) (Math.random() * MAX_SPEED) + yMIN;
        //System.out.println("x: " + (int) ((Math.random() * MAX_SPEED) + xMIN));
        //System.out.println("y: " + (int) ((Math.random() * MAX_SPEED) + yMIN));
    }

    /*******************************************Метод отрисовки мяча****************************************************/
    public void draw(Graphics canvas) {
        canvas.setColor(Color.WHITE);
        canvas.fillOval(x, y, size, size);
    }
}
