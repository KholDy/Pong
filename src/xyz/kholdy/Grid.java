package xyz.kholdy;

import java.awt.Color;
import java.awt.Graphics;

public class Grid {
    private int x;
    private int y;
    private int sizeX;
    private int sizeY;
    private Color color;

    public Grid(int x, int y, int sizeX, int sizeY) {
        this.x = x;
        this.y = y;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        color = new Color(255, 255, 255);
    }

    public void draw(Graphics canvas) {
        canvas.setColor(color);
        canvas.fillRect(x, y, sizeX, sizeY);
    }
}
