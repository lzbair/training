package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class Textural {

    private int color;
    private List<Integer> listColorCodes;

    public Textural(int color) {
        this.color = color;
    }

    public Textural(List<Integer> listColorCodes) {
        this.listColorCodes = listColorCodes;
    }

    public void print(int x, int y) {
        BufferedImage image = new BufferedImage(2 * x, y, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, 0xff00ff00);
            }
        }
        for (int i = x; i < 2 * x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, 0xffffff00);
            }
        }
        try {
            ImageIO.write(image, "PNG", new File("mixedColors.png"));
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
