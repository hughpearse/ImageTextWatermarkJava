/*
 * Author: Hugh Pearse
 * Purpose: Create PNG file with green background colour, and write to file
 */
import java.io.File;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

class Prog1
{
  public static void main (String[] args) throws java.lang.Exception {  
 
    int width = 100;
    int height = 100;
    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bufferedImage.createGraphics();
    
    g.setColor(Color.green);
    g.fillRect(0, 0, width, height);
    
    ImageIO.write(bufferedImage, "png", new File("image1.png"));
  }     
}