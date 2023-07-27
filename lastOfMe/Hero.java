package lastOfMe;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Hero extends Thread implements VisibleObjects{
	int x, y;
	Image image = null;
	int width = 164, height = 164;
    boolean updateImage = true;
    MyFrame frame;
    int spriteCounter = 0;
    boolean move = false;
    boolean stop = false;
    boolean roll = false; 
    int NoPistolState = 0;
    int drawPistolState = 1;
    int state = NoPistolState;
    
    boolean pistolDrawn = false;
    boolean shoot = false;

	public Hero(int a, int b,MyFrame frame) {
		x = a;
		y = b;
		this.frame = frame;
		getimage();
		start();
	}
	
	public void HeroRight() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_0.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_1.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_2.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_3.png")).getImage();
			x = x + 3;
			move = false;
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_4.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_5.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 6) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_6.png")).getImage();
			x = x + 3;
		}
		if(spriteCounter == 7) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/run/characterRunning_7.png")).getImage();
			x = x + 3;
			move = false;
			spriteCounter = 0;
		}
		else {
			spriteCounter++;
		}
	}

	
	public void HeroDead() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_0.png")).getImage();
		
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_1.png")).getImage();
			
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_2.png")).getImage();
			
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_3.png")).getImage();
			
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_4.png")).getImage();
			
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_5.png")).getImage();
			
		}
		if(spriteCounter == 6) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_6.png")).getImage();
			
		}
		if(spriteCounter == 7) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_7.png")).getImage();
		}
		if(spriteCounter == 8) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/dead/characterDead_8.png")).getImage();
			spriteCounter = 0;
			stop = true;
		}
		else {
			spriteCounter++;
		}
	}
	
	public void pistolDraw() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/pistol/characterPistolDraw_0.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/pistol/characterPistolShooting_0.png")).getImage();
			spriteCounter = 0;
			pistolDrawn = true;
		}else {
			spriteCounter++;
		}
	}
	
	public void HeroPistolDead() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_00.png")).getImage();
		
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_01.png")).getImage();
			
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_02.png")).getImage();
			
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_03.png")).getImage();
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_04.png")).getImage();
			
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_05.png")).getImage();
			
		}
		if(spriteCounter == 6) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_06.png")).getImage();
			
		}
		if(spriteCounter == 7) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_07.png")).getImage();
		}
		if(spriteCounter == 8) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_08.png")).getImage();
			
		}
		if(spriteCounter == 9) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_09.png")).getImage();
		}
		if(spriteCounter == 10) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/dead/characterPistolDead_10.png")).getImage();
			spriteCounter = 0;
			stop = true;
		}
		else {
			spriteCounter++;
		}
	}
	
	public void HeroPistolRun() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_0.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_1.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 2) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_2.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 3) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_3.png")).getImage();
			
			x=x+3;
		}
		if(spriteCounter == 4) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_4.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 5) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_5.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 6) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_6.png")).getImage();
			x=x+3;
		}
		if(spriteCounter == 7) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/Pistol/run/characterPistolAimingRunning_7.png")).getImage();
			spriteCounter = 0;
			move = false;
			x=x+3;
		}
		else {
			spriteCounter++;
		}
	}
	public void PistolShoot() {
		if(spriteCounter == 0) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/pistol/characterPistolShooting_0.png")).getImage();
		}
		if(spriteCounter == 1) {
			image = new ImageIcon(getClass().getResource("/res/asset/Hero/pistol/characterPistolShooting_1.png")).getImage();
			spriteCounter = 0;
			shoot = false;
		}else {
			spriteCounter++;
		}
	}
	
	public void getimage(){
		
		 if(state == NoPistolState) {
			if(frame.totalZombieHits >= 3) {
				HeroDead();
			}
			else if(move == true){
				HeroRight();
			}
			else {
				image = new ImageIcon(getClass().getResource("/res/characterIdle_0.png")).getImage();
			}
		}
		else if(state == drawPistolState) {
			if(frame.totalZombieHits >= 3) {
				HeroPistolDead();
			}
			else if(shoot) {
				PistolShoot();
			}
			else if(move) {
				HeroPistolRun();
			}
			else {
				if(!pistolDrawn) {
					pistolDraw();
				}
				else {
					image = new ImageIcon(getClass().getResource("/res/asset/Hero/pistol/characterPistolShooting_0.png")).getImage();
				}
			}
		}
	}
	
	@Override
	public void run() {
		while(!stop) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (x < 150) {
				HeroRight();
	        }
			else {
				getimage();
			}
		}
	}
	
	@Override
	public void display(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(image, x, y,width,height,null);
	}
	
	public void moveRight() {
		move = true;
	}
	
	public void drawPistol() {
		spriteCounter = 0;
		state = drawPistolState;
	}

	public void hidePistol() {
		spriteCounter = 0;
		state = NoPistolState;
		pistolDrawn = false;
	}
	
	public void ShootZombie() {
		shoot = true;
	}
}
