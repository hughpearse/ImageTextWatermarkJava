/*
 * Author: Hugh Pearse
 * Purpose: Randomly located watermark v2
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Font;

public class Prog7 {

	public static void main(String[] args) {
	    
		try {
			//variables for controlling visual effect
			int fontSize = 40;
			String msg = "©Hugh Pearse";
			float msgOpacity = .1f;
			Font msgFont = new Font( "SansSerif", Font.BOLD, fontSize );
			Color msgColour = Color.blue;
			int randPadding = 5;
			int randSpacing = 3;
			
			Random rand = new Random();
			BufferedImage image = ImageIO.read(new File(args[0]));
			Graphics2D g = (Graphics2D) image.getGraphics();
			
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, msgOpacity);
			g.setComposite(ac);
			g.setFont(msgFont);
			g.setColor(msgColour);
			
			String randMsg = msg;
			for(int i=1; i<=image.getHeight(); i=i+fontSize){
				for(int j=1; j<=image.getWidth(); j=j+(fontSize*msg.length())){
					if(rand.nextInt(randSpacing) == 2){
						for(int r=0; r<=rand.nextInt(randPadding); r++)
							randMsg = " " + randMsg;
						g.drawString(randMsg, j, i);
					}
					randMsg = msg;
				}
			}

			ImageIO.write(image, "jpg", new File(args[0].toString().replace(".", "_watermarked.")));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}