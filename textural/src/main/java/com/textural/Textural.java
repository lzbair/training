package com.textural;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textural {

    private int[] listColorCodes;
    private int numberLines;
    private int numberColumns;

    public Textural(int[] listColorCodes) {
        this.listColorCodes = listColorCodes;
    }

    public Textural(int[] listColorCodes, int numberLines, int numberColumns) {
        this.listColorCodes = listColorCodes;
        this.setNumberLines(numberLines);
        this.setNumberColumns(numberColumns);
    }

    public void print(int x, int y) {
        int d = 0;
        int color = 0xff000000;
        BufferedImage image = new BufferedImage(5 * x, 3 * y, BufferedImage.TYPE_INT_ARGB);
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 5; b++) {
                for (int i = b * x; i < (b + 1) * x; i++) {
                    for (int j = a * y; j < (a + 1) * y; j++) {
                        image.setRGB(i, j, color);
                    }
                }
                if (d == 1) {
                    color = 0xff000000;
                    d = 0;
                } else {
                    color = 0xff0000ff;
                    d = 1;
                }
            }
        }

        try {
            ImageIO.write(image, "PNG", new File("mixedColors.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(int numberLines) {
        this.numberLines = numberLines;
    }

    public int getNumberColumns() {
        return numberColumns;
    }

    public void setNumberColumns(int numberColumns) {
        this.numberColumns = numberColumns;
    }

}
