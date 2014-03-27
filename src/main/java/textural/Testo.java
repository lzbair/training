package textural;

import java.io.IOException;

import com.lazy.textural.Color;

public class Testo {

    public static void main(String[] args) throws IOException {
        int randomNuber = (int) (Math.random() * 99 + 1);
        System.out.println(randomNuber);

        Color color = Color.BLACK;

        System.out.println(color.getRgb());
    }
}
