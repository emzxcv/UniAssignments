package imageShop;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;  
import java.io.IOException;  
  
import javax.imageio.ImageIO; 

public class ImageLoader{

	  private String fileName;
	  BufferedImage Image; 


	public ImageLoader(String file){
	fileName = file;
	}

	public ImageDocument loadImage(){
	  File file = new File(fileName);
	   try {
		Image = ImageIO.read(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  ImageDocument imagedocument=new ImageDocument(Image);
	   return imagedocument;

	}

	public static void writeImage(Image finalImage, String outputFile) throws IOException{
	  File ouptut = new File(outputFile);
	  ImageIO.write((RenderedImage) finalImage, "jpg", ouptut);
	}




	}
