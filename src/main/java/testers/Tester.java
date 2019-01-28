package main.java.testers;

import main.java.Drawing;

import java.io.IOException;

public class Tester {
    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        drawing.setVisable();

    }
}
