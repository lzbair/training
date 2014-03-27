package com.lazy.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private static final String DEFAULT_TEXTURE_NAME = "new picture";

    private Color texturalColor;

    private String texturalName;

    public Textural(Color color) throws Exception {
        this.texturalColor = color;
        // if no texturalName is given then take texturalColor name
        this.texturalName = DEFAULT_TEXTURE_NAME;
    }

    public Textural(Color texturalColor, String texturalName) throws Exception {
        this.texturalColor = texturalColor;
        this.texturalName = texturalName;
    }

    public void print(int width, int height) throws IOException {

        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffImg.setRGB(i, j, texturalColor.getRgb());
            }
        }

        File imageFile = new File(texturalName + ".png");
        ImageIO.write(buffImg, "PNG", imageFile);
    }

}
