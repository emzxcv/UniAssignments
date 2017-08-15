package imageShop;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class EffectLibrary{
	  private HashMap<String,Effect> EFFECTS;


	  public EffectLibrary(){
	    this.EFFECTS = new HashMap<String,Effect>();
	  }
	public boolean registerEffect(String name, Effect effect){
	   EFFECTS.put(name,effect);
	  return true ;
	}

	public boolean deregisterEffect(String name){
	     EFFECTS.remove(name);
	    return true;
	}

	public Effect getEffect(String name){
	  return EFFECTS.get(name);
	}

	public String[] availableEffects(){

	/*  String  aE[] = new String [100];
	  ae = EFFECTS.values().toString().toArray();
	  return ae;*/
	
	return null;
	}
	 public BufferedImage GrayScale() {

		 
		 int width;
		 int height;
		  BufferedImage  image;
      try {
         File input = new File("/Users/MigiHome/desktop/adv.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();

         for(int i=0; i<height; i++){

            for(int j=0; j<width; j++){

               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,

               red+green+blue,red+green+blue);

                image.setRGB(j,i,newColor.getRGB());
            }
         }

       return image;

      } catch (Exception e) {}
	return null;
   }
}