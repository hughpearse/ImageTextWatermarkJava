/*
 * Author: Hugh Pearse
 * Purpose: watermark image
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Font;

public class Prog5 {

	public static void main(String[] args) {
	    
		try {
			int fontSize = 12;
			BufferedImage image = ImageIO.read(new File(args[0]));
			Graphics2D g = (Graphics2D) image.getGraphics();
			
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .3f); 
			g.setComposite(ac);
			g.setFont(new Font( "SansSerif", Font.BOLD, fontSize ));
			g.setColor(Color.blue);
			
			String msg = "©Hugh Pearse";
			for(int i=1; i<=image.getHeight(); i=i+fontSize)
				for(int j=1; j<=image.getWidth(); j=j+(fontSize*msg.length()))
					g.drawString(msg, j, i);

			ImageIO.write(image, "jpg", new File(args[0].toString().replace(".", "_watermarked.")));
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}