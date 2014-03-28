package com.lazy.textural;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {

    private Color firstColor;

    private Color secondColor;

    private int occurrence;

    public Picture(Color firstColor, Color secondColor, int occurrence) {
        this.firstColor = firstColor;
        this.secondColor = secondColor;
    }

    public void print(int width, int height) throws IOException {
        Textural firstTextural = new Textural(firstColor);
        Textural secondTextural = new Textural(secondColor);

        BufferedImage firstTexturalBuffImg = firstTextural.getTexturalBufferedImage(width / 2, height / 2);
        BufferedImage secondTexturalBuffImg = secondTextural.getTexturalBufferedImage(width / 2, height / 2);

        BufferedImage combined = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combined.getGraphics();
        g.drawImage(firstTexturalBuffImg, 0, 0, null);
        g.drawImage(secondTexturalBuffImg, width / 2, 0, null);
        g.drawImage(secondTexturalBuffImg, 0, height / 2, null);
        g.drawImage(firstTexturalBuffImg, width / 2, height / 2, null);

        // Save as new image
        ImageIO.write(combined, "PNG", new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
    }
}
