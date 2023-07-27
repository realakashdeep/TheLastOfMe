package lastOfMe;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Cloud  extends Thread implements VisibleObjects {
	
	Image image = null;
	int x, y;
	int height = 60;
	int width = 100;
	
	public Cloud(int a, int b) {
		x = a;
		y = b;
		
//		System.out.println("I am in Clouds");
		image = new ImageIcon(getClass().getResource("/res/cloud.png")).getImage();
		start();
	}
	
	@Override
	public void run() {
		while(y>0) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x=x+1;
			//System.out.println(x);
		}
	}
	
	public int getx() {
		return x;
	}


	@Override
	public void display(Graphics g) {
		//System.out.println("image painted");
		g.drawImage(image, x, y,width,height,null);
	}

}
