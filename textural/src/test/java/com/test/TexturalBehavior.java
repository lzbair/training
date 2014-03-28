package com.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Ignore;
import org.junit.Test;

import com.textural.ColorCode;
import com.textural.Textural;

public class TexturalBehavior {

    @Ignore
    public void printsBlackTexture() throws IOException {
        List<Integer> listColorCodes = new ArrayList<>();
        listColorCodes.add(ColorCode.BLACK);
        Textural textural = new Textural(listColorCodes);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("black.png"));
        assertEquals(0xff000000, texture.getRGB(0, 0));
        assertEquals(0xff000000, texture.getRGB(99, 0));
        assertEquals(0xff000000, texture.getRGB(0, 99));
        assertEquals(0xff000000, texture.getRGB(99, 99));
    }

    /*
     * refinement test of color
     */

    @Ignore
    public void printRedTexture() throws IOException {
        List<Integer> listColorCodes = new ArrayList<>();
        listColorCodes.add(ColorCode.RED);
        Textural textural = new Textural(listColorCodes);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("red.png"));
        assertEquals(0xffff0000, texture.getRGB(0, 0));
        assertEquals(0xffff0000, texture.getRGB(99, 0));
        assertEquals(0xffff0000, texture.getRGB(0, 99));
        assertEquals(0xffff0000, texture.getRGB(99, 99));
    }

    /*
     * innovation test : we test if our system generate juxtaposed textures
     */

    @Test
    public void printJuxtaposedHorizontalTextures() throws IOException {
        List<Integer> listColorCodes = new ArrayList<>();
        listColorCodes.add(ColorCode.GREEN);
        listColorCodes.add(ColorCode.YELLOW);
        Textural textural = new Textural(listColorCodes);
        textural.print(100, 100);
        BufferedImage texture = ImageIO.read(new File("mixedColors.png"));
        assertEquals(0xff00ff00, texture.getRGB(0, 0));
        assertEquals(0xff00ff00, texture.getRGB(99, 0));
        assertEquals(0xff00ff00, texture.getRGB(0, 99));
        assertEquals(0xff00ff00, texture.getRGB(99, 99));

        assertEquals(0xffffff00, texture.getRGB(100, 0));
        assertEquals(0xffffff00, texture.getRGB(199, 0));
        assertEquals(0xffffff00, texture.getRGB(100, 99));
        assertEquals(0xffffff00, texture.getRGB(199, 99));
    }
}
