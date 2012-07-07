/*
 * Author: Hugh Pearse
 * Purpose: Read in file, alter file object, write to disk
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Prog2 {

	public static void main(String[] args) {
	    int width = 100;
	    int height = 100;
	    
		try {
			BufferedImage image = ImageIO.read(new File("image1.png"));
			Graphics2D g = (Graphics2D) image.getGraphics();
			g.setColor(Color.red);
			g.fillOval(0, 0, width, height);
			ImageIO.write(image, "png", new File("image2.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}