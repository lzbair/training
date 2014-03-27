package com.lazy.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Textural {

    private String texturalColor;

    private Map<String, Integer> colorsMap;

    public Textural(String texturalColor) {
        this.texturalColor = texturalColor;
        initColorsMap();
    }

    public void print(int width, int height) throws IOException {

        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buffImg.setRGB(i, j, colorsMap.get(texturalColor));
            }
        }

        File imageFile = new File(texturalColor + ".png");
        ImageIO.write(buffImg, "PNG", imageFile);
    }

    private void initColorsMap() {
        colorsMap = new HashMap<String, Integer>();
        colorsMap.put("black", 0xff000000);
        colorsMap.put("gray", 0xff808080);
        colorsMap.put("white", 0xffffffff);
        colorsMap.put("red", 0xffff0000);
        colorsMap.put("blue", 0xff0000ff);
        colorsMap.put("yellow", 0xffffff00);

    }
}
