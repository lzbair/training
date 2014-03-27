package com.lazy.textural;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private Color color;

    public Textural(Color color) throws Exception {
        this.color = color;
    }

    public void print(int width, int height) throws IOException {

        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffImg.setRGB(i, j, color.getRGB());
            }
        }

        File imageFile = new File(color + ".png");
        ImageIO.write(buffImg, "PNG", imageFile);
    }

}
