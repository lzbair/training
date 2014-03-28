package com.lazy.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private Color texturalColor;

    private String texturalName;

    public Textural(Color color) {
        this.texturalColor = color;
        // if no texturalName is given then take default name
        this.texturalName = Constantes.DEFAULT_TEXTURE_NAME;
    }

    public Textural(Color texturalColor, String texturalName) throws Exception {
        this.texturalColor = texturalColor;
        this.texturalName = texturalName;
    }

    public Textural(Color firstColor, Color secondColor, String texturalName) {

    }

    public void print(int width, int height) throws IOException {
        BufferedImage buffImg = getTexturalBufferedImage(width, height);

        File imageFile = new File(texturalName + ".png");
        ImageIO.write(buffImg, "PNG", imageFile);
    }

    public BufferedImage getTexturalBufferedImage(int width, int height) {
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffImg.setRGB(i, j, texturalColor.getRgb());
            }
        }
        return buffImg;
    }

}
