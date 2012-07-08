import java.awt.image.BufferedImage;

public class CountPixels {
	
	public int count(BufferedImage br){
		int number = 0;
		
		for(int i=0; i<br.getHeight(); i++){
			for(int j=0; j<br.getWidth(); j++){
				
				//int pixelData = br.getRGB(i, j);
				int pixelData = br.getRGB(j, i);
				int transparency = (pixelData & 0xff000000) >>> 24;
			    int red =          (pixelData & 0x00ff0000) >>> 16;
	            int green =        (pixelData & 0x0000ff00) >>> 8;
	            int blue =         (pixelData & 0x000000ff);
	            
	            if(transparency > 0){
		            if( (red > 0) || (green > 0) || (blue > 0) ){
		            	number++;
		            }
	            }
			}
		}
		
		return number;
	}//end count
}//end class
