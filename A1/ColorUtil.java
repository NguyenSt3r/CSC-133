package com.mycompany.a1;

import java.awt.Color;

public class ColorUtil {

	public static int rgb(int r, int g, int b) {
		Color c=new Color(r, g, b);
		return c.getRGB();
	}

	public static int red(int color) {
		Color c= new Color(color);
		return c.getRed();
	}

	public static int green(int color) {
		Color c= new Color(color);
		return c.getGreen();
	}
	public static int blue(int color) {
		Color c= new Color(color);
		return c.getBlue();
	}

}
