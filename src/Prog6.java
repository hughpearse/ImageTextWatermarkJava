/*
 * Author: Hugh Pearse
 * Purpose: Randomly located watermark v1
 */

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

public class Prog6 {

	public static void main(String[] args) {
	    
		try {
			CountPixels cp = new CountPixels();
			Random randomGenerator = new Random();
			BufferedImage image = ImageIO.read(new File("2012-07-07-151046.jpg"));
			BufferedImage tempCanvas = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			BufferedImage canvas = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			BufferedImage combined = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			
			Graphics2D gTempCanvas = (Graphics2D) tempCanvas.getGraphics();
			Graphics gCombined = combined.getGraphics();
			
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .8f); 
			gTempCanvas.setComposite(ac);
			int fontSize = 12;
			gTempCanvas.setFont(new Font( "SansSerif", Font.BOLD, fontSize ));
			gTempCanvas.setColor(Color.blue);
			String msg = "©Hugh Pearse";
			gTempCanvas.drawString(msg, tempCanvas.getWidth()/2, tempCanvas.getHeight()/2);
			int msgPixelCount = cp.count(tempCanvas);
			tempCanvas = canvas;
			
			int sucessfulIterations = 0;
			for(int i=1; i<=200; i++){
				int rx = randomGenerator.nextInt(image.getWidth());
				int ry = randomGenerator.nextInt(image.getHeight());
				gTempCanvas.drawString(msg, rx, ry);
				int count = cp.count(tempCanvas);

				System.out.println("Trying x=" + rx + " y=" + ry);
				System.out.println("Current watermark size is " + count + "px");

				//avoid overlapping - multiple of message pixels
				if(count == ( (sucessfulIterations+1)*msgPixelCount) ){
					canvas = tempCanvas;
					sucessfulIterations++;
				}
				else{
					tempCanvas = canvas;
				}
				if(sucessfulIterations == 100.0)
					break;
			}
			System.out.println("Watermark size is " + cp.count(canvas) + "px");
			System.out.println("Message size is " + msgPixelCount + "px");
			System.out.println("The total number of sucessful random watermarks is: " + sucessfulIterations);
			
			//combine BufferedImage canvas+image
			gCombined.drawImage(image, 0, 0, null);
			gCombined.drawImage(canvas, 0, 0, null);

			ImageIO.write(combined, "png", new File("prog6.png"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}