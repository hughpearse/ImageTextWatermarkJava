/*
 * Author: Hugh Pearse
 * Purpose: Read in file, get RGB value of pixel
 * 
 * References:
 * 	http://www.javamex.com/java_equivalents/unsigned.shtml
 * 	http://stackoverflow.com/questions/1050877/reading-in-a-jpeg-image-in-java
 */
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Prog3 {

	public static void main(String[] args) {
		try {
			BufferedImage image = ImageIO.read(new File("image1.png"));
			
			int x = 1;
			int y = 1;
			int pixelData = image.getRGB(x, y);
		    
			//output full hex colour value
		    System.out.println(Integer.toHexString(pixelData));
		    
		    //output pixel values by performing a bitmask and shifting the bits
		    //note: logical shift - not arithmetic shift (ignore signature bit)
		    int transparency = (pixelData & 0xff000000) >>> 24;
		    int red =          (pixelData & 0x00ff0000) >>> 16;
            int green =        (pixelData & 0x0000ff00) >>> 8;
            int blue =         (pixelData & 0x000000ff);

		    System.out.println(transparency);
		    System.out.println(red);
		    System.out.println(green);
		    System.out.println(blue);
		    
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
