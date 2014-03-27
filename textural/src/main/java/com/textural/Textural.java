package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    public Textural(String string) {

    }

    public void print(int x, int y) {
        BufferedImage image = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                image.setRGB(i, j, 0xff000000);
            }
        }

        try {
            ImageIO.write(image, "PNG", new File("black.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
