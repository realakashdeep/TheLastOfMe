package lastOfMe;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiles implements VisibleObjects {
	Image image = null;
	int x, y;
	int height = 120;
	int width = 550;
	public Tiles(int a, int b) {
		x = a;
		y = b;
		
//		System.out.println("I am in Clouds");
		image = new ImageIcon(getClass().getResource("/res/tiles.png")).getImage();
		
	}
	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y,width,height,null);

	}
}
