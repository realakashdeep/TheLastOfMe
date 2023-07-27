package lastOfMe;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Zombie extends Thread implements VisibleObjects{
	
	int x, y;
	Image image = null;
	int width = 164, height = 164;
	MyFrame frame;
	int spriteCounter = 0;
	int move = 0;
	boolean stop = false;
	boolean gotShot = false;
	int Speed = 100;
	int ZombieCnt = 0;
	
	public Zombie(int a, int b, MyFrame frame,int ZombieCnt) {
		x = a;
		y = b;
		this.frame = frame;
		this.ZombieCnt = ZombieCnt;
		if(ZombieCnt == 0) {
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					move = 1;
				}
			}, 2000);
		}
		else {
			move = 1;
		}
	}

	@Override
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(100-ZombieCnt*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			drawImage();
			
		}
		System.out.println("died");
	}
	
	public void drawImage() {
		if(frame.totalHeroHits >= 3) {
			Dead();
			if(stop == true) {
				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						frame.ZombieDied();
					}
				}, 2000);
			}
		}
		else if(gotShot == true) {
			hit();
		}
		else if(frame.hero.x >= frame.zombie.x-20) {
			if(frame.totalZombieHits<3) {
				Attack();
			}
			else {
				idle();
			}
		}
		else if(move == 1) {
			move();

		}
		else {
			idle();
		}
	}
	
	public void move() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Walk/left/zombie_Walk_0_left.png")).getImage();
			x = x - 3;
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Walk/left/zombie_Walk_1_left.png")).getImage();
			x = x - 3;
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Walk/left/zombie_Walk_2_left.png")).getImage();
			x = x - 3;
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Walk/left/zombie_Walk_3_left.png")).getImage();
			x = x - 3;
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Walk/left/zombie_Walk_4_left.png")).getImage();
			x = x - 3;
			spriteCounter = 0;
		}
		else {
			spriteCounter++;
		}
	}
	
	public void idle() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/idle/left/zombie_idle_0_left.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/idle/left/zombie_idle_1_left.png")).getImage();
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/idle/left/zombie_idle_2_left.png")).getImage();
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/idle/left/zombie_idle_3_left.png")).getImage();
			spriteCounter = 0;
		}
		else {
			spriteCounter++;
		}
	}
	
	public void hit() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Hit/left/zombie_Hit_0_left.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Hit/left/zombie_Hit_1_left.png")).getImage();
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Hit/left/zombie_Hit_2_left.png")).getImage();
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Hit/left/zombie_Hit_3_left.png")).getImage();
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Hit/left/zombie_Hit_4_left.png")).getImage();
			spriteCounter = 0;
			gotShot = false;
		}
		else {
			spriteCounter++;
		}
	}
	
	public void Dead() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_0_left.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_1_left.png")).getImage();
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_2_left.png")).getImage();
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_3_left.png")).getImage();
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_4_left.png")).getImage();
			
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_5_left.png")).getImage();
		}
		if(spriteCounter == 6) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_6_left.png")).getImage();
		}
		if(spriteCounter == 7) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_7_left.png")).getImage();
		}
		if(spriteCounter == 8) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Dead/left/zombie_Dead_8_left.png")).getImage();
			spriteCounter = 0;
			stop = true;
			gotShot = false;
		}
		else {
			spriteCounter++;
		}
	}
	public void Attack() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_0_left.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_1_left.png")).getImage();
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_2_left.png")).getImage();
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_3_left.png")).getImage();
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_4_left.png")).getImage();
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Zombie/Attack/left/zombie_Attack_5_left.png")).getImage();
			spriteCounter = 0;
			frame.totalZombieHits++;
			frame.HeroLife--;
		}
		else {
			spriteCounter++;
		}
	}
	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y,width,height,null);
	}

}
