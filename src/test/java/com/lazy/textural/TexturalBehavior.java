package com.lazy.textural;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TexturalBehavior {

    private static final String DEFAULT_TEXTURE_NAME = "new picture.png";

    @Test
    public void printsBlackTexture() throws Exception {
        Textural textural = new Textural(Color.BLACK);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File(DEFAULT_TEXTURE_NAME));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(0, 0));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(99, 0));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(0, 99));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(99, 99));
    }

    @Test
    public void printsFullBlackTexture() throws Exception {
        Textural textural = new Textural(Color.BLACK);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File(DEFAULT_TEXTURE_NAME));

        int randomAbscissa = (int) (Math.random() * 99 + 1);
        int randomOrdinate = (int) (Math.random() * 99 + 1);

        assertEquals(Color.BLACK.getRgb(), texture.getRGB(randomAbscissa, randomOrdinate));

        randomAbscissa = (int) (Math.random() * 99 + 1);
        randomOrdinate = (int) (Math.random() * 99 + 1);

        assertEquals(Color.BLACK.getRgb(), texture.getRGB(randomAbscissa, randomOrdinate));
    }

    @Test
    public void printsYellowTexture() throws Exception {
        Textural textural = new Textural(Color.YELLOW);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File(DEFAULT_TEXTURE_NAME));

        assertEquals(Color.YELLOW.getRgb(), texture.getRGB(0, 0));
        assertEquals(Color.YELLOW.getRgb(), texture.getRGB(99, 0));
        assertEquals(Color.YELLOW.getRgb(), texture.getRGB(0, 99));
        assertEquals(Color.YELLOW.getRgb(), texture.getRGB(99, 99));
    }

    // no need to this test
    // @Test(expected = Exception.class)
    // public void printsUnfoundColorTexture() throws Exception {
    // Textural textural = new Textural("myColor");
    // textural.print(100, 100);
    // BufferedImage texture = ImageIO.read(new File("myColor.png"));
    //
    // assertEquals(0xffffff00, texture.getRGB(0, 0));
    // assertEquals(0xffffff00, texture.getRGB(99, 0));
    // assertEquals(0xffffff00, texture.getRGB(0, 99));
    // assertEquals(0xffffff00, texture.getRGB(99, 99));
    // }

    @Test
    public void printsTextureUsingAwtColor() throws Exception {
        Textural textural = new Textural(Color.RED, "redPicture");
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("redPicture.png"));

        assertEquals(Color.RED.getRgb(), texture.getRGB(0, 0));
        assertEquals(Color.RED.getRgb(), texture.getRGB(99, 0));
        assertEquals(Color.RED.getRgb(), texture.getRGB(0, 99));
        assertEquals(Color.RED.getRgb(), texture.getRGB(99, 99));
    }

    @Test
    public void printsMixedTextureColor() {
        // given
        Textural textural = new Textural(Color.ORANGE, Color.GREEN, "mixedPicture");

        // when
        textural.print(100, 100);

        // then
        assertEquals(0xffffff00, texture.getRGB(0, 49));
        assertEquals(0xff000000, texture.getRGB(50, 99));

    }
}
