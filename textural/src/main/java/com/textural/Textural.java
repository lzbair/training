package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private String color;

    public Textural(String color) {
        this.color = color;
    }

    public Textural() {
    }

    public void print(int x, int y) {
        int codeColor = 0;
        switch (this.color) {
        case "black":
            codeColor = 0xff000000;
            break;
        case "red":
            codeColor = 0xffff0000;
        default:
            break;
        }
        BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, codeColor);
            }
        }

        switch (this.color) {
        case "black":
            try {
                ImageIO.write(image, "PNG", new File("black.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            break;
        case "red":
            try {
                ImageIO.write(image, "PNG", new File("red.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        default:
            break;
        }

    }

    public void juxtaspose(String color1, String color2, int x, int y) {

        BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < x / 2; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, 0xff000000);
            }
        }
        for (int i = x / 2; i < x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, 0xffff0000);
            }
        }

        try {
            ImageIO.write(image, "PNG", new File("juxtapose.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
