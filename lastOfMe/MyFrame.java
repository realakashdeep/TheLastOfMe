package lastOfMe;


import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.Timer;





public class MyFrame extends JFrame implements ActionListener,KeyListener{
	MyCanvas canvas;
	ArrayList<Hero> heros;
	Cloud cloud = new Cloud(-110, 50);
	Tiles tile = new Tiles(1, 412);
	Hero hero ;
	Zombie zombie;
	boolean move = false;
	int totalHeroHits = 0;
	int totalZombieHits = 0;
	int ZombieCnt  = 0;
	
	int HeroLife = 3;
	int ZombieKills = 0;
	

	ArrayList<Cloud> clouds = new ArrayList<>();
	
	public MyFrame() {
		setTitle("The Last of Me");
		setSize(1000, 568);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		requestFocus();
		setResizable(false);
		addKeyListener(this);
		
		canvas = new MyCanvas(this);
		heros = new ArrayList<>();
		hero = new Hero(-112,290,this);
		zombie = new Zombie(800,290,this,ZombieCnt);
		Timer timer = new Timer(1, this);
		timer.start();
		init();
	}
	
	public void init() {
//		canvas.objects.add(cloud);
//		clouds.add(cloud);
		canvas.objects.add(tile);
		Tiles tile = new Tiles(460, 412);
		canvas.objects.add(tile);
		
		canvas.objects.add(hero);
		canvas.objects.add(zombie);
		heros.add(hero);
		
		add(canvas);
		zombie.start();
		
//		StartCloud();
		//startHero();
	}
//	public void startHero() {
//		Timer timer3 = new Timer(250, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				for (int i = 0; i < ThreadLocalRandom.current().nextInt(0, 2); i++) {
//					Random random = new Random();
//			        int randomNumber = random.nextInt(21) + 30;
//					Hero hero = new Hero(-110, );
//					canvas.objects.add(hero);
//					//clouds.add(cloud);
//				}
//			}
//		});
//		
//		timer3.start();
//	}
//	public void StartCloud() {
//		Timer timer2 = new Timer(250, new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//				for (int i = 0; i < ThreadLocalRandom.current().nextInt(0, 4); i++) {
//					Random random = new Random();
//			        int randomNumber1 = random.nextInt(21) + 30;
//					Cloud cloud = new Cloud(-110, getRand(0, 7, 100));
//					canvas.objects.add(cloud);
//					clouds.add(cloud);
//				}
//			}
//		});
//		
//		timer2.start();
//	}
//	public int getRand(int min, int max, int dim) {
//		int val = 0;
//		if (clouds.size() == 0) {
//			int rand = ThreadLocalRandom.current().nextInt(min, max);
//			val = rand * dim + 50;
//			return val;
//		}
//		Cloud lastBall;
//		Cloud secondLastBall;
//		if (clouds.size() > 2) {
//			lastBall = clouds.get(clouds.size() - 1);
//			secondLastBall = clouds.get(clouds.size() - 2);
//		} else if (clouds.size() == 2) {
//			lastBall = clouds.get(1);
//			secondLastBall = clouds.get(0);
//		} else {
//			lastBall = clouds.get(0);
//			secondLastBall = clouds.get(0);
//		}
//
//		do {
//			int rand = ThreadLocalRandom.current().nextInt(min, max);
//			val = rand * dim + 20;
//		} while (val == lastBall.getx() || val == secondLastBall.getx());
//		return val;
//	}
	
	public static void main(String args[]) {
		MyFrame f = new MyFrame();
		f.setVisible(true);
	}
	
	public void ZombieDied() {
		//System.out.println(totalZombieHits+" "+shoot+" "+totalHeroHits);
		ZombieCnt++;
		ZombieKills++;
		totalHeroHits = 0;
		totalZombieHits = 0;
		canvas.objects.remove(zombie);
		zombie  = new Zombie(900,290,this,ZombieCnt);
		canvas.objects.add(zombie);
		zombie.start();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		canvas.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		
		if(move == false) {
			if(keycode == KeyEvent.VK_LEFT) {
				
			}
			else if(keycode == KeyEvent.VK_RIGHT) {
				hero.moveRight();
			}
			else if(keycode == KeyEvent.VK_2) {
				hero.drawPistol();
			}
			else if(keycode == KeyEvent.VK_1) {
				hero.hidePistol();
			}
			else if(keycode == KeyEvent.VK_SPACE ){
				if(hero.pistolDrawn) {
					totalHeroHits += 1;
					hero.ShootZombie();
					zombie.gotShot = true;
					System.out.println("shoot");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	

	
}
