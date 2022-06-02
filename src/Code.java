import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class Code implements MouseListener {
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		
		BufferedImage image = null;
		GraphicsDevice screen = null;

		Robot robot = null;
		
		screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		try{
			robot = new Robot(screen);
			image = robot.createScreenCapture(new Rectangle(10, 0, 580, 580));
			
			String currentTime = new SimpleDateFormat("yy-mm-dd hh-mm-ss").format(new Date(System.currentTimeMillis()));
			ImageIO.write(image, "PNG", new java.io.File("C://Users//min//Desktop//" + currentTime + ".png"));
			//C:\Users\PC\Downloads
		}catch(AWTException | IOException ex){				
			System.err.println(ex.getMessage());
		}	
	}
}
