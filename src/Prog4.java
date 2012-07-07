/*
 * Source: http://www.lac.inpe.br/JIPCookbook/1100-create-bw.jsp
 * Author: Hugh Pearse
 * Purpose: Read in file, change RGB value of pixel, write to disk
 */
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import javax.imageio.ImageIO;

public class Prog4 {
	public static void main(String[] args) {
		int width = 100;
		int height = 100;
		try {
			BufferedImage image = ImageIO.read(new File("image2.png"));
			WritableRaster raster = image.getRaster();
			for(int h=0;h<height;h++)
				for(int w=0;w<width;w++)
						//note 3rd parameter is the layer
						//raster.setSample(w,h,1,0);
						raster.setSample(w,h,0,0);
					
			ImageIO.write(image, "png", new File("image3.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
