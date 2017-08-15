package imageShop;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageShop {
	private static ImageDocument image;
	private static BufferedImage GrayScale;

	public static void main(String[] args) throws IOException {
		BufferedImage initialImage;
		BufferedImage finalImage;

		ImageLoader loader = new ImageLoader("/Users/MigiHome/desktop/adv.jpg");
		image = loader.loadImage();
		EffectLibrary effect = new EffectLibrary();
		finalImage =  effect.GrayScale();
		ImageLoader.writeImage(finalImage, "/Users/MigiHome/desktop/adv1.jpg");
		System.out.println("Done done doneeee with the greyscale");
	}

	private Effect[] processTransforms(String args[]) {
		return null;

	}

	private void processImage(String image, Effect[] transforms) {

	}
}
