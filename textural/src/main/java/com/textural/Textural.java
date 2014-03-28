package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private int color;

    public Textural(int color) {
        this.color = color;
    }

    public void print(int x, int y) {
        BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, color);
            }
        }

        try {
            ImageIO.write(image, "PNG", new File("black.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
