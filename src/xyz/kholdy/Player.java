package xyz.kholdy;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private Color color;

    public Player(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        color = new Color(255, 255, 255);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void update(int y) {
        if (this.y <= 10) this.y = 10;
        else if (this.y >= 500) this.y = 500;
        this.y = y;
    }

    public void draw(Graphics canvas) {
        canvas.setColor(color);
        canvas.fillRect(x, y, sizeX, sizeY);
    }
}
