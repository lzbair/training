package com.lazy.textural;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.junit.Test;

public class TexturalBehavior {

    @Test
    public void printsBlackTexture() throws Exception {
        Textural textural = new Textural(Color.BLACK);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(0, 0));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(99, 0));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(0, 99));
        assertEquals(Color.BLACK.getRgb(), texture.getRGB(99, 99));
    }

    @Test
    public void printsFullBlackTexture() throws Exception {
        Textural textural = new Textural(Color.BLACK);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));

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
        BufferedImage texture = ImageIO.read(new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));

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
    public void printsTextureWithName() throws Exception {
        Textural textural = new Textural(Color.RED, "redPicture");
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("redPicture.png"));

        assertEquals(Color.RED.getRgb(), texture.getRGB(0, 0));
        assertEquals(Color.RED.getRgb(), texture.getRGB(99, 0));
        assertEquals(Color.RED.getRgb(), texture.getRGB(0, 99));
        assertEquals(Color.RED.getRgb(), texture.getRGB(99, 99));
    }

    @Test
    public void printsMixedTextureColor() throws Exception {
        // le pb dans ce code est
        // que nous devions imprimer les deux textures
        // y a pas une taille par defaut pour un rectangle
        // il faut permettre plusieurs formats d mage : GIF, BMP, JPEG
        // refactorer le code de print de l image pour qu il soit plus simple

        // given
        Textural texturalRed = new Textural(Color.RED, "redPicture");
        texturalRed.print(50, 50);

        Textural texturalYellow = new Textural(Color.YELLOW, "yellowPicture");
        texturalYellow.print(50, 50);

        Picture picture = new Picture(texturalRed, texturalYellow);

        // when
        // afficher 2 fois les rectangles en hauteur et deux fois en largeur
        picture.print(2, 2);

        // then
        BufferedImage texture = ImageIO.read(new File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
        assertEquals(Color.RED.getRgb(), texture.getRGB(0, 49));
        assertEquals(Color.YELLOW.getRgb(), texture.getRGB(50, 0));

    }

    // @Test
    // public void printsMixedTextureColorUpgrade() throws Exception {
    // // afficher la meme couleur deux fois
    // // given
    // Picture picture = new Picture(Color.RED, Color.BLUE);
    //
    // // when
    // picture.print(100, 100);
    //
    // // then
    // BufferedImage texture = ImageIO.read(new
    // File(Constantes.DEFAULT_TEXTURE_NAME + ".png"));
    // assertEquals(Color.RED.getRgb(), texture.getRGB(0, 49));
    // assertEquals(Color.BLUE.getRgb(), texture.getRGB(99, 0));
    //
    // }

}
