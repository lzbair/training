package com.lazy.textural;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TexturalBehavior {

    @Test
    public void printsBlackTexture() throws IOException {
        Textural textural = new Textural("black");
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("black.png"));
        assertEquals(0xff000000, texture.getRGB(0, 0));
        assertEquals(0xff000000, texture.getRGB(99, 0));
        assertEquals(0xff000000, texture.getRGB(0, 99));
        assertEquals(0xff000000, texture.getRGB(99, 99));
    }

    @Test
    public void printsFullBlackTexture() throws IOException {
        Textural textural = new Textural("black");
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("black.png"));

        int randomAbscissa = (int) (Math.random() * 99 + 1);
        int randomOrdinate = (int) (Math.random() * 99 + 1);

        assertEquals(0xff000000, texture.getRGB(randomAbscissa, randomOrdinate));

        randomAbscissa = (int) (Math.random() * 99 + 1);
        randomOrdinate = (int) (Math.random() * 99 + 1);

        assertEquals(0xff000000, texture.getRGB(randomAbscissa, randomOrdinate));
    }

    @Test
    public void printsYellowTexture() throws IOException {
        Textural textural = new Textural("yellow");
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("yellow.png"));

        assertEquals(0xffffff00, texture.getRGB(0, 0));
        assertEquals(0xffffff00, texture.getRGB(99, 0));
        assertEquals(0xffffff00, texture.getRGB(0, 99));
        assertEquals(0xffffff00, texture.getRGB(99, 99));
    }
}
