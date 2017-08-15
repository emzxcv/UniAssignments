package imageShop;

import java.awt.image.BufferedImage;

import java.util.ArrayList;

public class ImageDocument {

	public BufferedImage image;
	public Effect[] transforms;
	public String outputFile;
	ArrayList<Effect> Transform = new ArrayList<Effect>();

	public ImageDocument(BufferedImage img) {
		image = img;
	}

	public boolean addTranform(Effect t) {
		return Transform.add(t);
	}

	public boolean addTransformations(Effect[] trans) {
		return false;

	}

	public void renderImage(String outFile) {

	}
}
