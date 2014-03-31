package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private BackgroundTexture backgroundTexture;
    private FrontBorder frontBorder;
    static final int widthRectangle = 100;
    static final int heightRectangle = 100;

    public Textural(BackgroundTexture backgroundTexture, FrontBorder frontBorder) {
        this.backgroundTexture = backgroundTexture;
        this.frontBorder = frontBorder;
    }

    public void print() {
        int d = 0;
        int color = backgroundTexture.getListColorCodes()[0];
        BufferedImage image = new BufferedImage(backgroundTexture.getNumberColumns() * widthRectangle, backgroundTexture.getNumberLines()
            * heightRectangle, BufferedImage.TYPE_INT_ARGB);
        for (int a = 0; a < backgroundTexture.getNumberLines(); a++) {
            for (int b = 0; b < backgroundTexture.getNumberColumns(); b++) {
                for (int i = b * widthRectangle; i < (b + 1) * widthRectangle; i++) {
                    for (int j = a * heightRectangle; j < (a + 1) * heightRectangle; j++) {
                        image.setRGB(i, j, color);
                    }
                }
                if (d == 1) {
                    color = backgroundTexture.getListColorCodes()[0];
                    d = 0;
                } else {
                    color = backgroundTexture.getListColorCodes()[1];
                    d = 1;
                }
            }
        }

        for (int z = 130; z < 370; z++) {
            image.setRGB(z, 50, frontBorder.getBorderColor());
        }
        for (int z = 130; z < 370; z++) {
            image.setRGB(z, 250, frontBorder.getBorderColor());
        }
        for (int w = 50; w < 250; w++) {
            image.setRGB(130, w, frontBorder.getBorderColor());
        }
        for (int w = 50; w < 250; w++) {
            image.setRGB(370, w, frontBorder.getBorderColor());
        }

        try {
            ImageIO.write(image, "PNG", new File("allTextures.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BackgroundTexture getBackgroundTexture() {
        return backgroundTexture;
    }

    public void setBackgroundTexture(BackgroundTexture backgroundTexture) {
        this.backgroundTexture = backgroundTexture;
    }

    public FrontBorder getFrontBorder() {
        return frontBorder;
    }

    public void setFrontBorder(FrontBorder frontBorder) {
        this.frontBorder = frontBorder;
    }

}
