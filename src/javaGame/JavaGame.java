package javaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame implements Runnable{
	
	int x, y, xDirection, yDirection;
	private Image dbImage;
	private Graphics dbg;
	boolean mouseOnScreen;
	Image face;
	
	public void run(){
		try{
			while(true){
				
				move();
				
				Thread.sleep(10);
			}
		}
		catch(Exception e){
			System.out.println("Error");
		}
	}
	
	public void move(){
		x += xDirection;
		y += yDirection;
		if(x <= 0){
			x = 0;
		}
		if(x >= 220){
			x = 220;
		}
		if(y <= 28){
			y = 28;
		}
		if(y >= 220){
			y = 220;
		}
	}
	
	public void setXDir(int xdir){
		xDirection = xdir;
	}
	
	public void setYDir(int ydir){
		yDirection = ydir;
	}
	
	Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 
			30);
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				setXDir(-1);
			}
			if(keyCode == e.VK_RIGHT){
				setXDir(1);
			}
			if(keyCode == e.VK_UP){
				setYDir(-1);
			}
			if(keyCode == e.VK_DOWN){
				setYDir(1);
			}
		}
		public void keyReleased(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				setXDir(0);
			}
			if(keyCode == e.VK_RIGHT){
				setXDir(0);
			}
			if(keyCode == e.VK_UP){
				setYDir(0);
			}
			if(keyCode == e.VK_DOWN){
				setYDir(0);
			}
		}
	}
	
	public class Mouse extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e){
			int xCoord = e.getX();
			int yCoord = e.getY();
			x = xCoord - 7;
			y = yCoord - 7;
		}
		@Override
		public void mouseReleased(MouseEvent e){
			
		}
		public void mouseEntered(MouseEvent e){
			mouseOnScreen = true;
		}
		public void mouseExited(MouseEvent e){
			mouseOnScreen = false;
		}
	
	}
	
	public JavaGame(){
		//Load images
		ImageIcon i = new ImageIcon("E:/workspace/face.gif");
		face = i.getImage();
		//Game properties
		addKeyListener(new AL());
		addMouseListener(new Mouse());
		setTitle("Java Game");
		setSize(250, 250);
		setResizable(false);
		setVisible(true);
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 150; 
		y = 150;
	}
	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void paintComponent(Graphics g){
		g.fillOval(x,  y, 15, 15);
		g.setColor(Color.red);
		if(mouseOnScreen){
			g.drawString("Coord: (" + x + ", " + y + ")", 150, 150);
		}
		repaint();
	}
	
	/*
	public static void main(String[] args){
		JavaGame jg = new JavaGame();
		//Threads
		Thread t1 = new Thread(jg);
		t1.start();
	}
	*/
	
	
	
}
