package javaGame;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class JavaGame extends JFrame{
	
	int x, y;
	
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == e.VK_LEFT){
				x--;
			}
			if(keyCode == e.VK_RIGHT){
				x++;
			}
			if(keyCode == e.VK_UP){
				y--;
			}
			if(keyCode == e.VK_DOWN){
				y++;
			}
		}
		public void keyReleased(KeyEvent e){
			
		}
	}
	
	public JavaGame(){
		addKeyListener(new AL());
		setTitle("Java Game");
		setSize(250, 250);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 150; 
		y = 150;
	}
	
	public void paint(Graphics g){
		g.fillOval(x, y, 15, 15);
		
		repaint();
	}
	
	public static void main(String[] args){
		new JavaGame();
	}
	
	
	
}
