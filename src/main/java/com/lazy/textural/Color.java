package com.lazy.textural;

public class Color {

    private Integer redComponent;

    private Integer greenComponent;

    private Integer blueComponent;

    private Integer rgb;

    public Color(Integer redComponent, Integer greenComponent, Integer blueComponent) {
        super();
        this.redComponent = redComponent;
        this.greenComponent = greenComponent;
        this.blueComponent = blueComponent;

        this.rgb = ((255 & 0xFF) << 24 | (redComponent & 0xFF) << 16 | (greenComponent & 0xFF) << 8 | (blueComponent & 0xFF) << 0);
    }

    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color PINK = new Color(255, 175, 175);
    public static final Color ORANGE = new Color(255, 200, 0);
    public static final Color YELLOW = new Color(255, 255, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color MAGENTA = new Color(255, 0, 255);
    public static final Color CYAN = new Color(0, 255, 255);
    public static final Color BLUE = new Color(0, 0, 255);

    public Integer getRgb() {
        return rgb;
    }

}
