package com.lazy.textural;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {

    private Textural firstTextural;

    private Textural secondTextural;

    private static int TEXTURAL_WIDTH = 50;

    private static int TEXTURAL_HEIGHT = 30;

    public Picture(Textural firstTextural, Textural secondTextural) {
        super();
        this.firstTextural = firstTextural;
        this.secondTextural = secondTextural;
    }

    public void print(int occurrenceWidth, int occurrenceHeight) throws IOException {
        BufferedImage firstBufferedImage = firstTextural.getTexturalBufferedImage(TEXTURAL_WIDTH, TEXTURAL_HEIGHT);
        BufferedImage secondBufferedImage = secondTextural.getTexturalBufferedImage(TEXTURAL_WIDTH, TEXTURAL_HEIGHT);

        BufferedImage combinedBufferedImage = new BufferedImage(occurrenceWidth * TEXTURAL_WIDTH, occurrenceHeight * TEXTURAL_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);

        // paint both images, preserving the alpha channels
        Graphics g = combinedBufferedImage.getGraphics();
        for (int i = 0; i < occurrenceWidth; i++) {
            for (int j = 0; j < occurrenceHeight; j++) {
                if (i % 2 == 0) {
                    // pour la meme ligne il faut alterner l ordre de l ecriture
                    // des buffererdImage
                    if (j % 2 == 0) {
                        g.drawImage(firstBufferedImage, TEXTURAL_WIDTH * i, TEXTURAL_HEIGHT * j, null);
                    } else {
                        g.drawImage(secondBufferedImage, TEXTURAL_WIDTH * i, TEXTURAL_HEIGHT * j, null);
                    }
                    // pour la deuxieme colonne il faut alterner l ordre de l
                    // ecriture des buffererdImage
                } else {
                    if (j % 2 == 0) {
                        g.drawImage(secondBufferedImage, TEXTURAL_WIDTH * i, TEXTURAL_HEIGHT * j, null);
                    } else {
                        g.drawImage(firstBufferedImage, TEXTURAL_WIDTH * i, TEXTURAL_HEIGHT * j, null);
                    }
                }
            }
        }

        // Save as new image
        ImageIO.write(combinedBufferedImage, "PNG", new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
    }
}
