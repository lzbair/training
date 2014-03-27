package com.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.textural.Textural;

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
}
