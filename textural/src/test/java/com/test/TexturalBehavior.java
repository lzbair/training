package com.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.textural.BackgroundTexture;
import com.textural.ColorCode;
import com.textural.FrontBorder;
import com.textural.Textural;

public class TexturalBehavior {

    // @Ignore
    // public void printsBlackTexture() throws IOException {
    // int[] listColorCodes = { ColorCode.BLACK };
    // Textural textural = new Textural(listColorCodes);
    // textural.print();
    // BufferedImage texture = ImageIO.read(new File("black.png"));
    // assertEquals(0xff000000, texture.getRGB(0, 0));
    // assertEquals(0xff000000, texture.getRGB(99, 0));
    // assertEquals(0xff000000, texture.getRGB(0, 99));
    // assertEquals(0xff000000, texture.getRGB(99, 99));
    // }
    //
    // /*
    // * refinement test of color
    // */
    //
    // @Ignore
    // public void printRedTexture() throws IOException {
    // int[] listColorCodes = { ColorCode.RED };
    // Textural textural = new Textural(listColorCodes);
    // textural.print();
    // BufferedImage texture = ImageIO.read(new File("red.png"));
    // assertEquals(0xffff0000, texture.getRGB(0, 0));
    // assertEquals(0xffff0000, texture.getRGB(99, 0));
    // assertEquals(0xffff0000, texture.getRGB(0, 99));
    // assertEquals(0xffff0000, texture.getRGB(99, 99));
    // }
    //
    // /*
    // * innovation test : we test if our system generate juxtaposed textures
    // */
    //
    // @Ignore
    // public void printJuxtaposedHorizontalTextures() throws IOException {
    // int[] listColorCodes = { ColorCode.GREEN, ColorCode.YELLOW };
    // Textural textural = new Textural(listColorCodes);
    // textural.print();
    // BufferedImage texture = ImageIO.read(new File("mixedColors.png"));
    // assertEquals(0xff00ff00, texture.getRGB(0, 0));
    // assertEquals(0xff00ff00, texture.getRGB(99, 0));
    // assertEquals(0xff00ff00, texture.getRGB(0, 99));
    // assertEquals(0xff00ff00, texture.getRGB(99, 99));
    //
    // assertEquals(0xffffff00, texture.getRGB(100, 0));
    // assertEquals(0xffffff00, texture.getRGB(199, 0));
    // assertEquals(0xffffff00, texture.getRGB(100, 99));
    // assertEquals(0xffffff00, texture.getRGB(199, 99));
    // }
    //
    // /*
    // * innovation test : we test if our system generate all juxtaposed
    // textures
    // * with lines numbers and columns numbers
    // */
    //
    // @Ignore
    // public void printAllTextures() throws IOException {
    // int[] listColorCodes = new int[2];
    // listColorCodes[0] = ColorCode.BLACK;
    // listColorCodes[1] = ColorCode.BLUE;
    // Textural textural = new Textural(listColorCodes, 3, 5);
    // textural.print();
    // BufferedImage texture = ImageIO.read(new File("allTextures.png"));
    // assertEquals(0xff000000, texture.getRGB(0, 0));
    // assertEquals(0xff000000, texture.getRGB(99, 0));
    // assertEquals(0xff000000, texture.getRGB(0, 99));
    // assertEquals(0xff000000, texture.getRGB(99, 99));
    //
    // assertEquals(0xff0000ff, texture.getRGB(100, 0));
    // assertEquals(0xff0000ff, texture.getRGB(199, 0));
    // assertEquals(0xff0000ff, texture.getRGB(100, 99));
    // assertEquals(0xff0000ff, texture.getRGB(199, 99));
    // }

    /*
     * innovation test : we test color border generation
     */

    @Test
    public void printFrontBorder() throws IOException {
        int[] listColorCodes = new int[2];
        listColorCodes[0] = ColorCode.BLACK;
        listColorCodes[1] = ColorCode.BLUE;
        BackgroundTexture backgroundTexture = new BackgroundTexture();
        backgroundTexture.setListColorCodes(listColorCodes);
        backgroundTexture.setNumberColumns(5);
        backgroundTexture.setNumberLines(3);
        FrontBorder frontBorder = new FrontBorder();
        frontBorder.setBorderColor(ColorCode.RED);
        Textural textural = new Textural(backgroundTexture, frontBorder);
        textural.print();
        BufferedImage texture = ImageIO.read(new File("allTextures.png"));
        assertEquals(0xff0000ff, texture.getRGB(100, 0));
        assertEquals(0xff0000ff, texture.getRGB(199, 0));
        assertEquals(0xff0000ff, texture.getRGB(100, 99));
        assertEquals(0xff0000ff, texture.getRGB(199, 99));

    }

}
