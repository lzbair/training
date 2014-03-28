package com.lazy.textural;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {

    private Textural firstTextural;

    private Textural secondTextural;

    public Picture(Textural firstTextural, Textural secondTextural) {
        super();
        this.firstTextural = firstTextural;
        this.secondTextural = secondTextural;
    }

    public void print() throws IOException {
        BufferedImage firstTexturalBuffImg = firstTextural.getTexturalBufferedImage();
        BufferedImage secondTexturalBuffImg = secondTextural.getTexturalBufferedImage();

        int firstTextureWidth = firstTextural.getWidth();

        BufferedImage combined = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(firstTexturalBuffImg, 0, 0, null);
        g.drawImage(secondTexturalBuffImg, firstTextureWidth, 0, null);

        // Save as new image
        ImageIO.write(combined, "PNG", new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
    }
}
