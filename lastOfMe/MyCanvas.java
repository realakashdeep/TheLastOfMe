package lastOfMe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;







public class MyCanvas extends JPanel {
	
	List<VisibleObjects> objects = new ArrayList<VisibleObjects>();
	MyFrame frame ;
	
	public MyCanvas(MyFrame frame) {
        setBackground(new Color(173, 216, 230));
        this.frame = frame;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ZombieKills(g);
		HeroHealth(g);
		if(frame.HeroLife <= 0) {
			String str = "Hero Died";
			g.setFont(new Font("Serif", Font.BOLD, 36));
			g.drawString(str, 450, 150);
		}
		for(VisibleObjects o : objects)
			o.display(g);
	}
	public void ZombieKills(Graphics g) {
		String Kills = String.valueOf(frame.ZombieKills);
		g.setFont(new Font("Serif", Font.PLAIN, 14));
		g.drawString("Total Kills : "+Kills, 850, 50);
	}
	public void HeroHealth(Graphics g) {
		String lifes = String.valueOf(frame.HeroLife);
		g.setFont(new Font("Serif", Font.PLAIN, 14));
		g.drawString("Life Remaining : "+lifes, 150, 50);
	}
	

}
